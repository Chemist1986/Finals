package Final_work.Core.Infrastructure;

import java.time.LocalDate;

import Final_work.Core.Models.Animal;

public interface ICreateAnimal {

    public Animal createAnimal(String name, String type, LocalDate birthday);
    
}
