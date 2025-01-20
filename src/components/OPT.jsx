import React from 'react';

const SendOPT = ({ onSwitchPage }) => {
  return (
    <div className="min-h-screen flex items-center justify-center">
      <div className="w-full max-w-md p-8 bg-gray-800 rounded-lg shadow-lg transform scale-110">
        <h2 className="text-3xl font-bold text-white mb-4 text-center">OPT</h2>
        <div className="mb-6">
          <label className="block text-white text-sm font-bold mb-1">
            Code OPT *
          </label>
          <input
            type="password"
            placeholder="Enter your OTP"
            className="w-full p-3 bg-gray-700 text-white rounded focus:outline-none focus:ring-2 focus:ring-blue-500"
          />
        </div>

        {/* Enter Button */}
        <button className="w-full bg-blue-500 text-white font-bold py-3 rounded hover:bg-blue-600">
          Enter
        </button>

        <div className="mt-4 text-center">
          <p className="text-gray-400">
            Already have an account?{' '}
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

export default SendOPT;
