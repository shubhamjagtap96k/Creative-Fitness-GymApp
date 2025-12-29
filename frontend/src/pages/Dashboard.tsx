import React from 'react';
import { useAuth } from '../context/AuthContext';

export default function Dashboard() {
    const { user, logout } = useAuth();

    return (
        <div className="min-h-screen bg-gray-900 text-white p-8">
            <div className="max-w-7xl mx-auto">
                <div className="flex justify-between items-center mb-8 border-b border-gray-700 pb-4">
                    <div>
                        <h1 className="text-3xl font-bold text-accent">Creative Fitness</h1>
                        <p className="text-gray-400">Welcome back, {user?.sub}</p>
                    </div>
                    <div className="flex items-center gap-4">
                        <span className="bg-gray-800 px-3 py-1 rounded text-sm border border-gray-600">{user?.role}</span>
                        <button onClick={logout} className="bg-secondary px-4 py-2 rounded font-semibold hover:bg-red-700 transition">Logout</button>
                    </div>
                </div>

                <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
                    <div className="bg-gray-800 p-6 rounded-lg border border-gray-700 hover:border-accent transition duration-300">
                        <h3 className="text-xl font-semibold mb-4 text-secondary">My Stats</h3>
                        <div className="space-y-2 text-gray-300">
                            <div className="flex justify-between">
                                <span>Classes Attended</span>
                                <span className="font-bold">0</span>
                            </div>
                            <div className="flex justify-between">
                                <span>Membership Status</span>
                                <span className="text-green-500">Active</span>
                            </div>
                        </div>
                    </div>

                    <div className="bg-gray-800 p-6 rounded-lg border border-gray-700 hover:border-accent transition duration-300">
                        <h3 className="text-xl font-semibold mb-4 text-secondary">Upcoming Classes</h3>
                        <p className="text-gray-400 italic">No classes booked yet.</p>
                        <button className="mt-4 w-full bg-gray-700 hover:bg-gray-600 text-white py-2 rounded">Book a Class</button>
                    </div>

                    <div className="bg-gray-800 p-6 rounded-lg border border-gray-700 hover:border-accent transition duration-300">
                        <h3 className="text-xl font-semibold mb-4 text-secondary">Announcements</h3>
                        <p className="text-gray-400">Gym will be closed on New Year's Day.</p>
                    </div>
                </div>
            </div>
        </div>
    );
}
