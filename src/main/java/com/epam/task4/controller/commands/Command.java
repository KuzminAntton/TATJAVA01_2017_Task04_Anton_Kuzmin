package com.epam.task4.controller.commands;

import com.epam.task4.service.exception.ServiceException;

import java.io.IOException;

public interface Command {
    public String execute(String request) throws IOException, ServiceException;
}
