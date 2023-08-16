package ru.bandurina.junglesimulator._main;

import ru.bandurina.junglesimulator.entity.Shark;
import ru.bandurina.junglesimulator.util.EventProducer;

public class _Main {

    public static void main(String[] args) {
        Shark shark = new Shark();
        EventProducer eventProducer = new EventProducer();
        eventProducer.startSimulator(shark);
    }
}
