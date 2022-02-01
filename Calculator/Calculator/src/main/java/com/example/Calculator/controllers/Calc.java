package com.example.Calculator.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class Calc {
    @GetMapping("/")
    public String home(Model model){
        return "MainPage";
    }

    double itog1;
    @GetMapping("Get")
    public String num(@RequestParam(required = false)
                                  double Value1,
                                  double Value2,
                                  Model model, String deistvie){

        switch (deistvie){
            case"umnozit":
                itog1 = Value1 * Value2;
                break;
            case"delenie":
                itog1 = Value1 / Value2;
                break;
            case"slozenie": itog1 = Value1 + Value2;
                break;
            case"vichet": itog1 = Value1 - Value2;
                break;
        }
        model.addAttribute("number1", Value1);
        model.addAttribute("number2", Value2);
        model.addAttribute("itog1", itog1);
        return "MainPage";
    }
    double itog2;
    @PostMapping("Post")
    public String num2(@RequestParam double Value3,
                       @RequestParam double Value4, Model model,
                       @RequestParam String deistvie2)
    {
        switch (deistvie2) {
            case"umnozit": itog2 = Value3 * Value4;
                break;
                case"delenie": itog2 = Value3 / Value4;
                break;
                case"slozenie": itog2 = Value3 + Value4;
                break;
                case"vichet": itog2 = Value3 - Value4;
                break;
        }
        model.addAttribute("number3", Value3);
        model.addAttribute("number4", Value4);
        model.addAttribute("itog2", itog2);
        return "MainPage";
    }
    public ModelAndView filter(@ModelAttribute("journalData") Calc calc, BindingResult bindingResult) {

    }
}