package com.zqp.domain;

import java.io.Serializable;

public class Traveller implements Serializable {

    private Integer travellerId;
    private String travellerName;
    private String travellerGender;
    private String travellerPhoneNum;
    private Integer idType;
    private String idNum;
    private Integer travellerType;

    public String getTravellerTypeStr(){
        if (this.travellerType==0){
            return "成人";
        }else{
            return "儿童";
        }
    }

    public String getIdTypeStr(){
        if (this.idType==0){
            return "身份证";
        }else if (this.idType==1){
            return "护照";
        }else{
            return "军官证";
        }
    }

    public Integer getTravellerId() {
        return travellerId;
    }

    public void setTravellerId(Integer travellerId) {
        this.travellerId = travellerId;
    }

    public String getTravellerName() {
        return travellerName;
    }

    public void setTravellerName(String travellerName) {
        this.travellerName = travellerName;
    }

    public String getTravellerGender() {
        return travellerGender;
    }

    public void setTravellerGender(String travellerGender) {
        this.travellerGender = travellerGender;
    }

    public String getTravellerPhoneNum() {
        return travellerPhoneNum;
    }

    public void setTravellerPhoneNum(String travellerPhoneNum) {
        this.travellerPhoneNum = travellerPhoneNum;
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public Integer getTravellerType() {
        return travellerType;
    }

    public void setTravellerType(Integer travellerType) {
        this.travellerType = travellerType;
    }

    @Override
    public String toString() {
        return "Traveller{" +
                "travellerId=" + travellerId +
                ", travellerName='" + travellerName + '\'' +
                ", travellerGender='" + travellerGender + '\'' +
                ", travellerPhoneNum='" + travellerPhoneNum + '\'' +
                ", idType=" + idType +
                ", idNum='" + idNum + '\'' +
                ", travellerType=" + travellerType +
                '}';
    }
}
