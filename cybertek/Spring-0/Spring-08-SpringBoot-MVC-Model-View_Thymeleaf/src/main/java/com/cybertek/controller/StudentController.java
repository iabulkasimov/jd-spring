package com.cybertek.controller;

import com.cybertek.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/welcome")
    public String homePage(Model model){

        String name = "Ozzy";
        model.addAttribute("name", name);
        model.addAttribute("course", "Cybertek");

        int num = new Random().nextInt(1000);
        model.addAttribute("random", num);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        model.addAttribute("numbers", numbers);

        LocalDate birthday = LocalDate.now().minusYears(42);
        model.addAttribute("birthday", birthday);

        Student student = new Student(1, "Mike", "Smith");
        model.addAttribute("student", student);


        return "student/welcome";
    }
}
