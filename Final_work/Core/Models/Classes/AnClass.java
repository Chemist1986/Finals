package Final_work.Core.Models.Classes;

public enum AnClass {
    
    PET, PACKANIMAL;

    public static AnClass toClass (String text) {
        switch (text.toLowerCase()) {
            case "pet":
                return AnClass.PET;
            case "packanimal":
                return AnClass.PACKANIMAL;
            default:
                return AnClass.PET;  
        }
    } 

}
