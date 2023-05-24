package Final_work.Core.Infrastructure;

import java.util.ArrayList;
import java.util.List;

import Final_work.Core.Models.Animal;

public class Repository implements IRepository {

    private List<Animal> animals;

    public Repository() {
        this.animals = new ArrayList<>();
    }

    @Override
    public void add(Animal animal) {
        animals.add(animal);
    }

    @Override
    public void remove(Animal animal) {
        animals.remove(animal);
    }

    @Override
    public Animal getByName(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equals(name)) {
                return animal;
            }
        }
        return null;
    }

    @Override
    public Animal getById(int id) {
        if(id >= 0 && id < animals.size()) {
            return animals.get(id);
        }
        return null;
    }

    @Override
    public int getCount() {
        if(animals != null) {
            return animals.size();
        }
        return 0; 
    }

    @Override
    public List<Animal> getAnimalList() {
        if(animals != null) {
            return animals;
        }
        return null;
    }

    @Override
    public void save() {
        // try (FileWriter writer = new FileWriter(pathDB, false)) {
        //     for (int i = 0; i < currentBook.count(); i++) {
        //         Note note = currentBook.getTask(i);
        //         writer.append(String.format("%d;%s;%s;%s;%s;%s;%s\n", note.getId(), note.getDate(), note.getTime(), note.getDeadline(), note.getTask(), note.getAuthor(), note.getPriority()));
        //     }
        //     writer.flush();
        //     writer.close();
        // } catch (IOException ex) {
        //     System.out.println(ex.getMessage());
        // }
    }

    @Override
    public void load() {
        // try {
        //     File file = new File(pathDB);
        //     if (file.exists()) {
        //         FileReader fr = new FileReader(file);
        //         BufferedReader reader = new BufferedReader(fr);
        //         String currLine = reader.readLine();
        //         int id = 0;
        //         while (currLine != null) {
        //             String[] nl = currLine.split(";");
        //             id++;
        //             String date = nl[1];  
        //             String time = nl[2];
        //             String deadline = nl[3];
        //             String task = nl[4];
        //             String author = nl[5];
        //             Priority priority = Priority.toPriority(nl[6]);
        //             this.currentBook.add(new Note(id, date, time, deadline, task, author, priority));
        //             currLine = reader.readLine();
        //         }
        //         reader.close();
        //         fr.close();
        //     } else {
        //         System.out.println("Ошибка открытия файла! Файл data.csv не найден!");
        //     } 
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
    }
    
}
