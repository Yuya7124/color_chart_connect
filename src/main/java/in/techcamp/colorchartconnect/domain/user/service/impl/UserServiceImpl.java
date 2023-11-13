package in.techcamp.colorchartconnect.domain.user.service.impl;

import in.techcamp.colorchartconnect.domain.user.model.MUser;
import in.techcamp.colorchartconnect.domain.user.service.UserService;
import in.techcamp.colorchartconnect.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserMapper userMapper;

  //ユーザー登録
  @Override
  public void signup(MUser user){
    userMapper.insertOne(user);
  }
}
