package main.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "global_settings")
public class GlobalSetting
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private GlobalSetting()
    {}

    public GlobalSetting(@NotNull String code, @NotNull String name, @NotNull String value)
    {
        this.code = code;
        this.name = name;
        this.value = value;
    }

    @NotNull
    private String code;

    @NotNull
    private String name;

    @NotNull
    private String value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
