package Final_work.Core.MVC.View;

import Final_work.Core.Infrastructure.Repository;
import Final_work.Core.Models.Animal;

public interface IView {
    
    void showMenu(int menu);
    void refresh();
    void setCurrIndex(int value);
    void printAnimals(Repository animals);
    void printCommands(Animal animal);
    void print(String value);
    String inputText(String text);

}
