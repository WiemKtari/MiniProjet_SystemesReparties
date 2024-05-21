import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

public class TaskClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1098);
            TaskList taskList = (TaskList) registry.lookup("TaskListService");
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("1. Ajouter une tâche");
                System.out.println("2. Supprimer une tâche");
                System.out.println("3. Récupérer la liste complète des tâches");
                System.out.println("4. Quitter");
                System.out.print("Choix : ");
                int choix = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choix) {
                    case 1:
                        System.out.print("Entrez la tâche à ajouter : ");
                        String taskToAdd = scanner.nextLine();
                        taskList.addTask(taskToAdd);
                        break;
                    case 2:
                        System.out.print("Entrez la tâche à supprimer : ");
                        String taskToRemove = scanner.nextLine();
                        taskList.removeTask(taskToRemove);
                        break;
                    case 3:
                        List<String> allTasks = taskList.getAllTasks();
                        System.out.println("Liste des tâches :");
                        for (String task : allTasks) {
                            System.out.println(task);
                        }
                        break;
                    case 4:
                        System.out.println("Au revoir !");
                        System.exit(0);
                    default:
                        System.out.println("Choix invalide. Veuillez réessayer.");
                }
            }
        } catch (Exception e) {
            System.err.println("Erreur lors de l'utilisation du client : " + e.getMessage());
        }
    }
}
