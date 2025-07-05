package dhbw.mos.algorithms;

import java.util.Arrays;

class Gamer {
    static int amount = 0;
    public int id;
    public String name;

    public Gamer(String name) {
        this.id = amount++;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Gamer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

public class GamerAdministration {
    public static void main(String[] args) {
        Gamer[] gamers = new Gamer[]{
                new Gamer("Ben"),
                new Gamer("Foo"),
                new Gamer("aaa")
        };

        for (int i = 0; i < gamers.length; i++) {
            for (int j = 0; j < gamers.length; j++) {
                if (i == j) continue;
                if (gamers[i].id == gamers[j].id) {
                    System.out.println("IDs not unique");
                }
            }
        }

        System.out.println(Arrays.toString(gamers));
    }
}
