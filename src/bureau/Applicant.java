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
        this.lastName = ApplicantValidator.requireName(lastName, "Фамилия");
        this.firstName = ApplicantValidator.requireName(firstName, "Имя");
        this.middleName = middleName == null ? "" : middleName.trim();
        this.qualification = qualification;
        this.profession = ApplicantValidator.requireName(profession, "Профессия");
        this.phone = ApplicantValidator.requirePhone(phone);
        this.desiredSalary = ApplicantValidator.requireSalary(desiredSalary);
    }

    public String getLastName() { return lastName; }
    public String getFirstName() { return firstName; }
    public String getMiddleName() { return middleName; }
    public String getQualification() { return qualification; }
    public String getProfession() { return profession; }
    public String getPhone() { return phone; }
    public double getDesiredSalary() { return desiredSalary; }

    public void setLastName(String lastName) { this.lastName = ApplicantValidator.requireName(lastName, "Фамилия"); }
    public void setFirstName(String firstName) { this.firstName = ApplicantValidator.requireName(firstName, "Имя"); }
    public void setMiddleName(String middleName) { this.middleName = middleName == null ? "" : middleName.trim(); }
    public void setQualification(String qualification) { this.qualification = qualification; }
    public void setProfession(String profession) { this.profession = ApplicantValidator.requireName(profession, "Профессия"); }
    public void setPhone(String phone) { this.phone = ApplicantValidator.requirePhone(phone); }
    public void setDesiredSalary(double desiredSalary) { this.desiredSalary = ApplicantValidator.requireSalary(desiredSalary); }
}