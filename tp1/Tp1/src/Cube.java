public class Cube extends Carre{
    public Cube(double cote){
        super(cote);
    }

    public double surface(){
        return 6*getCote()*getCote();
    }

    public double volume(){
        return getCote()*getCote()*getCote();
        //return Math.pow(getCote(), 3);
    }

}
