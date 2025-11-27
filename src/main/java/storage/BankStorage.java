package storage;

import model.Bank;
import java.util.List;

public interface BankStorage {
    List<Bank> loadBanks();
    void saveBanks(List<Bank> banks);
}