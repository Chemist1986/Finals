package Final_work.Core.Models.Types;

import java.time.LocalDate;
import java.util.ArrayList;

import Final_work.Core.Models.Command;
import Final_work.Core.Models.Behavior.IPlayable;
import Final_work.Core.Models.Behavior.IRunable;
import Final_work.Core.Models.Behavior.IVoiceble;
import Final_work.Core.Models.Classes.AnClass;
import Final_work.Core.Models.Classes.Pet;

public class Hamster extends Pet implements IRunable, IPlayable, IVoiceble {

    public Hamster(String name, LocalDate birthday) {
        super.name = name;
        super.birthday = birthday;
        super.anClass = AnClass.PET;
        super.commands = new ArrayList<>();
        voice();
        play();
        run();
    }

    @Override
    public void voice() {
        super.addCommand(new Command("Голос:","Пи-пи-пи"));
    }

    @Override
    public void play() {
        super.addCommand(new Command("Бежать/идти","Играет в прятки"));
    }

    @Override
    public void run() {
        super.addCommand(new Command("Бежать/идти","Бежит, вращая колесо"));
    }
    
}
