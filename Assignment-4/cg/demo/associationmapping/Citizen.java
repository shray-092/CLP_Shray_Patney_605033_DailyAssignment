package cg.demo.associationmapping;

import jakarta.persistence.*;

@Entity
public class Citizen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String city;

    @OneToOne(mappedBy = "citizen",
              cascade = CascadeType.ALL,
              fetch = FetchType.LAZY)
    private IndianPassport passport;

    public Citizen() {}

    public Citizen(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public IndianPassport getPassport() {
        return passport;
    }

    public void setPassport(IndianPassport passport) {
        this.passport = passport;
    }

	public void setCity(String city) {
		// TODO Auto-generated method stub
		this.city = city;
		
	}
}