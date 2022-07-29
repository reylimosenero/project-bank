package com.ca.controller;

import com.ca.entity.BudgetRequest;
import com.ca.service.BudgetRequestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class BudgetRequestController {

    @Autowired
    private BudgetRequestServiceImpl budgetRequestService;


    @GetMapping("/budgets")
    public List<BudgetRequest> getBudgetRequest() {

        return budgetRequestService.getBudgetRequest();
    }

    @PostMapping("/budgets")
    public BudgetRequest createBudgetRequest(@RequestBody BudgetRequest body){
        return budgetRequestService.createBudgetRequest(body);
    }

    @GetMapping("/budgets/{id}")
    public Optional<BudgetRequest> getBudgetById(@PathVariable Integer id){
    	return budgetRequestService.getBudgetById(id);
    }

    @DeleteMapping("/budgets/{id}")
    public void deleteBudget(@PathVariable Integer id)
    {
        budgetRequestService.deleteBudget(id);
    }


//    @GetMapping("/accounts")
//    public Page<Account> getAccounts(@PageableDefault(page = 0, size = 10)
//                                         @SortDefault.SortDefaults({
//                                                 @SortDefault(sort = "name",
//                                                         direction = Sort.Direction.ASC)
//                                         })
//                                                 Pageable pageable){
//        return bankService.getAccounts(pageable);
//    }

}
