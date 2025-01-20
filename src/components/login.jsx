// src/components/Login.jsx
import React, { useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { login } from '../api/auth/authActions';
import { selectAuthUser , selectAuthLoading, selectAuthError } from '../api/auth';

const Login = ({ onSwitchPage}) => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const dispatch = useDispatch();

  const loading = useSelector(selectAuthLoading);
  const user = useSelector(selectAuthUser);
  const error = useSelector(selectAuthError);

  const handleLogin = () => {
    dispatch(login({ email, password }));
  };

  return (
    <div className="min-h-screen flex items-center justify-center">
      <div className="w-full max-w-md p-8 bg-gray-800 rounded-lg shadow-lg">
        <h2 className="text-3xl font-bold text-white mb-4 text-center">Login</h2>
        <div className="mb-4">
          <label
            htmlFor="email"
            className="block text-white text-sm font-bold mb-1"
          >
            Email *
          </label>
          <input
            id="email"
            type="text"
            placeholder="Enter your email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            className="w-full p-3 bg-gray-700 text-white rounded focus:outline-none focus:ring-2 focus:ring-blue-500"
          />
        </div>
        <div className="mb-6">
          <label
            htmlFor="password"
            className="block text-white text-sm font-bold mb-1"
          >
            Password *
          </label>
          <input
            id="password"
            type="password"
            placeholder="Enter your password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            className="w-full p-3 bg-gray-700 text-white rounded focus:outline-none focus:ring-2 focus:ring-blue-500"
          />
        </div>
        {error && <p className="text-red-500 mb-4">{error}</p>}
        <button
          onClick={handleLogin}
          className="w-full bg-blue-500 text-white font-bold py-3 rounded hover:bg-blue-600 transition-all"
          disabled={loading}
        >
          {loading ? 'Logging in...' : 'Log In'}
        </button>
        <div className="mt-4 text-center">
          <p className="text-gray-400">
            Need an account?{" "}
            <button
              onClick={onSwitchPage}
              className="text-blue-400 hover:underline"
            >
              Register
            </button>
          </p>
        </div>
        {user && (
          <p className="text-green-500 mt-4 text-center">
            Login successful! Welcome {user.name}.
          </p>
        )}
      </div>
    </div>
  );
};

export default Login;
