// src/redux/store.js
import { configureStore } from '@reduxjs/toolkit';
import { authReducer  } from '../api/auth';
import userReducer from '../api/users/userReducers';

const store = configureStore({
  reducer: {
    auth: authReducer,
    user: userReducer,
  },
});

export default store;
