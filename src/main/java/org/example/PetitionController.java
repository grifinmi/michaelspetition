package org.example;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class PetitionController {
    private ArrayList <Petition> pList = new ArrayList<Petition>();


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
        pList.add(p);
        for (Petition pl : pList) {
            System.out.println (pl.getPetitionDetail());
        }
        return "DisplayPetitions";
    }
    @GetMapping("/DisplayPetitions")
    public String displayForm() {

        return "DisplayPetitions";
}


}
