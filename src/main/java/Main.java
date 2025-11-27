package com;

import service.*;
import storage.BankStorage;
import storage.FileBankStorage;
import ui.Menu;

public class Main {
    public static void main(String[] args) {
        BankStorage storage = new FileBankStorage("bank_data.dat");
        CreditService service = new CreditService(storage);
        Menu mainMenu = new Menu(service);

        mainMenu.registerCommand("storage", new SubMenuStorage(service));
        mainMenu.registerCommand("offer", new SubMenuOffer(service));
        mainMenu.registerCommand("basket", new SubMenuBasket(service));

        mainMenu.run();
    }
}