import axios from 'axios'

const getSearchEndpoint = async ({page}) => {
  try {
    const response = await axios.get("http://localhost:8080/forms/available-forms", {
        params: {pageNumber: page, pageSize:8},
        headers: { userId: 3 }
    })
    return Promise.resolve(response.data)
  } catch (error) {
    console.log(error)
    return Promise.reject(error)
  }
}

export default getSearchEndpoint