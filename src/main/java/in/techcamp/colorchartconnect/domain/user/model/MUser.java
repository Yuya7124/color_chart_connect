package in.techcamp.colorchartconnect.domain.user.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
public class MUser {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long user_id;
  private String nickname;

  private String email;

  private String password;
}
