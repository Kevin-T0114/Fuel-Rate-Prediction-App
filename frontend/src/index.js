import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';

const root = ReactDOM.createRoot(document.getElementById('root'));
document.body.style.backgroundColor = "#808080"
document.body.style.overflow = "hidden"
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);