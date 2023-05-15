import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListManager{
    private List<String> tasks;

    public ToDoListManager(){
        tasks = new ArrayList<>();
    }

    public void addTodo(String task){
         tasks.add(task);
    }
    public void removeTodo(int index){
        if(index < 0 && index < tasks.size()){
            tasks.remove(index);
        }

    }
    public void markTaskAsCompleted(int index){
        if(index >= 0 && index < tasks.size()) {
            String task = tasks.get(index);
            tasks.set(index,"[Completed]" + task);
        }
        }

        public void displayTask(){
        System.out.println("Todo list:");
        for(int i = 0; i < tasks.size(); i++){
            System.out.println(i +", "+ tasks.get(i));
        }
        System.out.println();
        }
        public void saveTaskFromFile(String filename){
            try(PrintWriter writer = new PrintWriter(new FileWriter(filename))){
                for (String task : tasks){
                    writer.println(task);
                }
                System.out.println("File saved Successfully "+ filename);
            }
            catch(IOException e){
                System.out.println("Could not save File"+ e.getMessage());
            }
        }
        public void loadTaskFromFile(String filename){
        tasks.clear();
            try(Scanner scanner = new Scanner(new File(filename))){
                while (scanner.hasNextLine()) {
                    String task = scanner.nextLine();
                    tasks.add(task);
                }
                System.out.println("Loaded file successfully "+ filename);
            }
            catch(IOException e){
                    System.out.println("Error loading file "+ e.getMessage());
            }
        }
        public static void main(String[] args){
        ToDoListManager manager = new ToDoListManager();
        Scanner scanner  = new Scanner(System.in);
        boolean running = true;

        while(running){
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. Mark Completed Task");
            System.out.println("4. Display Task");
            System.out.println("5. Save Task");
            System.out.println("6. Load Task");
            System.out.println("7. Quit");
            System.out.println("Enter your choice");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    System.out.println("Enter Task");
                    String task = scanner.nextLine();
                    manager.addTodo(task);
                    break;
                case 2:
                    System.out.println("Remove Task");
                    int index = scanner.nextInt();
                    manager.removeTodo(index);
                    break;
                case 3:
                    System.out.println("Select Completed Task");
                    int markSelected = scanner.nextInt();
                    manager.markTaskAsCompleted(markSelected);
                    break;
                case 4:
                    manager.displayTask();
                    scanner.nextLine();
                    break;
                case 5:
                    System.out.println("Enter file name to save");
                    String saveFileName= scanner.nextLine();
                    manager.saveTaskFromFile(saveFileName);
                    break;
                case 6:
                    System.out.println("Enter File name to load");
                    String loadFilename = scanner.nextLine();
                    manager.loadTaskFromFile(loadFilename);
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice, pick again");
            }
        }
        scanner.close();
        System.out.println("Process Terminated");

        }
}