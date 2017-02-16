package com.epam.task4.view;


import com.epam.task4.controller.Controller;
import com.epam.task4.controller.exception.ControllerException;
import com.epam.task4.service.exception.ServiceException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleCommunication {




    public void consoleCommunication() throws IOException, ControllerException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Controller controller = Controller.getInstance();
<<<<<<< HEAD
=======

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private Controller controller = Controller.getInstance();


    public static void main(String[] args) throws IOException, ControllerException, ServiceException {

        ConsoleCommunication consoleCommunication = new ConsoleCommunication();

        consoleCommunication.consoleCommunication();

    }

    public void consoleCommunication() throws IOException, ControllerException {
>>>>>>> af063971f98d9a349628d7125e4110bee5d21714
        String request = "";

        controller.init();

        while (!request.toLowerCase().equals("exit-")) {

            request = reader.readLine();

<<<<<<< HEAD
            controller = Controller.getInstance();
=======

            controller = Controller.getInstance();

            Controller controller = Controller.getInstance();
>>>>>>> af063971f98d9a349628d7125e4110bee5d21714
            controller.executeTask(request);

        }


        controller.destroy();
    }
}
