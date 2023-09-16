import getSearchEndpoint from '../../../services/form/searchEndpoint'

const REQUEST_SEARCH_API = 'REQUEST_SEARCH_API'
const REQUEST_SEARCH_API_SUCCESS = 'REQUEST_SEARCH_API_SUCCESS'
const REQUEST_SEARCH_API_FAILURE = 'REQUEST_SEARCH_API_FAILURE'

const requestSearchApi = ({page}) => ({
  type: REQUEST_SEARCH_API,
  page: page
})

const requestSearchApiSuccess = ({ content, page, last }) => ({
  type: REQUEST_SEARCH_API_SUCCESS,
  content,
  page,
  last
})

const requestSearchApiFailure = (error) => ({
  type: REQUEST_SEARCH_API_FAILURE,
  error
})

export const getSearch = ({page}) => {
  return (dispatch) => {
    console.log("getSearch" + page)
    dispatch(requestSearchApi({page}))
    return getSearchEndpoint({page}).then(
      ({ content, pageable, last }) =>
        dispatch(
          requestSearchApiSuccess({
            content: content,
            page: pageable.pageNumber + 1,
            last: last
          })
        ),
      ({ message }) => dispatch(requestSearchApiFailure(message))
    )
  }
}

const INITIAL_STATE = {
  content: [],
  error: false,
  loading: true,
  page: -1,
  last: false
}

const reducer = (state = INITIAL_STATE, action) => {
  switch (action.type) {
    case REQUEST_SEARCH_API:
      return {
        ...state,
        loading: true
      }
    case REQUEST_SEARCH_API_SUCCESS:
      return {
        ...state,
        loading: false,
        content: action.content,
        page: action.page,
        last: action.last
      }
    case REQUEST_SEARCH_API_FAILURE:
      return {
        ...state,
        loading: false,
        error: action.error
      }

    default:
      return state
  }
}
export default reducer