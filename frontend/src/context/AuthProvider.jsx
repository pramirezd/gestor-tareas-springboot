import React, { useState, useEffect } from 'react';
import { AuthContext } from './AuthContext';

export const AuthProvider = ({ children }) => {
  const [isAuthenticated, setIsAuthenticated] = useState(false);

  useEffect(() => {
    const token = localStorage.getItem('token');
    setIsAuthenticated(!!token);
  }, []);

  const login = async ({ username, password }) => {
    try {
      const response = await fetch('http://localhost:8080/auth/login', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ username, password }),
      });

      if (!response.ok) {
        console.warn('Login fallido:', response.status);
        return false;
      }

      const data = await response.json();
      if (!data.token) {
        console.warn('Token no recibido en respuesta');
        return false;
      }

      localStorage.setItem('token', data.token);
      setIsAuthenticated(true);
      console.log('Login exitoso. Token:', data.token);
      return true;

    } catch (error) {
      console.error('Error en login:', error.message);
      return false;
    }
  };

  const logout = () => {
    localStorage.removeItem('token');
    setIsAuthenticated(false);
  };

  return (
    <AuthContext.Provider value={{ isAuthenticated, login, logout }}>
      {children}
    </AuthContext.Provider>
  );
};