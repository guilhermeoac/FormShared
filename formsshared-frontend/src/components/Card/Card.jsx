
import './Card.css';
const Card = ({index, children}) => {
  console.log("card key: " + index)
  return (
    <li className="round3" key={index}>
      {children}
    </li>
  );
}

export default Card;
