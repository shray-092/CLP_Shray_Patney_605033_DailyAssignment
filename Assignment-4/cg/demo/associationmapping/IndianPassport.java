package cg.demo.associationmapping;

import jakarta.persistence.*;

@Entity
public class IndianPassport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int passportId;

    private String passportNumber;

    @OneToOne
    @JoinColumn(name="citizen_id")
    private Citizen citizen;

    public IndianPassport() {}

    public IndianPassport(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public int getPassportId() {
        return passportId;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }
}