import { createSelector } from 'reselect'; // Import `createSelector` từ `reselect`

// Selector cơ bản: Lấy trạng thái auth từ Redux state
const authState = (state) => state.auth;

// Selector memoized: Trạng thái loading của auth
export const selectAuthLoading = createSelector(
  [authState], // Input selector
  (auth) => auth?.loading // Output selector
);

// Selector memoized: Thông tin user từ auth
export const selectAuthUser = createSelector(
  [authState], // Input selector
  (auth) => auth?.user // Output selector
);

// Selector memoized: Lỗi từ auth
export const selectAuthError = createSelector(
  [authState], // Input selector
  (auth) => auth?.error // Output selector
);
