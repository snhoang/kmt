package com.dhsynergetech.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

import com.dhsynergetech.domain.enumeration.EngineStatus;

/**
 * A Engine.
 */
@Entity
@Table(name = "engine")
public class Engine implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "jhi_number", nullable = false)
    private String number;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private EngineStatus status;

    @ManyToMany(mappedBy = "engines")
    @JsonIgnore
    private Set<Article> articles = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public Engine number(String number) {
        this.number = number;
        return this;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public EngineStatus getStatus() {
        return status;
    }

    public Engine status(EngineStatus status) {
        this.status = status;
        return this;
    }

    public void setStatus(EngineStatus status) {
        this.status = status;
    }

    public Set<Article> getArticles() {
        return articles;
    }

    public Engine articles(Set<Article> articles) {
        this.articles = articles;
        return this;
    }

    public Engine addArticle(Article article) {
        this.articles.add(article);
        article.getEngines().add(this);
        return this;
    }

    public Engine removeArticle(Article article) {
        this.articles.remove(article);
        article.getEngines().remove(this);
        return this;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Engine engine = (Engine) o;
        if (engine.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), engine.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Engine{" +
            "id=" + getId() +
            ", number='" + getNumber() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }
}
