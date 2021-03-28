package main.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "captcha_codes")
public class CaptchaCode
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private Date time;
    @NotNull
    @Column(columnDefinition="TINYTEXT")
    private String code;
    @NotNull
    @Column(columnDefinition="TINYTEXT")
    private String secretCode;
}
