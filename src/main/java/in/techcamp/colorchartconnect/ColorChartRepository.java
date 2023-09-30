package in.techcamp.colorchartconnect;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ColorChartRepository {
  @Select("select * from color_charts")
  List<ColorChartEntity> findAll();
}
