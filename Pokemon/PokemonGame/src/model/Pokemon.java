package model;

public class Pokemon {

    private int id;
    private String name;
    private int health;
    private int damage;
    private TypeEnum type;
    private SpecialPower specialPower;

    public Pokemon() {
    }

    public Pokemon(int id, String name, int health, int damage, TypeEnum type, SpecialPower specialPower) {
        this.id = id;
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.type = type;
        this.specialPower = specialPower;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public SpecialPower getSpecialPower() {
        return specialPower;
    }

    public void setSpecialPower(SpecialPower specialPower) {
        this.specialPower = specialPower;
    }

    public int specialAttack() {
        if (getSpecialPower().getRemainingRights() > 0) {
            this.specialPower.setRemainingRights(this.specialPower.getRemainingRights() - 1);
            return this.damage + this.getSpecialPower().getExtraDamage();
        } else {
            System.out.println("You can not use special power!");
            return 0;
        }
    }

    @Override
    public String toString() {
        return  "- Name: " + name + "\n" +
                "Health: " + health +
                ", Damage: " + damage +
                ", Type: " + type;


    }
}
