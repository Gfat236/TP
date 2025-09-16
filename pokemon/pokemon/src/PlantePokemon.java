public class PlantePokemon extends Pokemon {

    public PlantePokemon(int numeroNational, String nom, int niveau,
                         int pointsDeVie, int attaque, int defense,
                         int attaqueSpeciale, int defenseSpeciale, int vitesse) {
        super(numeroNational, nom, "Plante", niveau, pointsDeVie, attaque, defense,
                attaqueSpeciale, defenseSpeciale, vitesse);
    }

    @Override
    public void attaquer(Pokemon adversaire) {
        System.out.println(getNom() + " utilise 藤鞭 !");
        int degats = calculerDommage(adversaire, 45, false); // 藤鞭，威力45，物理攻击

        afficherEfficacite(this.getType(), adversaire.getType());

        adversaire.setPointsDeVie(adversaire.getPointsDeVie() - degats);
        System.out.println(adversaire.getNom() + " perd " + degats + " PV !");
    }
}
