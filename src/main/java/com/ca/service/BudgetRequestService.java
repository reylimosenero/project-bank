package com.ca.service;

import com.ca.entity.BudgetRequest;

import java.util.List;
import java.util.Optional;

public interface BudgetRequestService {

    public List<BudgetRequest> getBudgetRequest();

    BudgetRequest createBudgetRequest(BudgetRequest body);

    void deleteBudget(Integer id);

    Optional<BudgetRequest> getBudgetById(Integer id);
}
