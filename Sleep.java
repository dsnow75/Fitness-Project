package jmda.pocketfitness;

public class Sleep
{
    private int time_spent;
    private String date;

    public Sleep(int time_spent, String date)
    {
        setTime(time_spent);
        setDate(date);
    }

    public void setTime(int time_spent)
    {
        this.time_spent = time_spent;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public int getTime()
    {
        return time_spent;
    }

    public String getDate()
    {
        return date;
    }
}