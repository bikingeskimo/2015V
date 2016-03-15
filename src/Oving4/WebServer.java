package Oving4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Roger on 02.03.2016.
 */
public class WebServer {

    public static void main(String[] args) throws IOException {
        final int port = 80;

        ServerSocket tjener = new ServerSocket(port);
        System.out.println("Logg for tjenersiden. Nå venter vi...");
        Socket connection = tjener.accept();

        InputStreamReader streamReader = new InputStreamReader(connection.getInputStream());
        BufferedReader reader = new BufferedReader(streamReader);
        PrintWriter writer = new PrintWriter(connection.getOutputStream(), true);

        writer.println("<HTML><BODY><H1>Velkommen!</H1>");
        writer.println("Header:");
        writer.println("<ul>");


        String line = reader.readLine();
        while (line != null) {
            System.out.println("En klient skrev: " + line);
            writer.println("<li>" + line + "</li>");
            line = reader.readLine();
        }
        writer.println("</ul></BODY></HTML>");
        reader.close();
        writer.close();
        connection.close();
    }

}
