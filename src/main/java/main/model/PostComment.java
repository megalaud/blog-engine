package main.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "post_comments")
public class PostComment
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    private PostComment parent;

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Post post;

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private User user;

    @NotNull
    private Date time;

    @NotNull
    @Column(length = 65535,columnDefinition="Text")
    private String text;
}
