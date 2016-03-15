package Oving2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TraadKlientHaandterer extends Thread {
    Socket forbindelse;
    InputStreamReader leseforbindelse;
    BufferedReader leseren;
    PrintWriter skriveren;

    int id;

    public TraadKlientHaandterer(Socket forbindelse, int id) {
        this.id = id;
        this.forbindelse = forbindelse;
        System.out.println("Connection tråd: " + id);

    }
    public void run(){
        try {
        /* Åpner strømmer for kommunikasjon med klientprogrammet */
            leseforbindelse = new InputStreamReader(forbindelse.getInputStream());
            leseren = new BufferedReader(leseforbindelse);
            skriveren = new PrintWriter(forbindelse.getOutputStream(), true);

    /* Sender innledning til klienten */
            skriveren.println("Hei, du har kontakt med tjenersiden!");
            skriveren.println("Skriv hva du vil, så skal jeg gjenta det, avslutt med linjeskift.");

    /* Mottar data fra klienten */
            String enLinje = leseren.readLine();  // mottar en linje med tekst
            while (enLinje != null) {  // forbindelsen på klientsiden er lukket
                System.out.println("En klient med nr " + id + " skrev: " + enLinje);
                skriveren.println("Du skrev: " + enLinje);  // sender svar til klienten
                enLinje = leseren.readLine();

                if (enLinje.equals("Kalk")) {
                    System.out.println("Kalkulator er valgt");
                    skriveren.println("Du har valgt kalkulator");
                    enLinje = leseren.readLine();

                    while (enLinje != null) {
                        String tall[] = enLinje.trim().split(" ");
                        if (tall.length != 3) {
                            System.out.println("En klient skrev noe som ikke funker");
                            skriveren.println("Du skrev: " + enLinje + ". Dette er ikke lov");
                            break;
                        }
                        int tall1 = 0;
                        int tall2 = 0;
                        try {
                            tall1 = Integer.parseInt(tall[0]);
                        } catch (Exception e) {
                            System.out.println("Dette er ikke et tall");
                            skriveren.println("Du skrev: " + tall[0] + ". Det er ikke et tall");
                        }
                        try {
                            tall2 = Integer.parseInt(tall[1]);
                        } catch (Exception e) {
                            System.out.println("Dette er ikke et tall");
                            skriveren.println("Du skrev: " + tall[1] + ". Det er ikke et tall");
                        }
                        int sum = 0;
                        switch (tall[2]) {
                            case "add":
                                sum = tall1 + tall2;
                                System.out.println("Svaret er: " + sum);
                                skriveren.println("Svaret er: " + sum);
                                break;
                            case "sub":
                                sum = Integer.parseInt(tall[0]) - Integer.parseInt(tall[1]);
                                System.out.println("Svaret er: " + sum);
                                skriveren.println("Svaret er: " + sum);
                                break;
                            default:
                                System.out.println("Dette er ikke en gyldig kommando");
                                skriveren.println("Du skrev: " + tall[2] + ". Det er ikke en gyldig kommando");
                                break;
                        }
                        enLinje = leseren.readLine();
                    }
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        finally {
            try {
                /* Lukker forbindelsen */
                leseren.close();
                skriveren.close();
                forbindelse.close();
            } catch (Exception e){
                System.out.println(e);
            }
        }
    }
}