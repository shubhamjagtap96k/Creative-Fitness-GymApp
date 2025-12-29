import React from 'react';
import { useForm } from 'react-hook-form';
import { useNavigate, Link } from 'react-router-dom';
import api from '../api/axios';
import { useAuth } from '../context/AuthContext';

export default function Login() {
    const { register, handleSubmit } = useForm();
    const navigate = useNavigate();
    const { login } = useAuth();
    const [error, setError] = React.useState('');

    const onSubmit = async (data: any) => {
        try {
            const res = await api.post('/auth/login', data);
            login(res.data.token);
            navigate('/dashboard');
        } catch (err) {
            setError('Invalid credentials');
        }
    };

    return (
        <div className="min-h-screen flex items-center justify-center bg-gray-900">
            <div className="bg-gray-800 p-8 rounded-lg shadow-xl w-96 border border-gray-700">
                <h2 className="text-3xl font-bold text-white mb-6 text-center">Login</h2>
                {error && <p className="text-red-500 mb-4">{error}</p>}
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
                    <button type="submit" className="w-full bg-red-600 hover:bg-red-700 text-white font-bold py-2 rounded transition">
                        Sign In
                    </button>
                </form>
                <div className="mt-4 text-center">
                    <Link to="/register" className="text-gray-400 hover:text-white text-sm">Create an account</Link>
                </div>
            </div>
        </div>
    );
}
