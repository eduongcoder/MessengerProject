import { FETCH_USER_PROF_REQU , FETCH_USER_PROF_SUCC , FETCH_USER_PROF_FAIL } from "./userConstants";
const initialStateFecthUser = {
    user: null,
    loading: false,
    error: null,
  };
  
  const userReducer = (state = initialStateFecthUser, action) => {
    switch (action.type) {
      case FETCH_USER_PROF_REQU:
        return { ...state, loading: true };
      case FETCH_USER_PROF_SUCC:
        return { ...state, loading: false, user: action.payload };
      case FETCH_USER_PROF_FAIL:
        return { ...state, loading: false, error: action.payload };
      default:
        return state;
    }
  };
  
  export default userReducer;