package org.example;

class Petition {
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
    private void setPetitionTitle(String petitionTitle){
        this.petitionTitle = petitionTitle;
    }

    public String getPetitionDetail() {
        return petitionDetail;
    }

    public void setPetitionDetail(String petitionDetail) {
        this.petitionDetail = petitionDetail;
    }
}
