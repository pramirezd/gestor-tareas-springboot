import React from 'react';
import { Routes, Route } from 'react-router-dom';
import LoginPage from './pages/LoginPage';
import TareasPage from './pages/TareasPage';
import PrivateRoute from './components/PrivateRoute';

function App() {
  return (
    <Routes>
      <Route path="/" element={<LoginPage />} />
      <Route
        path="/tareas"
        element={
          <PrivateRoute>
            <TareasPage />
          </PrivateRoute>
        }
      />
    </Routes>
  );
}

export default App;