public class Rest {
    private final double rest;
    private final int[] nominals = {500, 200, 100, 50, 20, 10, 5, 2, 1};
    private final int[] given = new int[9];
    private final int restInCents;

    public Rest(double rest) {
        this.rest = rest;
        this.restInCents = (int)((rest+0.00001)*100);
    }

    public String spend() {
        int temp = restInCents;
        StringBuilder communicate = new StringBuilder("<span style=\"color: red; font-weight:700;\">Reszta do wydania: " + String.format("%.2f", this.rest) + " zł</span>");

        int i=0;
        while(true) {
            if (i<9) {

                if (temp-this.nominals[i]>=0) {
                    temp -= this.nominals[i];
                    this.given[i]++;
                } else i++;

            } else break;
        }

        communicate.append("<table style=\"width:100px; border: 1px solid black; border-collapse: collapse;\"><caption>Wydana reszta:</caption>");
        for(i=0;i<9;i++) {
            communicate.append("<tr><td style=\"border: 1px solid black; text-align: center; border-collapse: collapse;\">").append(this.nominals[i] / 100.0).append("</td><td style=\"text-align: center; border: 1px solid black; border-collapse: collapse;\">").append(this.given[i]).append("</td></tr>");
        }

        communicate.append("</table></html>");
        return communicate.toString();
    }
}
