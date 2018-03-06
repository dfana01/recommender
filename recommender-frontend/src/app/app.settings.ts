export class Settings{

    private static APIKEY_TMDB = 'b1e28dd7e44511052a8d30a441b7408a';
    private static DOMAIN_IP = "http://dfb.com.do:8080";
    private static END_POINT = `${Settings.DOMAIN_IP}/recommender/api`;
    private static TMDB_ENDPOINT = "https://api.themoviedb.org";
    private static TMDB_VERSION = "3";

    static movieUrl(id:number){
        return `${Settings.END_POINT}/movie/${id}`;
    }

    static movieDetailUrl(tmdbId:number){
        return `${Settings.TMDB_ENDPOINT}/${Settings.TMDB_VERSION}/movie/${tmdbId}?api_key=${Settings.APIKEY_TMDB}`;
    }

    static movieRangeUrl(from:number, to:number){
        return `${Settings.END_POINT}/movie/${from}/${to}`;
    }

    static authUrl(){
        return `${Settings.END_POINT}/authentication`;
    }

    static movieImgUrl(path, size = '500'){
        return `https://image.tmdb.org/t/p/w${size}${path}`;
    }

    static recommendationUrl(userId:number){
        return `${Settings.END_POINT}/recommendation/${userId}`;
    }

    static rateUrl(){
        return `${Settings.END_POINT}/rating/`;
    }

    static invitationUrl(){
        return `${Settings.END_POINT}/authentication/`;
    }
}