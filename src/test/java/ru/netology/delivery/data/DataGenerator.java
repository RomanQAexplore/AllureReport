package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;


public class DataGenerator {
    private DataGenerator() {

    }

    static Faker faker = new Faker((new Locale("ru")));

    public static String generateDate(int daysToAdd) {
        // TODO: добавить логику для объявления переменной date и задания её значения, для генерации строки с датой
        // Вы можете использовать класс LocalDate и его методы для получения и форматирования даты
        return LocalDate.now().plusDays(daysToAdd).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity(String locale) {
        String[] ArrayOfCities = {"Москва", "Санкт-Петербург", "Орёл", "Петропавловск-Камчатский", "Ростов-на-Дону", "Ханты-Мансийск",
                "Горно-Алтайск", "Йошкар-Ола", "Южно-Сахалинск", "Нижний Новгород", "Нарьян-Мар", "Великий Новгород", "Улан-Удэ",
                "Южно-Сахалинск", "Тюмень", "Екатеринбург", "Челябинск", "Пермь", "Омск", "Томск", "Барнаул", "Владивосток",
                };

        Random random = new Random();
        int i = random.nextInt(ArrayOfCities.length);

        // TODO: добавить логику для объявления переменной city и задания её значения, генерацию можно выполнить
        // с помощью Faker, либо используя массив валидных городов и класс Random
        return ArrayOfCities[i];
    }

    public static String generateName(String locale) {
        // TODO: добавить логику для объявления переменной name и задания её значения, для генерации можно
        // использовать Faker
        return faker.name().fullName();
    }


    public static String generatePhone(String locale) {
        // TODO: добавить логику для объявления переменной phone и задания её значения, для генерации можно
        // использовать Faker
        Faker faker = new Faker(new Locale(locale));
        String phone = faker.numerify("+7##########");
        return phone;
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            // TODO: добавить логику для создания пользователя user с использованием методов generateCity(locale),
            // generateName(locale), generatePhone(locale)

            return new UserInfo(
                    generateCity("ru"),
                    generateName("ru"),
                    generatePhone("ru")
            );
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}