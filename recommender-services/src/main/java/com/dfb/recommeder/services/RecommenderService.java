package com.dfb.recommeder.services;

import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import java.io.File;
import java.util.List;

/**
 * Created by Dante on 3/5/2018.
 */
public class RecommenderService {

    public static void main(String args[]) throws Exception {
        DataModel datamodel = new FileDataModel(new File("c:/dataset.csv")); // data
        Recommender recommender = getRecommender(datamodel);
        List<RecommendedItem> recommendations;
        LongPrimitiveIterator lp = datamodel.getUserIDs();
        while(lp.hasNext()){
            Long userId = lp.nextLong();
            recommendations = getRecommendations(recommender, userId.intValue(), 5);
            displayRecommendations(userId.intValue(), recommendations);
        }
    }

    static Recommender getRecommender(DataModel datamodel) throws Exception {
        UserSimilarity similarity = new PearsonCorrelationSimilarity(datamodel);
        UserNeighborhood neighborhood = new NearestNUserNeighborhood(
                datamodel.getNumUsers(), similarity, datamodel);
        Recommender recommender = new GenericUserBasedRecommender(datamodel,
                neighborhood, similarity);
        return recommender;
    }

    static List<RecommendedItem> getRecommendations(Recommender recommender, int custId, int noOfRecommendations) throws Exception {
        return recommender.recommend(custId, noOfRecommendations);
    }

    static void displayRecommendations(int custId, List<RecommendedItem> recommendations) {
        for (RecommendedItem recommendation : recommendations) {
            System.out.println(String.format("%s,%s", recommendation.getItemID(), custId));
        }
    }
}
