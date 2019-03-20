package lesson7;

abstract class Hero {
    int health; // здоровье
    String type; // тип героя
    int damage; // наносимый урон
    String type2; // склонение типа героя (для вставки текста)
    int healthing; // лечение

    // конструктор
    Hero(int health, String type, int damage, String type2, int healthing) {
        this.health = health;
        this.type = type;
        this.type2 = type2;
        this.damage = damage;
        this.healthing=healthing;
    }

    // абстрактные удар и лечение
    abstract void hit(Hero h);
    abstract void healing(Hero h);

    // метод по кому ударяют
    void causeDamage(int damage) {
        if (health - damage<=0){
            health=0;
        } else {
            health -= damage;
        }
    }

    // метод кого лечат
    void causeHealthing(int healthing) {
        health += healthing;
    }
}
