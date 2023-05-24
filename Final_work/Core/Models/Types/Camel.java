package Final_work.Core.Models.Types;

import java.time.LocalDate;
import java.util.ArrayList;

import Final_work.Core.Models.Command;
import Final_work.Core.Models.Behavior.ILearnable;
import Final_work.Core.Models.Behavior.IRunable;
import Final_work.Core.Models.Behavior.IVoiceble;
import Final_work.Core.Models.Classes.AnClass;
import Final_work.Core.Models.Classes.PackAnimal;

public class Camel extends PackAnimal implements ILearnable, IRunable, IVoiceble {

    public Camel(String name, LocalDate birthday) {
            super.name = name;
            super.birthday = birthday;
            super.anClass = AnClass.PACKANIMAL;
            super.commands = new ArrayList<>();
            learn();
            voice();
            run();
            carryLoad();
    }

    @Override
    public void run() {
        super.addCommand(new Command("Бежать/идти","Бежит не быстро и забавно"));
    }

    @Override
    public void voice() {
        super.addCommand(new Command("Голос","Эо-эо-о"));
    }

    @Override
    public void learn() {
        super.addCommand(new Command("Запомнить команду","Я могу запомнить новую команду"));
    }
    
}
