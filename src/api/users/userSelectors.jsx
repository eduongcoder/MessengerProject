import { createSelector } from 'reselect';  // Đảm bảo bạn nhập khẩu đúng

const userState = (state) => state.user;

// Selector memoized: Trạng thái loading của auth
export const selectUserLoading = createSelector(
  [userState], // Input selector
  (user) => user?.loading // Output selector
);

// Selector memoized: Thông tin user từ auth
export const selectUser = createSelector(
  [userState], // Input selector
  (user) => user?.user // Output selector
);

// Selector memoized: Lỗi từ auth
export const selectUserError = createSelector(
  [userState], // Input selector
  (user) => user?.error // Output selector
);
