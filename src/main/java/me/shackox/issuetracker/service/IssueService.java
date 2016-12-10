package me.shackox.issuetracker.service;

import me.shackox.issuetracker.model.Issue;

import java.util.List;

/**
 * Created by SHACKOX on 10/12/16.
 */
public interface IssueService {
    List<Issue> findAll();
    Issue create(Issue issue);
    Issue find(Long id);
    Issue update(Issue issue);
    void delete(Long id);
}
