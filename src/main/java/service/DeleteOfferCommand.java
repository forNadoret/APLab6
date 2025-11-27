package service;

public class DeleteOfferCommand implements Command {
    private final CreditService service;

    public DeleteOfferCommand(CreditService service) {
        this.service = service;
    }

    @Override
    public String getDesc() {
        return "Delete an offer. Usage: delete <offerId>";
    }

    @Override
    public void execute(String params) {
        if (params == null || params.trim().isEmpty()) {
            System.out.println("Error: Please specify the Offer ID to delete.");
            System.out.println("Usage: delete <offerId>");
            return;
        }

        String offerId = params.trim();
        boolean isDeleted = service.deleteOffer(offerId);

        if (isDeleted) {
            System.out.println("Offer '" + offerId + "' was successfully deleted.");
        } else {
            System.out.println("Failed to delete. Offer with ID '" + offerId + "' not found.");
        }
    }
}