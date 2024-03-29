package in.techcamp.colorchartconnect.repository;

import in.techcamp.colorchartconnect.domain.user.model.MUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    //ユーザー登録
    public int insertOne(MUser muser);
    //ユーザー情報取得
    public MUser findLoginUser(String nickname);
}
