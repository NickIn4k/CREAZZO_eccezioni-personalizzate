public class InvalidDateException extends Exception{
    public InvalidDateException(){
        super("Formato inserito non valido!");
    }

    public InvalidDateException(String message){
        super(message);
    }
}
