package com.gpr.project_gpr;





public class Demande {

    private int id_request;
    private String short_name_request;
    private String long_name_request;
    private String Desc_request;
    private String theme_request;
    private String type_project_request;
    private String licence_request;
    private String visibility;
    private String type_request;
    private String id_User;

    public Demande(String short_name_request, String long_name_request, String desc_request, String theme_request, String type_project_request, String licence_request, String visibility) {
        this.short_name_request = short_name_request;
        this.long_name_request = long_name_request;
        Desc_request = desc_request;
        this.theme_request = theme_request;
        this.type_project_request = type_project_request;
        this.licence_request = licence_request;
        this.visibility = visibility;
    }

    public Demande(int id_request, String short_name_request, String long_name_request, String desc_request, String theme_request, String type_project_request, String licence_request, String visibility, String type_request) {
        this.id_request = id_request;
        this.short_name_request = short_name_request;
        this.long_name_request = long_name_request;
        Desc_request = desc_request;
        this.theme_request = theme_request;
        this.type_project_request = type_project_request;
        this.licence_request = licence_request;
        this.visibility = visibility;
        this.type_request = type_request;
    }

    public int getId_request() {
        return id_request;
    }

    public void setId_request(int id_request) {
        this.id_request = id_request;
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

    public String getType_project_request() {
        return type_project_request;
    }

    public void setType_project_request(String type_project_request) {
        this.type_project_request = type_project_request;
    }

    public String getLicence_request() {
        return licence_request;
    }

    public void setLicence_request(String licence_request) {
        this.licence_request = licence_request;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getType_request() {
        return type_request;
    }

    public void setType_request(String type_request) {
        this.type_request = type_request;
    }

    public String getId_User() {
        return id_User;
    }

    public void setId_User(String id_User) {
        this.id_User = id_User;
    }
}


