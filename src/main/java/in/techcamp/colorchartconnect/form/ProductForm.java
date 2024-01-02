package in.techcamp.colorchartconnect.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import javax.persistence.Id;

@Data
public class ProductForm {
  @Id
  @NotBlank
  private long product_id;
  @NotBlank
  private String product_name;
  private String color_chart;
  @NotBlank
  private byte[] image_data;
  @NotBlank
  private String image_filename;
  private String comment;
}