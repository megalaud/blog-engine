package main.model;

import javax.persistence.*;

@Entity
public class Tag2Post
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Tag tag;

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Post post;
}
