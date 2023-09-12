

import {
  BrowserRouter as Router,
  Routes,
  Route,
  useRoutes,
} from "react-router-dom";


import FormList from './Pages/FormList/FormList'
import NewForm from './Pages/NewForm/NewForm'

const App = () => {
  let routes = useRoutes([
    { path: "/", element: <FormList /> },
    { path: "/new", element: <NewForm /> },
    // ...
  ]);
  return routes;
};

const AppWrapper = () => {
  return (
    <Router>
      <App />
    </Router>
  );
};

export default AppWrapper;
