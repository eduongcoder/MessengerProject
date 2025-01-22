import { register } from "./regiApi";
 import { REGISTER_REQU , REGISTER_SUCC , REGISTER_FAIL } from "./regiConstants";

 export const registerUser = (userData) => async (dispatch) => {
    dispatch({ type: REGISTER_REQU });
    
    try {
      const response = await register(userData);
  
      dispatch({
        type: REGISTER_SUCC,
        payload: response.data, // Dữ liệu trả về từ API sau khi đăng ký thành công
      });
    } catch (error) {
      dispatch({
        type: REGISTER_FAIL,
        payload: error.response ? error.response.data.message : error.message, // Lỗi từ API
      });
    }
  };