package main.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "post_votes")
public class PostVote
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Post post;

    @NotNull
    private Date time;

    @NotNull
    @Column(columnDefinition = "TINYINT(1)")
    boolean value;
}
