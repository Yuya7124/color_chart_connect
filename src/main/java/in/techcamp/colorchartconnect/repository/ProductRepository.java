package in.techcamp.colorchartconnect.repository;

import in.techcamp.colorchartconnect.entity.ProductEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
//@Repository
public interface ProductRepository {
  @Select("select * from product")
  List<ProductEntity> findAll();
  @Insert("INSERT INTO product (product_name, nickname, color_chart, image_data, image_filename, comment) VALUES (#{product_name}, #{nickname},#{color_chart}, #{image_data}, #{image_filename}, #{comment})")
  void insert(@Param("product_name") String product_name, @Param("nickname") String nickname, @Param("color_chart")String color_chart, @Param("image_data")byte[] image_data, @Param("image_filename")String image_filename, @Param("comment")String comment);
  @Select("select * from product where product_id = #{product_id}")
  ProductEntity findById(long product_id);
  @Update("UPDATE product SET product_name = #{product_name}, color_chart = #{color_chart}, image_data = #{image_data}, image_filename = #{image_filename}, comment = #{comment} WHERE product_id = #{product_id}")
  void update(@Param("product_id")long product_id, @Param("product_name")String product_name, @Param("color_chart")String color_chart, @Param("image_data")byte[] image_data, @Param("image_filename")String image_filename, @Param("comment")String comment);
  @Delete("delete from product WHERE product_id = #{product_id}")
  void deleteById(long product_id);
}
