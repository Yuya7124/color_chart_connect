package in.techcamp.colorchartconnect.controller;

import in.techcamp.colorchartconnect.entity.GroupOrder;
import in.techcamp.colorchartconnect.entity.SignupEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

@Controller
@RequestMapping("/user")
@Slf4j
public class SignupController {
  @GetMapping("/signup")
  public String getSignup(Model model, Locale locale, @ModelAttribute SignupEntity entity){
    //ユーザー登録画面に遷移
    return "user/signup";
  }

  //ユーザー登録
  @PostMapping("/signup")
  public String postSignup(Model model, Locale locale, @ModelAttribute @Validated(GroupOrder.class) SignupEntity entity, BindingResult bindingResult) {
    log.info(entity.toString());

    //入力チェック
    if(bindingResult.hasErrors()){
      //エラー発生時
      return getSignup(model, locale, entity);
    }
    //ログイン画面へ
    return "redirect:/login";
  }
}