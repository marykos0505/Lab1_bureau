package bureau;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("1. Создание полного клиента");
        Applicant a1 = new Applicant("Иванов", "Илья", "Сергеевич", "высшее", "программист", "+79981539507", 100000);
        System.out.println(a1.toString());

        System.out.println("\n2. Перегрузка конструктора");
        String data = "Матвеев;Сидор;Андреевич;высшее;аналитик;+79796001822;120000";
        Applicant a2 = new Applicant(data);
        System.out.println(a2.toString());

        System.out.println("\n3. Валидация");
        try {
            new Applicant("", "Иван", "Иванович", "среднее", "сварщик", "+79991234567", 90000);
        } catch (IllegalArgumentException e) {
            System.out.println("Поймано исключение: " + e.getMessage());
        }

        System.out.println("\n4. Сравнение на равенство");
        Applicant a3 = new Applicant("Иванов", "Илья", "Сергеевич", "высшее", "программист", "+79981539507", 100000);
        System.out.println("a1.equals(a3): " + a1.equals(a3) + " (ожидается true)");

        System.out.println("\n5. Маппинг в краткую версию");
        List<Applicant> list = new ArrayList<>();
        list.add(a1);
        list.add(a2);

        List<ApplicantShort> shortList = ApplicantMapper.mapAll(list);
        for (ApplicantShort s : shortList) {
            System.out.println(s.toShortString());
        }

        System.out.println("\n6. Обновление краткой версии через Mapper");
        ApplicantShort shortA1 = shortList.get(0);
        System.out.println("До обновления:  " + shortA1);

        a1.setPhone("+79980070809");
        a1.setDesiredSalary(150000);

        ApplicantMapper.update(a1, shortA1);
        System.out.println("После обновления: " + shortA1);

        System.out.println("\n7. Защита сеттеров (валидация при перезаписи)");
        System.out.println("До попытки сломать телефон: " + a1.getPhone());
        try {
            a1.setPhone("невалидный_телефон");
        } catch (IllegalArgumentException e) {
            System.out.println("Поймано исключение при смене телефона: " + e.getMessage());
        }
        System.out.println("После неудачной попытки: " + a1.getPhone() + " (осталось прежним)");
    }
}
