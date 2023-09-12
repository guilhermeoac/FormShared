
const Button = ({disabled = false, onclick, name}) => {
  return (
    <button type="button" disabled={disabled} onClick={onclick}>{name}</button>
  );
}

export default Button;
