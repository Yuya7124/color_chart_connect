package in.techcamp.colorchartconnect.domain.user.service.impl;

import in.techcamp.colorchartconnect.domain.user.service.UserService;
import in.techcamp.colorchartconnect.form.SignupForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    //@Autowired
    private UserService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SignupForm loginUser = service.getLoginUser(username);

        if(loginUser == null){
            throw new UsernameNotFoundException("user not found");
        }

    //    GrantedAuthority authority = new SimpleGrantedAuthority(loginUser.getRole());
    //    List<GrantedAuthority> authorities = new ArrayList<>();
    //    authorities.add(authority);

        UserDetails userDetails = (UserDetails) new User(loginUser.getNickname(),loginUser.getPassword(),null);

        return userDetails;
    }

}
