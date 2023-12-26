package in.techcamp.colorchartconnect.domain.user.service;

import in.techcamp.colorchartconnect.domain.user.model.MUser;

public interface UserService {

  //ユーザー登録
  public void signup(MUser user);

  public MUser getLoginUser(String userId);
}
