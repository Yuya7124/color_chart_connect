package in.techcamp.colorchartconnect.mapper;

import in.techcamp.colorchartconnect.entity.ColorChartEntity;
import in.techcamp.colorchartconnect.entity.ProductEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductMapper {
  @Select("select * from color_chart")
  List<ProductEntity> findAll();

  @Insert("insert into product(product_name) values (#{product_name})")
  void insert(String product_name);
}
