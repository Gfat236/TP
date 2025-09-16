public class EauPokemon extends Pokemon {

    public EauPokemon(int numeroNational, String nom, int niveau,
                      int pointsDeVie, int attaque, int defense,
                      int attaqueSpeciale, int defenseSpeciale, int vitesse) {
        super(numeroNational, nom, "Eau", niveau, pointsDeVie, attaque, defense,
                attaqueSpeciale, defenseSpeciale, vitesse);
    }

    @Override
    public void attaquer(Pokemon adversaire) {
        System.out.println(getNom() + " utilise 水枪 !");
        int degats = calculerDommage(adversaire, 40, true); // 水枪，威力40，特殊攻击

        afficherEfficacite(this.getType(), adversaire.getType());

        adversaire.setPointsDeVie(adversaire.getPointsDeVie() - degats);
        System.out.println(adversaire.getNom() + " perd " + degats + " PV !");
    }
}
