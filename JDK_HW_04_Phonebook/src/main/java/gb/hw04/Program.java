package gb.hw04;

import java.util.Locale;
import java.util.Objects;
import java.util.Set;
public class Program {
    public static final Locale LOCALE = Locale.forLanguageTag("ru");
    private static final Employee[] initialEmployees = {
            new Employee(null, "Козлов Максим", "+7(920)714-67-69", 3),
            new Employee(5, "Иванов Петр", "+7(930)221-74-25", 2),
            new Employee(7, "Ка София", "+7(952)761-90-87", 8),
            new Employee(11, "Трешкина Анна", "+7(999)411-59-68", 9),
            new Employee(null, "Васильева Лера", null, null),
            null,
            new Employee(3, "Воронов Владимир", "+7(943)389-54-81", 7),
            new Employee(null, "Кузиков Антон", "+7(956)451-72-73", 15),
            new Employee(1, "Смиронов Сергей", "+7(953)370-22-50", 1),
            null,
            new Employee(null, "Денисова Эльвира", null, 0),
            new Employee(2, "Лебедкин Никита", "+7(946)742-96-70 ", 2)
    };
    public static void program(){
        Repository employeeRepo = new EmployeeRepository(initialEmployees);
        Utils.printlnEmphasized("\nСОТРУДНИКИ\n");
        Utils.printlnEmphasized("Исходная картотека:\n");
        employeeRepo.forEach(Utils::println);
        final var menuAllowedOptions = Set.of(Set.of("1"), Set.of("2"), Set.of("3"), Set.of("4"), Set.of("0"));
        boolean suppressMenuPrint = false;
        do {
            if (!suppressMenuPrint) {
                printMenu();
                suppressMenuPrint = false;
            }
            var choice = Utils.askUserChoice("Введите пункт меню: ", menuAllowedOptions);
            if (choice.contains("0")) {
                break;
            } else if (choice.contains("1")) {
                // 1. Найти сотрудников по стажу
                var answer = Utils.askInteger(
                        "Введите стаж в полных годах, либо"
                                + "\n\t-1 для поиска сотрудников с не указанным стажем,"
                                + "\n\tили пустой ввод чтобы отменить поиск: ",
                        -1, Integer.MAX_VALUE);
                if (answer.isEmpty()) {
                    suppressMenuPrint = true;
                    continue;
                }
                Integer experience = answer.getAsInt() == -1 ? null : answer.getAsInt();
                var result = employeeRepo.getByExperience(experience);
                Utils.println();
                if (result.isEmpty()) {
                    Utils.println("Не найдено сотрудников с заданным стажем.");
                } else {
                    Utils.printlnEmphasized("Найденные сотрудники:");
                    result.forEach(Utils::println);
                }
            } else if (choice.contains("2")) {
                // 2. Найти телефон(ы) по имени
                var answer = Utils.askString(
                        "Введите имя сотрудника, частично или полностью"
                                + "\n\tили пустой ввод чтобы отменить поиск: ",
                        null, null);
                if (answer.isEmpty()) {
                    suppressMenuPrint = true;
                    continue;
                }
                var result = employeeRepo.getPhonesByName(answer.get());
                Utils.println();
                if (result.isEmpty()) {
                    Utils.println("Не найдено сотрудников с таким именем.");
                } else {
                    Utils.printlnEmphasized("Найденные сотрудники и их телефонные номера:");
                    result.forEach(e -> {
                        Utils.println(
                                e.fullName() + " -- Тел.: " + Objects.requireNonNullElse(e.phone(), "не указан!"));
                    });
                }
            } else if (choice.contains("3")) {
                // 3. Найти сотрудника по табельному номеру
                var answer = Utils.askInteger("Введите табельный номер сотрудника"
                        + "\n\tили пустой ввод чтобы отменить поиск: ", 1, Integer.MAX_VALUE);
                if (answer.isEmpty()) {
                    suppressMenuPrint = true;
                    continue;
                }
                int id = answer.getAsInt();
                var result = employeeRepo.getById(id);
                Utils.println();
                if (result == null) {
                    Utils.println("Не найдено сотрудника с заданным табельным номером.");
                } else {
                    Utils.printlnEmphasized("Найденный сотрудник:");
                    Utils.println(result);
                }
            } else if (choice.contains("4")) {
                // 4. Добавить сотрудника
                Utils.printlnEmphasized("\nНовый сотрудник\n");
                var fullNameOpt = Utils.askString("Введите полное имя (пустой ввод для отмены): ",
                        s -> !s.isBlank(), "Вы не ввели имя. Попробуйте ещё раз.");
                if (fullNameOpt.isEmpty()) {
                    Utils.println("Отменено");
                    suppressMenuPrint = true;
                    continue;
                }
                var phoneOpt = Utils.askString("Введите номер телефона (пустой ввод для отмены): ", null, null);
                if (phoneOpt.isEmpty()) {
                    Utils.println("Отменено");
                    suppressMenuPrint = true;
                    continue;
                }
                String phone = phoneOpt.get().isBlank() ? null : phoneOpt.get();
                var experienceOpt = Utils.askInteger(
                        "Введите стаж в полных годах,"
                                + "\n\tлибо -1, если стаж неизвестен"
                                + "\n\t(пустой ввод для отмены): ",
                        -1, Integer.MAX_VALUE);
                if (experienceOpt.isEmpty()) {
                    Utils.println("Отменено");
                    suppressMenuPrint = true;
                    continue;
                }
                Integer experience = experienceOpt.getAsInt() == -1 ? null : experienceOpt.getAsInt();
                employeeRepo.add(fullNameOpt.get(), phone, experience);
                Utils.println("Новый сотрудник успешно добавлен в базу!");
                Utils.printlnEmphasized("\nКартотека:");
                employeeRepo.forEach(Utils::println);
            }
        } while (Utils.askYesNo("-\nПродолжить (Y/n)? ", true));
        Utils.println("-\nПриложение завершено.");
    }
    private static void printMenu(){
        Utils.printlnEmphasized("\nГлавное меню:");
        Utils.println("1. Найти сотрудников по стажу");
        Utils.println("2. Найти телефон(ы) по имени");
        Utils.println("3. Найти сотрудника по табельному номеру");
        Utils.println("4. Добавить сотрудника");
        Utils.println("0. Завершить");
    }
}

