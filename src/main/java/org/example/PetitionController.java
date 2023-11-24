package org.example;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class PetitionController {
    private ArrayList<Petition> pList = new ArrayList<Petition>();
    private int petitionId = 0;
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
        /*This code is called when submit button is pressed to enter petition
        * it adds the petition to the petition list and updates the model to
        * containing the petitions list */
        System.out.println("@PostMapping(/enterPetition)");
        Petition p = new Petition();
        p.setPetitionDetail(pDetail);
        p.setPetitionTitle(pName);
        pList.add(p);
        petitionId++;
        model.addAttribute("pList", pList);

        return "displaypetitions"; //goto displaypetitions html page
    }

    @GetMapping("/showSearchPetitionPage")
    public String showSearchPetitionPage(String search) {
        System.out.println("@GetMapping(\"/showSearchPetitionPage\")    ");
        return "searchpetition";
    }
    @GetMapping("/displayPetitionPage")
    public String showDisplayPetitionPage(String search,Model model) {
        System.out.println("@GetMapping(\"/displayPetitionPage\")    ");
        System.out.println(((String)pList.get(0).getPetitionTitle()));
        model.addAttribute("pList", pList);
        return "displaypetitions";
    }
    @GetMapping("/signpetition{title}")
    public String signPetition(@PathVariable("title") String title, Model model ) {

        System.out.println("in getMapping/signpetition");
        model.addAttribute("petitionTitle", title.substring(7,title.length()-2));;
        System.out.println(title);
        return "signpetition";
    }
    @PostMapping("/signPetition")
    public String signPetition()
    {

        return "enterpetition";
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
