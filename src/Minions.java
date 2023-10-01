public class Minions {
    public int age;
    public String name;


    public Minions(int age, String name) {
        this.age = age;
        this.name = name;

    }

    @Override
    public String toString() {
        return "Minions{" +
                "age='" + age + '\'' +
                ", name=" + name +
                '}';
    }
}
