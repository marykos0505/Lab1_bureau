package bureau;

import java.util.Objects;

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

    public Applicant(String rawData) {
        String[] parts = rawData.split(";");
        if (parts.length != 7) {
            throw new IllegalArgumentException("Ожидается 7 полей, разделенных ';'");
        }
        this.lastName = ApplicantValidator.requireName(parts[0], "Фамилия");
        this.firstName = ApplicantValidator.requireName(parts[1], "Имя");
        this.middleName = parts[2].trim();
        this.qualification = parts[3].trim();
        this.profession = ApplicantValidator.requireName(parts[4], "Профессия");
        this.phone = ApplicantValidator.requirePhone(parts[5]);
        this.desiredSalary = ApplicantValidator.requireSalary(Double.parseDouble(parts[6]));
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

    public String getFullName() {
        return lastName + " " + firstName + (middleName.isEmpty() ? "" : " " + middleName);
    }

    @Override
    public String toString() {
        return String.format("Applicant{ФИО='%s', квалификация='%s', профессия='%s', телефон='%s', зарплата=%.0f}",
                getFullName(), qualification, profession, phone, desiredSalary);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Applicant applicant = (Applicant) o;
        return Double.compare(applicant.desiredSalary, desiredSalary) == 0 &&
                Objects.equals(getFullName(), applicant.getFullName()) &&
                Objects.equals(profession, applicant.profession) &&
                Objects.equals(phone, applicant.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFullName(), profession, phone, desiredSalary);
    }
}