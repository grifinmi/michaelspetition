package org.example;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class PetitionController {
    private ArrayList<Petition> pList = new ArrayList<Petition>();

    @GetMapping("/")
    public String home() {

        /*This code is called on launch of localhost:8080/ */
        System.out.println("in GetMapping/");
        return "EnterPetition";
    }

    @GetMapping("/EnterPetition")
    public String enterPetition() {
        /*This code is called on launch of localhost:8080/EnterPetition */
        System.out.println("GetMapping/enterpetition");
        return "EnterPetition";
    }

    @PostMapping("/EnterPetition")
    /* This code is executed when the user presses the submit button on the enterPetition page*/
    public String processForm
            (@RequestParam("petitionTitle") String pName,
             @RequestParam("petitionDetail") String pDetail,
             Model model) {
        /*This code is called when submit button is pressed to enter petition */
        System.out.println("@PostMapping(/EnterPetition)");
        Petition p = new Petition();
        p.setPetitionDetail(pDetail);
        p.setPetitionTitle(pName);
        pList.add(p);
        model.addAttribute("Petitions", pList);

        return "DisplayPetitions";
    }

    @GetMapping("/showSearchPetitionPage")
    public String showSearchPetitionPage(String search) {
        System.out.println("@GetMapping(\"/showSearchPetitionPage\")    ");
        return "Searchpetition";
    }

    @PostMapping("/SearchPetition")
    public String searchPetition(@RequestParam (name = "petitionSearch") String search) {

        System.out.println("in postMapping/searchpetition");
        Petition petition = new Petition();

        for (Petition p : pList) {
            System.out.print("in for and string is >>>");
            System.out.println(search);
            if (p.getPetitionDetail().contains(search)) {
                petition = p;
                break;
            } else if (p.getPetitionTitle().contains(search)) {
                petition = p;
                break;
            }
        }
        System.out.println("out of  for");
        System.out.println(petition.getPetitionDetail());
        return "DisplayPetitions";
    }
}
