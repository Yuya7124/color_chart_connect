package in.techcamp.colorchartconnect.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SignupEntity {
  @NotBlank
  private String nickname;
  @NotBlank
  private String email;
  @NotBlank
  private String password;
}
