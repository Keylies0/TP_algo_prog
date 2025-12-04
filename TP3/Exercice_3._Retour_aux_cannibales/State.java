public class State {
    /* -------------------- attributs -------------------- */
    // a state is immutable : all fields are final
    private final int MISSIONNAIRES;
    private final int CANNIBALES;
    private final int BATEAU;
    private final int score;


    /* ------------------ constructeur ------------------ */

    public State(int MISSIONNAIRES, int CANNIBALES, int BATEAU, int score) {
        if (MISSIONNAIRES < 0 || MISSIONNAIRES > 3) throw new IllegalArgumentException("Quantité invalide de missionnaires.");
        if (CANNIBALES    < 0 || CANNIBALES    > 3) throw new IllegalArgumentException("Quantité invalide de cannibales."   );
        if (BATEAU        < 0 || BATEAU        > 1) throw new IllegalArgumentException("Position invalide du bateau."       );
        if (score         < 0                     ) throw new IllegalArgumentException("Score invalide."                    );
        this.MISSIONNAIRES = MISSIONNAIRES;
        this.CANNIBALES    = CANNIBALES;
        this.BATEAU        = BATEAU;
        this.score         = score;
    }

    /* -------------------- getteurs -------------------- */

    public int getMissionnaires() { return this.MISSIONNAIRES; }
    public int getCannibales()    { return this.CANNIBALES;    }
    public int getBateau()        { return this.BATEAU;        }
    public int getScore()         { return this.score;         }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o.getClass() != this.getClass()) return false;
        State that = (State) o;
        return this.getCannibales() == that.getCannibales()
            && this.getMissionnaires() == that.getMissionnaires()
            && this.getBateau() == that.getBateau();
    }

    /** Fournit une description de l'état */
    @Override
    public String toString() {
        StringBuffer description = new StringBuffer();

        description.append("Nombre de traversées : ").append(this.getScore()).append("\n");

        description.append(this.getMissionnaires()).append("M ");
        description.append(this.getCannibales()   ).append("C ");

        if (this.getBateau() == 0)
            description.append("~\\_/~~~~~~~~~~ ");
        else
            description.append("~~~~~~~~~~\\_/~  ");

        description.append(3 - this.getMissionnaires()).append("M ");
        description.append(3 - this.getCannibales()   ).append("C");

        return description.toString();
    }
}