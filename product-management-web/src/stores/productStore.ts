// src/stores/productStore.ts
import { defineStore } from "pinia";
import productService, { Product } from "../api/productService";
export const useProductStore = defineStore("productStore", () => {
 const fetchProducts = async (): Promise<Product[]> => {
 try {
 const response = await productService.getProducts();
 return response.data;
 } catch (err: any) {
 throw new Error(err.message || "加载商品失败");
 }
 };
 const createProduct = async (data: Product): Promise<void> => {
 try {
 await productService.createProduct(data);
 } catch (err: any) {
 throw new Error(err.message || "创建商品失败");
 }
 };
 const updateProduct = async (id: number, data: Product): Promise<void> => {
 try {
 await productService.updateProduct(id, data);
 } catch (err: any) {
 throw new Error(err.message || "更新商品失败");
 }
 };
 const deleteProduct = async (id: number): Promise<void> => {
 try {
 await productService.deleteProduct(id);
 } catch (err: any) {
 throw new Error(err.message || "删除商品失败");
 }
 };
 return {
 fetchProducts,
 createProduct,
 updateProduct,
 deleteProduct,
};
});