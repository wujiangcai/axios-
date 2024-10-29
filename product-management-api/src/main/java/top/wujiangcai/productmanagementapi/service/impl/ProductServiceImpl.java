package top.wujiangcai.productmanagementapi.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.wujiangcai.productmanagementapi.entity.Product;
import top.wujiangcai.productmanagementapi.mapper.ProductMapper;
import top.wujiangcai.productmanagementapi.service.ProductService;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
}
