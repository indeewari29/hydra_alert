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
<img width="745" height="797" alt="Screenshot 2026-06-07 150342" src="https://github.com/user-attachments/assets/6e3d9cb3-1c34-495c-b1a4-eb0039a3876b" />
<img width="733" height="802" alt="Screenshot 2026-06-07 150356" src="https://github.com/user-attachments/assets/0d96dd16-b788-4e8c-9a1d-f3803cd9143c" />
<img width="731" height="803" alt="Screenshot 2026-06-07 150410" src="https://github.com/user-attachments/assets/f8e85561-4c34-4b28-a996-d851cabb1509" />
<img width="738" height="802" alt="Screenshot 2026-06-07 150422" src="https://github.com/user-attachments/assets/fa1daf1f-4335-4298-b6d8-ce1632a2db24" />
<img width="733" height="802" alt="Screenshot 2026-06-07 150433" src="https://github.com/user-attachments/assets/ba07553e-32c8-4f05-a21e-c27c879f6b33" />
<img width="732" height="806" alt="Screenshot 2026-06-07 150443" src="https://github.com/user-attachments/assets/7f23459a-7fa1-40ef-8a4a-501e899c9490" />
<img width="727" height="806" alt="Screenshot 2026-06-07 150452" src="https://github.com/user-attachments/assets/44fc518a-1c6a-437b-b1e3-76909b77042c" />
<img width="727" height="811" alt="Screenshot 2026-06-07 150517" src="https://github.com/user-attachments/assets/b0b00130-5285-4751-bc0a-5625ce02ba6a" />
<img width="731" height="803" alt="Screenshot 2026-06-07 150531" src="https://github.com/user-attachments/assets/b25cc85f-a83f-4da3-9c32-688f095f799b" />
<img width="1403" height="345" alt="Screenshot 2026-06-07 150618" src="https://github.com/user-attachments/assets/d16581af-bb33-42b7-97e5-f2071d1e3cdc" />

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



