package bureau;

public final class ApplicantValidator {
    private ApplicantValidator() {}

    public static boolean validateName(String v) {
        return v != null && !v.trim().isEmpty();
    }
    public static boolean validatePhone(String v) {
        return v != null && v.matches("\\+?\\d{10,15}");
    }
    public static boolean validateSalary(double v) {
        return v >= 0;
    }

    public static String requireName(String v, String field) {
        if (!validateName(v)) throw new IllegalArgumentException(field + " не может быть пустым");
        return v.trim();
    }
    public static String requirePhone(String v) {
        if (!validatePhone(v)) throw new IllegalArgumentException("Телефон невалиден");
        return v.trim();
    }
    public static double requireSalary(double v) {
        if (!validateSalary(v)) throw new IllegalArgumentException("Зарплата не может быть отрицательной");
        return v;
    }
}
