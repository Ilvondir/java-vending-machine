public class Rest {
    private double rest;
    private int[] nominals = {500, 200, 100, 50, 20, 10, 5, 2, 1};
    private int[] given = new int[9];
    private int restInCents;

    public Rest(double rest) {
        this.rest = rest;
        int temp = (int)(rest*100);
        this.restInCents = temp;
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

        System.out.println(communicate);

        return communicate;
    }
}
