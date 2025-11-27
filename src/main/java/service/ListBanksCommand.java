package service;

import model.Bank;
import java.util.List;

public class ListBanksCommand implements Command {
    private final CreditService service;

    public ListBanksCommand(CreditService service) {
        this.service = service;
    }

    @Override
    public String getDesc() {
        return "Show all banks and their IDs";
    }

    @Override
    public void execute(String params) {
        List<Bank> banks = service.listAllBanks();

        if (banks.isEmpty()) {
            System.out.println("No banks found.");
            return;
        }

        System.out.println("--- Available Banks ---");
        System.out.printf("%-10s | %-20s | %s\n", "ID", "Name", "Offers Count");
        System.out.println("---------------------------------------------");

        for (Bank bank : banks) {
            System.out.printf("%-10s | %-20s | %d\n",
                    bank.getId(),
                    bank.getName(),
                    bank.getOffers().size()
            );
        }
        System.out.println("---------------------------------------------");
    }
}