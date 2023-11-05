package org.example;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
public class PetitionController {

    @RequestMapping("/EnterPetition")
    public String EnterPetition() {
        System.out.println("In submit in controller");
        return "Submit Got to here";
    }

    @RequestMapping(value = "/EnterPetition", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("petition") Petition petition,
                         BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        model.addAttribute("name", petition.getPetitionTitle());
        model.addAttribute("contactNumber", petition.getPetitionTitle());

        return "employeeView";
    }
}