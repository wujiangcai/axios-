package top.wujiangcai.productmanagementapi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.wujiangcai.productmanagementapi.entity.Product;
@Mapper
public interface ProductMapper extends BaseMapper<Product> {
}
