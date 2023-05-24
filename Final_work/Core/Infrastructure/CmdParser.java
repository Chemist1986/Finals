package Final_work.Core.Infrastructure;

import Final_work.Core.Models.Command;

public class CmdParser {
    
    private String[] splitStr;
    private String command;
    private String description;
    
    public CmdParser(String input) {
        if (input == null ) {
            throw new NullPointerException("Данные отсутствуют");
        }
        this.splitStr = input.split("=");
    }

    
    public void parseData() throws BadParsingException {
        if(splitStr.length != 2) {
            throw new BadParsingException("Ошибка ввода данных!");
        } else {
            this.command = splitStr[0];
            this.command = command.replaceAll("\\s+", " ");
            if (this.command != null && this.command.length() > 0 && this.command.charAt(this.command.length() - 1) == ' ') {
                this.command = this.command.substring(0, this.command.length() - 1);
            }
            this.description = splitStr[1];
            this.description = description.replaceAll("\\s+", " ");
            if (this.description != null && this.description.length() > 0 && this.description.charAt(0) == ' ') {
                this.description = this.description.substring(1, this.description.length());
            }
        }
    }

    public Command makeCommand() {
        if(this.command == null || this.description == null || this.command.equals("") || this.description.equals("")) {
            throw new NullPointerException("Данные отсутствуют");
        }
        return new Command(this.command, this.description);
    }

}
