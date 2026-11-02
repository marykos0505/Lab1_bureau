package bureau;

import java.util.ArrayList;
import java.util.List;

public final class ApplicantMapper {
    private ApplicantMapper() {}

    public static ApplicantShort map(Applicant applicant) {
        if (applicant == null) throw new IllegalArgumentException("applicant is null");
        String shortFio = abbreviateName(applicant.getLastName(), applicant.getFirstName(), applicant.getMiddleName());
        return new ApplicantShort(shortFio, applicant.getProfession(), applicant.getDesiredSalary());
    }

    public static List<ApplicantShort> mapAll(List<Applicant> applicants) {
        List<ApplicantShort> result = new ArrayList<>();
        for (Applicant a : applicants) result.add(map(a));
        return result;
    }

    private static String abbreviateName(String lastName, String firstName, String middleName) {
        StringBuilder sb = new StringBuilder(lastName).append(" ");
        sb.append(firstName.charAt(0)).append(".");
        if (middleName != null && !middleName.isEmpty()) sb.append(middleName.charAt(0)).append(".");
        return sb.toString();
    }
}