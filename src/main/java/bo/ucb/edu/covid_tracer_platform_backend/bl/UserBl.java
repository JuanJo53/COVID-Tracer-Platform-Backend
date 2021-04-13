package bo.ucb.edu.covid_tracer_platform_backend.bl;

import bo.ucb.edu.covid_tracer_platform_backend.dao.PersonDao;
import bo.ucb.edu.covid_tracer_platform_backend.dao.TransactionDao;
import bo.ucb.edu.covid_tracer_platform_backend.dao.UserDao;
import bo.ucb.edu.covid_tracer_platform_backend.dao.UserRoleDao;
import bo.ucb.edu.covid_tracer_platform_backend.dto.UserRequest;
import bo.ucb.edu.covid_tracer_platform_backend.model.Person;
import bo.ucb.edu.covid_tracer_platform_backend.model.Transaction;
import bo.ucb.edu.covid_tracer_platform_backend.model.UserM;
import bo.ucb.edu.covid_tracer_platform_backend.model.UserRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserBl {
    private PersonDao personDao;
    private UserDao userDao;
    private UserRoleDao userRoleDao;
    private TransactionDao transactionDao;
    private BCryptPasswordEncoder passwordEncoder;

    private static Logger logger = LoggerFactory.getLogger(UserBl.class);

    @Autowired
    public UserBl(PersonDao personDao, UserRoleDao userRoleDao, UserDao userDao, TransactionDao transactionDao, BCryptPasswordEncoder passwordEncoder) {
        this.personDao = personDao;
        this.userRoleDao = userRoleDao;
        this.transactionDao = transactionDao;
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    public UserRequest createUser(UserRequest userRequest, Transaction transaction){
        logger.error(userRequest.getUserName());
        UserM userMValidator = userDao.findUserByUserName(userRequest.getUserName());
        if(userMValidator == null){
           Person person = new Person();
           UserM userM = new UserM();
           UserRole userRole = new UserRole();

           person.setFirstName(userRequest.getFirstName());
           person.setFirstSurname(userRequest.getFirstSurname());
           person.setSecondSurname(userRequest.getSecondSurname());
           person.setTransaction(transaction);
           personDao.createPerson(person);
           Integer lastPersonId = transactionDao.getLastInsertId();

           userM.setPersonId(lastPersonId);
           userM.setEmail(userRequest.getEmail());
           userM.setUserName(userRequest.getUserName());
           String password = passwordEncoder.encode(userRequest.getPassword());
           userM.setPassword(password);
           userM.setTransaction(transaction);
           userDao.createUser(userM);
           Integer lastUserId = transactionDao.getLastInsertId();

           userRole.setUserId(lastUserId);
           userRole.setRoleId(userRequest.getRole());
           userRole.setTransaction(transaction);
           userRoleDao.createUserRole(userRole);

           return userRequest;
        }else{
            return null;
        }
        /*Person person = new Person();
        UserM userM = new UserM();
        UserRole userRole = new UserRole();

        person.setFirstName(userRequest.getFirstName());
        person.setFirstSurname(userRequest.getFirstSurname());
        person.setSecondSurname(userRequest.getSecondSurname());
        person.setTransaction(transaction);
        personDao.createPerson(person);
        Integer lastPersonId = transactionDao.getLastInsertId();

        userM.setPersonId(lastPersonId);
        userM.setEmail(userRequest.getEmail());
        userM.setUserName(userRequest.getUserName());
        String password = passwordEncoder.encode(userRequest.getPassword());
        userM.setPassword(password);
        userM.setTransaction(transaction);
        userDao.createUser(userM);
        Integer lastUserId = transactionDao.getLastInsertId();

        userRole.setUserId(lastUserId);
        userRole.setRoleId(userRequest.getRole());
        userRole.setTransaction(transaction);
        userRoleDao.createUserRole(userRole);

        return userRequest;*/
    }
}