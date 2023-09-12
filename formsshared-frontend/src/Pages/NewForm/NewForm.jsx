import List from '../../components/List/List';
import Card from '../../components/Card/Card';
import Button from '../../components/Button/Button';
import { useNavigate } from "react-router-dom";


const NewForm = () => {
  
  const navigate = useNavigate();
  const navigateFormListPage = () => {
    navigate("/")
  
  }
 return <div>
          <h1>Formulario de cadastro</h1>
          <Button name="Voltar" onclick={navigateFormListPage}></Button>
        </div>;
}

export default NewForm;
