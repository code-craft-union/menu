import axios from 'axios'

const service = axios.create({
  baseURL: '',
  timeout: 60000
})

service.interceptors.response.use(
  response => {
    const { data } = response
    return data
  },
  error => {
    console.log(error)
  }
)

export default service