package service;
public class SelectOfferCommand implements Command {
    private final CreditService service;
    public SelectOfferCommand(CreditService service)
    {
        this.service = service;
    }
    public String getDesc() {
        return "Add to basket: select <offerId>";
    }
    public void execute(String params)
    {
        service.addToSelection(params.trim());
    }
}