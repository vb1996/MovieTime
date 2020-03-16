package com.example.movietime;

public class PartnerData {
int partnerimage;
    String PartnerName,PartnerAge,PartnerQualification;

    public int getPartnerimage() {
        return partnerimage;
    }

    public void setPartnerimage(int partnerimage) {
        this.partnerimage = partnerimage;
    }

    public String getPartnerName() {
        return PartnerName;
    }

    public void setPartnerName(String partnerName) {
        PartnerName = partnerName;
    }

    public String getPartnerAge() {
        return PartnerAge;
    }

    public void setPartnerAge(String partnerAge) {
        PartnerAge = partnerAge;
    }

    public String getPartnerQualification() {
        return PartnerQualification;
    }

    public void setPartnerQualification(String partnerQualification) {
        PartnerQualification = partnerQualification;
    }

    public PartnerData(int partnerimage, String partnerName, String partnerAge, String partnerQualification) {
        this.partnerimage = partnerimage;
        PartnerName = partnerName;
        PartnerAge = partnerAge;
        PartnerQualification = partnerQualification;
    }


}
