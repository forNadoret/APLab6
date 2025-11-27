package storage;

import model.Bank;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileBankStorage implements BankStorage {
    private String filePath;

    public FileBankStorage(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Bank> loadBanks() {
        File file = new File(filePath);
        if (!file.exists())
        {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Bank>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading banks: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public void saveBanks(List<Bank> banks) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(banks);
            System.out.println("Data saved.");
        } catch (IOException e) {
            System.err.println("Error saving banks: " + e.getMessage());
        }
    }
}