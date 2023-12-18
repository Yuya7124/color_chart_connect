package in.techcamp.colorchartconnect.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NonNull;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Id;

@Data
public class ProductForm {
  @Id
  @NotBlank
  private long product_id;
  @NotBlank
  private String product_name;
  private String file_name;
  private MultipartFile product_image;
  private String color_chart;
  private String comment;
}