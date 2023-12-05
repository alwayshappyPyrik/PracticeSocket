package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static final String host = "netology.homework";

    public static void main(String[] args) {

        try (Socket clientSocket = new Socket(host, Server.LOCALHOST_PORT);
             Scanner scanner = new Scanner(System.in);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            System.out.println(in.readLine());
            String name = scanner.nextLine();
            out.println(name);
            System.out.println(in.readLine());
            String answerOnQuestion = scanner.nextLine();
            out.println(answerOnQuestion);
            System.out.println(in.readLine());

        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
