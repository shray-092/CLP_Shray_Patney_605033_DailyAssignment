package cg.demo.jpahibernates.entities;

//import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employee") 
//Specifies the database table name to which this entity is mapped.
public class Employee {
	@Id
//	@Column(name = "EMP_ID") 
	// by using this we can rename a column
	// here the Java field id will be stored in the database column EMP_ID.
//	@GeneratedValue .... single value sequence created .. automatic id generated for all entities
//	@GeneratedValue(strategy=GenerationType.IDENTITY) // auto incremented id generated for all 
	// entities with new sequence values starting with 1
//	@ElementCollection .... collection of values for a single entity apply on wrapper class like List<String> or Set<String> or Map<String, String> etc only
//	@Embeddable .... to create reusable component class for common attributes of multiple entities and use it as a field in those entities
//	@email .... to validate email format for a String field
//	@NotNull ... to validate that a field value should not be null
//	@Notblank ... to validate that a String field value should not be null or empty
// @Size(min=2, max=20) ... to validate that a String field value should have
// length between 2 and 20
// @Min(1000) ... to validate that a numeric field value should be minimum 1000
// @Max(100000) ... to validate that a numeric field value should be maximum 100000
// @Past ... to validate that a Date field value should be in the past
// @Future ... to validate that a Date field value should be in the future
// @Pattern(regexp="^[A-Za-z]+$") ... to validate that a String field value
	// should match the given regular expression pattern

	private int id;
	private String ename;
	private double salary;
	private String dept;
	private long phoneno;

	public Employee() {
	}

	public Employee(int id, String ename, double salary, String dept, long phoneno) {
		this.id = id;
		this.ename = ename;
		this.salary = salary;
		this.dept = dept;
		this.phoneno = phoneno;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public long getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}

	@Override
	public String toString() {
		return "Employees [id=" + id + ", ename=" + ename + ", salary=" + salary + ", dept=" + dept + ", phoneno="
				+ phoneno + "]";
	}
}
