package service;
public class ViewSelectionCommand implements Command {
    private final CreditService service;
    public ViewSelectionCommand(CreditService service)
    {
        this.service = service;
    }
    public String getDesc()
    {
        return "View basket";
    }
    public void execute(String params) {
        service.viewSelection().forEach(System.out::println);
    }
}