import React, { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { fetchUserProfile } from '../api/users/userActions';
import { selectUser , selectUserLoading , selectUserError } from '../api/users/userSelectors';
const FetchUser = () => {
  const dispatch = useDispatch();
  const  user = useSelector(selectUser);
  const  loading = useSelector(selectUserLoading);
  const  error = useSelector(selectUserError);

  useEffect(() => {
    dispatch(fetchUserProfile()); // Gọi API khi component được render
  }, [dispatch]);

  if (loading) return <p>Loading...</p>;
  if (error) return <p>Error: {error}</p>;

  return (
    <div>
      <h1>User Profile</h1>
      {user ? (
        <div>
          <p>ID: {user.id}</p>
          <p>Username: {user.username}</p>
          <p>Email: {user.email}</p>
        </div>
      ) : (
        <p>No user data</p>
      )}
    </div>
  );
};

export default FetchUser;
