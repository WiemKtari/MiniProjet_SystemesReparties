import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static final int PORT = 12345;
    private static Map<PrintWriter, String> clients = new HashMap<>();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Serveur de chat démarré sur le port " + PORT);

            while (true) {
                new ClientHandler(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            System.err.println("Erreur lors du démarrage du serveur : " + e.getMessage());
        }
    }

    private static class ClientHandler extends Thread {
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;
        private String clientName;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        public void run() {
            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                out.println("Veuillez saisir votre nom : ");
                clientName = in.readLine();
                clients.put(out, clientName);
                broadcast(clientName + " a rejoint le salon.");

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Message reçu de " + clientName + " : " + message);
                    broadcast(clientName + ": " + message);
                }
            } catch (IOException e) {
                System.err.println("Erreur lors de la communication avec le client : " + e.getMessage());
            } finally {
                if (out != null) {
                    clients.remove(out);
                    broadcast(clientName + " a quitté le salon.");
                }
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    System.err.println("Erreur lors de la fermeture du socket client : " + e.getMessage());
                }
            }
        }

        private void broadcast(String message) {
            for (PrintWriter client : clients.keySet()) {
                client.println(message);
            }
        }
    }
}
