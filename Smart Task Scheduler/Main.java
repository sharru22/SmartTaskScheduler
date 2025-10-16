import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    private List<Task> tasks = new ArrayList<>();
    private VBox taskListVBox;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Smart Task Scheduler");

        // Input fields
        TextField taskNameField = new TextField();
        taskNameField.setPromptText("Enter task name");

        DatePicker datePicker = new DatePicker();
        datePicker.setPromptText("Select date");

        TextField hourField = new TextField();
        hourField.setPromptText("Hour (0-23)");

        TextField minuteField = new TextField();
        minuteField.setPromptText("Minute (0-59)");

        Button addButton = new Button("Add Task");

        taskListVBox = new VBox(5);
        taskListVBox.setPadding(new Insets(10));

        addButton.setOnAction(e -> {
            try {
                String name = taskNameField.getText();
                if (name.isEmpty()) {
                    showAlert("Task name cannot be empty!");
                    return;
                }

                if (datePicker.getValue() == null) {
                    showAlert("Please select a date!");
                    return;
                }

                int hour = Integer.parseInt(hourField.getText());
                int minute = Integer.parseInt(minuteField.getText());

                LocalDateTime dateTime = LocalDateTime.of(
                        datePicker.getValue().getYear(),
                        datePicker.getValue().getMonthValue(),
                        datePicker.getValue().getDayOfMonth(),
                        hour,
                        minute
                );

                Task task = new Task(name, dateTime);
                tasks.add(task);
                updateTaskList();
                clearInputs(taskNameField, datePicker, hourField, minuteField);

            } catch (NumberFormatException ex) {
                showAlert("Hour and Minute must be numbers!");
            } catch (Exception ex) {
                showAlert("Error adding task: " + ex.getMessage());
            }
        });

        VBox root = new VBox(10, taskNameField, datePicker, hourField, minuteField, addButton, taskListVBox);
        root.setPadding(new Insets(15));

        Scene scene = new Scene(root, 400, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateTaskList() {
        taskListVBox.getChildren().clear();
        for (Task task : tasks) {
            Label taskLabel = new Label(task.toString());
            taskListVBox.getChildren().add(taskLabel);
        }
    }

    private void clearInputs(TextField nameField, DatePicker datePicker, TextField hourField, TextField minuteField) {
        nameField.clear();
        datePicker.setValue(null);
        hourField.clear();
        minuteField.clear();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Inner Task class
    private static class Task {
        private String name;
        private LocalDateTime dateTime;

        public Task(String name, LocalDateTime dateTime) {
            this.name = name;
            this.dateTime = dateTime;
        }

        @Override
        public String toString() {
            return name + " at " + dateTime.toString();
        }
    }
}
