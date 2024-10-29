<template>
  <div>
    <h1 class="text-xl mb-4">商品管理</h1>
    <el-button type="primary" @click="openCreateDialog">新增商品</el-button>
    <el-table :data="products" style="width: 100%" class="mt-4">
      <el-table-column
        prop="name"
        label="商品名称"
        width="180"
      ></el-table-column>
      <el-table-column prop="description" label="描述"></el-table-column>
      <el-table-column label="图片" width='120'>
       <template #default="scope" fit="cover">
           <el-image :src="scope.row.cover" />
       </template>
       </el-table-column>
      <el-table-column prop="price" label="价格" width="100"></el-table-column>
      <el-table-column prop="stock" label="库存" width="80"></el-table-column>
      <el-table-column label="操作" width="180">
        <template #default="scope">
          <el-button size="small" @click="openEditDialog(scope.row)"
            >编辑</el-button
          >
          <el-button
            size="small"
            type="danger"
            @click="deleteProduct(scope.row.id)"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>
    <el-dialog v-model="isDialogOpen" title="商品信息">
      <el-form :model="form">
        <el-form-item label="商品名称">
          <el-input v-model="form.name"></el-input>
        </el-form-item>
        <el-form-item label="描述">
          <el-input v-model="form.description"></el-input>
        </el-form-item>
        <el-form-item label="价格">
          <el-input v-model="form.price" type="number"></el-input>
        </el-form-item>
        <el-form-item label="库存">
          <el-input v-model="form.stock" type="number"></el-input>
        </el-form-item>
        <el-form-item label="图片">
          <el-input v-model="form.cover" ></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer">
        <el-button @click="isDialogOpen = false">取消</el-button>
        <el-button type="primary" @click="saveProduct">保存</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from "vue";
import { useProductStore } from "../stores/productStore";
import type { Product } from "../api/productService";
const productStore = useProductStore();
const { fetchProducts, createProduct, updateProduct, deleteProduct } =
  productStore;
const products = ref<Product[]>([]);
const isDialogOpen = ref(false);
const form = ref<Product>({
  name: "",
  description: "",
  price: 0,
  stock: 0,
  cover:"",
});
const loadProducts = async () => {
  products.value = await fetchProducts();
};
const openCreateDialog = () => {
  form.value = { name: "", description: "", price: 0, stock: 0,cover:""};
  isDialogOpen.value = true;
};
const openEditDialog = (product: Product) => {
  form.value = { ...product };
  isDialogOpen.value = true;
};
const saveProduct = async () => {
  try {
    if (form.value.id) {
      await updateProduct(form.value.id, form.value);
    } else {
      await createProduct(form.value);
    }
    await loadProducts(); // 刷新数据
  } catch (error) {
    console.error(error);
  } finally {
    isDialogOpen.value = false;
  }
};
// ⻚⾯加载时获取商品数据
onMounted(() => {
  loadProducts();
});
</script>
