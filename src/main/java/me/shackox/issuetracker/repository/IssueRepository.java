package me.shackox.issuetracker.repository;

import me.shackox.issuetracker.model.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by SHACKOX on 10/12/16.
 */

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {
}
