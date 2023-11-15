package org.example;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("Session")

public class Petition {
    /*Class to store a single petition*/
    private String  petitionTitle;
    private String petitionDetail;
    Petition(){
        petitionTitle = null;
        petitionDetail = null;
    }
    public String getPetitionTitle()
    {
        return petitionTitle;
    }
    public void setPetitionTitle(String petitionTitle){
        this.petitionTitle = petitionTitle;
    }

    public String getPetitionDetail() {
        return petitionDetail;
    }

    public void setPetitionDetail(String petitionDetail) {
        this.petitionDetail = petitionDetail;
    }
}
