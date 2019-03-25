package lesson7;

public class Moba {

    // процесс игры
    public static void main(String[] args) {
        do {
            arrInfo(arrHero1, arrHero2);
            System.out.println();
            fight();
            if (checkWin()){
                arrInfo(arrHero1, arrHero2);
                System.out.println("Победила "+textRes+"!");
            }
        } while (!checkWin());
    }

    // номер хода
    private static int count = 0; // все ходы
    private static int indexOfMove1 = 0; // ходы 1-й команды (индекс ходящего)
    private static int indexOfMove2 = 0; // ходы 2-й команды (индекс ходящего)

    // создание комманд
    private static Hero[]arrHero1 = {
            new Warrior(100, "Воин", 20, "Воина",0),
            new Killer(80, "Убийца", 40, "Убийцу",0),
            new Healther(60, "Врач", 0, "Врача", 30),
    };

    private static Hero[]arrHero2 = {
            new Warrior(60, "Воин", 20, "Воина",0),
            new Killer(80, "Убийца", 40, "Убийцу",0),
            new Healther(100, "Врач", 0, "Врача", 30),
    };

    // вывод информации об обоих коммандах
    private static void arrInfo(Hero[] arr1, Hero[] arr2){
        System.out.print("Первая команда: ");
        comInfo(arr1);
        System.out.print("Вторая команда: ");
        comInfo(arr2);
    }

    // печать информации об одной команде
    private static void comInfo (Hero[] arr){
        for (Hero hero : arr) {
            System.out.print(hero.type + " (" + hero.health + "), ");
        }
        System.out.println();
    }

    // алгоритм боя
    private static void fight(){
        String text; // команда, которая ходит
        int countRes; // счёт команды, которая ходит
        // определение команды, которая ходит
        Hero[] arr1;
        Hero[] arr2;
        if (count%2==0){
            arr1 =arrHero1;
            arr2 =arrHero2;
            text="1-я команда";
            countRes=indexOfMove1;
        } else {
            arr2 =arrHero1;
            arr1 =arrHero2;
            text="2-я команда";
            countRes=indexOfMove2;
        }
        System.out.print("Ход №"+(count+1)+" ("+text+"):");
        // определение индекса ходящего героя
        int fighter=-1;
        for (int i = countRes%arr1.length; i < arr1.length; i++) {
            if (arr1[i].health!=0){
                fighter=i;
                break;
            }
        }
        if (fighter==-1){
            for (int i = 0; i < countRes%arr1.length; i++) {
                if (arr1[i].health!=0){
                    fighter=i;
                    break;
                }
            }
        }
        // определение цели у кого больше здоровья
        int target=0;
        int maxHealth=0;
        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i].health>maxHealth){
                maxHealth=arr2[i].health;
                target=i;
            }
        }
        // определение героя, у которого меньше здоровья (кого лечить)
        int sick=0;
        int minHealth=arr1[0].health;
        for (int i = 1; i < arr1.length; i++) {
            if (arr1[i].health<minHealth&&arr1[i].health!=0&&!arr1[i].type.equals("Врач")){
                minHealth=arr1[i].health;
                sick=i;
            }
        }
        // процесс хода
        String moveRes= " ударил ";
        if (arr1[fighter].type.equals("Врач")){
            System.out.println("Врач вылечил "+ arr1[sick].type2+"("+arr1[sick].health+"+"+arr1[fighter].healthing+")");
            arr1[fighter].healing(arr1[sick]);
        }else {
            if (arr2[target].health-arr1[fighter].damage<=0){
                moveRes= " убил ";
            }
            System.out.println(arr1[fighter].type+moveRes+ arr2[target].type2+"("+arr2[target].health+"-"+arr1[fighter].damage+")");
            arr1[fighter].hit(arr2[target]);
        }
        count++;
        if (arr1 ==arrHero1){
            if (fighter+1==arr1.length){
                indexOfMove1=0;
            }else {
                indexOfMove1=fighter+1;
            }
        }else {
            if (fighter+1==arr2.length){
                indexOfMove2=0;
            }else {
                indexOfMove2=fighter+1;
            }
        }
    }

    // проверка победы
    private static String textRes;
    private static boolean checkWin(){
        boolean res=true;
        Hero[] arr1;
        if ((count-1)%2==0){
            arr1 =arrHero2;
            textRes="1-я команда";
        } else {
            arr1 =arrHero1;
            textRes="2-я команда";
        }
        for (Hero hero : arr1) {
            if (!hero.type.equals("Врач")) {
                res &= (hero.health == 0);
            }
        }
        return res;
    }
}
