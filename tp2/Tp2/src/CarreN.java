public class CarreN extends ShapeN{
    public CarreN(double cote) {
        super(cote,2);
    }
    public double calculateBoundary() {
        return 4*getCote();
    }
}
