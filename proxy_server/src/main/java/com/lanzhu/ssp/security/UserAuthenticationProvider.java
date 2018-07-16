package com.lanzhu.ssp.security;

import com.lanzhu.ssp.dao.CompanyMapper;
import com.lanzhu.ssp.dao.UserMapper;
import com.lanzhu.ssp.entities.User;
import com.lanzhu.ssp.exception.BizRuntimeException;
import com.lanzhu.ssp.exception.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.util.StringUtils;

import javax.inject.Inject;

@Slf4j
public class UserAuthenticationProvider implements AuthenticationProvider {

    private UserMapper userMapper;
    private CompanyMapper companyMapper;

    @Inject
    public UserAuthenticationProvider(UserMapper userMapper, CompanyMapper companyMapper) {
        this.userMapper = userMapper;
        this.companyMapper = companyMapper;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // 获取认证的用户名 & 密码
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        if (StringUtils.isEmpty(username)) {
            log.warn("username missing");
            throw new BizRuntimeException(ErrorCode.LOGIN_USERNAME_MISSING);
        }
        return null;
//        // identifier could by username/mobile/qq/weixin/weibo etc...
//        User user = userMapper.findUserByNameOrMobile(username);
//        if (user == null) {
//            log.warn("username/mobile = " + username + " not found");
//            throw new BizRuntimeException(ErrorCode.USER_NOT_FOUND);
//        }
////        if (UserStatus.NORMAL.getCode() != user.getStatus()) {
////            log.warn("user status is not in normal status. userId:{}, status:{}", user.getId(), user.getStatus());
////            throw new BizRuntimeException(ErrorCode.USER_LOGIN_UN_ACTIVATE);
////        }
//
//        // 认证逻辑
//        if (new BCryptPasswordEncoder().matches(password, user.getCredential())) {
//            log.info("Login in successfully, username={}", username);
//            Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//            List<UserRoute> userRoutes = userRouteMapper.getByUserId(user.getId());
//            if (userRoutes != null) {
//                for (UserRoute route : userRoutes) {
//                    grantedAuthorities.add(new SimpleGrantedAuthority(route.getRouteName()));
//                }
//            }
//
//            Authentication auth = new UsernamePasswordAuthenticationToken(user.getCompactUser(), password, grantedAuthorities);
//            return auth;
//        } else {
//            log.warn("Login password not match, username={}", username);
//            throw new BizRuntimeException(ErrorCode.LOGIN_PASSWORD_INVALID);
//        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
