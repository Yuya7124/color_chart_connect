package in.techcamp.colorchartconnect.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NonNull;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
public class ProductForm {
  @Id
  @NotBlank
  private long product_id;
  @NotBlank
  private String product_name;
  private String color_chart;
  private byte[] image_data;
  private String image_filename;
  private String comment;
}