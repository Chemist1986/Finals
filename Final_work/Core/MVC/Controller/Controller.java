package Final_work.Core.MVC.Controller;

import Final_work.Core.MVC.Model.Model;
import Final_work.Core.MVC.View.IView;
import Final_work.Core.Models.Behavior.ILearnable;

public class Controller {
    
    private Model model;
    private IView view;
    
    public Controller(Model model, IView view) {
        this.model = model;
        this.view = view;  
    }

    public void updateView() {
        view.printAnimals(model.getRepo());
    }

    public void next() {
        model.next();
        updateView();
        view.setCurrIndex(model.getIndex());                
    }

    public void prev() {
        model.prev();
        updateView();
        view.setCurrIndex(model.getIndex());
    }

    public void addAnimal() {
        String msg = "Введите данные животного в одну строку через запятую в формате: \nВид животного, имя, дата рождения (в формате дд.мм.гггг)\n";
        model.add(view.inputText(msg));
        updateView();
        view.setCurrIndex(model.getIndex());
    }

    public void removeAnimal() {
        model.remove(model.getById(model.getIndex()));
        view.printAnimals(model.getRepo());
        view.setCurrIndex(model.getIndex());
    }

    public void showCommands() {
        view.printCommands(model.getById(model.getIndex()));
    }

    public void addCommand() {
        if(model.getCount() == 0) {
            view.print("Ошибка! В реестре нет ни одного животного, которому можно добавить команду!");
        } else {
            if(model.getById(model.getIndex()) instanceof ILearnable) {
                String msg = "Введите в одну строку команду и её описание. Для разделения команды и описания используйте знак =\n";
                model.addCommandTo(model.getById(model.getIndex()), view.inputText(msg));
                view.printCommands(model.getById(model.getIndex()));
            } else {
                view.print("Это животное не может изучать новые команды");
                view.printCommands(model.getById(model.getIndex()));
            }
            
        }
    }

    public void save() {
        
    }
    
}
