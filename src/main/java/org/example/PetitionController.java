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
    private Petition pSearchResult = new Petition();
    @GetMapping("/")
    public String home() {

        /*This code is called on launch of localhost:8080/ */
        System.out.println("in GetMapping/");
        return "enterpetition";
    }

    @GetMapping("/enterPetition")
    public String enterPetition() {
        /*This code is called on launch of localhost:8080/EnterPetition */
        System.out.println("GetMapping/enterpetition");
        return "enterpetition";
    }

    @PostMapping("/enterPetition")
    /* This code is executed when the user presses the submit button on the enterPetition page*/
    public String processForm
            (@RequestParam("petitionTitle") String pName,
             @RequestParam("petitionDetail") String pDetail,
             Model model) {
        /*This code is called when submit button is pressed to enter petition */
        System.out.println("@PostMapping(/enterPetition)");
        Petition p = new Petition();
        p.setPetitionDetail(pDetail);
        p.setPetitionTitle(pName);
        pList.add(p);
        model.addAttribute("Petitions", pList);

        return "displaypetitions"; //goto displaypetitions html page
    }

    @GetMapping("/showSearchPetitionPage")
    public String showSearchPetitionPage(String search) {
        System.out.println("@GetMapping(\"/showSearchPetitionPage\")    ");
        return "searchpetition";
    }

    @PostMapping("/searchPetition")
    public String searchPetition(@RequestParam (name = "petitionSearch") String search, Model model ){

        System.out.println("in postMapping/searchpetition");


        for (Petition p : pList) {
            if (p.getPetitionDetail().contains(search)) {
                pSearchResult = p;
                model.addAttribute("found", pSearchResult);
                return "searchresults";
            } else if (p.getPetitionTitle().contains(search)) {
                pSearchResult = p;
                model.addAttribute("found", pSearchResult);
                return "searchresults";
            }
        }
        System.out.println(pSearchResult.getPetitionDetail());

        return "notfound";
    }
}
