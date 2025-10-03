public class Data {
    private int day;
    private int month;
    private int year;

    public Data(){
        day = 1;
        month = 1;
        year = 2000;
    }

    public Data(int day, int month, int year) throws InvalidDateException {
        if(!checkData(day, month, year))
            throw new InvalidDateException();

        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String getData(){
        return "[dd/mm/yyyy]: "+day + "/" + month + "/" + year;
    }

    public void setData(int day, int month, int year)throws InvalidDateException{
        if(!checkData(day, month, year))
            throw new InvalidDateException();

        this.day = day;
        this.month = month;
        this.year = year;
    }

    // Idea di base: trasformo entrambe le date in numero di giorni e poi li sottraggo
    public int dataDiff(Data other){
        return Math.abs(absoluteDays(this) - absoluteDays(other));
    }

    private int absoluteDays(Data d){
        int cont = 0;

        for(int i = 0; i < d.year; i++)
            cont += bisestile(i) ? 366 : 365;

        int[] monthDays = {31, (bisestile(d.year) ? 29 : 28), 31, 30, 31, 30,
                31, 31, 30, 31, 30, 31};

        for(int i = 0; i < d.month -1; i++)
            cont += monthDays[i];

        return cont + d.day;
    }

    private boolean checkData(int day, int month, int year){
        int[] monthDays = {31, (bisestile(year) ? 29 : 28), 31, 30, 31, 30,
                31, 31, 30, 31, 30, 31};

        if(month < 1 || month > 12 || year < 0 || year > 9999 || day < 1)
            return false;

        return day <= monthDays[month - 1];
    }

    private boolean bisestile(int year){
        return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
    }
}
