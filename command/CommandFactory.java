package command;

import command.parser.exceptions.WrongCommandNameException;
import command.execution.Command;
import turtle_interpreter.Environment;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Properties;

public class CommandFactory {
    private static CommandFactory instance;

    private final Environment              environment;

    private final HashMap<String, Integer> command_argc;
    private final HashMap<String, String>  command_name;
    private final HashMap<String, Command> command_inst;

    /**
     * Initialize CommandsFactory with commands maps that are creating
     * from commands.properties data
     *
     * @param environment Environment instance - to initialize it in commands
     */
    private CommandFactory(Environment environment) {
        this.environment = environment;

        this.command_argc = new HashMap<>();
        this.command_name = new HashMap<>();
        this.command_inst = new HashMap<>();

        InputStream commandFileStream = ClassLoader
                .getSystemResourceAsStream("commands.properties");

        Properties commandProperties = new Properties();
        try {
            assert command_file_stream != null;
            commandProperties.load(command_file_stream);
            command_file_stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String property : commandProperties.stringPropertyNames()) {
            String[] property_key   = property.split("\\.");
            String   property_value = commandProperties.getProperty(property);

            if (property_key[1].equals("class")) {
                command_name.put(property_key[0], property_value);
                command_inst.put(property_key[0], null);
            } else if (property_key[1].equals("argc")) {
                command_argc.put(property_key[0], Integer.parseInt(property_value));
            }
        }
    }
    /**
     * Create command instance
     *
     * @param key Name of command
     * */
    private void createCommandInstance(String key) {
        try {
            Class<?> cmd_class = Class.forName(command_name.get(key));
            Constructor<?> cmd_constructor = cmd_class.getConstructor(Environment.class);
            command_inst.put(key, (Command) cmd_constructor.newInstance(environment));
        }
        catch (ClassNotFoundException
                | NoSuchMethodException
                | InvocationTargetException
                | InstantiationException
                | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    /**
     * Get arguments count
     *
     * @param key Name of command
     * */
    public Integer getArgc(String key) throws WrongCommandNameException {
        String low_key = key.toLowerCase();

        if(!command_argc.containsKey(low_key)) {
            throw new WrongCommandNameException();
        }

        return command_argc.get(low_key);
    }
    /**
     * Return command instance
     * If it doesn't exist - call createCommandInstance function
     * Otherwise - return existing instance from map
     *
     * @param args List of command arguments with command name
     * */
    public Command getCommandInstance(String[] args) {
        if (command_inst.get(args[0]) == null) {
            createCommandInstance(args[0]);
        }

        Command cmd = command_inst.get(args[0]);
        cmd.setArgs(args);

        return cmd;
    }
    /**
     * Return instance of CommandFactory
     * If it doesn't exist - create CommandFactory
     *
     * @param environment Environment instance - to initialize it in commands
     * */
    public static CommandFactory getInstance(Environment environment) {
        if(instance == null) {
            instance = new CommandFactory(environment);
        }

        return instance;
    }
}
