package com.gpr.project_gpr;

public class Projet_request_class {
    String id_project;
    String content_ressource ;
    String agenda_ressource;

    public String getAgenda_ressource() {
        return agenda_ressource;
    }

    public Projet_request_class(String id_project, String content_ressource, String agenda_ressource) {
        this.id_project = id_project;
        this.content_ressource = content_ressource;
        this.agenda_ressource = agenda_ressource;
    }

    public void setAgenda_ressource(String agenda_ressource) {
        this.agenda_ressource = agenda_ressource;
    }

    public Projet_request_class(String content_ressource) {
        this.content_ressource = content_ressource;
    }

    public String getId_project() {
        return id_project;
    }

    public Projet_request_class(String id_project, String content_ressource) {
        this.id_project = id_project;
        this.content_ressource = content_ressource;
    }

    public void setId_project(String id_project) {
        this.id_project = id_project;
    }

    public String getContent_ressource() {
        return content_ressource;
    }

    public void setContent_ressource(String content_ressource) {
        this.content_ressource = content_ressource;
    }
}
