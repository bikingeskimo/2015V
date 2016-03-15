package Oving4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

class SocketTjener {
    public static void main(String[] args) throws IOException {
        final int portnr = 1250;

        Socket forbindelse = null;
        ArrayList<TraadKlientHaandterer> tråder = new ArrayList<>();
        ArrayList<Socket> connections = new ArrayList<>();

        ServerSocket tjener = new ServerSocket(portnr);

        System.out.println("Logg for tjenersiden. Nå venter vi...");

        while (true) {
            forbindelse = tjener.accept();

            TraadKlientHaandterer klienttråd = new TraadKlientHaandterer(forbindelse, connections.size() + 1);
            klienttråd.start();
            connections.add(forbindelse);
            tråder.add(klienttråd);

            System.out.println("Ny tråd opprettet - nr: " + connections.size());
        }
    }

}


