package model.entity;

import java.util.Objects;

public class User {
    private long idUser;
    private String login;
    private String name;
    private String surname;
    private String email;
    private String password;
    private Role role;
    private int isActive;

    public User() {
        System.out.println("User.java -> inside User()");
    }

    public User(long idUser, String login, String name, String surname, String email, Role role, int isActive, String password) {

        System.out.println("User.java -> inside User(......)");
        System.out.println("idUser idUser idUser = " + idUser);

        this.idUser = idUser;
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.role = role;
        this.isActive = isActive;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return login.equals(user.login) &&
                name.equals(user.name) &&
                surname.equals(user.surname) &&
                email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, name, surname, email);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + idUser +
                ", login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", isActive=" + isActive +
                '}';
    }
}
