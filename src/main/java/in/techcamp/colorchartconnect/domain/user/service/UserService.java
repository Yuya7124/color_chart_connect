package in.techcamp.colorchartconnect.domain.user.service;

import in.techcamp.colorchartconnect.domain.user.model.MUser;
import in.techcamp.colorchartconnect.entity.UserEntity;
import in.techcamp.colorchartconnect.form.SignupForm;
import org.springframework.stereotype.Service;


public interface UserService {
  //ユーザー登録
  public void signup(MUser muser);

  public SignupForm getLoginUser(String userId);
}
