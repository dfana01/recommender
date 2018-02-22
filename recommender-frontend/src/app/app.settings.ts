export class Settings{
    public static DOMAIN_IP = "http://localhost:8080";
    public static END_POINT = `${Settings.DOMAIN_IP}/recommender-backend-1.0-SNAPSHOT/api`;

    static movieUrl(id:number){
        return `${Settings.END_POINT}/movie/${id}`;
    }

    static movieRangeUrl(from:number, to:number){
        return `${Settings.END_POINT}/movie/${from}/${to}`;
    }

    static authUrl(){
        return `${Settings.END_POINT}/authentication`;
    }
}