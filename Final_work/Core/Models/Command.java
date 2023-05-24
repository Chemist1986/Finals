package Final_work.Core.Models;

public class Command {
    
    private String cmd;
    private String description;

    public Command(String command, String description) {
        this.cmd = command;
        this.description = description;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.cmd);
        sb.append(": ");
        sb.append(this.description);
        return sb.toString();
    }


}
