package com.gpr.project_gpr;



    public class Project {

        private int id_projet;
        private String short_name_project;
        private String long_name_project;
        private String Desc_project;
        private String theme_project;
        private String type_project;
        private String licence_projectt;
        private String visibility_project;
        private String state_project;
        private String agenda_project;

        public int getId_projet() {
            return id_projet;
        }

        public void setId_projet(int id_projet) {
            this.id_projet = id_projet;
        }

        public String getShort_name_project() {
            return short_name_project;
        }

        public void setShort_name_project(String short_name_project) {
            this.short_name_project = short_name_project;
        }

        public String getLong_name_project() {
            return long_name_project;
        }

        public void setLong_name_project(String long_name_project) {
            this.long_name_project = long_name_project;
        }

        public String getDesc_project() {
            return Desc_project;
        }

        public void setDesc_project(String desc_project) {
            Desc_project = desc_project;
        }

        public String getTheme_project() {
            return theme_project;
        }

        public void setTheme_project(String theme_project) {
            this.theme_project = theme_project;
        }

        public String getType_project() {
            return type_project;
        }

        public void setType_project(String type_project) {
            this.type_project = type_project;
        }

        public String getLicence_projectt() {
            return licence_projectt;
        }

        public void setLicence_projectt(String licence_projectt) {
            this.licence_projectt = licence_projectt;
        }

        public String getVisibility_project() {
            return visibility_project;
        }

        public void setVisibility_project(String visibility_project) {
            this.visibility_project = visibility_project;
        }

        public String getState_project() {
            return state_project;
        }

        public void setState_project(String state_project) {
            this.state_project = state_project;
        }

        public String getAgenda_project() {
            return agenda_project;
        }

        public void setAgenda_project(String agenda_project) {
            this.agenda_project = agenda_project;
        }

        public Project(int id_projet, String short_name_project, String long_name_project, String desc_project, String theme_project, String type_project, String licence_projectt, String visibility_project, String state_project, String agenda_project) {
            this.id_projet = id_projet;
            this.short_name_project = short_name_project;
            this.long_name_project = long_name_project;
            Desc_project = desc_project;
            this.theme_project = theme_project;
            this.type_project = type_project;
            this.licence_projectt = licence_projectt;
            this.visibility_project = visibility_project;
            this.state_project = state_project;
            this.agenda_project = agenda_project;
        }

        public Project(String short_name_project, String long_name_project, String desc_project, String theme_project, String type_project, String licence_projectt) {
            this.short_name_project = short_name_project;
            this.long_name_project = long_name_project;
            Desc_project = desc_project;
            this.theme_project = theme_project;
            this.type_project = type_project;
            this.licence_projectt = licence_projectt;
        }
    }


