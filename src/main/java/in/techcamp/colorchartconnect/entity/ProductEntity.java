package in.techcamp.colorchartconnect.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Data
public class ProductEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "product_id")
  private Long product_id;
  @Column(name = "product_name")
  private String product_name;
  @Column(name = "color_chart")
  private String color_chart;
  @Column(name = "image_data")
  private byte[] image_data;
  @Column(name = "image_filename")
  private String image_filename;
  @Column(name = "comment")
  private String comment;

  private String encodedImageData;
}

