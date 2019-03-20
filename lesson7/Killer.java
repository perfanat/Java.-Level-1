package lesson7;

class Killer extends Hero {

    public Killer(int health, String type, int damage, String type2, int healthing) {
        super(health, type, damage, type2, healthing);
    }

    @Override
    void hit(Hero h) {
        h.causeDamage(damage);
    }

    @Override
    void healing(Hero h) {
        System.out.println("Убийцы не умеют лечить!");
    }
}
