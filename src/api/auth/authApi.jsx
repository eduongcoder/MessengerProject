import axios from 'axios';

const BASE_URL = 'http://26.232.136.42:8082';

export const login = (credentials) => {
  return axios.post(`${BASE_URL}/identity/useridentity/login`, credentials);
};

export const logout = () => {
    return axios.post(`${BASE_URL}/useridentity/logout`);
  };

