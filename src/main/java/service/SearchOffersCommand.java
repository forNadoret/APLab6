package service;
import model.CreditOffer;
import model.SearchCriteria;
import java.util.List;

public class SearchOffersCommand implements Command {
    private final CreditService service;
    public SearchOffersCommand(CreditService service) { this.service = service; }

    @Override
    public String getDesc() { return "Search offers: search rate=15 amount=1000"; }

    @Override
    public void execute(String params) {
        SearchCriteria criteria = new SearchCriteria();
        String[] args = params.split(" ");
        for (String arg : args) {
            if (arg.startsWith("rate="))
            {
                criteria.setMaxRate(Double.parseDouble(arg.split("=")[1]));
            }
            if (arg.startsWith("amount="))
            {
                criteria.setMinAmount(Double.parseDouble(arg.split("=")[1]));
            }
            if (arg.startsWith("bank="))
            {
                criteria.setBankName(arg.split("=")[1]);
            }
        }
        List<CreditOffer> results = service.searchOffers(criteria);
        results.forEach(System.out::println);
    }
}