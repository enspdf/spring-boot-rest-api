package me.shackox.issuetracker.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by SHACKOX on 10/12/16.
 */

@Entity
public class Issue {
    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty
    private String title;
    @NotEmpty
    private String description;
    @Enumerated(EnumType.STRING)
    private IssueType type;
    @Enumerated(EnumType.STRING)
    private IssuePriority priority;
    @Enumerated(EnumType.STRING)
    private IssueStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public IssueType getType() {
        return type;
    }

    public void setType(IssueType type) {
        this.type = type;
    }

    public IssuePriority getPriority() {
        return priority;
    }

    public void setPriority(IssuePriority priority) {
        this.priority = priority;
    }

    public IssueStatus getStatus() {
        return status;
    }

    public void setStatus(IssueStatus status) {
        this.status = status;
    }
}
