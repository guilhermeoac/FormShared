import List from "../../components/List/List";
import Card from "../../components/Card/Card";
import Button from "../../components/Button/Button";
import { useNavigate } from "react-router-dom";
import { getSearch } from "../../redux/modules/form/search";
import { connect } from "react-redux";
import PropTypes from "prop-types";
import { useEffect, useState } from "react";

var list = [];
const FormList = ({ getSearchAction, content, searchLoading, page, last }) => {
  const [pageNumber, setPageNumber] = useState(0);
  useEffect(() => {
    if (!last) {
      getSearchAction({ page: pageNumber });
      list.push(...content);
    }
  }, [pageNumber]);

  useEffect(() => {
    if (content && content.length > 0) list.push(...content);
  }, [content]);

  const navigate = useNavigate();
  const navigateNewFormPage = () => {
    navigate("/new");
  };
  return (
    <>
      <List
        scrollBottomFun={() => {
          getSearchAction({ page: pageNumber + 1 });
        }}
      >
        {list.map((form) => (
          <>
            <Card index={form.id}>
              <span>Título:{form.title}</span>
              <br></br>
              <span>Tempo de preenchimento:{form.fillTime}min</span>
              <br></br>
            </Card>
          </>
        ))}
      </List>
      <Button
        name="Cadastrar formulario"
        onclick={navigateNewFormPage}
      ></Button>
    </>
  );
};

const mapStateToProps = ({ search }) => {
  return {
    content: search.content,
    page: search.page,
    last: search.last,
    searchLoading: search.loading,
  };
};

const mapDispatchToProps = {
  getSearchAction: getSearch,
};

FormList.propTypes = {
  searchLoading: PropTypes.bool,
  getSearchAction: PropTypes.func,
  page: PropTypes.number,
  last: PropTypes.bool,
  content: PropTypes.arrayOf(
    PropTypes.shape({
      id: PropTypes.string.isRequired,
      url: PropTypes.string.isRequired,
      title: PropTypes.string.isRequired,
      fillTime: PropTypes.string.isRequired,
    })
  ),
};

export default connect(mapStateToProps, mapDispatchToProps)(FormList);
