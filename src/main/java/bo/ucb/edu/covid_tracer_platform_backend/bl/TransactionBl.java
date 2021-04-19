package bo.ucb.edu.covid_tracer_platform_backend.bl;

import bo.ucb.edu.covid_tracer_platform_backend.dao.TransactionDao;
import bo.ucb.edu.covid_tracer_platform_backend.shared.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionBl {

    private TransactionDao transactionDao;

    @Autowired
    public TransactionBl(TransactionDao transactionDao) {
        this.transactionDao = transactionDao;
    }

    public Transaction createTransaction (Transaction transaction) {
        // Registramos la transacción en la Base de Datos
        this.transactionDao.create(transaction);

        // Obtenemos la llave primaria generada
        Integer lastPrimaryKey = this.transactionDao.getLastInsertId();

        transaction.setTxId(lastPrimaryKey);
        return transaction;
    }
}
