package in.techcamp.colorchartconnect.controller;

import in.techcamp.colorchartconnect.entity.SignupEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@Slf4j
public class SignupController {
  @GetMapping("/signup")
  public String getSignup(@ModelAttribute SignupEntity entity){
    //ユーザー登録画面に遷移
    return "user/signup";
  }

  //ユーザー登録
  @PostMapping("/signup")
  public String postSignup(@ModelAttribute @Validated SignupEntity entity) {
    log.info(entity.toString());
    //ログイン画面へ
    return "redirect:/login";
  }
}