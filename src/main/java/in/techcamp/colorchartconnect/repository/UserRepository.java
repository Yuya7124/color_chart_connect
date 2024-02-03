package in.techcamp.colorchartconnect.repository;

import in.techcamp.colorchartconnect.form.SignupForm;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
//@Repository
public interface UserRepository {
  //ユーザー登録
  @Insert("INSERT INTO user (nickname, email, password) VALUES (#{nickname}, #{email}, #{password})")
  void insertOne(String nickname, String email, String password);

  public SignupForm findLoginUser(String userId);
}