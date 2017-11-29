package com.example.yebuo_admin.game.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Yebuo-admin on 2017-05-26.
 */

public class Unit implements Parcelable{

    private int hp;
    private int attack;
    private int defence;
    private int dmgMin;
    private int dmgMax;
    private int cost;
    private String name;

    public Unit(){

    }

    public Unit(String name, int hp, int attack, int defence, int dmgMax, int dmgMin, int cost){
        this.attack = attack;
        this.defence = defence;
        this.hp = hp;
        this.dmgMax = dmgMax;
        this.dmgMin = dmgMin;
        this.cost = cost;
        this.name = name;
    }

    protected Unit(Parcel in) {
        hp = in.readInt();
        attack = in.readInt();
        defence = in.readInt();
        dmgMin = in.readInt();
        dmgMax = in.readInt();
        cost = in.readInt();
        name = in.readString();
    }

    public static final Creator<Unit> CREATOR = new Creator<Unit>() {
        @Override
        public Unit createFromParcel(Parcel in) {
            return new Unit(in);
        }

        @Override
        public Unit[] newArray(int size) {
            return new Unit[size];
        }
    };

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getDmgMin() {
        return dmgMin;
    }

    public void setDmgMin(int dmgMin) {
        this.dmgMin = dmgMin;
    }

    public int getDmgMax() {
        return dmgMax;
    }

    public void setDmgMax(int dmgMax) {
        this.dmgMax = dmgMax;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getName(){return name;}

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(hp);
        parcel.writeInt(attack);
        parcel.writeInt(defence);
        parcel.writeInt(dmgMax);
        parcel.writeInt(dmgMin);
        parcel.writeInt(cost);
        parcel.writeString(name);
    }
}
