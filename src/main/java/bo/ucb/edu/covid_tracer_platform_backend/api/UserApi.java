package bo.ucb.edu.covid_tracer_platform_backend.api;

import bo.ucb.edu.covid_tracer_platform_backend.bl.TransactionBl;
import bo.ucb.edu.covid_tracer_platform_backend.bl.UserBl;
import bo.ucb.edu.covid_tracer_platform_backend.dto.UserRequest;
import bo.ucb.edu.covid_tracer_platform_backend.model.Transaction;
import bo.ucb.edu.covid_tracer_platform_backend.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
    public ResponseEntity createUser(@RequestBody UserRequest userRequest, HttpServletRequest httpServletRequest){
        Transaction transaction = TransactionUtil.createTransaction(httpServletRequest);
        transactionBl.createTransaction(transaction);
        UserRequest userResponse = userBl.createUser(userRequest, transaction);
        if(userResponse != null){
            return new ResponseEntity(userResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity("User already exists", HttpStatus.BAD_REQUEST);
        }
    }
}
