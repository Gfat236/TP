public class Combat {

    public static void main(String[] args) {
        Pokemon squirtle = new EauPokemon(7, "Squirtle", 10,
                100, 48, 65, 50, 64, 43);
        Pokemon charmander = new FeuPokemon(4, "Charmander", 10,
                100, 52, 43, 60, 50, 65);

        System.out.println("--- Début du Combat ---");
        System.out.println(squirtle);
        System.out.println(charmander);
        System.out.println();

        // 速度决定先手
        Pokemon premier = (squirtle.getVitesse() >= charmander.getVitesse()) ? squirtle : charmander;
        Pokemon second  = (premier == squirtle) ? charmander : squirtle;

        int tour = 1;
        while (squirtle.getPointsDeVie() > 0 && charmander.getPointsDeVie() > 0) {
            System.out.println("--- Tour " + tour + " ---");

            // 先手行动
            if (second.getPointsDeVie() > 0) {
                premier.attaquer(second);
                afficherHP(second);
            }
            if (second.getPointsDeVie() <= 0) break;

            // 后手行动
            if (premier.getPointsDeVie() > 0) {
                second.attaquer(premier);
                afficherHP(premier);
            }

            System.out.println();
            tour++;
        }

        Pokemon gagnant = (squirtle.getPointsDeVie() > 0) ? squirtle : charmander;
        System.out.println("🏁 Fin du combat ! Vainqueur : " + gagnant.getNom());
    }

    // 显示被攻击者的 HP
    private static void afficherHP(Pokemon cible) {
        System.out.println(cible.getNom() + " (HP: " + cible.getPointsDeVie() + ")");
    }
}
