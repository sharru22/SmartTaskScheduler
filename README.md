# Smart Task Scheduler

Project Overview
The Smart Task Scheduler is a Java-based desktop application that helps users manage and prioritize tasks efficiently. Tasks are automatically sorted based on priority and deadline, making it easier to focus on the most urgent work. The application also supports persistent storage, ensuring tasks are saved between sessions.

Features

Add, edit, and remove tasks with title, priority, and deadline.
Tasks are automatically sorted by priority (High, Medium, Low) and deadline.
Persistent storage using file-based serialization (tasks.dat).
JavaFX UI for user-friendly interaction.
Filter tasks by today or high priority (optional enhancements possible).

Tools & Technologies

Language: Java 11+
UI Framework: JavaFX
Data Storage: File I/O (serialization)
IDE Support: IntelliJ IDEA / Eclipse / VS Code

Project Structure
SmartTaskScheduler/
│
├─ src/
│   ├─ Task.java           // Model class for tasks
│   ├─ TaskManager.java    // Manages PriorityQueue and file storage
│   └─ Main.java           // JavaFX UI and application entry point
│
├─ lib/                    // JavaFX SDK jars (if using VS Code)
├─ tasks.dat               // Saved task data file
└─ README.md

Setup Instructions
1. Install Java
Make sure Java 11 or above is installed.
Check with:
java -version
2. Install JavaFX SDK
Download from Gluon JavaFX
Extract to a local folder, e.g., C:\javafx-sdk-20\
3. Configure Project
IntelliJ/Eclipse: Add JavaFX SDK as a library.
VS Code: Add VM arguments in .vscode/launch.json:
"vmArgs": "--module-path C:/javafx-sdk-20/lib --add-modules javafx.controls,javafx.fxml"
4. Run the Application
Run Main.java as a JavaFX Application.
The GUI window will open, allowing you to add, view, and remove tasks.

Usage
Enter the task title.
Select priority (1-High, 2-Medium, 3-Low).
Choose deadline date and time.
Click Add Task → task is added to the sorted list.
To remove a task, select it in the list and click Remove Selected Task.
Tasks are automatically saved to tasks.dat.

Future Enhancements
Add reminders/notifications using java.util.Timer.
Implement task editing functionality.
Add filters for today’s tasks or high-priority tasks.
Export tasks to CSV/PDF for reporting.
Add dark mode UI for better user experience.

Conclusion
This project demonstrates:
Use of JavaFX for UI
Use of PriorityQueue for task prioritization
Use of file serialization for persistent storage
Ability to design and implement a full-featured desktop application in Java
