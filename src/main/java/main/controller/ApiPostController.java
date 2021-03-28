package main.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/post")
public class ApiPostController
{
    @RequestMapping("/")
    public String index(Model model)
    {
        return "/api/post/";
    }
}
