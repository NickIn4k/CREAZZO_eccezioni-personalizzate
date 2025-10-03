import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InvalidDateException {
        LocalDate td = LocalDate.now();
        Data today = new Data(td.getDayOfMonth(), td.getMonthValue(), td.getYear());
        Data other = new Data();

        System.out.println(today.getData()+"\n"+other.getData());

        other.setData(13,4,2007);
        System.out.println(today.getData()+"\n"+other.getData());

        System.out.println("Differenza tra le due date: " + today.dataDiff(other));
    }
}