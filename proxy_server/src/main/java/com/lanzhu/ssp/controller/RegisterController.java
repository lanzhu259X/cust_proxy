package com.lanzhu.ssp.controller;

import com.lanzhu.ssp.constants.IdentifierType;
import com.lanzhu.ssp.constants.UserRole;
import com.lanzhu.ssp.constants.UserStatus;
import com.lanzhu.ssp.dao.CompanyMapper;
import com.lanzhu.ssp.dao.UserAuthMapper;
import com.lanzhu.ssp.dao.UserMapper;
import com.lanzhu.ssp.dto.RegisterBody;
import com.lanzhu.ssp.entities.Company;
import com.lanzhu.ssp.entities.User;
import com.lanzhu.ssp.entities.UserAuth;
import com.lanzhu.ssp.exception.BizException;
import com.lanzhu.ssp.exception.BizRuntimeException;
import com.lanzhu.ssp.exception.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Slf4j
@RestController
public class RegisterController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserAuthMapper userAuthMapper;
    @Autowired
    private CompanyMapper companyMapper;


    /**
     * 注册
     * @param body
     * @return
     * @throws Exception
     */
    @Transactional
    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> register(@RequestBody RegisterBody body) throws Exception {
        if (body == null) {
            throw new BizException(ErrorCode.PARAM_ERROR);
        }
        if (StringUtils.isEmpty(body.getPhone())) {
            log.warn("register but phone is empty.");
            throw new BizException(ErrorCode.PHONE_EMPTY);
        }
        if (StringUtils.isEmpty(body.getPassword())) {
            log.warn("register but password is empty.");
            throw new BizException(ErrorCode.PASSWORD_EMPTY);
        }
        if (StringUtils.isEmpty(body.getCompanyName())) {
            log.warn("register but company name empty.");
            throw new BizException(ErrorCode.COMPANY_NAME_EMPTY);
        }

        // validate phone was register ?
        User phoneUser = userMapper.findByPhone(body.getPhone());
        if (phoneUser != null) {
            log.warn("register user but phone was registered, {}", body.getPhone());
            throw new BizException(ErrorCode.PHONE_WAS_REGISTERED);
        }

        // create company info.

        Company company = new Company();
        company.setCompanyName(body.getCompanyName());
        company.setEnabled(true);
        company.setCreatedBy(body.getPhone());
        company.setCreatedTime(new Date());
        int companyCount = companyMapper.insert(company);
        if (companyCount <= 0 || company.getId() == null) {
            log.error("register user but create company fail.");
            throw new BizRuntimeException(ErrorCode.DB_INSER_FAIL);
        }

        //create user info
        User user = new User();
        user.setCompanyId(company.getId());
        user.setPhone(body.getPhone());
        user.setUserRole(UserRole.ROOT.name()); //注册的角色都是直接设置为仓管员，其他所有人员通过上级建立
        user.setStatus(UserStatus.NORMAL.name());
        user.setCreatedBy(body.getPhone());
        user.setCreatedTime(new Date());
        int userCount = userMapper.insert(user);
        if (userCount <= 0 || user.getId() == null) {
            log.error("register user but create user info fail.");
            throw new BizRuntimeException(ErrorCode.DB_INSER_FAIL);
        }

        //create user auth info
        UserAuth userAuth = new UserAuth();
        userAuth.setUserId(user.getId());
        userAuth.setIdentifierType(IdentifierType.PHONE.name());
        userAuth.setIdentifier(body.getPhone());
        userAuth.setVerified(true);
        userAuth.setCredential(new BCryptPasswordEncoder().encode(body.getPassword()));
        userAuth.setCreatedTime(new Date());
        userAuth.setCreatedBy(String.valueOf(user.getId()));
        int authCount = userAuthMapper.insert(userAuth);
        if (authCount <= 0) {
            log.error("register user but create user auth fail.");
            throw new BizRuntimeException(ErrorCode.DB_INSER_FAIL);
        }

        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "logoff", method = RequestMethod.GET)
    public ResponseEntity<String> logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            log.info("user:{} logout system.", auth.getPrincipal());
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return ResponseEntity.ok().build();
    }

}
