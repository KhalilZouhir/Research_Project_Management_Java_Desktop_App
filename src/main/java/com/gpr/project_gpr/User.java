package com.gpr.project_gpr;

import java.util.Collection;

public class User {
    private Collection<Project> projects;
    private String Surname;

    public Collection<Project> getProjects() {
        return projects;
    }

    public void setProjects(Collection<Project> projects) {
        this.projects = projects;
    }

    private String Name;
    private String Email;
    private String username;
    private int Id_User;

    public User(String surname, String name, String email) {
        Surname = surname;
        Name = name;
        Email = email;

    }

    @Override
    public String toString() {
        return "User{" +
                "Surname='" + Surname + '\'' +
                ", Name='" + Name + '\'' +
                ", Email='" + Email + '\'' +
                ", username='" + username + '\'' +
                ", Id_User=" + Id_User +
                '}';
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId_User() {
        return Id_User;
    }

    public void setId_User(int id_User) {
        Id_User = id_User;
    }
}
