import React from 'react';
import { useForm } from 'react-hook-form';
import { useNavigate, Link } from 'react-router-dom';
import api from '../api/axios';

export default function Register() {
    const { register, handleSubmit } = useForm();
    const navigate = useNavigate();

    const onSubmit = async (data: any) => {
        try {
            await api.post('/auth/register', data);
            navigate('/login');
        } catch (err) {
            alert('Registration failed');
        }
    };

    return (
        <div className="min-h-screen flex items-center justify-center bg-gray-900">
            <div className="bg-gray-800 p-8 rounded-lg shadow-xl w-96 border border-gray-700">
                <h2 className="text-3xl font-bold text-white mb-6 text-center">Register</h2>
                <form onSubmit={handleSubmit(onSubmit)} className="space-y-4">
                    <div>
                        <label className="block text-gray-300 mb-1">Email</label>
                        <input
                            {...register('email')}
                            className="w-full p-2 rounded bg-gray-700 text-white focus:outline-none focus:ring-2 focus:ring-red-500"
                            type="email"
                        />
                    </div>
                    <div>
                        <label className="block text-gray-300 mb-1">Password</label>
                        <input
                            {...register('password')}
                            className="w-full p-2 rounded bg-gray-700 text-white focus:outline-none focus:ring-2 focus:ring-red-500"
                            type="password"
                        />
                    </div>
                    <div>
                        <label className="block text-gray-300 mb-1">Role</label>
                        <select {...register('role')} className="w-full p-2 rounded bg-gray-700 text-white focus:outline-none focus:ring-2 focus:ring-red-500">
                            <option value="MEMBER">Member</option>
                            <option value="OWNER">Owner</option>
                        </select>
                    </div>
                    <button type="submit" className="w-full bg-red-600 hover:bg-red-700 text-white font-bold py-2 rounded transition">
                        Register
                    </button>
                    <div className="mt-4 text-center">
                        <Link to="/login" className="text-gray-400 hover:text-white text-sm">Already have an account?</Link>
                    </div>
                </form>
            </div>
        </div>
    );
}
