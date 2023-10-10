package in.techcamp.colorchartconnect.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SignupEntity {
  private String nickname;
  private String email;
  private String password;
}
