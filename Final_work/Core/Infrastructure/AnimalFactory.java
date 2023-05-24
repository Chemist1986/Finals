package Final_work.Core.Infrastructure;

import java.time.LocalDate;

import Final_work.Core.Models.Animal;
import Final_work.Core.Models.Types.Camel;
import Final_work.Core.Models.Types.Cat;
import Final_work.Core.Models.Types.Dog;
import Final_work.Core.Models.Types.Donkey;
import Final_work.Core.Models.Types.Hamster;
import Final_work.Core.Models.Types.Horse;

public class AnimalFactory implements ICreateAnimal {

    private static AnimalFactory instance;

    private AnimalFactory() {
    }

    public static AnimalFactory getFactory() {
        if (instance == null) {
            return new AnimalFactory();
        }
        return instance;
    }

    @Override
    public Animal createAnimal(String name, String type, LocalDate birthday) {
        switch (type) {
            case "dog":
                return new Dog(name, birthday);
            case "cat":
                return new Cat(name, birthday);
            case "hamster":
                return new Hamster(name, birthday);
            case "horse":
                return new Horse(name, birthday);
            case "camel":
                return new Camel(name, birthday);
            case "donkey":
                return new Donkey(name, birthday);
            default:
                throw new RuntimeException("Ошибка ввода данных!");
        }
    }
    
}
