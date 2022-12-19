package me.olgas.recipesapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class FirstController {

    @GetMapping
    public String helloWorld(){
        return "Hello,web!";
    }
    @GetMapping("/path/to/page")
    public String page(@RequestParam String page){
        return "Page: " + page;
    }


    @GetMapping("/")
    public String applicationIsRunning(){
        return "Приложение запущено";
    }
    @GetMapping("/info")
    public String info(String nameStudent, String nameProject, LocalDate dateProject, String descriptionProject){
        nameStudent = "Ольга";
        nameProject = "Приложение для рецептов";
        dateProject = LocalDate.now();
        descriptionProject = "Веб приложение для рецептов";
        return "Приложение запущено " + " / " + nameStudent + " / " + nameProject + " / " + dateProject +" / " + descriptionProject;
    }
}
