import { REGISTER_REQU , REGISTER_SUCC , REGISTER_FAIL } from "./regiConstants";


const initialState = {
    loading: false,
    userInfo: null,  // Lưu trữ thông tin người dùng sau khi đăng ký thành công
    error: null,     // Lưu trữ lỗi khi đăng ký thất bại
  };
  
  export const RegisterReducer = (state = initialState, action) => {
    switch (action.type) {
      case REGISTER_REQU:
        return { ...state, loading: true };
      case REGISTER_SUCC:
        return { ...state, loading: false, userInfo: action.payload };
      case REGISTER_FAIL:
        return { ...state, loading: false, error: action.payload };
      default:
        return state;
    }
  };