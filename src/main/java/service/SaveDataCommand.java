package service;
public class SaveDataCommand implements Command {
    private final CreditService service;
    public SaveDataCommand(CreditService service)
    {
        this.service = service;
    }
    public String getDesc() {
        return "Save data to file";
    }
    public void execute(String params)
    {
        service.saveData();
    }
}