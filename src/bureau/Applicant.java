package bureau;

public class Applicant {
    private String lastName;
    private String firstName;
    private String middleName;
    private String qualification;
    private String profession;
    private String phone;
    private double desiredSalary;

    public Applicant(String lastName, String firstName, String middleName,
                     String qualification, String profession, String phone, double desiredSalary) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.qualification = qualification;
        this.profession = profession;
        this.phone = phone;
        this.desiredSalary = desiredSalary;
    }

    public String getLastName() { return lastName; }
    public String getFirstName() { return firstName; }
    public String getMiddleName() { return middleName; }
    public String getQualification() { return qualification; }
    public String getProfession() { return profession; }
    public String getPhone() { return phone; }
    public double getDesiredSalary() { return desiredSalary; }

    public void setPhone(String phone) { this.phone = phone; }
    public void setDesiredSalary(double desiredSalary) { this.desiredSalary = desiredSalary; }
}
