package service;

import model.OfferUpdate;

public class UpdateOfferCommand implements Command {
    private final CreditService service;

    public UpdateOfferCommand(CreditService service) {
        this.service = service;
    }

    @Override
    public String getDesc() {
        return "Update offer. Usage: update <id> [rate=12.5] [minAmount=5000] ...";
    }

    @Override
    public void execute(String params) {
        if (params == null || params.trim().isEmpty()) {
            System.out.println("Error: Specify Offer ID and parameters.");
            System.out.println("Example: update OFF1 rate=10.5 minAmount=2000");
            return;
        }

        String[] args = params.trim().split(" ");
        if (args.length < 2) {
            System.out.println("Error: You must provide parameters to update.");
            return;
        }

        String offerId = args[0];
        OfferUpdate updateData = new OfferUpdate();

        try {
            for (int i = 1; i < args.length; i++) {
                String[] pair = args[i].split("=");
                if (pair.length != 2) {
                    System.out.println("Skipping invalid parameter: " + args[i]);
                    continue;
                }

                String key = pair[0].toLowerCase();
                String value = pair[1];

                switch (key) {
                    case "rate":
                    case "interestrate":
                        updateData.setInterestRate(Double.parseDouble(value));
                        break;
                    case "minamount":
                        updateData.setMinAmount(Double.parseDouble(value));
                        break;
                    case "maxamount":
                        updateData.setMaxAmount(Double.parseDouble(value));
                        break;
                    case "minterm":
                        updateData.setMinTermMonths(Integer.parseInt(value));
                        break;
                    case "maxterm":
                        updateData.setMaxTermMonths(Integer.parseInt(value));
                        break;
                    case "early":
                    case "earlyrepayment":
                        updateData.setAllowsEarlyRepayment(Boolean.parseBoolean(value));
                        break;
                    case "increase":
                    case "lineincrease":
                        updateData.setAllowsLineIncrease(Boolean.parseBoolean(value));
                        break;
                    default:
                        System.out.println("Unknown parameter ignored: " + key);
                }
            }

            boolean success = service.updateOffer(offerId, updateData);

            if (success) {
                System.out.println("Offer " + offerId + " updated successfully.");
            } else {
                System.out.println("Failed to update. Offer with ID '" + offerId + "' not found.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format in parameters. " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error updating offer: " + e.getMessage());
        }
    }
}