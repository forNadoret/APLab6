package service;

import ui.Menu;

public class SubMenuStorage extends Menu implements Command {

    public SubMenuStorage(CreditService service) {
        super(service);
    }

    protected void init(CreditService service)
    {
        registerCommand("load", new LoadDataCommand(service));
        registerCommand("save", new SaveDataCommand(service));
    }

    @Override
    public String getDesc() {
        return "SubMenuStorage";
    }

    @Override
    public void execute(String params) {
        run();
    }
}
