import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class TaskListImpl extends UnicastRemoteObject implements TaskList {
    private List<String> tasks;

    public TaskListImpl() throws RemoteException {
        super();
        tasks = new ArrayList<>();
    }

    @Override
    public synchronized void addTask(String task) throws RemoteException {
        tasks.add(task);
        System.out.println("Nouvelle tâche ajoutée : " + task);
    }

    @Override
    public synchronized void removeTask(String task) throws RemoteException {
        if (tasks.contains(task)) {
            tasks.remove(task);
            System.out.println("Tâche supprimée : " + task);
        } else {
            System.out.println("La tâche n'existe pas dans la liste.");
        }
    }

    @Override
    public synchronized List<String> getAllTasks() throws RemoteException {
        return new ArrayList<>(tasks); // Return a copy of the tasks list
    }
}
