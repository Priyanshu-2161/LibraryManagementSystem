package org.example.library.model;

public class Member {

    private int id;
    private String name;
    private String email;
    private String membershipId;
    private String password;

    public Member(int id, String name, String email,
                  String membershipId, String password) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.membershipId = membershipId;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMembershipId() {
        return membershipId;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMembershipId(String membershipId) {
        this.membershipId = membershipId;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}