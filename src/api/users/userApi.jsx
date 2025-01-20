import axios from 'axios';

const BASE_URL = 'http://26.232.136.42:8082';
export const getubtoken = (token) => {
    return axios.get(`${BASE_URL}/api/users/getubtoken?token=${token}`, /* { headers: { 'Authorization': `Bearer ${token}` } }*/);
}
export const register = (user) => {
  return axios.post(`${BASE_URL}/api/users/register`, user);}