// index.js
import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import { AppRoutes } from './Routes'; 
import reportWebVitals from './reportWebVitals';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <AppRoutes />
  </React.StrictMode>,
);

reportWebVitals();
