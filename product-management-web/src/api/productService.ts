import apiInstance from './axiosInstance';
export interface Product {
 id?: number;
 name: string;
 description: string;
 price: number;
 stock: number;
 cover: string;
}
const productService = {
 getProducts() {
 return apiInstance.get<Product[]>('/products');
 },
 getProductById(id: number) {
 return apiInstance.get<Product>(`/products/${id}`);
 },
 createProduct(data: Product) {
 return apiInstance.post('/products', data);
 },
 updateProduct(id: number, data: Product) {
 return apiInstance.put(`/products/${id}`, data);
 },
 deleteProduct(id: number) {
 return apiInstance.delete(`/products/${id}`);
 },
};
export default productService;