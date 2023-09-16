

import {
  BrowserRouter as Router,
  Routes,
  Route,
  useRoutes,
} from "react-router-dom";


import FormList from './Pages/FormList/FormList'
import NewForm from './Pages/NewForm/NewForm'
import {Provider} from 'react-redux'
import store from './redux/store'

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
    <Provider store={store}>
      <Router>
        <App />
      </Router>
    </Provider>
  );
};

export default AppWrapper;
