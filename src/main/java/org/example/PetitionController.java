package org.example;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PetitionController {

    @GetMapping("/EnterPetition")
    public String sendForm(Petition petition) {

        return petition.getPetitionDetail();
    }

    @PostMapping("/EnterPetition")
    public String processForm(Petition petition) {

        return "showMessage";
    }
}
