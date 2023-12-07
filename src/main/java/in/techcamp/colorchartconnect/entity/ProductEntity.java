package in.techcamp.colorchartconnect.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
@Data
public class ProductEntity {
  @Id
  private long product_id;
  @NotBlank
  private String product_name;
  private String comment;
}
