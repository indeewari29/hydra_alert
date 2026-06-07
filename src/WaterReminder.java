import javax.swing.JOptionPane;
import java.util.Timer;
import java.util.TimerTask;

public class WaterReminder {
    public static Timer Reminder(double min) {
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                JOptionPane.showMessageDialog(null, "Time For A Water Break!");
            }
        }, (long) (min * 60000), (long) (min * 60000));

        return timer;
    }
}





