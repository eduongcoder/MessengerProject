import { createSelector } from "reselect";

// Truy cập đúng reducer từ state
const regiState = (state) => state.register;

export const selectRegiLoading = createSelector(
  [regiState],
  (register) => register?.loading
);

export const selectRegiInfo = createSelector(
  [regiState],
  (register) => register?.userInfo
);

export const selectRegiError = createSelector(
  [regiState],
  (register) => register?.error
);
