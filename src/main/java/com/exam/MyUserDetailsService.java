package com.exam;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
    private UserDao dao;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=dao.userByName(username);
		if(user==null) {
			throw new UsernameNotFoundException("User not found 404");
		}
		return new MyUserDetails(user);
	}

}
