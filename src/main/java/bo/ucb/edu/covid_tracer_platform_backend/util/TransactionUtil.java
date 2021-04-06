package bo.ucb.edu.covid_tracer_platform_backend.util;

import bo.ucb.edu.covid_tracer_platform_backend.model.Transaction;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class TransactionUtil {

    public static Transaction createTransaction(HttpServletRequest request) {
        Transaction transaction = new Transaction();
        transaction.setTxDate(new Date());
        transaction.setTxHost(request.getRemoteHost());
        // transaction.setTxUserId(request.getUserPrincipal().getName()); TODO fix username instead of userId
        transaction.setTxUserId(0);
        return transaction;
    }
}
