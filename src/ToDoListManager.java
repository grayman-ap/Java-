import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDoListManager{
    private List<String> tasks;

    public ToDoListManager(){
        tasks = new ArrayList<String>();
    }
    public void addTask(String task){
        tasks.add(task);
    }
    public void removeTask(int index){
        if(index <= 0 && index < tasks.size()){
            tasks.remove(index);
        }
    }
    public void markTaskAsCompleted(int index){
        if(index >= 0 && index < tasks.size()){
            String task = tasks.get(index);
            tasks.set(index,"[Completed] " +  task);
        }
    }
    public void displayTask(){
        System.out.println("Todo task:");
        for(int i=0; i < tasks.size(); i++){
            System.out.println(i + ".  "+tasks.get(i));
        }
        System.out.println();
    }

    public void saveTasksToFile(String filename){
        try(PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for(String task: tasks){
                writer.println(task);
            }
            System.out.println("To-Do list saved to " + filename);
        } catch(IOException e){
            System.out.println("Error saving To-Do "+ e.getMessage());
        }
}
public void loadTaskFromFile(String filename){
        tasks.clear();
        try(Scanner scanner = new Scanner(new File(filename))){
            while(scanner.hasNextLine()){
                String task = scanner.nextLine();
            }
            System.out.println("To DO list loaded from " + filename);
        }
        catch(IOException e){
            System.out.println("Error loading To-DO "+ e.getMessage());
        }
}

public static void main(String[] args){
        ToDoListManager manager = new ToDoListManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running){
                System.out.print("1. Add Task \b ");
                System.out.print("2. Remove Task \b ");
                System.out.print("3. Mark Task as Completed \b ");
                System.out.print("4. View Task \b ");
                System.out.print("5. Save Task to file  \b ");
                System.out.print("6. Load Task from file \b ");
                System.out.print("7. Quit \b ");
                System.out.print("Enter you choice: \b ");
                int  choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice){
                    case 1:
                        System.out.println("Add task: \b ");
                        String task  = scanner.nextLine();
                        manager.addTask(task);
                        break;
                    case 2:
                        System.out.println("Remove task: \b ");
                        int index = scanner.nextInt();
                        manager.removeTask(index);
                        break;
                    case 3:
                        System.out.println("Mark Completed Task: \b ");
                        int completedTask = scanner.nextInt();
                        manager.markTaskAsCompleted(completedTask);
                        break;
                    case 4:
                        manager.displayTask();
                        break;
                    case 5:
                        System.out.println("Enter Filename to save: \b ");
                        String saveFileName = scanner.nextLine();
                        manager.saveTasksToFile(saveFileName);
                        break;
                    case 6:
                        System.out.println("Enter Filename to save: \b ");
                        String loadFilename = scanner.nextLine();
                        manager.loadTaskFromFile(loadFilename);
                        break;
                    case 7:
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice,Try again \b ");
                }
        }
        scanner.close();
    System.out.println("Program Tarminated");
}
}