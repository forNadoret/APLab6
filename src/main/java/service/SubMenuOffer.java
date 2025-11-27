package service;

import ui.Menu;

public class SubMenuOffer extends Menu implements Command {

    public SubMenuOffer(CreditService service) {
        super(service);
    }

    protected void init(CreditService service)
    {
        registerCommand("list", new ListBanksCommand(service));
        registerCommand("create", new CreateOfferCommand(service));
        registerCommand("search", new SearchOffersCommand(service));
        registerCommand("update", new UpdateOfferCommand(service));
        registerCommand("delete", new DeleteOfferCommand(service));
        registerCommand("calc", new CalculatePaymentCommand(service));

    }

    @Override
    public String getDesc() {
        return "SubMenuOffer";
    }

    @Override
    public void execute(String params) {
        run();
    }
}
