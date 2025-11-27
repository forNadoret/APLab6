package service;
import model.*;

public class CreateOfferCommand implements Command {
    private final CreditService service;
    public CreateOfferCommand(CreditService service) { this.service = service; }

    @Override
    public String getDesc()
    {
        return "Create offer (Demo): create <bankId> <offerId>";
    }

    @Override
    public void execute(String params) {
        String[] args = params.split(" ");
        if(args.length < 2) {
            System.out.println("Usage: create <bankId> <offerId>");
            return;
        }
        PersonalLoan loan = new PersonalLoan(args[1], 20.0, 1000, 10000, 1, 12, true, true, "Created via Console");
        service.createOffer(args[0], loan);
    }
}