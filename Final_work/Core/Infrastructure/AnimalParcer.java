package Final_work.Core.Infrastructure;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class AnimalParcer {
    
    private String[] splitStr;
    private String type;
    private String name;
    private LocalDate birthday;

    public AnimalParcer(String input) {
        if (input == null ) {
            throw new NullPointerException("Данные отсутствуют");
        }
        input = input.replaceAll("\\s+", " ");
        this.splitStr = input.split(" ");
    }

    public void parseData() {
        try {
            if(splitStr.length != 3) {
                throw new BadParsingException("Ошибка ввода данных!");
            } else {
                try {
                    CheckData(this.splitStr);
                } catch (BadParsingException e) {
                    e.getMessage();
                }
            }
        } catch (BadParsingException e) {
            e.printStackTrace();
        }
    }

    public void CheckData(String[] splitedStr) throws BadParsingException {
        if (splitedStr == null) {
            throw new NullPointerException("Данные отсутствуют");
        }
        StringBuilder errCollector = new StringBuilder();
        for (String item : splitedStr) {
            if (Character.isLetter(item.charAt(0))) {
                    try {
                        String res = checkType(item);
                        if(res != null) {
                            this.type = res;
                        } else {
                            this.name = checkName(item);
                        }
                    } catch (BadParsingException e) {
                        errCollector.append("Указанный вид животного не найден\n");
                    }

            } else {
                if (item.matches("[0-9]{2}\\.[0-9]{2}\\.[0-9]{4}")) {
                    if (this.birthday == null) {
                        try {
                            this.birthday = checkBirthday(item);
                        } catch (BadBirthdayException e) {
                            errCollector.append(e.getMessage());
                        }
                    } else {
                        errCollector.append("Ошибка ввода даты рождения\n");
                    }
                } 
            }
        }
        if (errCollector.length() > 0) {
            throw new BadParsingException(errCollector.toString());
        }
    }

    private String checkName(String inputStr) throws BadParsingException {
        if (inputStr.toLowerCase().matches("^[a-zа-яё]*$")) {
            return inputStr;
        } else {
            throw new BadParsingException("Ошибка ввода имени животного, должны быть только буквы");
        }
    }

    private LocalDate checkBirthday(String inputStr) throws BadBirthdayException {
        try {
            return LocalDate.parse(inputStr, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (DateTimeParseException e) {
            throw new BadBirthdayException();
        }
    }

    private String checkType(String inputStr) throws BadParsingException {
        List<String> dog = new ArrayList<>();
        dog.add("собака");
        dog.add("пес");
        dog.add("пёс");
        dog.add("dog");
        List<String> cat = new ArrayList<>();
        cat.add("кошка");
        cat.add("кот");
        cat.add("cat");
        List<String> hamster = new ArrayList<>();
        hamster.add("хомяк");
        hamster.add("хомячок");
        hamster.add("hamster");
        List<String> horse = new ArrayList<>();
        horse.add("лошадь");
        horse.add("конь");
        horse.add("horse");
        List<String> camel = new ArrayList<>();
        camel.add("верблюд");
        camel.add("верблюдица");
        camel.add("camel");
        List<String> donkey = new ArrayList<>();
        donkey.add("осёл");
        donkey.add("осел");
        donkey.add("ослик");
        donkey.add("ослица");
        donkey.add("donkey");
        if(dog.contains(inputStr.toLowerCase())) {
            return "dog";
        }
        if(cat.contains(inputStr.toLowerCase())) {
            return "cat";
        }
        if(hamster.contains(inputStr.toLowerCase())) {
            return "hamster";
        }
        if(horse.contains(inputStr.toLowerCase())) {
            return "horse";
        }
        if(camel.contains(inputStr.toLowerCase())) {
            return "camel";
        }
        if(donkey.contains(inputStr.toLowerCase())) {
            return "donkey";
        }
        return null;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public LocalDate getBirthday() {
        return this.birthday;
    }

}
