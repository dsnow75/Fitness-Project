package jmda.pocketfitness;

public class Exercise
{
    private String activity;
    private int time_spent;
    private String date;

    public Exercise(String activity, int time_spent, String date)
    {
        setActivity(activity);
        setTime(time_spent);
        setDate(date);
    }

    public void setActivity(String activity)
    {
        this.activity = activity;
    }

    public void setTime(int time_spent)
    {
        this.time_spent = time_spent;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public String getActivity()
    {
        return activity;
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