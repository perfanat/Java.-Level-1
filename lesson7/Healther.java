package lesson7;

class Healther extends Hero {

    public Healther(int health, String type, int damage, String type2, int healthing) {
        super(health, type, damage, type2, healthing);
    }

    @Override
    void hit(Hero h) {
        System.out.println("Врачи не умеют бить!");
    }

    @Override
    void healing(Hero h) {
        h.causeHealthing(healthing);
    }
}
