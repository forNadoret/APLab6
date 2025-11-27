package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Bank implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private List<CreditOffer> offers;

    public Bank(String id, String name) {
        this.id = id;
        this.name = name;
        this.offers = new ArrayList<>();
    }

    public boolean addOffer(CreditOffer offer) {
        return offers.add(offer);
    }

    public boolean removeOffer(String offerId) {
        for (int i = 0; i < offers.size(); i++) {
            CreditOffer tempOffer = offers.get(i);
            if (tempOffer.getId().equals(offerId)) {
                offers.remove(i);
                return true;
            }
        }
        return false;
    }

    public String getId()
    {
        return id;
    }
    public String getName() {
        return name;
    }
    public List<CreditOffer> getOffers() {
        return offers;
    }

    @Override
    public String toString() {
        return "Bank {id='" + id + "', name='" + name + "', offersCount=" + offers.size() + "}";
    }
}