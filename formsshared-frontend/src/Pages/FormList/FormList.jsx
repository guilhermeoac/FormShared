import List from '../../components/List/List';
import Card from '../../components/Card/Card';
import Button from '../../components/Button/Button';
import { useNavigate } from "react-router-dom";


const FormList = () => {
  
  const navigate = useNavigate();
  const navigateNewFormPage = () => {
    navigate("/new")
  
  }
  const mockList = JSON.parse("{\"content\":[{\"id\":4,\"url\":\"qwe\",\"title\":\"qwe\",\"fillTime\":1},{\"id\":7,\"url\":\"https://docs.google.com/forms/d/e/1FAIpQLSfHfXk3LX0JuGikFF82gJr4mVhRdkC7kuvOkkdglBadIlVHpw/viewform\",\"title\":\"exemplo\",\"fillTime\":1},{\"id\":5,\"url\":\"zxc\",\"title\":\"zxc\",\"fillTime\":2}],\"pageable\":{\"pageNumber\":0,\"pageSize\":10,\"sort\":{\"empty\":true,\"sorted\":false,\"unsorted\":true},\"offset\":0,\"paged\":true,\"unpaged\":false},\"last\":true,\"totalElements\":3,\"totalPages\":1,\"size\":10,\"number\":0,\"sort\":{\"empty\":true,\"sorted\":false,\"unsorted\":true},\"first\":true,\"numberOfElements\":3,\"empty\":false}")
 return <><List>
   {mockList.content.map(form => <><Card><span>Título:{form.title}</span><br></br>
     <span>Tempo de preenchimento:{form.title}min</span><br></br></Card></>)}
 </List><Button name="Castrar formulario" onclick ={navigateNewFormPage}></Button></>;
}

export default FormList;
