package in.techcamp.colorchartconnect.domain.user.service.impl;

import in.techcamp.colorchartconnect.domain.user.model.MUser;
import in.techcamp.colorchartconnect.domain.user.service.UserService;
import in.techcamp.colorchartconnect.form.SignupForm;
import in.techcamp.colorchartconnect.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class UserDetailServiceImpl implements UserDetailsService {

    private UserService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SignupForm loginUser = service.getLoginUser(username);

        if(loginUser == null){
            throw new UsernameNotFoundException("user not found");
        }

//        GrantedAuthority authority = new SimpleGrantedAuthority(loginUser.getRole());
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        authorities.add(authority);

        UserDetails userDetails = (UserDetails) new User(loginUser.getNickname(),loginUser.getPassword(),null);

        return userDetails;
    }

}
