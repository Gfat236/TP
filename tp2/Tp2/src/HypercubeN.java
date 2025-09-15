public class HypercubeN extends ShapeN{
    public HypercubeN(double cote){
        super(cote,3);
    }
    public double calculateBoundary(){
        return 8*Math.pow(getCote(),3);
    }
}
