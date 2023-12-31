package in.techcamp.colorchartconnect.domain.user.service;

import in.techcamp.colorchartconnect.form.SignupForm;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
  //ユーザー登録
  public void signup(SignupForm form);

  public SignupForm getLoginUser(String userId);
}
