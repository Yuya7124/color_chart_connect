package in.techcamp.colorchartconnect.repository;

import in.techcamp.colorchartconnect.form.SignupForm;

import org.apache.ibatis.annotations.*;

@Mapper
public interface UserRepository {
  //ユーザー登録
  @Insert("INSERT INTO user (nickname, email, password, role) VALUES (#{nickname}, #{email}, #{password}, #{role})")
  void insertOne(@Param("nickname") String nickname, @Param("email") String email, @Param("password") String password, @Param("role") String role);
  @Select("select * from user where nickname = #{nickname}")
  public SignupForm findLoginUser(String userId);
}