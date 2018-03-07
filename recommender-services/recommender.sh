#recommender.services

hadoop fs -rm -f -r /recommendation/
hadoop fs -rm -f -r /user/hadoop/temp/

sqoop import --connect jdbc:mysql://localhost/recommenderdb --query  'SELECT user, movie, qualification FROM recommenderdb.Rating WHERE 1=1 and $CONDITIONS' --username root --password root --split-by user --target-dir /recommendation/input/ 

hadoop fs -cat /recommendation/input/part*    

mahout recommenditembased -s SIMILARITY_PEARSON_CORRELATION  -i /recommendation/input/part* -o /recommendation/output/ --numRecommendations 5 
    
hadoop fs -cat /recommendation/output/part* > ~/recommender/recommendation.txt

python3 ~/recommender/parse-file.py

hadoop fs -copyFromLocal /home/hadoop/recommender/output.csv /recommendation/output/output.csv

sqoop eval --connect jdbc:mysql://localhost/recommenderdb --username root --password root --query "TRUNCATE TABLE recommenderdb.Recommendation"

sqoop export --connect jdbc:mysql://localhost/recommenderdb --username root --password root --export-dir /recommendation/output/output.csv --table Recommendation --columns user,movie