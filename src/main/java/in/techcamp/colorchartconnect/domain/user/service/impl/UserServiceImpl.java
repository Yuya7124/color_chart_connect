package in.techcamp.colorchartconnect.domain.user.service.impl;

import in.techcamp.colorchartconnect.domain.user.service.UserService;
import in.techcamp.colorchartconnect.entity.UserEntity;
import in.techcamp.colorchartconnect.form.SignupForm;
import in.techcamp.colorchartconnect.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  //ユーザー登録
  @Override
  public void signup(UserEntity entity){
    UserEntity user = new UserEntity();

    user.setNickname(user.getNickname());
    user.setEmail(user.getEmail());
    // パスワードをハッシュ化してセットする
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    userRepository.insertOne(entity);
  }

  @Override
  public SignupForm getLoginUser(String userId){
    return userRepository.findLoginUser(userId);
  }
}
