package ui;

import service.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private final Map<String, Command> commands;
    private final Scanner scanner;
    protected final CreditService service;

    public Menu(CreditService service) {
        this.commands = new HashMap<>();
        this.scanner = new Scanner(System.in);
        this.service = service;
        init(service);
    }

    protected void init(CreditService service) {
    }

    public void registerCommand(String key, Command command) {
        commands.put(key, command);
    }

    public void run() {
        System.out.println("System started. Type 'help' for commands.");
        boolean running = true;
        while (running) {
            System.out.print("> ");
            if (!scanner.hasNextLine())
            {
                break;
            }

            String line = scanner.nextLine().trim();
            if (line.isEmpty())
            {
                continue;
            }

            String[] parts = line.split(" ", 2);
            String key = parts[0].toLowerCase();
            String params = (parts.length > 1) ? parts[1] : "";

            switch (key) {
                case "exit":
                    running = false;
                    break;
                case "help":
                    handleHelp();
                    break;
                default:
                    Command command = commands.get(key);
                    if (command != null) {
                        command.execute(params);
                    } else {
                        System.out.println("Unknown command.");
                    }
                    break;
            }
        }
    }

    private void handleHelp() {
        System.out.println("Available commands:");
        commands.forEach((k, v) -> System.out.printf("  %-10s - %s\n", k, v.getDesc()));
        System.out.println("  exit       - Exit program");
    }
}