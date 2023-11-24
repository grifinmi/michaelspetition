package org.example;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("Session")

public class Petition {
    /*Class to store a single petition*/
    private String  petitionName;
    private String petitionDetail;
    private int petitionId;
    private ArrayList<String> signatureList = new ArrayList<>();

    public ArrayList<String> getSignatureList() {
        return signatureList;
    }
    public void setSignatureList(String signature) {
        signatureList.add(signature);
    }

    Petition(){
        petitionName = null;
        petitionDetail = null;
        petitionId = 0;
    }
    public String getPetitionName()
    {
        return petitionName;
    }
    public void setPetitionName(String petitionName){
        this.petitionName = petitionName;
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