package in.techcamp.colorchartconnect.controller;

import in.techcamp.colorchartconnect.domain.user.model.MUser;
import in.techcamp.colorchartconnect.domain.user.service.UserService;
import in.techcamp.colorchartconnect.form.GroupOrder;
import in.techcamp.colorchartconnect.form.SignupForm;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

  @Autowired
  private UserService userService;

  @Autowired
  private ModelMapper modelMapper;

  @GetMapping("/signup")
  public String getSignup(Model model, Locale locale, @ModelAttribute SignupForm entity){
    //ユーザー登録画面に遷移
    return "user/signup";
  }

  //ユーザー登録
  @PostMapping("/signup")
  public String postSignup(Model model, Locale locale, @ModelAttribute @Validated(GroupOrder.class) SignupForm form, BindingResult bindingResult) {

    //入力チェック
    if(bindingResult.hasErrors()){
      //エラー発生時
      return getSignup(model, locale, form);
    }

    log.info(form.toString());

    //entity → MUser
    MUser user = modelMapper.map(form, MUser.class);

    //ユーザー登録
    userService.signup(user);

    //メイン画面へ遷移
    return "redirect:/";
  }
}