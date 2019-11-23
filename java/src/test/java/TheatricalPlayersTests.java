import org.approvaltests.reporters.JunitReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.Test;

import java.util.List;

import static org.approvaltests.Approvals.verify;

@UseReporter(JunitReporter.class)
public class TheatricalPlayersTests {

    @Test
    public void exampleStatement() {
        Invoice invoice = new Invoice("BigCo", List.of(
                new Performance(new Play("Hamlet", "tragedy"), 55),
                new Performance(new Play("As You Like It", "comedy"), 35),
                new Performance(new Play("Othello", "tragedy"), 40)));

        TheatricalPlayers theatricalPlayers = new TheatricalPlayers();
        var result = theatricalPlayers.print(invoice);

        verify(result);
    }
}
