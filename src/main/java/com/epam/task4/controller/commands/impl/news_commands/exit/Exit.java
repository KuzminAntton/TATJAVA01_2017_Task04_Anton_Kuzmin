package com.epam.task4.controller.commands.impl.news_commands.exit;

import com.epam.task4.controller.commands.Command;

public class Exit implements Command {
    private String exitMessage = "Thank you for using my application";

    @Override
    public String execute(String request) {
        return exitMessage;
    }
}
