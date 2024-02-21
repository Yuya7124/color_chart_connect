package in.techcamp.colorchartconnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import in.techcamp.colorchartconnect.form.SignupForm;
import in.techcamp.colorchartconnect.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class LoginController {

  @Autowired
  private UserRepository userRepository;

  @GetMapping("/login")
  public String getLogin() {
    return "login/login";
  }

  @PostMapping("/login")
  public String postLogin(@PathVariable String nickname, Long userId, Model model, SignupForm form){
    
    model.addAttribute(nickname, "nickname");
    // ユーザ情報取得
    userRepository.findLoginUserName(nickname);
    log.info(form.toString());
    return "redirect:/";
  }
}