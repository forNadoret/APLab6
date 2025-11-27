package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Selection implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<CreditOffer> selectedOffers;

    public Selection() {
        this.selectedOffers = new ArrayList<>();
    }

    public void addOffer(CreditOffer offer) {
        selectedOffers.add(offer);
    }

    public boolean removeOffer(String offerId) {
        for (int i = 0; i < selectedOffers.size(); i++) {
            CreditOffer tempOffer = selectedOffers.get(i);
            if (tempOffer.getId().equals(offerId)) {
                selectedOffers.remove(i);
                return true;
            }
        }
        return false;
    }

    public List<CreditOffer> getSelectedOffers() {
        return selectedOffers;
    }
}