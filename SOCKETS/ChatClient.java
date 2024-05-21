import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in)
        ) {
            System.out.println("Connecté au serveur de chat.");

            Thread receiveThread = new Thread(() -> {
                String message;
                try {
                    while ((message = in.readLine()) != null) {
                        System.out.println("Message du serveur : " + message);
                    }
                } catch (IOException e) {
                    System.err.println("Erreur lors de la réception des messages : " + e.getMessage());
                }
            });
            receiveThread.start();

            String userMessage;
            while (true) {
                userMessage = scanner.nextLine();
                out.println(userMessage);
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la communication avec le serveur : " + e.getMessage());
        }
    }
}
