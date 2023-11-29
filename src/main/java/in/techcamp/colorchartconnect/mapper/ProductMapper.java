package in.techcamp.colorchartconnect.mapper;

import in.techcamp.colorchartconnect.entity.ColorChartEntity;
import in.techcamp.colorchartconnect.entity.ProductEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

@Mapper
public interface ProductMapper {
  @Select("select * from product")
  List<ProductEntity> findAll();
  @Insert("INSERT INTO product(product_name, comment, type, data) VALUES (#{product_name}, #{comment}, #{type}, #{data})")
  void insert(ProductEntity entity);
  @Select("select * from product where product_id = #{product_id}")
  ProductEntity findById(long product_id);
  @Update("UPDATE product SET product_name = #{product_name}, comment = #{comment}, type = #{type}, data = #{data} WHERE product_id =#{product_id}")
  void update(long product_id, String product_name, String comment, String type, byte[] data);
  @Delete("delete from product WHERE product_id = #{product_id}")
  void deleteById(Long product_id);
}
