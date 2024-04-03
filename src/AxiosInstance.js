import axios from "axios";


export const myService = axios.create({
    baseURL: 'http://localhost:9090'
});