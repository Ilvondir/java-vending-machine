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
        String communicate = "Reszta do wydania: " + this.rest + "\nWydana reszta:\n";

        int i=0;
        while(true) {
            if (i<9) {

                if (temp-this.nominals[i]>=0) {

                    temp -= this.nominals[i];
                    this.given[i]++;

                } else i++;

            } else break;
        }

        for(i=0;i<9;i++) {
            communicate += this.nominals[i]/100.0 + " \t" + this.given[i] + "\n";
        }

        return communicate;
    }
}