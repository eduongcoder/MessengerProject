import { LOGIN_SUCCESS, LOGIN_FAILURE, LOGOUT   } from "./authConstants";

const initialStateAuth = {
  token: null,
  error: null,
  authenticated: false,
};

export const authReducer = (state = initialStateAuth, action) => {
  switch (action.type) {
    case LOGIN_SUCCESS:
      return {
        ...state,
        token: action.payload,
        authenticated: true,
        error: null,
      };
    case LOGIN_FAILURE:
      return { ...state, error: action.payload, authenticated: false };
    case LOGOUT:
      return initialState;
    default:
      return state;
  }
};

