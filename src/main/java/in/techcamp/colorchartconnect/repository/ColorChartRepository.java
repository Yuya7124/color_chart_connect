package in.techcamp.colorchartconnect.repository;

import in.techcamp.colorchartconnect.form.ColorChartForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ColorChartRepository {
  @Select("select * from color_chart")
  List<ColorChartForm> findAll();
}
