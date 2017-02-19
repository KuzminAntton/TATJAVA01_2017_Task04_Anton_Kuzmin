package com.epam.task4.controller.commands;

public class WrongCommand implements Command {

    @Override
    public String execute(String request) {
        return "Command is incorrect";
    }
}
