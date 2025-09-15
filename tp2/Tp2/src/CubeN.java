public class CubeN extends ShapeN{
    public CubeN(double cote){
        super(cote,3);
    }
    public double calculateBoundary(){
        return 6*Math.pow(getCote(),2);
    }
}
