package lesson6;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Барсик");
        Dog dog1 = new Dog("Шарик");
        Dog dog2 = new Dog("Бобик");
        Dog dog3 = new Dog("Джек");
        dog2.setRunLim(400);
        dog3.setRunLim(600);
        int dis1 = 300;
        double dis2 = 1;
        int dis3 = 5;
        int dis4 = 400;
        int dis5 = 600;
        cat1.run(dis1);
        cat1.jump(dis2);
        cat1.swim(dis3);
        dog1.run(dis1);
        dog1.jump(dis2);
        dog1.swim(dis3);
        dog2.run(dis4);
        dog3.run(dis5);
    }
}
