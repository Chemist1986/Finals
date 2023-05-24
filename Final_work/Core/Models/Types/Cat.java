package Final_work.Core.Models.Types;

import java.time.LocalDate;
import java.util.ArrayList;

import Final_work.Core.Models.Command;
import Final_work.Core.Models.Behavior.IPlayable;
import Final_work.Core.Models.Behavior.IRunable;
import Final_work.Core.Models.Behavior.ISitable;
import Final_work.Core.Models.Behavior.IVoiceble;
import Final_work.Core.Models.Classes.AnClass;
import Final_work.Core.Models.Classes.Pet;

public class Cat extends Pet implements IPlayable, ISitable, IRunable, IVoiceble  {

    public Cat(String name, LocalDate birthday) {
        super.name = name;
        super.birthday = birthday;
        super.anClass = AnClass.PET;
        super.commands = new ArrayList<>();
        voice();
        play();
        run();
        sit();
    }

    @Override
    public void voice() {
        super.addCommand(new Command("Голос","Мяу-Мяу"));
    }

    @Override
    public void run() {
        super.addCommand(new Command("Бежать/идти","Бежит быстро"));
    }

    @Override
    public void sit() {
        super.addCommand(new Command("Сидеть","Садится на задние лапы"));
    }

    @Override
    public void play() {
        super.addCommand(new Command("Играть","Весело играет с предметами"));
    }
    
}
