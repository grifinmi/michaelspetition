package org.example;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    /* This code is executed when the user presses the submit button on the enterPetition page*/
    public String processForm
            (@RequestParam("petitionTitle") String pName,
             @RequestParam("petitionDetail") String pDetail) {

        Petition p = new Petition();
        p.setPetitionDetail(pDetail);
        p.setPetitionTitle(pName);

        return "DisplayPetitions";
    }
    @GetMapping("/DisplayPetitions")
    public String displayForm() {

        return "DisplayPetitions";
}


}
