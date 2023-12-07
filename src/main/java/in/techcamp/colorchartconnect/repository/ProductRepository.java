package in.techcamp.colorchartconnect.repository;

import in.techcamp.colorchartconnect.form.ProductForm;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

@Mapper
public interface ProductRepository {
  @Select("select * from product")
  List<ProductForm> findAll();
  @Insert("INSERT INTO product(product_name, comment, type, data) VALUES (#{product_name}, #{comment}, #{type}, #{data})")
  ProductForm insert(ProductForm form);
  @Select("select * from product where product_id = #{product_id}")
  ProductForm findById(long product_id);
  @Update("UPDATE product SET product_name = #{product_name}, comment = #{comment}, type = #{type}, data = #{data} WHERE product_id =#{product_id}")
  void update(long product_id, String product_name, String comment, String type, byte[] data);
  @Delete("delete from product WHERE product_id = #{product_id}")
  void deleteById(Long product_id);
}
