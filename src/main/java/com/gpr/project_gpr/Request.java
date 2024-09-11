package com.gpr.project_gpr;

public class Request {



    private int id_projet;
    private String short_name_request;
    private String long_name_request;
    private String Desc_request;
    private String theme_request;
    private String type_request;
    private String licence_requestt;
    private String visibility_request;
    private String state_request;
    private String agenda_request;

    public int getId_projet() {
        return id_projet;
    }

    public void setId_projet(int id_projet) {
        this.id_projet = id_projet;
    }

    public String getShort_name_request() {
        return short_name_request;
    }

    public void setShort_name_request(String short_name_request) {
        this.short_name_request = short_name_request;
    }

    public String getLong_name_request() {
        return long_name_request;
    }

    public void setLong_name_request(String long_name_request) {
        this.long_name_request = long_name_request;
    }

    public String getDesc_request() {
        return Desc_request;
    }

    public void setDesc_request(String desc_request) {
        Desc_request = desc_request;
    }

    public String getTheme_request() {
        return theme_request;
    }

    public void setTheme_request(String theme_request) {
        this.theme_request = theme_request;
    }

    public String getType_request() {
        return type_request;
    }

    public void setType_request(String type_request) {
        this.type_request = type_request;
    }

    public String getLicence_requestt() {
        return licence_requestt;
    }

    public void setLicence_requestt(String licence_requestt) {
        this.licence_requestt = licence_requestt;
    }

    public String getVisibility_request() {
        return visibility_request;
    }

    public void setVisibility_request(String visibility_request) {
        this.visibility_request = visibility_request;
    }

    public String getState_request() {
        return state_request;
    }

    public void setState_request(String state_request) {
        this.state_request = state_request;
    }

    public String getAgenda_request() {
        return agenda_request;
    }

    public void setAgenda_request(String agenda_request) {
        this.agenda_request = agenda_request;
    }

    public Request(int id_projet, String short_name_request, String long_name_request, String desc_request, String theme_request, String type_request, String licence_requestt, String visibility_request, String state_request, String agenda_request) {
        this.id_projet = id_projet;
        this.short_name_request = short_name_request;
        this.long_name_request = long_name_request;
        Desc_request = desc_request;
        this.theme_request = theme_request;
        this.type_request = type_request;
        this.licence_requestt = licence_requestt;
        this.visibility_request = visibility_request;
        this.state_request = state_request;
        this.agenda_request = agenda_request;
    }

    public Request(String short_name_request, String long_name_request, String desc_request, String theme_request, String type_request, String licence_requestt) {
        this.short_name_request = short_name_request;
        this.long_name_request = long_name_request;
        Desc_request = desc_request;
        this.theme_request = theme_request;
        this.type_request = type_request;
        this.licence_requestt = licence_requestt;
    }

    public Request(String short_name_request, String long_name_request, String desc_request) {
        this.short_name_request = short_name_request;
        this.long_name_request = long_name_request;
        Desc_request = desc_request;

    }
}


