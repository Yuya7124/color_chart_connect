package in.techcamp.colorchartconnect.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

public class ProductResult {

  @Data
  public class ProductForm {
    private long product_id;
    private String product_name;
    private MultipartFile product_image;
    private String color_chart;
    private String comment;

  }
}
