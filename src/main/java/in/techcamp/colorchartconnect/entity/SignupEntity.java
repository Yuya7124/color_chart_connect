package in.techcamp.colorchartconnect.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@Data
public class SignupEntity {


  @NotBlank(groups = ValidGroup1.class)
  private String nickname;
  @NotBlank(groups = ValidGroup1.class)
  @Email(groups = ValidGroup2.class)
  private String email;
  @NotBlank(groups = ValidGroup1.class)
  @Length(min = 6, max = 100, groups = ValidGroup2.class)
  @Pattern(regexp = "^[a-zA-Z0-9]+$", groups = ValidGroup2.class)
  private String password;
}
