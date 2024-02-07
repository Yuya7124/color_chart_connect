package in.techcamp.colorchartconnect.form;

import org.springframework.web.multipart.MultipartFile;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import java.io.IOException;

@Data
@Setter
@Getter
public class ProductForm {
  @Id
  private long product_id;
  @NotBlank
  private String product_name;
  @NotBlank
  private String color_chart;
  private MultipartFile file;
  private byte[] image_data;
  private String image_filename;
  private String comment;

  public void convertFileToBytes() throws IOException {
    this.image_data = file.getBytes();
  }
}