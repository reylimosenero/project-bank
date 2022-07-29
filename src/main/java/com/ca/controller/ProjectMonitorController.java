package com.ca.controller;

import com.ca.entity.Projects;
import com.ca.service.ProjectMonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class ProjectMonitorController {

    @Autowired
    private ProjectMonitorService projectMonitorService;


    @GetMapping("/projects")
    public List<Projects> getAll() {

        return projectMonitorService.getProjects();
    }

    @PostMapping("/projects")
    public Projects createProject(@RequestBody Projects body){
        System.out.println("test");
        return projectMonitorService.createProjects(body);
    }

    @GetMapping("/projects/{id}")
    public Optional<Projects> getById(@PathVariable Integer id){
    	return projectMonitorService.getProjectById(id);
    }

    @DeleteMapping("/projects/{id}")
    public void delete(@PathVariable Integer id)
    {
        projectMonitorService.deleteProject(id);
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
