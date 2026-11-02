package bureau;

import java.util.Objects;

public class ApplicantShort {
    private String shortFio;
    private String profession;
    private double desiredSalary;

    public ApplicantShort(String shortFio, String profession, double desiredSalary) {
        this.shortFio = ApplicantValidator.requireName(shortFio, "ФИО");
        this.profession = ApplicantValidator.requireName(profession, "Профессия");
        this.desiredSalary = ApplicantValidator.requireSalary(desiredSalary);
    }

    public String getShortFio() { return shortFio; }
    public String getProfession() { return profession; }
    public double getDesiredSalary() { return desiredSalary; }

    public void setShortFio(String shortFio) { this.shortFio = ApplicantValidator.requireName(shortFio, "ФИО"); }
    public void setProfession(String profession) { this.profession = ApplicantValidator.requireName(profession, "Профессия"); }
    public void setDesiredSalary(double desiredSalary) { this.desiredSalary = ApplicantValidator.requireSalary(desiredSalary); }

    public String toShortString() {
        return String.format("%s — %s (з/п: %.0f)", shortFio, profession, desiredSalary);
    }

    @Override
    public String toString() { return toShortString(); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApplicantShort that = (ApplicantShort) o;
        return Double.compare(that.desiredSalary, desiredSalary) == 0 &&
                Objects.equals(shortFio, that.shortFio) &&
                Objects.equals(profession, that.profession);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shortFio, profession, desiredSalary);
    }
}
