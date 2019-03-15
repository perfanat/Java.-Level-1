package lesson6;

public class AdditionalTask {
    public static void main(String[] args) {
        String s = "Предложение  один     Теперь предложение    два   Предложение   три";
        String s1 = s.replaceAll(" +", " ");
        StringBuilder s2 = new StringBuilder(s1);

        int count=0;
        for (int i = 1; i < s1.length(); i++) {
            if(s1.charAt(i) >= 'А' && s1.charAt(i) <= 'Я') {
                s2.insert(i-1+count, ".");
                count++;
            }
        }
        s2.append('.');
        System.out.println(s2.toString());
    }
}
