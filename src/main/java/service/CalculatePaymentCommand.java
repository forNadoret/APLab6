package service;
import model.CreditOffer;

public class CalculatePaymentCommand implements Command {
    private final CreditService service;
    public CalculatePaymentCommand(CreditService service)
    {
        this.service = service;
    }

    @Override
    public String getDesc()
    {
        return "Calc payment: calc <offerId> <amount> <months>";
    }

    @Override
    public void execute(String params) {
        try {
            String[] args = params.split(" ");
            String id = args[0];
            double amount = Double.parseDouble(args[1]);
            int term = Integer.parseInt(args[2]);

            CreditOffer offer = service.findOfferById(id);
            if(offer != null) {
                double payment = offer.calculatePayment(amount, term);
                System.out.printf("Monthly Payment: %.2f\n", payment);
            } else {
                System.out.println("Offer not found.");
            }
        } catch (Exception e) {
            System.out.println("Invalid format. Use: calc <id> <amount> <term>");
        }
    }
}