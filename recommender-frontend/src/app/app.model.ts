
export interface Movie {
    id: number;
    title: string;
    genres: string[];
    link?: any;
    tags?: any;
    rating: number;
}

export interface Credential{
    id: number;
    password: string;
    username: string;
}