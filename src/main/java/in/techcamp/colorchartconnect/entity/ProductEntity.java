package in.techcamp.colorchartconnect.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
@Data
public class ProductEntity {
  @Id
  @Column(name = "product_id")
  private Long product_id;

  @Column(name = "product_name")
  private String product_name;

  @Column(name = "color_chart")
  private String color_chart;

  @Column(name = "comment")
  private String comment;
}

