package lesson6;

public class Dog extends Animal {
    int runLim=500;
    double jumpLim=0.5;
    int swimLim=10;

    public Dog(String name) {
        super(name);
    }

    void run (int dis){
        if (runLim>=dis){
            System.out.println("Пёс "+name+" пробежал "+dis+" м.");
        } else {
            System.out.println("Пёс "+name+" не может пробежать "+dis+" м.");
        }
    }

    void jump (double dis){
        if (jumpLim>=dis){
            System.out.println("Пёс "+name+" прыгнул "+dis+" м.");
        } else {
            System.out.println("Пёс "+name+" не может прыгнуть "+dis+" м.");
        }
    }

    void swim (int dis){
        if (swimLim>=dis){
            System.out.println("Пёс "+name+" проплыл "+dis+" м.");
        } else {
            System.out.println("Пёс "+name+" не может проплыть "+dis+" м.");
        }
    }

    void setRunLim (int newLim){
        this.runLim=newLim;
    }
}
