package in.techcamp.colorchartconnect.domain.user.service.impl;

import in.techcamp.colorchartconnect.form.SignupForm;
import in.techcamp.colorchartconnect.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SignupForm loginUser = userRepository.findLoginUserName(username);

        if(loginUser == null){
            throw new UsernameNotFoundException("user not found");
        }
       
       String role = "GENERAL";
       GrantedAuthority authority = new SimpleGrantedAuthority(role);
       List<GrantedAuthority> authorities = new ArrayList<>();
       authorities.add(authority);

        UserDetails userDetails = (UserDetails) new User(loginUser.getNickname(),loginUser.getPassword(),authorities);

        return userDetails;
    }
}
