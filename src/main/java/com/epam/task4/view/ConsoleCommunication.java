package com.epam.task4.view;


import com.epam.task4.controller.Controller;
import com.epam.task4.controller.exception.ControllerException;
import com.epam.task4.service.exception.ServiceException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleCommunication {
<<<<<<< HEAD




    public void consoleCommunication() throws IOException, ControllerException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Controller controller = Controller.getInstance();
=======
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private Controller controller = Controller.getInstance();


    public static void main(String[] args) throws IOException, ControllerException, ServiceException {

        ConsoleCommunication consoleCommunication = new ConsoleCommunication();

        consoleCommunication.consoleCommunication();

    }

    public void consoleCommunication() throws IOException, ControllerException {
>>>>>>> 928a172da525de4ed9c409d06b8a3334992c4d1b
        String request = "";

        controller.init();

        while (!request.toLowerCase().equals("exit-")) {

            request = reader.readLine();

<<<<<<< HEAD
            controller = Controller.getInstance();
=======
            Controller controller = Controller.getInstance();
>>>>>>> 928a172da525de4ed9c409d06b8a3334992c4d1b
            controller.executeTask(request);

        }


        controller.destroy();
    }
}
