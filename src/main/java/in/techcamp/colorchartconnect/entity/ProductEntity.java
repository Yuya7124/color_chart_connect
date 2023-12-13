package in.techcamp.colorchartconnect.entity;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
@Data
public class ProductEntity {
  @Id
  @Column(name = "product_id")
  private long product_id;
  @Column(name = "product_name")
  private String product_name;
  private String product_image;
  @Column(name = "color_chart")
  private String color_chart;
  @Column(name = "comment")
  private String comment;
}
