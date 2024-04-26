package org.example;

public class Student {
    private String usn;
    private String name;
    private String email;
    private String section;
    private String sex;
    private String doB;
    private int heightCm;
    private int weightKg;
    private String homeState;
    private String homeTown;
    private String motherTongue;
    private String elective;
    private String clubs;

    // Default constructor (required for JSON serialization)
    public Student() {}

    public Student(String usn, String name, String email, String section, String sex,
                   String doB, int heightCm, int weightKg, String homeState,
                   String homeTown, String motherTongue, String elective, String clubs) {
        this.usn = usn;
        this.name = name;
        this.email = email;
        this.section = section;
        this.sex = sex;
        this.doB = doB;
        this.heightCm = heightCm;
        this.weightKg = weightKg;
        this.homeState = homeState;
        this.homeTown = homeTown;
        this.motherTongue = motherTongue;
        this.elective = elective;
        this.clubs = clubs;
    }

    public String getUsn() {
        return usn;
    }

    public void setUsn(String usn) {
        this.usn = usn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDoB() {
        return doB;
    }

    public void setDoB(String doB) {
        this.doB = doB;
    }

    public int getHeightCm() {
        return heightCm;
    }

    public void setHeightCm(int heightCm) {
        this.heightCm = heightCm;
    }

    public int getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(int weightKg) {
        this.weightKg = weightKg;
    }

    public String getHomeState() {
        return homeState;
    }

    public void setHomeState(String homeState) {
        this.homeState = homeState;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public String getMotherTongue() {
        return motherTongue;
    }

    public void setMotherTongue(String motherTongue) {
        this.motherTongue = motherTongue;
    }

    public String getElective() {
        return elective;
    }

    public void setElective(String elective) {
        this.elective = elective;
    }

    public String getClubs() {
        return clubs;
    }

    public void setClubs(String clubs) {
        this.clubs = clubs;
    }

    @Override
    public String toString() {
        return "Student{" +
                "usn='" + usn + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", section='" + section + '\'' +
                ", sex='" + sex + '\'' +
                ", doB='" + doB + '\'' +
                ", heightCm=" + heightCm +
                ", weightKg=" + weightKg +
                ", homeState='" + homeState + '\'' +
                ", homeTown='" + homeTown + '\'' +
                ", motherTongue='" + motherTongue + '\'' +
                ", elective='" + elective + '\'' +
                ", clubs='" + clubs + '\'' +
                '}';
    }
}