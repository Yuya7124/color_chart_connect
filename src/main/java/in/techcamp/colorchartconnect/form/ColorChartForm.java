package in.techcamp.colorchartconnect.form;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ColorChartForm {
  private long product_id;
  private String part;
  private String maker;
  private int red;
  private int green;
  private int blue;
  private int coat;
  private int ratio;
}
