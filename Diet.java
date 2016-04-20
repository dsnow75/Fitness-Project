package mattski47.databases386;

/**
 * Created by Matthew on 2/24/2016.
 */
public class Diet
{
    private String food;
    private int calories;
    private String date;

    public Diet(String food, int calories, String date)
    {
        setFood(food);
        setCalories(calories);
        setDate(date);
    }

    public void setFood(String food)
    {
        this.food = food;
    }

    public void setCalories(int calories)
    {
        this.calories = calories;
    }

    public void setDate(String time)
    {
        this.date = time;
    }

    public String getFood()
    {
        return food;
    }

    public int getCalories()
    {
        return calories;
    }

    public String getDate()
    {
        return date;
    }
}
