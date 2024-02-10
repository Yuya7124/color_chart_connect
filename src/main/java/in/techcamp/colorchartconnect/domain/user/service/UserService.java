package in.techcamp.colorchartconnect.domain.user.service;

import in.techcamp.colorchartconnect.entity.UserEntity;
import in.techcamp.colorchartconnect.form.SignupForm;


public interface UserService {
  //ユーザー登録
  public void signup(UserEntity user);
  
  //ログインユーザー情報取得
  public SignupForm getLoginUser(String nickname);
}
