//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Carre a = new Carre(5);
        Cube b = new Cube(4);
        Hypercube c = new Hypercube(3);

        System.out.println("Carre: cote = " + a.getCote() + ", Aire = "+a.aire());
        System.out.println("Cube: cote = " + b.getCote() + ", Surface = " + b.surface() + ", Volume = " + b.volume());
        System.out.println("Hupercube: cote = " + c.getCote() + ", Hypervolume = " + c.hypervolume() + ", Bordure = " + c.bordure());

        }
    }
