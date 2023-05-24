package Final_work.Core.Infrastructure;

public class OutResourseException extends RuntimeException{
    
    public void showMessage() {
        System.out.println("Работа с объектом Counter была не в ресурсном try и/или ресурс остался открыт");
    }

}
