import React, { useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { registerUser } from "../api/regi";
import { selectRegiError , selectRegiLoading } from "../api/regi";

const RegisterPage = ({ onSwitchPage }) => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");
  const [username, setUsername] = useState("");
  const dispatch = useDispatch();
  const loading = useSelector(selectRegiLoading);
  const error = useSelector(selectRegiError);

  const handleRegister = () => {
    if (!email.trim() || !username.trim()) {
      alert("Username and Email are required.");
      return;
    }
    if (password !== confirmPassword) {
      alert("Passwords do not match.");
      return;
    }
    const userData = { username, email, password };
    dispatch(registerUser(userData));
  };

  return (
    <div className="min-h-screen flex items-center justify-center">
      <div className="w-full max-w-md p-8 bg-blue-800 rounded-lg shadow-lg transform transition-transform hover:scale-105">
        <h2 className="text-3xl font-bold text-white mb-4 text-center">
          Create Account
        </h2>

        {/* Username Field */}
        <div className="mb-4">
          <label className="block text-white text-sm font-bold mb-1">
            Username *
          </label>
          <input
            type="text"
            placeholder="Enter your username"
            className="w-full p-3 bg-gray-700 text-white rounded focus:outline-none focus:ring-2 focus:ring-blue-500"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
            required
          />
        </div>

        {/* Email Field */}
        <div className="mb-4">
          <label className="block text-white text-sm font-bold mb-1">
            Email *
          </label>
          <input
            type="email"
            placeholder="Enter your email"
            className="w-full p-3 bg-gray-700 text-white rounded focus:outline-none focus:ring-2 focus:ring-blue-500"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />
        </div>

        {/* Password Field */}
        <div className="mb-6">
          <label className="block text-white text-sm font-bold mb-1">
            New Password *
          </label>
          <input
            type="password"
            placeholder="Enter your password"
            className="w-full p-3 bg-gray-700 text-white rounded focus:outline-none focus:ring-2 focus:ring-blue-500"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />
        </div>

        {/* Confirm Password Field */}
        <div className="mb-6">
          <label className="block text-white text-sm font-bold mb-1">
            Confirm New Password *
          </label>
          <input
            type="password"
            placeholder="Confirm your password"
            className="w-full p-3 bg-gray-700 text-white rounded focus:outline-none focus:ring-2 focus:ring-blue-500"
            value={confirmPassword}
            onChange={(e) => setConfirmPassword(e.target.value)}
            required
          />
        </div>

        {/* Error Message */}
        {error && (
          <p className="text-red-500 text-sm mb-4 text-center">{error}</p>
        )}

        {/* Register Button */}
        <button
          onClick={handleRegister}
          disabled={loading}
          className={`w-full text-white font-bold py-3 rounded ${
            loading
              ? "bg-gray-500 cursor-not-allowed"
              : "bg-blue-500 hover:bg-blue-600"
          }`}
        >
          {loading ? "Registering..." : "Register"}
        </button>

        {/* Switch to Login */}
        <div className="mt-4 text-center">
          <p className="text-gray-400">
            Already have an account?{" "}
            <button
              onClick={onSwitchPage}
              className="text-blue-400 hover:underline"
            >
              Log In
            </button>
          </p>
        </div>
      </div>
    </div>
  );
};

export default RegisterPage;
