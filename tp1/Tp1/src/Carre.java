public class Carre {
    private double cote;

    public Carre(double cote) {
        this.cote = cote;
    }
    public double getCote() {
        return cote;
    }
    public void setCote(double cote) {
        this.cote = cote;
    }

    public double aire(){
        return cote*cote;
    }
}
