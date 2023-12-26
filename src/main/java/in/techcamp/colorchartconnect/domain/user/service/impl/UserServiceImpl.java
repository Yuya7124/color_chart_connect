package in.techcamp.colorchartconnect.domain.user.service.impl;

import in.techcamp.colorchartconnect.domain.user.model.MUser;
import in.techcamp.colorchartconnect.domain.user.service.UserService;
import in.techcamp.colorchartconnect.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userMapper;

  @Autowired
  private PasswordEncoder passwordEncoder;

  //ユーザー登録
  @Override
  public void signup(MUser user){
    String rawPassword = user.getPassword();
    user.setPassword(passwordEncoder.encode(rawPassword));
    userMapper.insertOne(user);
  }

  @Override
  public MUser getLoginUser(String userId){
    return userMapper.findLoginUser(userId);
  }
}
