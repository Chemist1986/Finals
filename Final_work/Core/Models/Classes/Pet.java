package Final_work.Core.Models.Classes;

import java.time.LocalDate;
import java.util.List;

import Final_work.Core.Models.Animal;
import Final_work.Core.Models.Command;

public class Pet extends Animal {

    @Override
    public void setName(String name) {
        super.name = name;
    }

    @Override
    public String getName() {
        return super.name;
    }

    @Override
    public void setBirtday(LocalDate date) {
        super.birthday = date;
        
    }

    @Override
    public LocalDate getBirthday() {
        return super.birthday;
    }

    @Override
    public void addCommand(Command command) {
        super.commands.add(command);
    }

    @Override
    public List<Command> getCommands() {
        return super.commands;
    }
    
}
