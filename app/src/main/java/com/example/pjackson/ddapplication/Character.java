package com.example.pjackson.ddapplication;

import java.util.Random;

import static com.example.pjackson.ddapplication.Constants.*;


public class Character {
    // Constructor
    Character() {
        characterName = "Drarr";

        Random r = new Random();
        totalLevel = r.nextInt(20) + 1;
        abilityScores = new int[]{r.nextInt(14) + 6,r.nextInt(14) + 6,r.nextInt(14) + 6,r.nextInt(14) + 6,r.nextInt(14) + 6,r.nextInt(14) + 6};
        proficiencyBonus = r.nextInt(5);
        speeds = new int[]{30,r.nextInt(30),15,r.nextInt(30),15};
        hitpoints = r.nextInt(140) + 10;
        savingThrowProficiency = new boolean[]{r.nextBoolean(),r.nextBoolean(),r.nextBoolean(),r.nextBoolean(),r.nextBoolean(),r.nextBoolean()};
        skillProficiency = new boolean[]{r.nextBoolean(),r.nextBoolean(),r.nextBoolean(),r.nextBoolean(),r.nextBoolean(),r.nextBoolean(),r.nextBoolean(),r.nextBoolean(),
                r.nextBoolean(),r.nextBoolean(),r.nextBoolean(),r.nextBoolean(),r.nextBoolean(),r.nextBoolean(),r.nextBoolean(),r.nextBoolean(),r.nextBoolean(),r.nextBoolean()};
    }



    // Variables
    private String characterName;
    private int totalLevel;
    private int[] abilityScores;
    private int proficiencyBonus;
    private int[] speeds;
    private int hitpoints;
    private boolean[] savingThrowProficiency;
    private boolean[] skillProficiency;
    private static int[] skillAssociatedAbility = {DEX,WIS,INT,STR,CHA,INT,WIS,CHA,INT,WIS,INT,WIS,CHA,CHA,INT,DEX,DEX,WIS};





    // Functions
    public int getAbilityModifier(int index) {return ((abilityScores[index] - 10) / 2);}

    public int[] getAbilityModifiers()
    {
        int[] ret = new int[6];
        for (int i = 0; i < 6; i++)
        {
            ret[i] = getAbilityModifier(i);
        }
        return ret;
    }

    //TODO check death related things
    public void heal(int hp){hitpoints += hp;}

    //TODO check death related things & temp HP
    public void damage(int hp) {hitpoints -= hp;}

    public int getSavingThrow(int index)
    {
        int ret = getAbilityModifier(index);
        if(savingThrowProficiency[index])
            ret += proficiencyBonus;
        return ret;
    }

    public int[] getSavingThrows()
    {
        int[] ret = getAbilityModifiers();
        for (int i = 0; i < 6; i++)
        {
            if(savingThrowProficiency[i])
                ret[i] += proficiencyBonus;
        }
        return ret;
    }

    public int[] getSenses()
    {
        int[] ret = new int[3];
        ret[0] = 10 + getSkillModifier(PERCEPTION);
        ret[1] = 10 + getSkillModifier(INVESTIGATION);
        ret[2] = 10 + getSkillModifier(INSIGHT);
        return ret;
    }

    public int getSkillModifier(int index)
    {
        int ret;
        ret = getAbilityModifier(skillAssociatedAbility[index]);
        if (skillProficiency[index])
            ret += proficiencyBonus;
        return ret;
    }

    public int[] getSkillModifiers()
    {
        int[] ret = new int[18];
        for (int i = 0; i < 18; i++)
        {
            ret[i] = getSkillModifier(i);
        }
        return ret;
    }

    public int getInitiative()
    {
        return getAbilityModifier(DEX);
    }

    public String getCharacterSummary()
    {
        String ret = characterName;
        ret += "\n\nTotal Level: " + totalLevel;
        ret += "\n\nAbility Scores: ";
        for (int i = 0; i < 6; i++)
            ret += "\n" + abilityScores[i] + "-" + getAbilityModifier(i) + " (" + getSavingThrow(i) + "), ";

        ret += "\n\nProficiency Bonus: " + proficiencyBonus;

        ret += "\n\nSpeeds: ";
        for (int i = 0; i < 5; i++)
            ret += "\n" + speeds[i] + ", ";

        ret += "\n\nHitpoints: " + hitpoints;

        ret += "\n\nSkills: ";
        for (int i = 0; i < 18; i++)
            ret += "\n" + skillAssociatedAbility[i] + "-" + getSkillModifier(i) + " (" + skillProficiency[i] + "), ";

        ret += "\n\nSenses: ";
        for (int i = 0; i < 3; i++)
            ret += "\n" + getSenses()[i];

        ret += "\n\nInitiative: " + getInitiative();

        return ret;
    }





    // Getters and Setters
    public String getCharacterName() {return characterName;}
    public void setCharacterName(String characterName) {this.characterName = characterName;}

    public int getTotalLevel() {return totalLevel;}
    public void setTotalLevel(int totalLevel) {this.totalLevel = totalLevel;}

    public int[] getAbilityScores() {return abilityScores;}
    public void setAbilityScores(int[] abilityScores) {this.abilityScores = abilityScores;}

    public int getProficiencyBonus() {return proficiencyBonus;}
    public void setProficiencyBonus(int proficiencyBonus) {this.proficiencyBonus = proficiencyBonus;}

    public int[] getSpeeds() {return speeds;}
    public void setSpeeds(int[] speeds) {this.speeds = speeds;}

    public int getHitpoints() {return hitpoints;}
    public void setHitpoints(int hitpoints) {this.hitpoints = hitpoints;}

    public boolean[] getSavingThrowProficiency() {return savingThrowProficiency;}
    public void setSavingThrowProficiency(boolean[] savingThrowProficiency) {this.savingThrowProficiency = savingThrowProficiency;}

    public boolean[] getSkillProficiency() {return skillProficiency;}
    public void setSkillProficiency(boolean[] skillProficiency) {this.skillProficiency = skillProficiency;}

    public static int[] getSkillAssociatedAbility() {return skillAssociatedAbility;}
    public static void setSkillAssociatedAbility(int[] skillAssociatedAbility) {Character.skillAssociatedAbility = skillAssociatedAbility;}
}
