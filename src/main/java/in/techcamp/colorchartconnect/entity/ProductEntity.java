package in.techcamp.colorchartconnect.entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ProductEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long product_id;
  @NotBlank
  private String product_name;
  private String comment;
  private String type;

  @Lob
//  @Type(type = "org.hibernate.type.BinaryType")
  @Column(name = "data")
  private byte[] data;

  public ProductEntity(String product_name, String type, byte[] data){
    this.product_name = product_name;
    this.type = type;
    this.data = data;
  }
}