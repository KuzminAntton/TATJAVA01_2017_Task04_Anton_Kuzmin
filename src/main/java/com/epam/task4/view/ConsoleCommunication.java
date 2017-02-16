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
        String request = "";

        controller.init();

        while (!request.toLowerCase().equals("exit-")) {

            request = reader.readLine();

            controller = Controller.getInstance();
            controller.executeTask(request);

        }


        controller.destroy();
    }
}
