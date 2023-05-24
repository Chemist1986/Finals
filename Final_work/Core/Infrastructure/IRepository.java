package Final_work.Core.Infrastructure;

import java.util.List;

import Final_work.Core.Models.Animal;

public interface IRepository {
    
    void add(Animal animal);

    void remove(Animal animal);

    Animal getById(int id);

    Animal getByName(String name);

    int getCount();

    List<Animal> getAnimalList();
    
    void save();

    void load();

}
