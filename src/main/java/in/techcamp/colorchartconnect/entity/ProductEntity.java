package in.techcamp.colorchartconnect.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
public class ProductEntity {
  private long product_id;
  @NotBlank
  private String product_name;
  private String comment;
  private String type;
  private byte[] data;
}