package bo.ucb.edu.covid_tracer_platform_backend.controller.api;

import bo.ucb.edu.covid_tracer_platform_backend.bl.TransactionBl;
import bo.ucb.edu.covid_tracer_platform_backend.bl.UserBl;
import bo.ucb.edu.covid_tracer_platform_backend.shared.dto.UserPasswordRequest;
import bo.ucb.edu.covid_tracer_platform_backend.shared.dto.UserRequest;
import bo.ucb.edu.covid_tracer_platform_backend.shared.model.Transaction;
import bo.ucb.edu.covid_tracer_platform_backend.bl.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/user")
public class UserApi {
    private UserBl userBl;
    private TransactionBl transactionBl;

    @Autowired
    public UserApi(UserBl userBl, TransactionBl transactionBl) {
        this.userBl = userBl;
        this.transactionBl = transactionBl;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus createUser(@RequestBody UserRequest userRequest, HttpServletRequest httpServletRequest, BindingResult result){
        if(!result.hasErrors()){
            Transaction transaction = TransactionUtil.createTransaction(httpServletRequest);
            transactionBl.createTransaction(transaction);
            UserRequest userResponse = userBl.createUser(userRequest, transaction);
            if(userResponse != null){
                return  HttpStatus.OK;
            } else {
                return HttpStatus.BAD_REQUEST;
            }

        }else {
            return HttpStatus.BAD_REQUEST;
        }


    }

    @RequestMapping(method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus updatePasswordUser(@Valid @RequestBody UserPasswordRequest userPasswordRequest, HttpServletRequest request, BindingResult result){
        if(!result.hasErrors()){
            Transaction transaction = TransactionUtil.createTransaction(request);
            transactionBl.createTransaction(transaction);
            UserPasswordRequest userPasswordReques1 = userBl.updatepasswordUser(userPasswordRequest, transaction);
            if (userPasswordReques1!=null){
                return HttpStatus.OK;
            }else{
                return HttpStatus.BAD_REQUEST;
            }
        } else{
            return HttpStatus.BAD_REQUEST;
        }
    }


}
