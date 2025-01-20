import { getubtoken, register } from "./userApi";
import {
  FETCH_USER_PROF_REQU,
  FETCH_USER_PROF_SUCC,
  FETCH_USER_PROF_FAIL,
} from "./userConstants";
export const fetchUserProfile = (token) => async (dispatch) => {
  const token = localStorage.getItem("token"); // Lấy token từ localStorage
  if (!token) {
    dispatch({
      type: FETCH_USER_PROF_FAIL,
      payload: "Token is missing. Please login again.",
    });
    return;
  }
  dispatch({ type: FETCH_USER_PROF_REQU });
  try {
    const response = await getubtoken(token);
    dispatch({ type: FETCH_USER_PROF_SUCC, payload: response.data });
  } catch (error) {
    dispatch({
        type: FETCH_USER_PROF_FAIL,
        payload: error.response?.data || 'Failed to fetch user profile',
      });
  }
};

export const register = (credentials) => async (dispatch) => {
  try {
    const response = await loginApi(credentials);
    const { token } = response.data.result;

    localStorage.setItem("token", token); // Lưu token vào localStorage
    dispatch({ type: REGISTER_SUCCESS, payload: token });
  } catch (error) {
    dispatch({ type: REGISTER_FAILURE, payload: error.message });
  }
};
