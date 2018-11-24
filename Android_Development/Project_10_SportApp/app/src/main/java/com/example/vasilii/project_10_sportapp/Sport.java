package com.example.vasilii.project_10_sportapp;

import android.support.annotation.NonNull;

public class Sport {
    private String name;
    private String description;
    private int imageResourceId;

    private Sport(String name, String description, int imageResourceId) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public static final Sport [] sports = {
        new Sport(
            "Футбол",
            "Спортивная игра двух команд (по одиннадцати игроков в каждой), состоящая в том, что игроки стараются ударами ноги загнать мяч в ворота противника.",
            R.drawable.football
        ),
        new Sport(
            "Хоккей",
            "Командная игра на льду на коньках в небольшой мяч или шайбу, ударяемые клюшкой.",
            R.drawable.hockey
        ),
        new Sport(
            "Волейбол",
            "Спортивная игра в мяч, перебрасываемый руками через сетку от одной команды к другой.",
            R.drawable.volleyball
        ),
        new Sport(
            "Регби",
            "Спортивная командная игра с овальным мячом, который игроки передают друг другу руками и ногами, стараясь пересечь линию ворот противника.",
            R.drawable.rugby
        ),
        new Sport(
            "Танцы",
            "Ритмичные, выразительные телодвижения, обычно выстраиваемые в определённую композицию и исполняемые с музыкальным сопровождением.",
            R.drawable.dancing
        ),
        new Sport(
            "Баскетбол",
            "Игра, в которой мяч забрасывают руками в подвешенную сетку (называемую корзиной) противной партии.",
            R.drawable.basketball
        ),
        new Sport(
            "Теннис",
            "Спортивная игра маленьким мячом, который перебрасывается ракеткой через сетку, разделяющую площадку.",
            R.drawable.tennis
        ),
        new Sport(
            "Плавание",
            "Вид спорта или спортивная дисциплина, заключающаяся в преодолении вплавь за наименьшее время различных дистанций.",
            R.drawable.swimming
        ),
        new Sport(
            "Каратэ",
            "Спортивная японская борьба, система самозащиты без оружия.",
            R.drawable.karate
        ),
        new Sport(
            "Бокс",
            "Кулачный бой в специальных перчатках по определённым правилам между двумя спортсменами.",
            R.drawable.boxing
        ),
    };

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    @NonNull
    @Override
    public String toString() {
        return this.name;
    }
}
