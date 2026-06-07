import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.util.Timer;

public class HydraAlert {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame();
        frame.setSize(600, 650);
        frame.setTitle("HydraAlert - Smart Water Reminder System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);
        frame.setShape(new RoundRectangle2D.Double(0, 0, 600, 650, 30, 30));

        JPanel titleBar = new JPanel();
        titleBar.setBackground(new Color(30, 100, 150));
        titleBar.setPreferredSize(new Dimension(600, 35));
        titleBar.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("  HydraAlert");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        titleLabel.setForeground(Color.WHITE);

        JButton closeBtn = new JButton("X");
        closeBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        closeBtn.setForeground(Color.WHITE);
        closeBtn.setBackground(new Color(30, 100, 150));
        closeBtn.setBorderPainted(false);
        closeBtn.setFocusPainted(false);
        closeBtn.addActionListener(e -> System.exit(0));

        titleBar.add(titleLabel, BorderLayout.WEST);
        titleBar.add(closeBtn, BorderLayout.EAST);

        JPanel mainPanel = new JPanel(new BorderLayout()) {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gradient = new GradientPaint(
                        0, 0, new Color(135, 206, 235),
                        getWidth(), getHeight(), new Color(70, 130, 200)
                );
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        mainPanel.setBorder(new EmptyBorder(20, 30, 30, 30));

        frame.add(titleBar, BorderLayout.NORTH);
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setVisible(true);

        UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.PLAIN, 14));

        String name = JOptionPane.showInputDialog(frame, "Enter Your Name:", "HydraAlert Setup", JOptionPane.QUESTION_MESSAGE);
        if (name == null || name.trim().isEmpty()) {
            name = "User";
        }

        int dailyGoal = 0;
        while (true) {
            try {
                String goalInput = JOptionPane.showInputDialog(frame, "Enter Your Daily Goal (ml):\n(500ml - 10000ml)", "HydraAlert Setup", JOptionPane.QUESTION_MESSAGE);
                if (goalInput == null) System.exit(0);
                dailyGoal = Integer.parseInt(goalInput);
                if (dailyGoal <= 0 || dailyGoal > 10000) {
                    JOptionPane.showMessageDialog(frame, "Please enter a value between 1 and 10000 ml!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    continue;
                }
                break;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(frame, "Invalid Input! Please enter numbers only.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        int intake = 0;
        while (true) {
            try {
                String intakeInput = JOptionPane.showInputDialog(frame, "Amount of Water Per Intake (ml):\n(50ml - 1000ml)", "HydraAlert Setup", JOptionPane.QUESTION_MESSAGE);
                if (intakeInput == null) System.exit(0);
                intake = Integer.parseInt(intakeInput);
                if (intake <= 0 || intake > 1000) {
                    JOptionPane.showMessageDialog(frame, "Please enter a value between 1 and 1000 ml!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    continue;
                }
                break;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(frame, "Invalid Input! Please enter numbers only.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        double reminderInterval = 0;
        while (true) {
            try {
                String reminderInput = JOptionPane.showInputDialog(frame, "Reminder Interval (minutes):\n(1 - 120 minutes)", "HydraAlert Setup", JOptionPane.QUESTION_MESSAGE);
                if (reminderInput == null) System.exit(0);
                reminderInterval = Double.parseDouble(reminderInput);
                if (reminderInterval <= 0 || reminderInterval > 120) {
                    JOptionPane.showMessageDialog(frame, "Please enter a value between 1 and 120 minutes!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    continue;
                }
                break;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(frame, "Invalid Input! Please enter numbers only.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        User user = new User(name, dailyGoal);
        final double finalReminderInterval = reminderInterval;
        final int finalIntake = intake;

        JPanel welcomeCard = new JPanel();
        welcomeCard.setBackground(new Color(255, 255, 255, 220));
        welcomeCard.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(255, 255, 255, 150), 1),
                new EmptyBorder(20, 20, 20, 20)
        ));
        welcomeCard.setLayout(new GridLayout(3, 1, 5, 5));

        JLabel welcomeLabel = new JLabel("Welcome, " + user.getName() + "!");
        welcomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        welcomeLabel.setForeground(new Color(30, 100, 150));
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel goalLabel = new JLabel("Daily Goal: " + user.getDailyGoal() + " ml");
        goalLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        goalLabel.setForeground(new Color(70, 70, 70));
        goalLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel intakeLabel = new JLabel("Per Intake: " + finalIntake + " ml  |  Reminder: " + (int)finalReminderInterval + " min");
        intakeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        intakeLabel.setForeground(new Color(70, 70, 70));
        intakeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        welcomeCard.add(welcomeLabel);
        welcomeCard.add(goalLabel);
        welcomeCard.add(intakeLabel);

        JPanel progressPanel = new JPanel();
        progressPanel.setOpaque(false);
        progressPanel.setLayout(new BoxLayout(progressPanel, BoxLayout.Y_AXIS));

        JLabel progressTitle = new JLabel("Today's Progress");
        progressTitle.setFont(new Font("Segoe UI", Font.BOLD, 18));
        progressTitle.setForeground(Color.WHITE);
        progressTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JProgressBar progressBar = new JProgressBar(0, user.getDailyGoal());
        progressBar.setValue(user.getCurrentIntake());
        progressBar.setStringPainted(true);
        progressBar.setString(user.getCurrentIntake() + " / " + user.getDailyGoal() + " ml");
        progressBar.setPreferredSize(new Dimension(400, 40));
        progressBar.setFont(new Font("Segoe UI", Font.BOLD, 13));
        progressBar.setBackground(Color.WHITE);
        progressBar.setForeground(new Color(0, 160, 255));
        progressBar.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));

        progressPanel.add(Box.createVerticalStrut(20));
        progressPanel.add(progressTitle);
        progressPanel.add(Box.createVerticalStrut(15));
        progressPanel.add(progressBar);

        JButton drinkButton = new JButton("DRINK WATER (+" + finalIntake + " ml)");
        drinkButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
        drinkButton.setBackground(new Color(50, 150, 200));
        drinkButton.setForeground(Color.WHITE);
        drinkButton.setFocusPainted(false);
        drinkButton.setBorder(BorderFactory.createEmptyBorder(15, 25, 15, 25));
        drinkButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        drinkButton.setPreferredSize(new Dimension(350, 60));

        JPanel centerWrapper = new JPanel();
        centerWrapper.setOpaque(false);
        centerWrapper.setLayout(new BoxLayout(centerWrapper, BoxLayout.Y_AXIS));
        centerWrapper.add(welcomeCard);
        centerWrapper.add(Box.createVerticalStrut(25));
        centerWrapper.add(progressPanel);
        centerWrapper.add(Box.createVerticalStrut(25));

        JPanel buttonWrapper = new JPanel();
        buttonWrapper.setOpaque(false);
        buttonWrapper.add(drinkButton);

        mainPanel.add(centerWrapper, BorderLayout.CENTER);
        mainPanel.add(buttonWrapper, BorderLayout.SOUTH);

        frame.revalidate();
        frame.repaint();

        Timer reminderTimer = WaterReminder.Reminder(finalReminderInterval);

        drinkButton.addActionListener(e -> {
            user.addIntake(finalIntake);
            int current = user.getCurrentIntake();
            int goal = user.getDailyGoal();
            progressBar.setValue(current);
            progressBar.setString(current + " / " + goal + " ml");

            if (current < goal / 2) {
                progressBar.setForeground(new Color(255, 180, 80));
            } else if (current < goal) {
                progressBar.setForeground(new Color(80, 200, 80));
            } else {
                progressBar.setForeground(new Color(50, 150, 255));
            }

            if (current >= goal) {
                reminderTimer.cancel();
                JOptionPane.showMessageDialog(frame, "Amazing! You've reached your daily water goal!", "Goal Completed", JOptionPane.INFORMATION_MESSAGE);
                drinkButton.setEnabled(false);
                drinkButton.setText("GOAL COMPLETED!");
                DataManager.saveData(user, finalIntake, finalReminderInterval);
                JOptionPane.showMessageDialog(frame, "Hydration report has been saved to your computer.", "Report Saved", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
}