package Final_work.Core.Models;

import java.time.LocalDate;
import java.util.List;

import Final_work.Core.Models.Classes.AnClass;

public abstract class Animal {
    
    protected String name;
    protected LocalDate birthday;
    protected AnClass anClass;
    protected List<Command> commands;

    abstract public void setName(String name);

    abstract public String getName();

    abstract public void setBirtday(LocalDate date);

    abstract public LocalDate getBirthday();

    abstract public void addCommand(Command command);

    abstract public List<Command> getCommands();

}
