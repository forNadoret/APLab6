package service;
public class LoadDataCommand implements Command {
    private final CreditService service;
    public LoadDataCommand(CreditService service)
    {
        this.service = service;
    }
    public String getDesc() {
        return "Load data from file";
    }
    public void execute(String params) {
        service.loadData(); System.out.println("Loaded.");
    }
}