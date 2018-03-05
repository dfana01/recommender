export interface Movie {
    id: number;
    title: string;
    genres: string[];
    link: Link;
    tags?: any;
    rating: number;
    detail?: MovieDetail;
}

interface Link {
    id: number;
    imdbid: number;
    tmdbid: number;
}

export interface MovieDetail {
    adult: boolean;
    backdrop_path: string;
    belongs_to_collection?: any;
    budget: number;
    genres: Genre[];
    homepage: string;
    id: number;
    imdb_id: string;
    original_language: string;
    original_title: string;
    overview: string;
    popularity: number;
    poster_path: string;
    production_companies: Genre[];
    production_countries: Productioncountry[];
    release_date: string;
    revenue: number;
    runtime: number;
    spoken_languages: Spokenlanguage[];
    status: string;
    tagline: string;
    title: string;
    video: boolean;
    vote_average: number;
    vote_count: number;
}

interface Spokenlanguage {
    iso_639_1: string;
    name: string;
}

interface Productioncountry {
    iso_3166_1: string;
    name: string;
}

interface Genre {
    id: number;
    name: string;
}

export interface Credential {
    id: number;
    password: string;
    username: string;
}

export interface User {
    id: number;
    firstName: string;
    lastName: string;
    phone: string;
    email: string;
    username: string;
    password?: string;
}

export interface Recommendation {
    id: number;
    movie: Movie;
    date: number;
    type: string;
}

export interface Rate{
    id: number;
    movieId: number;
    userId: number;
    qualification: number;
    movie: Movie;
    user: User;
}