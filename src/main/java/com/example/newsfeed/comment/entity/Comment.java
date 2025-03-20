package com.example.newsfeed.comment.entity;

import com.example.newsfeed.common.BaseTimeEntity;
import com.example.newsfeed.post.entity.Post;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "comments")
public class Comment extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    private String name;
    private String content;



    public Comment(Post post, String name, String content) {
        this.post = post;
        this.name = name;
        this.content = content;
    }

    public void update(String content) {
        this.content = content;
    }
}
