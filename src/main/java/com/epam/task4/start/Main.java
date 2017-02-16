package com.epam.task4.start;

import com.epam.task4.controller.exception.ControllerException;
import com.epam.task4.service.exception.ServiceException;
import com.epam.task4.view.ConsoleCommunication;

import java.io.IOException;

/**
 * Created by anton on 16/02/17.
 */
public class Main {

    public static void main(String[] args) throws IOException, ControllerException, ServiceException {

        ConsoleCommunication consoleCommunication = new ConsoleCommunication();

        consoleCommunication.consoleCommunication();

    }
}
