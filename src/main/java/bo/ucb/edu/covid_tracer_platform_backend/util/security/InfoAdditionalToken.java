package bo.ucb.edu.covid_tracer_platform_backend.util.security;

import bo.ucb.edu.covid_tracer_platform_backend.dao.UserDao;
import bo.ucb.edu.covid_tracer_platform_backend.dao.UserRoleDao;
import bo.ucb.edu.covid_tracer_platform_backend.model.UserM;
import bo.ucb.edu.covid_tracer_platform_backend.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class InfoAdditionalToken implements TokenEnhancer {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        Map<String, Object> info = new HashMap<>();

        UserM userM = userDao.findUserByUserName(oAuth2Authentication.getName());
        info.put("userId", userM.getUserId());
        info.put("userName", userM.getUserName());
        List<String> role = userRoleDao.findRoleByUserId(userM.getUserId());
        info.put("role", role);
        //info.put("info_adicional","Cualquier_valor".concat(oAuth2Authentication.getName()));

        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(info);

        return oAuth2AccessToken;
    }
}