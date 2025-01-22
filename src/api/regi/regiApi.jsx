import axios from 'axios';

const BASE_URL = 'http://26.232.136.42:8083';
export const register = (user) => {
    return axios.post(`${BASE_URL}/api/users/register`, user);}