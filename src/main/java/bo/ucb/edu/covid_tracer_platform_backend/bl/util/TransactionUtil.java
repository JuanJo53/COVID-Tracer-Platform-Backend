package bo.ucb.edu.covid_tracer_platform_backend.bl.util;

import bo.ucb.edu.covid_tracer_platform_backend.shared.model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class TransactionUtil {

    private static Logger LOGGER = LoggerFactory.getLogger(TransactionUtil.class);

    public static Transaction createTransaction(HttpServletRequest request) {
        Transaction transaction = new Transaction();
        transaction.setTxDate(new Date());
        //LOGGER.error(String.valueOf(new Date()));
        transaction.setTxHost(request.getRemoteHost());
        //transaction.setTxUserId(request.getUserPrincipal().getName()); TODO fix username instead of userId
        transaction.setTxUserId(0);
        return transaction;
    }
}
