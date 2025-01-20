import React, { useState } from "react";

const CreNewPass = ({ onSwitchPage, onSendOPT }) => {
  const [email, setEmail] = useState("");
  const [newPassword, setNewPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");
  const [error, setError] = useState("");
  const [confirmError, setConfirmError] = useState("");

  const handleSubmit = () => {
    if (newPassword !== confirmPassword) {
      setError("Passwords do not match");
      setConfirmError("Invalid password confirmation");
    } else {
      setError("");
      setConfirmError("");
      alert("Password updated successfully!");
      onSendOPT(); // Call callback to switch to OTP interface
    }
  };

  return (
    <div className="min-h-screen flex items-center justify-center">
      <div className="w-full max-w-md p-8 bg-gray-800 rounded-lg shadow-lg transform scale-110">
        <h2 className="text-3xl font-bold text-white mb-4 text-center">
          UPDATE PASSWORD
        </h2>

        {/* Email Field */}
        <div className="mb-4">
          <label className="block text-white text-sm font-bold mb-1">
            EMAIL *
          </label>
          <input
            type="text"
            placeholder="Enter your email or phone number"
            className="w-full p-3 bg-gray-700 text-white rounded focus:outline-none focus:ring-2 focus:ring-blue-500"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />
        </div>

        {/* New Password Field */}
        <div className="mb-6">
          <label className="block text-white text-sm font-bold mb-1">
            NEW PASSWORD *
          </label>
          <input
            type="password"
            placeholder="Enter your password"
            className="w-full p-3 bg-gray-700 text-white rounded focus:outline-none focus:ring-2 focus:ring-blue-500"
            value={newPassword}
            onChange={(e) => setNewPassword(e.target.value)}
          />
        </div>

        {/* Confirm New Password Field */}
        <div className="mb-6">
          <label
            className={`block text-sm font-bold mb-1 ${
              confirmError ? "text-red-500" : "text-white"
            }`}
          >
            {confirmError
              ? "Invalid password confirmation"
              : "CONFIRM NEW PASSWORD *"}
          </label>
          <input
            type="password"
            placeholder="Confirm your password"
            className={`w-full p-3 bg-gray-700 text-white rounded focus:outline-none focus:ring-2 ${
              confirmError ? "border-red-500" : "focus:ring-blue-500"
            }`}
            value={confirmPassword}
            onChange={(e) => setConfirmPassword(e.target.value)}
          />
        </div>

        {/* Error Message */}
        {error && (
          <p className="text-red-500 text-sm mb-4 text-center">{error}</p>
        )}

        {/* Send OPT Button */}
        <button
          onClick={handleSubmit}
          disabled={!email || !newPassword || newPassword !== confirmPassword}
          className={`w-full text-white font-bold py-3 rounded ${
            !email || !newPassword || newPassword !== confirmPassword
              ? "bg-gray-500 cursor-not-allowed"
              : "bg-blue-500 hover:bg-blue-600"
          }`}
        >
          Send OTP
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

export default CreNewPass;
