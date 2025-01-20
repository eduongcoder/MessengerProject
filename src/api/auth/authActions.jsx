import { login as loginApi} from './authApi'
import { LOGIN_SUCCESS, LOGIN_FAILURE, LOGOUT  } from './authConstants';

export const login = (credentials) => async (dispatch) => {
  try {
    const response = await loginApi(credentials);
    const { token } = response.data.result;

    localStorage.setItem('token', token); // Lưu token vào localStorage
    dispatch({ type: LOGIN_SUCCESS, payload: token });
  } catch (error) {
    dispatch({ type: LOGIN_FAILURE, payload: error.message });
  }
};

export const logout = () => (dispatch) => {
  localStorage.removeItem('token'); // Xóa token
  dispatch({ type: LOGOUT });
};
