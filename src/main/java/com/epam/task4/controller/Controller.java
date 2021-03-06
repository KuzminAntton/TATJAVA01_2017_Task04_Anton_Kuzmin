package com.epam.task4.controller;

import com.epam.task4.controller.commands.Command;
import com.epam.task4.controller.commands.CommandProvider;
import com.epam.task4.controller.exception.ControllerException;
import com.epam.task4.util.Help;
import com.epam.task4.service.impl.NewsServiceImpl;
import com.epam.task4.service.factory.ServiceFactory;
import com.epam.task4.service.exception.ServiceException;
import org.apache.log4j.Logger;

import java.io.IOException;

public class Controller {
    private static final Logger log = Logger.getLogger(Controller.class);

    private final CommandProvider provider = new CommandProvider();

    private static final Controller instance = new Controller();

    private Controller() {
    }

    public static Controller getInstance() {
        return instance;
    }


    private final String paramDelimeter = "-";



    public void init() {
        try {
            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            NewsServiceImpl newsServiceImpl = serviceFactory.getNewsServiceImpl();
            newsServiceImpl.initResource();
        } catch (ServiceException e) {
            log.error(e);
        }
    }

    public void destroy() {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        NewsServiceImpl newsServiceImpl = serviceFactory.getNewsServiceImpl();
        newsServiceImpl.destroyResource();
    }

    public void executeTask(String request) throws ControllerException {
        try {

            String commandName;
            Command executionCommand;
            commandName = request.substring(0, request.indexOf(paramDelimeter));
            executionCommand = provider.getCommand(commandName);

            String response;
            request = request.replace(commandName, "");
            request = request.replace(paramDelimeter, "");

            response = executionCommand.execute(request);

            System.out.println(response);

        } catch (ServiceException e1) {
            log.error(e1);
        } catch (IOException | StringIndexOutOfBoundsException e2) {
            log.error(e2);
            log.info(Help.getWrongInput());
        }


    }

}
