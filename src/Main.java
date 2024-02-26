import Service.TaskService;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        TaskService taskService = new TaskService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
        System.out.println("Выберите действие:\n" +
                "1. Создать\n" +
                "2. Редактировать\n" +
                "3. Удалить\n" +
                "4. Показать задачи\n" +
                "5. Закончить задачу\n " +
                "\n"+
                "Выберите номер действия (1-5): ");
        int userInput = scanner.nextInt();
        scanner.nextLine();
        try {
            switch (userInput) {
                case 1:
                    System.out.print("Введите текстовое описание задачи: ");
                    String userSaveTask = scanner.nextLine();
                    taskService.saveTask(userSaveTask);
                    break;
                case 2:
                    System.out.println("Введите ID задачи, которую хотите отредактировать: ");
                    int userEditTaskId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Введите новое текстовое описание задачи: ");
                    String userEditTaskString = scanner.nextLine();
                    taskService.editTask(userEditTaskId, userEditTaskString);
                    break;
                case 3:
                    System.out.print("Введите ID задачи, которую хотите удалить: ");
                    int userDeleteTask = scanner.nextInt();
                    taskService.deleteTask(userDeleteTask);
                    System.out.println("Задача удалена!");
                    break;
                case 4:
                    taskService.showTask();
                    break;
                case 5:
                    System.out.println("Введите ID задачи, которую хотите закончить: ");
                    int userFinishTask = scanner.nextInt();
                    taskService.finishTask(userFinishTask);
                    System.out.println("Задача завершена!");
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Неверный ввод");
            break;
            }
        }
    }
}