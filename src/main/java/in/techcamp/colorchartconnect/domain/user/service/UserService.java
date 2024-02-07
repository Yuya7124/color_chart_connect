package in.techcamp.colorchartconnect.domain.user.service;

import in.techcamp.colorchartconnect.domain.user.model.MUser;
import in.techcamp.colorchartconnect.form.SignupForm;


public interface UserService {
  //ユーザー登録
  public void signup(MUser muser);
  
  //ログインユーザー情報取得
  public SignupForm getLoginUser(String nickname);
}
