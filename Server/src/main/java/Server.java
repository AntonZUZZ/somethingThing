import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8000)) {
            //todo log
            System.out.println("Server started.");
            while (true) {
                Socket socket = server.accept();
                BufferedWriter writer =
                        new BufferedWriter(
                                new OutputStreamWriter(
                                        socket.getOutputStream()));
                BufferedReader reader =
                        new BufferedReader(
                                new InputStreamReader(
                                        socket.getInputStream()));
                new Thread(() -> {
                    try {
                        String request = reader.readLine();
                        System.out.println(request);

                        //TODO: full logic will be in creating response
                        String response = "HELLO FROM SERVER: " + request.length();

                        writer.write(response);
                        writer.newLine();
                        writer.flush();
                    } catch (IOException e) {
                        //todo log
                        throw new RuntimeException(e);
                    }
                }).start();
            }
        } catch (IOException e) {
            //todo log
            throw new RuntimeException(e);
        }
    }
}
