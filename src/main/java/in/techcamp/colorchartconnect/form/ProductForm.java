package in.techcamp.colorchartconnect.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Data
public class ProductForm {
  @Id
  private long product_id;
  @NotBlank
  private String product_name;
  private MultipartFile product_image;
  private String color_chart;
  private String comment;

}