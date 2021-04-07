package bo.ucb.edu.covid_tracer_platform_backend.bl;

import bo.ucb.edu.covid_tracer_platform_backend.dao.UserDao;
import bo.ucb.edu.covid_tracer_platform_backend.dao.UserRoleDao;
import bo.ucb.edu.covid_tracer_platform_backend.model.UserM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    private UserDao userDao;
    private UserRoleDao userRoleDao;

    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    public UserService(UserDao userDao, UserRoleDao userRoleDao) {
        this.userDao = userDao;
        this.userRoleDao = userRoleDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserM userM = userDao.findUserByUserName(username);
        logger.error(username);
        if(userM != null){
            logger.error(username);
            List<String> roles = userRoleDao.findRoleByUserId(userM.getUserId());
            List<GrantedAuthority> authorities = roles.stream()
                    .map(role -> new SimpleGrantedAuthority(role))
                    .peek(authority -> logger.info("Role: " + authority.getAuthority()))
                    .collect(Collectors.toList());
            return new User(userM.getUserName(), userM.getPassword(), authorities);
        } else {
            throw new UsernameNotFoundException("User '"+username+"' not found!");
        }
    }
}
