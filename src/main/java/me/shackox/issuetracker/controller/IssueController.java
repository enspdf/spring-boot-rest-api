package me.shackox.issuetracker.controller;

import me.shackox.issuetracker.model.Issue;
import me.shackox.issuetracker.service.IssueService;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by SHACKOX on 10/12/16.
 */

@RestController
@RequestMapping("/api")
public class IssueController {
    @Autowired
    private IssueService issueService;

    @RequestMapping(value = "/issues", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Issue> getAllIssues() {
        return issueService.findAll();
    }

    @RequestMapping(value = "/issues/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Issue getIssueById(@PathVariable("id") Long id) {
        return issueService.find(id);
    }

    @RequestMapping(value = "/issues", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Issue createIssue(@RequestBody @Valid Issue issue) {
        return issueService.create(issue);
    }

    @RequestMapping(value = "/issues/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Issue updateIssue(@PathVariable("id") Long id, @RequestBody @Valid Issue issue) {
        if (id !=  null) {
            issue.setId(id);
        }
        return issueService.update(issue);
    }

    @RequestMapping(value = "/issues/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteIssue(@PathVariable("id") Long id) {
        issueService.delete(id);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleIssueNotFound(ExceptionHandler ex) {

    }
}
