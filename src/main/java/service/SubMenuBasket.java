package service;

import ui.Menu;

public class SubMenuBasket extends Menu implements Command {
    public SubMenuBasket(CreditService service) {
        super(service);
    }

    protected void init(CreditService service)
    {
        registerCommand("select", new SelectOfferCommand(service));
        registerCommand("view", new ViewSelectionCommand(service));
    }

    @Override
    public String getDesc() {
        return "SubMenuBasket";
    }

    @Override
    public void execute(String params) {
        run();
    }
}
