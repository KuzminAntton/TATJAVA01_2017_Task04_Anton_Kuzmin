package com.epam.task4.controller.commands;

import com.epam.task4.service.exception.ServiceException;
import com.sun.istack.internal.logging.Logger;

import java.io.IOException;

public interface Command {
     String execute(String request) throws IOException, ServiceException;
}
