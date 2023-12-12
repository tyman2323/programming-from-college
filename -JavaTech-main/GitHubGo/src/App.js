/* This is all unnecessary and can be deleted */

import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import { HomeScreen } from './HomeScreen';
import { SearchScreen } from './SearchScreen';


export const AppRoutes = () => {
 return (
   <Router>
     <Routes>
       <Route path="/" element={<HomeScreen />} />
       <Route path="/SearchScreen" element={<SearchScreen />} />
     </Routes>
   </Router>
 );
};

/* This is all unnecessary and can be deleted */