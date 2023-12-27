package in.techcamp.colorchartconnect.entity;

import in.techcamp.colorchartconnect.form.ValidGroup1;
import in.techcamp.colorchartconnect.form.ValidGroup2;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @NotBlank
  @Column(name = "user_id")
  private Long user_id;
  @NotBlank(groups = ValidGroup1.class)
  @Column(name = "nickname")
  private String nickname;
  @NotBlank(groups = ValidGroup1.class)
  @Email(groups = ValidGroup2.class)
  @Column(name = "email")
  private String email;
  @NotBlank(groups = ValidGroup1.class)
  @Length(min = 6, max = 100, groups = ValidGroup2.class)
  @Pattern(regexp = "^[a-zA-Z0-9]+$", groups = ValidGroup2.class)
  @Column(name = "password")
  private String password;
}
