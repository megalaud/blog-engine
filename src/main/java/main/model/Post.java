package main.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "posts")
public class Post
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "is_active",columnDefinition = "TINYINT(1)")
    private boolean isActive;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name="moderation_status",columnDefinition = "varchar(8) default 'NEW'")
    private ModerationStatus moderationStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    private User moderator;

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private User user;

    @NotNull
    private Date time;

    @NotNull
    private String title;

    @NotNull
    @Column(length = 65535,columnDefinition="Text")
    private String text;

    @NotNull
    private int voteCount;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tag2post",
            joinColumns = {@JoinColumn(name = "post_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id",referencedColumnName = "id")}
    )
    private Set<Tag> tags;
}
