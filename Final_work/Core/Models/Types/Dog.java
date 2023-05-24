package Final_work.Core.Models.Types;

import java.time.LocalDate;
import java.util.ArrayList;

import Final_work.Core.Models.Command;
import Final_work.Core.Models.Behavior.IGivePaw;
import Final_work.Core.Models.Behavior.ILearnable;
import Final_work.Core.Models.Behavior.IPlayable;
import Final_work.Core.Models.Behavior.IRunable;
import Final_work.Core.Models.Behavior.ISitable;
import Final_work.Core.Models.Behavior.IVoiceble;
import Final_work.Core.Models.Classes.AnClass;
import Final_work.Core.Models.Classes.Pet;

public class Dog extends Pet implements ILearnable, IGivePaw, IPlayable, ISitable, IRunable, IVoiceble {
    
    public Dog(String name, LocalDate birthday) {
        super.name = name;
        super.birthday = birthday;
        super.anClass = AnClass.PET;
        super.commands = new ArrayList<>();
        learn();
        voice();
        play();
        run();
        sit();
        givePaw();
    }

    @Override
    public void run() {
        super.addCommand(new Command("Бежать/идти","Бежит, виляя хвостом"));
    }

    @Override
    public void play() {
        super.addCommand(new Command("Играть","Приносит палку или мячик"));
    }

    @Override
    public void givePaw() {
        super.addCommand(new Command("Дай лапу","Дает переднюю лапу"));
    }

    @Override
    public void sit() {
        super.addCommand(new Command("Сидеть","Садится на задние лапы"));
    }

    @Override
    public void voice() {
        super.addCommand(new Command("Голос","Гав-Гав"));
    }

    @Override
    public void learn() {
        super.addCommand(new Command("Запомнить команду","Я могу запомнить новую команду"));
    }

}
