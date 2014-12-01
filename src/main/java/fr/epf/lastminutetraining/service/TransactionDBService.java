package fr.epf.lastminutetraining.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.epf.lastminutetraining.dao.TransactionDAO;
import fr.epf.lastminutetraining.domain.Transaction;

@Service
public class TransactionDBService {

	@Autowired
	private TransactionDAO transactionDAO;

	public TransactionDBService() {
	}

	public List<Transaction> findAllTransactions() {
		return transactionDAO.findAllTransactions();
	}

	public Transaction findTransaction(String id) {
		return transactionDAO.findTransaction(id);
	}

	public void save(Transaction transaction) {
		transactionDAO.saveTransaction(transaction);
	}

	public void create(Transaction transaction) {
		transactionDAO.saveTransaction(transaction);
	}

	public void update(Transaction transaction) {
		transactionDAO.saveTransaction(transaction);
	}

	public void remove(Transaction transaction) {
		transactionDAO.removeTransaction(transaction);
	}
}
