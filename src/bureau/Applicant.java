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
        if (!ApplicantValidator.validateName(lastName)) throw new IllegalArgumentException("Фамилия пуста");
        if (!ApplicantValidator.validateName(firstName)) throw new IllegalArgumentException("Имя пусто");
        if (!ApplicantValidator.validateName(profession)) throw new IllegalArgumentException("Профессия пуста");
        if (!ApplicantValidator.validatePhone(phone)) throw new IllegalArgumentException("Телефон невалиден");
        if (!ApplicantValidator.validateSalary(desiredSalary)) throw new IllegalArgumentException("Зарплата < 0");

        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName == null ? "" : middleName;
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

    public void setLastName(String lastName) {
        if (!ApplicantValidator.validateName(lastName)) throw new IllegalArgumentException("Фамилия пуста");
        this.lastName = lastName;
    }
    public void setFirstName(String firstName) {
        if (!ApplicantValidator.validateName(firstName)) throw new IllegalArgumentException("Имя пусто");
        this.firstName = firstName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName == null ? "" : middleName;
    }
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
    public void setProfession(String profession) {
        if (!ApplicantValidator.validateName(profession)) throw new IllegalArgumentException("Профессия пуста");
        this.profession = profession;
    }
    public void setPhone(String phone) {
        if (!ApplicantValidator.validatePhone(phone)) throw new IllegalArgumentException("Телефон невалиден");
        this.phone = phone;
    }
    public void setDesiredSalary(double desiredSalary) {
        if (!ApplicantValidator.validateSalary(desiredSalary)) throw new IllegalArgumentException("Зарплата < 0");
        this.desiredSalary = desiredSalary;
    }
}
