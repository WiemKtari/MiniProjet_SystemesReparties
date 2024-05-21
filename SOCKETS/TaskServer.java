import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class TaskServer {
    public static void main(String[] args) {
        try {
            TaskList taskList = new TaskListImpl();
            Registry registry = LocateRegistry.createRegistry(1098); // Utilisez le port 1098
            registry.rebind("TaskListService", taskList);
            System.out.println("Serveur RMI démarré sur le port 1098.");
            System.out.println("Attente des requêtes des clients...");
        } catch (Exception e) {
            System.err.println("Erreur lors du démarrage du serveur : " + e.getMessage());
        }
    }
}

