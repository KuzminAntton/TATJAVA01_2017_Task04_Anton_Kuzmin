package com.epam.task4.controller.commands;

import com.epam.task4.controller.commands.impl.news_commands.add_news.AddNews;
import com.epam.task4.controller.commands.impl.news_commands.exit.Exit;
import com.epam.task4.controller.commands.impl.news_commands.search_news.*;
import com.epam.task4.util.Help;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;


public class CommandProvider {

    private static final Logger log = Logger.getLogger(CommandProvider.class);
    private final Map<CommandName, Command> repository = new HashMap<>();

    public CommandProvider() {

        repository.put(CommandName.ADD_NEWS, new AddNews());
        repository.put(CommandName.GET_NEWS_BY_TITLE, new GetNewsByTitle());
        repository.put(CommandName.GET_NEWS_BY_CREATOR, new GetNewsByCreator());
        repository.put(CommandName.GET_NEWS_BY_CATEGORY, new GetNewsByCategory());
        repository.put(CommandName.GET_NEWS_BY_TITLE_AND_CREATOR, new GetNewsByTitleAndCreator());
        repository.put(CommandName.GET_NEWS_BY_TITLE_AND_CATEGORY, new GetNewsByTitleAndCategory());
        repository.put(CommandName.GET_NEWS_BY_CREATOR_AND_CATEGORY, new GetNewsByCreatorAndCategory());
        repository.put(CommandName.GET_CONCRETE_NEWS, new GetConcreteNews());
        repository.put(CommandName.GET_NEWS_FREE_CRIT, new GetNewsFreeCriteria());
        repository.put(CommandName.WRONG_COMMAND, new WrongCommand());
        repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
        repository.put(CommandName.EXIT, new Exit());

    }

    public Command getCommand(String name) {

        CommandName commandName = null;
        Command command = null;

        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);

        } catch (IllegalArgumentException | NullPointerException e) {
            log.error(e);
            System.out.println(Help.getWrongInput());
            command = repository.get(CommandName.WRONG_REQUEST);

        }
        return command;
    }
}
