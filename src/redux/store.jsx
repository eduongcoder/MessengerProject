// src/redux/store.js
import { configureStore } from '@reduxjs/toolkit';
import { authReducer  } from '../api/auth';
import userReducer from '../api/users/userReducers';
import { RegisterReducer } from '../api/regi/regiReducers';

const store = configureStore({
  reducer: {
    auth: authReducer,
    user: userReducer,
    regi: RegisterReducer,  
  },
});

export default store;
