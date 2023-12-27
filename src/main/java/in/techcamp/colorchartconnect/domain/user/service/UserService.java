package in.techcamp.colorchartconnect.domain.user.service;

import in.techcamp.colorchartconnect.entity.UserEntity;

public interface UserService {

  //ユーザー登録
  public void signup(UserEntity entity);

  public UserEntity getLoginUser(String userId);
}
