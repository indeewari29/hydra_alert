import java.awt.*;
import java.io.File;
import java.io.PrintWriter;

public class DataManager
{
    public static void saveData(User user, int intake, double reminder)
    {
        try
        {
            int totalIntakes= user.getCurrentIntake() / intake;

            PrintWriter report=new PrintWriter(user.getName() + "'s Daily Hydration Report (HydraAlert).txt");
            report.println("Name: " + user.getName());
            report.println("Daily Goal: " + user.getDailyGoal() + " ml");
            report.println("Amount Per Intake: " + intake + " ml");
            report.println("Total Intakes Taken: " + totalIntakes);
            report.println("Reminder Interval: " + reminder + " min");
            report.println("Status: Goal Achieved Successfully! Keep It Up! 👏");

            report.close();
            Desktop.getDesktop().open(new File(user.getName() + "'s Daily Hydration Report (HydraAlert).txt"));

        }catch (Exception error)
        {
            System.out.println("Unexpected error occurred while saving data");
        }
    }
}
