import axios from "axios";


export const myService = axios.create({
    baseURL: process.env.REACT_APP_FRONTEND_URL
});