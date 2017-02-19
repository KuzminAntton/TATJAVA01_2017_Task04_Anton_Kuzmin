package com.epam.task4.controller.commands;

public class WrongRequest implements Command {
    @Override
    public String execute(String request) {
        return "Incorrect request";
    }
}
