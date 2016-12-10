package me.shackox.issuetracker.service.impl;

import me.shackox.issuetracker.model.Issue;
import me.shackox.issuetracker.model.IssuePriority;
import me.shackox.issuetracker.model.IssueStatus;
import me.shackox.issuetracker.model.IssueType;
import me.shackox.issuetracker.repository.IssueRepository;
import me.shackox.issuetracker.service.IssueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Created by SHACKOX on 10/12/16.
 */

@Service
public class IssueServiceImpl implements IssueService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IssueRepository issueRepository;

    @Override
    public List<Issue> findAll() {
        logger.info("> findAll");
        List<Issue> issues = issueRepository.findAll();
        logger.info("< findAll");
        return issues;
    }

    @Override
    public Issue create(Issue issue) {
        logger.info("> create");
        issue.setStatus(IssueStatus.OPEN);
        issue.setType(IssueType.TYPE);
        if (issue.getPriority() == null) {
            issue.setPriority(IssuePriority.MEDIUM);
        }
        Issue persistedIssue = issueRepository.save(issue);
        logger.info("< create");
        return persistedIssue;
    }

    @Override
    public Issue find(Long id) {
        Assert.notNull(id,"Id is required");
        logger.info("> find id: {}");
        Issue issue = issueRepository.findOne(id);
        logger.info("< find id: {}");
        return issue;
    }

    @Override
    public Issue update(Issue issue) {
        logger.info("> update");
        Issue updatedIssue = issueRepository.save(issue);
        logger.info("< update");
        return updatedIssue;
    }

    @Override
    public void delete(Long id) {
        Assert.notNull(id,"Id is required");
        logger.info("> delete");
        issueRepository.delete(id);
        logger.info("< delete");
    }
}
