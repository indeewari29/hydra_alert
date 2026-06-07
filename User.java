public class User extends Person
{
    private int currentIntake;
    private final int dailyGoal;

    public User(String name, int dailyGoal)
    {
        super(name);
        this.dailyGoal=dailyGoal;
        this.currentIntake=0;
    }


    public void addIntake(int num)
    {
        currentIntake += num;
    }

    public int getCurrentIntake()
    {
        return currentIntake;
    }

    public int getDailyGoal()
    {
        return dailyGoal;
    }
}




