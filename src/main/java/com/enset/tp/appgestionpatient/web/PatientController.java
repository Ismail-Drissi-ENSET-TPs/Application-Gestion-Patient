package com.enset.tp.appgestionpatient.web;

import com.enset.tp.appgestionpatient.entities.Patient;
import com.enset.tp.appgestionpatient.repositories.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {

    private PatientRepository patientRepository;

    @GetMapping("/index")
    public String index(Model model, @RequestParam(name = "p", defaultValue = "0") int page, @RequestParam(name = "s", defaultValue = "4") int size) {
        Page<Patient> patients = patientRepository.findAll(PageRequest.of(page, size));
        model.addAttribute("listPatients", patients.getContent());
        model.addAttribute("pages", new int[patients.getTotalPages()]);
        model.addAttribute("currentPage", page);
        return "patients";
    }

}
