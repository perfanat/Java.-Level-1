package lesson5;

public class Employee {
    private String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    private Employee(String name, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    private void info(){
        System.out.println(position + " "+name+", email: " + email+", phone: "+phone+", salary: "+salary+", age - "+age);
    }

    public static void main(String[] args) {
        Employee [] employees = new Employee[5];
        employees[0] = new Employee("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
        employees[1] = new Employee("Petrov Petr", "Doctor", "petr@mailbox.com", "89598417", 40000, 40);
        employees[2] = new Employee("Sidorov Sidor", "Driver", "sidor@mailbox.com", "895698741", 50000, 50);
        employees[3] = new Employee("Semenov Semen", "Teacher", "semen@mailbox.com", "892325872", 60000, 60);
        employees[4] = new Employee("Olegov Oleg", "Student", "oleg@mailbox.com", "8985479", 20000, 20);

        for (Employee employee : employees) {
            if (employee.age > 40) employee.info();
        }
    }
}
