package ru.learnUP.springboottest.dao.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

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

    @ManyToOne
    @JoinColumn
    private Post post;

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", post=" + post.getId() +
                '}';
    }
}
