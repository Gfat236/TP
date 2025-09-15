//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    CarreN carre = new CarreN(5);
    CubeN cube = new CubeN(4);
    HypercubeN hypercube = new HypercubeN(3);

    // Carré
        System.out.println("Carré : côté = " + carre.getCote() +
                ", Aire = " + carre.calculateVolume() +
                ", Bordure = " + carre.calculateBoundary());

    // Cube
        System.out.println("Cube : côté = " + cube.getCote() +
                ", Volume = " + cube.calculateVolume() +
                ", Surface = " + cube.calculateBoundary());

    // Hypercube
        System.out.println("Hypercube : côté = " + hypercube.getCote() +
                ", Hypervolume = " + hypercube.calculateVolume() +
                ", Bordure = " + hypercube.calculateBoundary());
}

}