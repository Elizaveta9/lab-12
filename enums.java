package com.company;


public class enums {
    public static void main(String[] args) {
        Sizes.XS.getDescription();
        Sizes.XXS.getDescription();
        Tshirt tshirt = new Tshirt(Sizes.S, 450, "Белый", "Футболка");
        Trousers trousers = new Trousers(Sizes.M, 1200, "Чёрный", "Штаны");
        Skirt skirt = new Skirt(Sizes.L, 750, "Розовый", "Юбка");
        Tie tie = new Tie(Sizes.M, 300, "Фиолетовый", "Галстук");
        Clothing[] clothing = new Clothing[]{
                tshirt, trousers, skirt, tie
        };
        Atelier atelier = new Atelier();
        atelier.dressMan(clothing);
        atelier.dressWoman(clothing);
    }
}

enum Sizes {
    XXS(32) {
        @Override
        public void getDescription() {
            System.out.println("Детский размер");
        }
    },
    XS(34),
    S(36),
    M(38),
    L(40);

    private int euroSize;

    Sizes(int euroSize) {
        this.euroSize = euroSize;
    }

    public void getDescription() {
        System.out.println("Взрослый размер");
    }
}

interface MenClothing {
    void dressMan();
}

interface WomenClothing {
    void dressWoman();
}

abstract class Clothing {
String name;
    Sizes sizeOfClothing;
    int cost;
    String color;

    Clothing(Sizes sizeOfClothing, int cost, String color, String name) {
        this.sizeOfClothing = sizeOfClothing;
        this.cost = cost;
        this.color = color;
        this.name = name;
    }

}

class Tshirt extends Clothing implements MenClothing, WomenClothing {           //футболка

    Tshirt(Sizes sizeOfClothing, int cost, String color, String name) {

        super(sizeOfClothing, cost, color, name = "Футболка");
    }


    public void dressWoman() {
    }

    public void dressMan() {
    }

}

class Trousers extends Clothing implements MenClothing, WomenClothing {          //штаны
    public String name = "Штаны";

    Trousers(Sizes sizeOfClothing, int cost, String color, String name) {
        super(sizeOfClothing, cost, color, name = "Штаны");
    }

    public void dressWoman() {
    }

    public void dressMan() {
    }

}

class Skirt extends Clothing implements WomenClothing {           //юбка
    public String name = "Юбка";

    Skirt(Sizes sizeOfClothing, int cost, String color, String name) {
        super(sizeOfClothing, cost, color, name = "Юбка");
    }

    public void dressWoman() {
    }

}

class Tie extends Clothing implements MenClothing {          //галстук
    public String name = "Галстук";

    Tie(Sizes sizeOfClothing, int cost, String color, String name) {
        super(sizeOfClothing, cost, color, name = "Галстук");
    }

    public void dressMan() {
    }

}

class Atelier {
    public void dressWoman(Clothing[] clothing) {
        System.out.println("\nЖенская одежда:");
        for (Clothing elem : clothing) {
            if (elem instanceof WomenClothing) {
                System.out.println(elem.name + " " + elem.sizeOfClothing + " " + elem.color + " " + elem.cost);

            }
        }
    }

    public void dressMan(Clothing[] clothing) {
        System.out.println("\nМужская одежда:");
        for (Clothing elem : clothing) {
            if (elem instanceof MenClothing) {
                System.out.println(elem.name + " " + elem.sizeOfClothing + " " + elem.color + " " + elem.cost);
            }
        }
    }

}
