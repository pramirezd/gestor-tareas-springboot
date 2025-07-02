import React, { useContext } from 'react';
import { AuthContext } from '../context/AuthContext';
import { useNavigate } from 'react-router-dom';

function TareasPage() {
  const { auth, logout } = useContext(AuthContext);
  const navigate = useNavigate();

  const handleLogout = () => {
    logout();         // Limpia el contexto
    navigate('/');    // Redirige al login
  };

  return (
    <div style={styles.container}>
      <div style={styles.card}>
        <h1>Bienvenido, {auth?.username}</h1>
        <p>Este será el listado de tareas.</p>
        <button onClick={handleLogout} style={styles.button}>
          Cerrar sesión
        </button>
      </div>
    </div>
  );
}

const styles = {
  container: {
    height: '100vh',
    backgroundColor: '#f0f2f5',
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center',
  },
  card: {
    backgroundColor: '#fff',
    padding: '2rem',
    borderRadius: '8px',
    boxShadow: '0 2px 10px rgba(0, 0, 0, 0.1)',
    textAlign: 'center',
  },
  button: {
    marginTop: '1rem',
    padding: '0.8rem 1.5rem',
    fontSize: '1rem',
    backgroundColor: '#dc3545',
    color: 'white',
    border: 'none',
    borderRadius: '5px',
    cursor: 'pointer',
  },
};

export default TareasPage;