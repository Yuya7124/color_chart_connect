package in.techcamp.colorchartconnect.repository;

import in.techcamp.colorchartconnect.entity.ProductEntity;
import in.techcamp.colorchartconnect.form.ProductForm;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductRepository {
  @Select("select * from product")
  List<ProductEntity> findAll();
  @Insert("INSERT INTO product (product_name, color_chart, image_data, image_filename, comment) VALUES (#{product_name}, #{color_chart}, #{image_data}, #{image_filename}, #{comment})")
  void insert(String product_name, String color_chart, byte[] image_data, String image_filename, String comment);
  @Select("select * from product where product_id = #{product_id}")
  ProductEntity findById(long product_id);
  @Update("UPDATE product SET product_name = #{product_name}, color_chart = #{color_chart}, image_data = #{image_data}, image_filename = #{image_filename} ,comment = #{comment} WHERE product_id =#{product_id}")
  void update(Long product_id, String product_name, String color_chart, byte[] image_data, String image_filename, String comment);
  @Delete("delete from product WHERE product_id = #{product_id}")
  void deleteById(Long product_id);
}
