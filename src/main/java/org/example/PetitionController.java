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

    @GetMapping("/")
    public String home() {
        return "EnterPetition";
    }
    @GetMapping("/EnterPetition")
    public String enterPetition() {
        return "EnterPetition";
    }
    @PostMapping("/EnterPetition")
    public String processForm(Petition petition) {

        return "DisplayPetitions";
    }
    @GetMapping("/DisplayPetitions")
    public String displayForm() {

        return "DisplayPetitions";
}


}
