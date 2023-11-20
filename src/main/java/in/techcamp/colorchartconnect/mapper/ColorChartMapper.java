package in.techcamp.colorchartconnect.mapper;

import in.techcamp.colorchartconnect.entity.ColorChartEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ColorChartMapper {
  @Select("select * from color_chart")
  List<ColorChartEntity> findAll();
}
