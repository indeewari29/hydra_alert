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



