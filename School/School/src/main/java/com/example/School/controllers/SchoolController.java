package com.example.School.controllers;

import com.example.School.models.*;
import com.example.School.reposit.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class SchoolController {
    @Autowired
    private TeachersRepository teachersRepository;
    @Autowired
    private AvtorizRepository avtorizRepository;
    @Autowired
    private RegRepository regRepository;
    @Autowired
    private RabochieRepository rabochieRepository;
    @Autowired
    private PredmetRepository predmetRepository;
    @Autowired
    private ZurnalRepository zurnalRepository;
    @Autowired
    private StudentsRepository studentsRepository;

    @GetMapping("/")
    public String home(Model model) {

        return "start-page";
    }


    @GetMapping("/reg")
    public String regView(Model model) {
        Iterable<Reg> regs = regRepository.findAll();
        model.addAttribute("reg", regs);
        return "registration-page";
    }

    @GetMapping("/reg/add")
    public String regAdd(Reg reg) {

        return "registration-page";
    }

    @PostMapping("/reg/add")
    public String regAdd(@Valid Reg reg, BindingResult bindingResult, @RequestParam String login,
                              @RequestParam String Password,
                              Model model) {
        if (bindingResult.hasErrors())
            return "registration-page";
        List<Reg> regs = regRepository.findByLogin(login);
        if (regs.size()>0)
        {
            ObjectError error = new ObjectError("login","Такие данные логина уже есть!");
            bindingResult.addError(error);
            return "registration-page";
        }

        else {
            regRepository.save(reg);
            return "start-page";
        }
    }




    @GetMapping("/avtoriz")
    public String avtorizView(Model model) {
        Iterable<Avtoriz> avtorizs = avtorizRepository.findAll();
        model.addAttribute("avtoriz", avtorizs);
        return "avtoriz-page";
    }

    @GetMapping("/avtoriz/add")
    public String avtorizAdd(Avtoriz avtoriz) {

        return "avtoriz-page";
    }

    @PostMapping("/avtoriz/add")
    public String avtorizAdd( @Valid Avtoriz avtoriz, BindingResult bindingResult, @RequestParam String login,
                         @RequestParam String Password,
                         Model model) {
        if (bindingResult.hasErrors())
            return "avtoriz-page";
        List<Avtoriz> avtorizs = avtorizRepository.findByLogin(login);

        if (avtorizs.size()==0)
        {
            ObjectError error = new ObjectError("login","Такие данные логина не существуют!");
            bindingResult.addError(error);
            return "avtoriz-page";
        }

        else {
            avtorizRepository.save(avtoriz);
            return "main-view";
        }
    }




    @GetMapping("/teachers")
    public String teachersView(Model model) {
        Iterable<Teachers> teachers = teachersRepository.findAll();
        model.addAttribute("teachers", teachers);
        return "Teachers-view";
    }

    @GetMapping("/teachers/add")
    public String teachersAdd(Teachers teachers) {

        return "Teachers-add";
    }

    @PostMapping("/teachers/add")
    public String teachersAdd(@Valid Teachers teachers, BindingResult bindingResult, @RequestParam String FIO,
                              @RequestParam String hours,
                              Model model) {
        if (bindingResult.hasErrors())
            return "Teachers-add";
        List<Teachers> res = teachersRepository.findByFIO(FIO);
        if (res.size()>0)
        {
            ObjectError error = new ObjectError("FIO","Такие данные ФИО уже есть!");
            bindingResult.addError(error);
            return "Teachers-add";
        }

        else {
            teachersRepository.save(teachers);
            return "redirect:/teachers";
        }
    }


    @GetMapping("/rabochies")
    public String rabochieView(Model model) {
        Iterable<Rabochie> rabochies = rabochieRepository.findAll();
        model.addAttribute("rabochie", rabochies);
        return "Rabochie-view";
    }

    @GetMapping("/rabochies/add")
    public String rabochieAdd(Rabochie rabochie) {

        return "Rabochie-add";
    }

    @PostMapping("/rabochies/add")
    public String rabochieAdd(@Valid Rabochie rabochie, BindingResult bindingResult, @RequestParam String zp, @RequestParam String name,
                              @RequestParam String role, Model model) {
        if (bindingResult.hasErrors())
            return "Rabochie-add";
        List<Rabochie> res = rabochieRepository.findByRole(role);
        if (res.size()>0)
        {
            ObjectError error = new ObjectError("role","Такая должность уже есть!");
            bindingResult.addError(error);
            return "Rabochie-add";
        }

        else {
            rabochieRepository.save(rabochie);
            return "redirect:/rabochies";
        }
    }

    @GetMapping("/predmet")
    public String PredmetView(Model model) {
        Iterable<Predmet> predmet = predmetRepository.findAll();
        model.addAttribute("predmet", predmet);
        return "Predmet-view";
    }

    @GetMapping("/predmet/add")
    public String PredmetAdd(Predmet predmet) {

        return "Predmet-add";
    }

    @PostMapping("/predmet/add")
    public String PredmetAdd(@Valid Predmet predmet, BindingResult bindingResult, @RequestParam String hours, @RequestParam String teachersCount, @RequestParam String name,
                             Model model) {
        if (bindingResult.hasErrors())
            return "Predmet-add";
        List<Predmet> res = predmetRepository.findByName(name);
        if (res.size()>0)
        {
            ObjectError error = new ObjectError("name","Такие данные предмета уже есть!");
            bindingResult.addError(error);
            return "Predmet-add";
        }

        else {
            predmetRepository.save(predmet);
            return "redirect:/predmet";
        }
    }

    @GetMapping("/zurnals")
    public String ZurnalView(Model model) {
        Iterable<Zurnal> zurnals = zurnalRepository.findAll();
        model.addAttribute("zurnal", zurnals);
        return "Zurnal-view";
    }

    @GetMapping("/zurnals/add")
    public String ZurnalAdd(Zurnal zurnal) {

        return "Zurnal-add";
    }

    @PostMapping("/zurnals/add")
    public String ZurnalAdd(@Valid Zurnal zurnal, BindingResult bindingResult, @RequestParam String Mark, @RequestParam String Name,
                            @RequestParam String date, Model model) {
        if (bindingResult.hasErrors())
            return "Zurnal-add";
        List<Zurnal> res = zurnalRepository.findByName(Name);
        if (res.size()>0)
        {
            ObjectError error = new ObjectError("name","Такие данные предмета уже есть!");
            bindingResult.addError(error);
            return "Zurnal-add";
        }

        else {
            zurnalRepository.save(zurnal);
            return "redirect:/zurnals";
        }
    }

    @GetMapping("/students")
    public String StudentView(Model model) {
        Iterable<Students> students = studentsRepository.findAll();
        model.addAttribute("students", students);
        return "Student-view";
    }

    @GetMapping("/students/add")
    public String StudentAdd(Students students) {

        return "Student-add";
    }

    @PostMapping("/students/add")
    public String StudentAdd(@Valid Students students, BindingResult bindingResult, @RequestParam String FIO, @RequestParam String curs,
                             Model model) {
        if (bindingResult.hasErrors())
            return "Student-add";
        List<Students> res = studentsRepository.findByFIO(FIO);
        if (res.size()>0)
        {
            ObjectError error = new ObjectError("name","Такие данные ФИО уже есть!");
            bindingResult.addError(error);
            return "Student-add";
        }

        else {
            studentsRepository.save(students);
            return "redirect:/students";
        }
    }




    @GetMapping("/teachers/{id}/detail")
    public String teacherDetails(@PathVariable(value = "id") Long id, Model model){
        Optional<Teachers> teachers = teachersRepository.findById(id);
        ArrayList<Teachers> result = new ArrayList<>();
        teachers.ifPresent(result::add);
        model.addAttribute("teacher", result);
        return "teachers-detail";
    }
    @PostMapping("/teachers/result")
    public String teacherSearch(@RequestParam String fio, Model model) {
        List<Teachers> result2 = teachersRepository.findByFIOContaining(fio);
        model.addAttribute("teachers", result2);
        return "Teachers-view";
    }

    @GetMapping("/zurnals/{id}/detail")
    public String zurnalDetails(@PathVariable(value = "id") Long id, Model model){
        Optional<Zurnal> zurnals = zurnalRepository.findById(id);
        ArrayList<Zurnal> result = new ArrayList<>();
        zurnals.ifPresent(result::add);
        model.addAttribute("zurnal", result);
        return "zurnals-detail";
    }
    @PostMapping("/zurnals/result")
    public String zurnalSearch(@RequestParam String name, Model model) {
        List<Zurnal> result2 = zurnalRepository.findByName(name);
        model.addAttribute("zurnal", result2);
        return "Zurnal-view";
    }

    @GetMapping("/students/{id}/detail")
    public String studentDetails(@PathVariable(value = "id") Long id, Model model){
        Optional<Students> students = studentsRepository.findById(id);
        ArrayList<Students> result = new ArrayList<>();
        students.ifPresent(result::add);
        model.addAttribute("students", result);
        return "students-detail";
    }
    @PostMapping("/students/result")
    public String studentSearch(@RequestParam String curs, Model model) {
        List<Students> result2 = studentsRepository.findByCurs(curs);
        model.addAttribute("students", result2);
        return "Student-view";
    }

    @GetMapping("/rabochie/{id}/detail")
    public String rabochieDetails(@PathVariable(value = "id") Long id, Model model){
        Optional<Rabochie> rabochie = rabochieRepository.findById(id);
        ArrayList<Rabochie> result = new ArrayList<>();
        rabochie.ifPresent(result::add);
        model.addAttribute("rabochies", result);
        return "rabochie-detail";
    }
    @PostMapping("/rabochie/result")
    public String rabochieSearch(@RequestParam String role, Model model) {
        List<Rabochie> result2 = rabochieRepository.findByRole(role);
        model.addAttribute("rabochies", result2);
        return "Rabochie-view";
    }

    @GetMapping("/predmet/{id}/detail")
    public String predmetDetails(@PathVariable(value = "id") Long id, Model model){
        Optional<Predmet> predmet = predmetRepository.findById(id);
        ArrayList<Predmet> result = new ArrayList<>();
        predmet.ifPresent(result::add);
        model.addAttribute("predmet", result);
        return "predmet-detail";
    }
    @PostMapping("/predmet/result")
    public String predmetSearch(@RequestParam String Name, Model model) {
        List<Predmet> result2 = predmetRepository.findByNameContaining(Name);
        model.addAttribute("predmet", result2);
        return "Predmet-view";
    }



    @GetMapping("/zurnals/{id}/edit")
    public String zurnalEdit(@PathVariable(value = "id") Long id, Zurnal zurnal, Model model){
        if(!zurnalRepository.existsById(id))
        {
            return "redirect:/zurnals";
        }

        Optional<Zurnal> zurnal1 = zurnalRepository.findById(id);
        ArrayList<Zurnal> res = new ArrayList<>();
        zurnal1.ifPresent(res::add);
        model.addAttribute("zurnalEdit", res);
        return "zurnal-edit";
    }

    @PostMapping("/zurnals/{id}/edit")
    public String zurnalPostUpdate(@Valid Zurnal zurnal, BindingResult bindingResult,@PathVariable(value = "id") Long id, @RequestParam String Mark,
                                 @RequestParam String Name, @RequestParam String Date,
                                 Model model){
        List<Zurnal> res = zurnalRepository.findByName(Name);

        if(bindingResult.hasErrors()){
            res = new ArrayList<>();
            res.add(zurnal);
            model.addAttribute("zurnalEdit",res);
            return "zurnal-edit";
        }

        if (res.size()>0)
        {
            ObjectError error = new ObjectError("Name","Такой Журнал уже есть!");
            bindingResult.addError(error);
            res = new ArrayList<>();
            res.add(zurnal);
            model.addAttribute("zurnalEdit",res);
            return "zurnal-edit";
        }
        else {
            zurnalRepository.save(zurnal);
            return "redirect:/zurnals";
        }
    }

    @GetMapping("/zurnals/{id}/remove")
    public String zurnalPostDelete(@PathVariable(value = "id") Long id, Model model){
        Zurnal zurnal = zurnalRepository.findById(id).orElseThrow();
        zurnalRepository.delete(zurnal);
        return "redirect:/zurnals";
    }


    @GetMapping("/students/{id}/edit")
    public String studentEdit(@PathVariable(value = "id") Long id,Students students, Model model){
        if(!studentsRepository.existsById(id))
        {
            return "redirect:/students";
        }

        Optional<Students> students1 = studentsRepository.findById(id);
        ArrayList<Students> res = new ArrayList<>();
        students1.ifPresent(res::add);
        model.addAttribute("studentEdit", res);
        return "student-edit";
    }

    @PostMapping("/students/{id}/edit")
    public String studentPostUpdate(@Valid Students students,BindingResult bindingResult, @PathVariable(value = "id") Long id, @RequestParam String curs,
                                   @RequestParam String FIO,
                                   Model model){
        List<Students> res = studentsRepository.findByFIO(FIO);

        if(bindingResult.hasErrors()){
            res = new ArrayList<>();
            res.add(students);
            model.addAttribute("studentEdit",res);
            return "student-edit";
        }

        if (res.size()>0)
        {
            ObjectError error = new ObjectError("FIO","Такой Ученик уже есть!");
            bindingResult.addError(error);
            res = new ArrayList<>();
            res.add(students);
            model.addAttribute("studentEdit",res);
            return "student-edit";
        }
        else {
            studentsRepository.save(students);
            return "redirect:/students";
        }
    }

    @GetMapping("/students/{id}/remove")
    public String studentPostDelete(@PathVariable(value = "id") Long id, Model model){
        Students students = studentsRepository.findById(id).orElseThrow();
        studentsRepository.delete(students);
        return "redirect:/students";
    }


    @GetMapping("/rabochie/{id}/edit")
    public String rabochieEdit(@PathVariable(value = "id") Long id,Rabochie rabochie, Model model){
        if(!rabochieRepository.existsById(id))
        {
            return "redirect:/rabochie";
        }

        Optional<Rabochie> rabochie1 = rabochieRepository.findById(id);
        ArrayList<Rabochie> res = new ArrayList<>();
        rabochie1.ifPresent(res::add);
        model.addAttribute("rabochieEdit", res);
        return "rabochie-edit";
    }

    @PostMapping("/rabochie/{id}/edit")
    public String rabochiePostUpdate(@Valid Rabochie rabochie,BindingResult bindingResult, @PathVariable(value = "id") Long id, @RequestParam String zp,
                                    @RequestParam String name, @RequestParam String role,
                                    Model model){
        List<Rabochie> res = rabochieRepository.findByName(name);

        if(bindingResult.hasErrors()){
            res = new ArrayList<>();
            res.add(rabochie);
            model.addAttribute("rabochieEdit",res);
            return "rabochie-edit";
        }

        if (res.size()>0)
        {
            ObjectError error = new ObjectError("name","Такой Сотрудник уже есть!");
            bindingResult.addError(error);
            res = new ArrayList<>();
            res.add(rabochie);
            model.addAttribute("rabochieEdit",res);
            return "rabochie-edit";
        }
        else {
            rabochieRepository.save(rabochie);
            return "redirect:/rabochies";
        }
    }

    @GetMapping("/rabochie/{id}/remove")
    public String rabochiePostDelete(@PathVariable(value = "id") Long id, Model model){
        Rabochie rabochie = rabochieRepository.findById(id).orElseThrow();
        rabochieRepository.delete(rabochie);
        return "redirect:/rabochies";
    }


    @GetMapping("/predmet/{id}/edit")
    public String predmetEdit(@PathVariable(value = "id") Long id,Predmet predmet, Model model){
        if(!predmetRepository.existsById(id))
        {
            return "redirect:/predmet";
        }

        Optional<Predmet> predmet1 = predmetRepository.findById(id);
        ArrayList<Predmet> res = new ArrayList<>();
        predmet1.ifPresent(res::add);
        model.addAttribute("predmetEdit", res);
        return "predmet-edit";
    }

    @PostMapping("/predmet/{id}/edit")
    public String predmetPostUpdate(@Valid Predmet predmet,BindingResult bindingResult, @PathVariable(value = "id") Long id, @RequestParam String hours,
                                     @RequestParam String teachersCount, @RequestParam String name,
                                     Model model){
        List<Predmet> res = predmetRepository.findByName(name);

        if(bindingResult.hasErrors()){
            res = new ArrayList<>();
            res.add(predmet);
            model.addAttribute("predmetEdit",res);
            return "predmet-edit";
        }

        if (res.size()>0)
        {
            ObjectError error = new ObjectError("name","Такой предмет уже есть!");
            bindingResult.addError(error);
            res = new ArrayList<>();
            res.add(predmet);
            model.addAttribute("predmetEdit",res);
            return "predmet-edit";
        }
        else {
            predmetRepository.save(predmet);
            return "redirect:/predmet";
        }
    }

    @GetMapping("/predmet/{id}/remove")
    public String predmetPostDelete(@PathVariable(value = "id") Long id, Model model){
        Predmet predmet = predmetRepository.findById(id).orElseThrow();
        predmetRepository.delete(predmet);
        return "redirect:/predmet";
    }


    @GetMapping("/teachers/{id}/edit")
    public String teacherEdit(@PathVariable(value = "id") Long id,Teachers teachers, Model model){
        if(!teachersRepository.existsById(id))
        {
            return "redirect:/teachers";
        }

        Optional<Teachers> teachers1 = teachersRepository.findById(id);
        ArrayList<Teachers> res = new ArrayList<>();
        teachers1.ifPresent(res::add);
        model.addAttribute("teacherEdit", res);
        return "teacher-edit";
    }


    @PostMapping("/teachers/{id}/edit")
    public String teacherPostUpdate(@Valid Teachers teachers,BindingResult bindingResult, @PathVariable(value = "id") Long id, @RequestParam String hours,
                                    @RequestParam String FIO,
                                    Model model){
        List<Teachers> res = teachersRepository.findByFIO(FIO);

        if(bindingResult.hasErrors()){
            res = new ArrayList<>();
            res.add(teachers);
            model.addAttribute("teacherEdit",res);
            return "teacher-edit";
        }

        if (res.size()>0)
        {
            ObjectError error = new ObjectError("FIO","Такое ФИО уже есть!");
            bindingResult.addError(error);
            res = new ArrayList<>();
            res.add(teachers);
            model.addAttribute("teacherEdit",res);
            return "teacher-edit";
        }
        else {
            teachersRepository.save(teachers);
            return "redirect:/teachers";
        }
    }


    @GetMapping("/teachers/{id}/remove")
    public String teacherPostDelete(@PathVariable(value = "id") Long id, Model model){
        Teachers teachers = teachersRepository.findById(id).orElseThrow();
        teachersRepository.delete(teachers);
        return "redirect:/teachers";
    }
}



