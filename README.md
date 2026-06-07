# HydraAlert - Smart Water Reminder System

A Java desktop application that helps users track daily water intake, set personalized goals, and receive reminders to stay hydrated.

## Features

- Create hydration profile with name and daily goal
- Set customizable reminder intervals (1-120 minutes)
- Add water intake with validation (max 1000ml per intake)
- Real-time progress bar with color changes based on completion
- Automatic hydration report generation (.txt file)
- Goal completion celebration dialog
- Timer-based reminders (multithreaded)
- Modern GUI with gradient background and custom title bar

## Tech Stack

- Java (Swing for GUI)
- Timer & TimerTask for reminders
- File I/O for report generation

## OOP Concepts Used

- Encapsulation: Private fields with getters/setters in User class
- Inheritance: User extends Person; WaterReminder extends TimerTask
- Polymorphism: Overridden run() method in TimerTask
- Abstraction: DataManager handles file saving without exposing details

## Visuals of Interfaces
<img width="733" height="802" alt="Screenshot 2026-06-07 150433" src="https://github.com/user-attachments/assets/ad9eee39-781e-4ec7-aedf-20161cb7c4b6" />
<img width="738" height="802" alt="Screenshot 2026-06-07 150422" src="https://github.com/user-attachments/assets/b55feecb-8fa0-4c8a-a46c-aef73be243ce" />
<img width="731" height="803" alt="Screenshot 2026-06-07 150410" src="https://github.com/user-attachments/assets/48aa5ac9-9067-492a-93af-f04ed27b1981" />
<img width="733" height="802" alt="Screenshot 2026-06-07 150356" src="https://github.com/user-attachments/assets/49146f92-47fc-4627-8b45-5f8ca720b2a5" />
<img width="745" height="797" alt="Screenshot 2026-06-07 150342" src="https://github.com/user-attachments/assets/8cf7d30a-526e-465a-9f30-36e62609656c" />
<img width="1403" height="345" alt="Screenshot 2026-06-07 150618" src="https://github.com/user-attachments/assets/95ecc76f-09de-44b5-bf50-6788922cd099" />
<img width="731" height="803" alt="Screenshot 2026-06-07 150531" src="https://github.com/user-attachments/assets/e158b89d-d137-4949-b245-277f2c13472c" />
<img width="727" height="811" alt="Screenshot 2026-06-07 150517" src="https://github.com/user-attachments/assets/b628c8ca-5df7-4ce5-bfc3-42b3b8fc6368" />
<img width="727" height="806" alt="Screenshot 2026-06-07 150452" src="https://github.com/user-attachments/assets/9a07ac4b-ab37-4b4a-961f-7d1e814dc3f6" />
<img width="732" height="806" alt="Screenshot 2026-06-07 150443" src="https://github.com/user-attachments/assets/59e20d5c-5ee5-487e-a495-2dae8731688c" />

## How to Run

1. Compile all Java files 
2. Run the application: HydraAlert.java
3. Enter your name, daily goal (ml), amount per intake (ml), and reminder interval (minutes)
4. Click "Drink Water" button to track your intake
5. Receive reminders at your set interval
6. Goal completion triggers automatic hydration report


## Validation Rules

- Daily Goal: 1 - 10000 ml
- Per Intake: 1 - 1000 ml
- Reminder Interval: 1 - 120 minutes

## Team

- W. P. M. H. I. Wijesooriya
- P. Leinojhan



