package top.wujiangcai.productmanagementapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import top.wujiangcai.productmanagementapi.entity.Product;
import top.wujiangcai.productmanagementapi.service.ProductService;

import java.util.List;

/**
 * @author dfysa
 * @data 2024/10/29 上午10:30
 * @description
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {
    private  final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.list();

    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Boolean createProduct(@RequestBody Product product){
        return productService.save(product);
    }

    //  更新商品
    @PutMapping("/{id}")
    public  Boolean updateProduct(@PathVariable Long id,@RequestBody Product product)
    {
        product.setId(id);
        return productService.updateById(product);
    }

    // 删除商品
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean deleteProduct(@PathVariable Long id){
        return productService.removeById(id);
    }

}