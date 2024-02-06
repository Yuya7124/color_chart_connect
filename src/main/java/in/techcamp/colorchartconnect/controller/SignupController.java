package in.techcamp.colorchartconnect.controller;

import in.techcamp.colorchartconnect.domain.user.service.UserService;
import in.techcamp.colorchartconnect.entity.UserEntity;
import in.techcamp.colorchartconnect.form.GroupOrder;
import in.techcamp.colorchartconnect.form.SignupForm;
import in.techcamp.colorchartconnect.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
@Slf4j
public class SignupController {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UserService userService;

  @Autowired
  private ModelMapper modelMapper;

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

    // 入力チェック
    if(bindingResult.hasErrors()){
      // エラー発生時
      String error_msg = bindingResult.getAllErrors().stream()
              .map(err -> err.getDefaultMessage())
              .collect(Collectors.joining(", "));
      return getSignup(model, locale, form);
    }

    String rawPassword = form.getPassword();
    // UserEntity を作成して UserRepository に渡す
    UserEntity entity = new UserEntity();
    entity.setNickname(form.getNickname());
    entity.setEmail(form.getEmail());
    entity.setPassword(passwordEncoder.encode(rawPassword));

//    // ユーザー登録
    model.addAttribute("signupForm", form);
    userRepository.insertOne(form.getNickname(), form.getEmail(), form.getPassword());
    log.info(form.toString());

//    MUser muser = modelMapper.map(form, MUser.class);
//    userService.signup(muser);

    //メイン画面へ遷移
    return "redirect:/login";
  }
}