package com.example.BDPractice.controllers;

import com.example.BDPractice.models.Teachers;
import com.example.BDPractice.reposit.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SchoolController {
    @Autowired
    private TeachersRepository teachersRepository;
    @Autowired
    private RabochieRepository rabochieRepository;
    @Autowired
    private PredmetRepository predmetRepository;
    @Autowired
    private ZurnalRepository zurnalRepository;
    @Autowired
    private StudentsRepository studentsRepository;

    @GetMapping("/")
    public String SchoolController(Model model) {

        return "main-view";
    }

    @GetMapping("/teachers")
    public String teachersView(Model model) {
        Iterable<Teachers> teachers = teachersRepository.findAll();
        model.addAttribute("teachers", teachers);
        return "teachers/teachers-view";
    }

    @GetMapping("/teachers/add")
    public String workersAdd(Model model) {

        return "teachers/teachers-add";
    }

    @PostMapping("/teachers/add")
    public String workersAdd(@RequestParam String fio, @RequestParam String position,
                             @RequestParam Long age, Model model) {
        Teachers teachers = new Teachers(FIO, Hours, age);
        teachersRepository.save(teachers);
        return "teachers/teachers-add";
    }

    @GetMapping("/patients")
    public String patientView(Model model) {
        Iterable<Patient> patients = rabochieRepository.findAll();
        model.addAttribute("patients", patients);
        return "patient/patient-view";
    }

    @GetMapping("/patients/add")
    public String patientAdd(Model model) {

        return "patient/patient-add";
    }

    @PostMapping("/patients/add")
    public String patientAdd(@RequestParam String fio, @RequestParam String diagnosis,
                             @RequestParam Long age, Model model) {
        Patient patient = new Patient(fio, diagnosis, age);
        rabochieRepository.save(patient);
        return "patient/patient-add";
    }

    @GetMapping("/drugs")
    public String drugView(Model model) {
        Iterable<Drug> drugs = predmetRepository.findAll();
        model.addAttribute("drugs", drugs);
        return "drug/drug-view";
    }

    @GetMapping("/drugs/add")
    public String drugAdd(Model model) {

        return "drug/drug-add";
    }

    @PostMapping("/drugs/add")
    public String drugAdd(@RequestParam String name, @RequestParam Float price,
                          Model model) {
        Drug drug = new Drug(price, name);
        predmetRepository.save(drug);
        return "drug/drug-add";
    }

    @GetMapping("/services")
    public String serviceView(Model model) {
        Iterable<Service> services = zurnalRepository.findAll();
        model.addAttribute("services", services);
        return "service/service-view";
    }

    @GetMapping("/services/add")
    public String serviceAdd(Model model) {

        return "service/service-add";
    }

    @PostMapping("/services/add")
    public String serviceAdd(@RequestParam String name, @RequestParam Float price,
                             @RequestParam String cabinet, Model model) {
        Service service = new Service(price, name, cabinet);
        zurnalRepository.save(service);
        return "service/service-add";
    }

    @GetMapping("/fasthelps")
    public String fasthelpView(Model model) {
        Iterable<FastHelp> fastHelps = studentsRepository.findAll();
        model.addAttribute("fasthelps", fastHelps);
        return "fast-help/fasthelp-view";
    }

    @GetMapping("/fasthelps/add")
    public String fasthelpAdd(Model model) {

        return "fast-help/fasthelp-add";
    }

    @PostMapping("/fasthelps/add")
    public String fasthelpAdd(@RequestParam String carNum, @RequestParam String carModel,
                              @RequestParam Long carLife, Model model) {
        FastHelp fastHelp = new FastHelp(carNum, carModel, carLife);
        studentsRepository.save(fastHelp);
        return "fast-help/fasthelp-add";
    }
}

