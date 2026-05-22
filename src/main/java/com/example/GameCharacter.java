package com.example;

import java.util.ArrayList;
import java.util.List;

public class GameCharacter implements Cloneable{
    private String name;
    private int level;
    private List<String> skills;

    public GameCharacter(String name, int level) {
        this.name = name;
        this.level = level;
        // Hard work
        this.skills = new ArrayList<>();
        System.out.println("Create new GameCharacter from DB");
    }

    public GameCharacter clone() throws CloneNotSupportedException {
        GameCharacter cloned = (GameCharacter) super.clone();
        cloned.skills = new ArrayList<>(this.skills);
        return cloned;
    }

    public void showInfo() {
        System.out.println("Name: " + name);
        System.out.println("Level: " + level);
        System.out.println("Skills:" + skills);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void addSkill(String fireball) {
        this.skills.add(fireball);
    }
}
