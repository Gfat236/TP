public abstract class ShapeN {
    private double cote;
    private int dimension;
    // TODO: Constructeur
    public ShapeN(double cote, int dimension) {
        this.cote = cote;
        this.dimension = dimension;
    }
    // TODO: Getter et Setter pour cote
    public double getCote() {
        return cote;
    }
    public void setCote(double cote) {
        this.cote = cote;
    }
    // TODO: Getter pour dimension
    public int getDimension() {
        return dimension;
    }
    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    // Volume général (aire pour 2D, volume pour 3D, hypervolume pour 4D)
    public double calculateVolume() {
        return Math.pow(getCote(),getDimension()); // à compléter
    }

    // Méthode abstraite pour la bordure
    public abstract double calculateBoundary();

}
