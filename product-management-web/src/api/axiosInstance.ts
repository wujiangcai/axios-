import axios from 'axios';
const apiInstance = axios.create({
 baseURL: 'http://localhost:8080/api',
 timeout: 10000,
});
apiInstance.interceptors.response.use(
 response => response,
 error => {
 console.error(error.response ? error.response.data : '请求失败');
 return Promise.reject(error);
 }
);
export default apiInstance;