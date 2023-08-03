package ru.learnUP.springboottest.dao.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity
@Table(name = "comment")
@Getter
@Setter
@RequiredArgsConstructor

public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //IDENTITY = PRIMARY KEY
    private Long id;

    @Column
    private String text;

    @Column
    private String title;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    private Post post;

    @PrePersist //выполнение перед сохранением объекта в БД
    @PostLoad  //выполнение загрузки объекта из БД
    private void titleUpdate() {
        this.title = post.getTitle();
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", post=" + post.getId() +
                '}';
    }
}
