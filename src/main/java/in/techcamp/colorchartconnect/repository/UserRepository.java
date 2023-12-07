package in.techcamp.colorchartconnect.repository;

import in.techcamp.colorchartconnect.domain.user.model.MUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
  //ユーザー登録
  public int insertOne(MUser user);
}
