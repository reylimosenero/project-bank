package com.ca.service;

import com.ca.entity.BudgetRequest;
import com.ca.repository.BudgetRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class BudgetRequestServiceImpl implements BudgetRequestService {
	final static Logger logger = Logger.getLogger("BudgetRequestService");
	@Autowired
	BudgetRequestRepository budgetRequestRepository;


	@Override
	public List<BudgetRequest> getBudgetRequest() {

		return budgetRequestRepository.findAll();
	}

	@Override
	public BudgetRequest createBudgetRequest(BudgetRequest body) {
		logger.info("post request "+body);
		return budgetRequestRepository.save(body);
	}

	@Override
	public void deleteBudget(Integer id) {
		 budgetRequestRepository.deleteById(id);
	}

	@Override
	public Optional<BudgetRequest> getBudgetById(Integer id) {
		return budgetRequestRepository.findById(id);
	}
}
