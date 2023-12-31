package in.techcamp.colorchartconnect.controller;

import in.techcamp.colorchartconnect.domain.user.service.impl.UserServiceImpl;
import in.techcamp.colorchartconnect.form.GroupOrder;
import in.techcamp.colorchartconnect.form.SignupForm;
import in.techcamp.colorchartconnect.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
@Slf4j
public class SignupController {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UserServiceImpl userServiceImpl;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @GetMapping("/signup")
  public String getSignup(Model model, Locale locale, @ModelAttribute SignupForm form){
    //ユーザー登録画面に遷移
    return "user/signup";
  }

  //ユーザー登録
  @PostMapping("/signup")
  public String postSignup(Model model, Locale locale, @ModelAttribute @Validated(GroupOrder.class) SignupForm form, BindingResult bindingResult) {

    //入力チェック
    if(bindingResult.hasErrors()){
      //エラー発生時
      String error_msg = bindingResult.getAllErrors().stream()
              .map(err -> err.getDefaultMessage())
              .collect(Collectors.joining(", "));
      return getSignup(model, locale, form);
    }

    log.info(form.toString());
    String rawPassword = form.getPassword();
    form.setPassword(passwordEncoder.encode(rawPassword));

    //ユーザー登録
    userRepository.insertOne(form.getNickname(), form.getEmail(), rawPassword);

    //メイン画面へ遷移
    return "redirect:/login";
  }
}