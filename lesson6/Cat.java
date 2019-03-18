package lesson6;

public class Cat extends Animal {
    int runLim=200;
    double jumpLim=2;
    int swimLim=0;

    public Cat(String name) {
        super(name);
    }

    void run (int dis){
        if (runLim>=dis){
            System.out.println("Кот "+name+" пробежал "+dis+" м.");
        } else {
            System.out.println("Кот "+name+" не может пробежать "+dis+" м.");
        }
    }

    void jump (double dis){
        if (jumpLim>=dis){
            System.out.println("Кот "+name+" прыгнул "+dis+" м.");
        } else {
            System.out.println("Кот "+name+" не может прыгнуть "+dis+" м.");
        }
    }

    void swim (int dis){
        if (runLim>=dis){
            System.out.println("Коты не умеют плавать");
        }
    }
}
