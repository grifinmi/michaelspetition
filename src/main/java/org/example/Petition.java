package org.example;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("Session")

public class Petition {
    /*Class to store a single petition*/
    private String  petitionTitle;
    private String petitionDetail;
    private int petitionId;
    Petition(){
        petitionTitle = null;
        petitionDetail = null;
        petitionId = 0;
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

    public void setPetitionId(int petitionId) {
        this.petitionId = petitionId;
    }
    public int getPetitionId() {
        return petitionId;
    }
}