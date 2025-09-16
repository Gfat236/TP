public abstract class Pokemon {
    // 属性
    private int numeroNational;
    private String nom;
    private String type;
    private int niveau;
    private int pointsDeVie;
    private int attaque;
    private int defense;
    private int attaqueSpeciale;
    private int defenseSpeciale;
    private int vitesse;

    // 构造函数，初始化所有属性
    public Pokemon(int numeroNational, String nom, String type, int niveau,
                   int pointsDeVie, int attaque, int defense,
                   int attaqueSpeciale, int defenseSpeciale, int vitesse) {
        this.numeroNational = numeroNational;
        this.nom = nom;
        this.type = type;
        this.niveau = niveau;
        this.pointsDeVie = pointsDeVie;
        this.attaque = attaque;
        this.defense = defense;
        this.attaqueSpeciale = attaqueSpeciale;
        this.defenseSpeciale = defenseSpeciale;
        this.vitesse = vitesse;
    }

    // Getters et Setters
    public int getNumeroNational() { return numeroNational; }
    public void setNumeroNational(int numeroNational) { this.numeroNational = numeroNational; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public int getNiveau() { return niveau; }
    public void setNiveau(int niveau) { this.niveau = niveau; }

    public int getPointsDeVie() { return pointsDeVie; }
    public void setPointsDeVie(int pointsDeVie) { this.pointsDeVie = pointsDeVie; }

    public int getAttaque() { return attaque; }
    public void setAttaque(int attaque) { this.attaque = attaque; }

    public int getDefense() { return defense; }
    public void setDefense(int defense) { this.defense = defense; }

    public int getAttaqueSpeciale() { return attaqueSpeciale; }
    public void setAttaqueSpeciale(int attaqueSpeciale) { this.attaqueSpeciale = attaqueSpeciale; }

    public int getDefenseSpeciale() { return defenseSpeciale; }
    public void setDefenseSpeciale(int defenseSpeciale) { this.defenseSpeciale = defenseSpeciale; }

    public int getVitesse() { return vitesse; }
    public void setVitesse(int vitesse) { this.vitesse = vitesse; }

    @Override
    public String toString() {
        return "Pokémon #" + numeroNational +
                " | Nom: " + nom +
                " | Type: " + type +
                " | Niveau: " + niveau +
                " | PV: " + pointsDeVie +
                " | Attaque: " + attaque +
                " | Défense: " + defense +
                " | Attaque Spéciale: " + attaqueSpeciale +
                " | Défense Spéciale: " + defenseSpeciale +
                " | Vitesse: " + vitesse;
    }

    // 抽象方法：由子类实现具体攻击逻辑
    public abstract void attaquer(Pokemon adversaire);

    // 伤害计算方法
    public int calculerDommage(Pokemon adversaire, int puissance, boolean special) {
        int attaque = special ? this.attaqueSpeciale : this.attaque;
        int defense = special ? adversaire.defenseSpeciale : adversaire.defense;

        double dommage = (((2.0 * this.niveau) / 5.0 + 2) * puissance * attaque / defense) / 50.0 + 2;

        double multiplicateur = 1.0;
        String typeAttaque = this.type;
        String typeDefense = adversaire.type;

        if (typeAttaque.equals("Eau")) {
            if (typeDefense.equals("Feu")) multiplicateur = 2.0;
            if (typeDefense.equals("Plante")) multiplicateur = 0.5;
        } else if (typeAttaque.equals("Feu")) {
            if (typeDefense.equals("Plante")) multiplicateur = 2.0;
            if (typeDefense.equals("Eau")) multiplicateur = 0.5;
        } else if (typeAttaque.equals("Plante")) {
            if (typeDefense.equals("Eau")) multiplicateur = 2.0;
            if (typeDefense.equals("Feu")) multiplicateur = 0.5;
        }

        dommage *= multiplicateur;

        return (int) dommage;
    }

    protected void afficherEfficacite(String typeAttaque, String typeDefense) {
        double multiplicateur = 1.0;
        if (typeAttaque.equals("Eau")) {
            if (typeDefense.equals("Feu")) multiplicateur = 2.0;
            if (typeDefense.equals("Plante")) multiplicateur = 0.5;
        } else if (typeAttaque.equals("Feu")) {
            if (typeDefense.equals("Plante")) multiplicateur = 2.0;
            if (typeDefense.equals("Eau")) multiplicateur = 0.5;
        } else if (typeAttaque.equals("Plante")) {
            if (typeDefense.equals("Eau")) multiplicateur = 2.0;
            if (typeDefense.equals("Feu")) multiplicateur = 0.5;
        }

        if (multiplicateur > 1.0) {
            System.out.println("C'est super efficace !");
        } else if (multiplicateur < 1.0) {
            System.out.println("Ce n'est pas très efficace...");
        }
    }

}
