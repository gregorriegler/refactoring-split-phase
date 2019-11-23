import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

public class TheatricalPlayers {

    public String print(Invoice invoice) {
        var totalAmount = 0;
        var volumeCredits = 0;
        var result = String.format("Statement for %s\n", invoice.customer);

        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);

        for (var perf : invoice.performances) {
            var play = perf.play;
            var thisAmount = 40000;
            if (perf.audience > 30) {
                thisAmount += 1000 * (perf.audience - 30);
            }

            var thisCredits = Math.max(perf.audience - 30, 0);
            if ("comedy".equals(play.type)) thisCredits += Math.floor((double) perf.audience / 5);

            totalAmount += thisAmount;
            volumeCredits += thisCredits;
        }
        
        result += String.format("Amount owed is %s\n", format.format(totalAmount / 100));
        result += String.format("You earned %s credits\n", volumeCredits);
        return result;
    }

}
