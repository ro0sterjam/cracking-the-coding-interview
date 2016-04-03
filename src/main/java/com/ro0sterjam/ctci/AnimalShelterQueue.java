package com.ro0sterjam.ctci;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kenwang on 2016-04-03.
 */
public class AnimalShelterQueue {

    private Map<Species, Queue<AnimalRegistration>> animalQueues = new HashMap<>();
    private int order = 0;

    public static class Animal {
        Species species;

        public Animal(Species species) {
            this.species = species;
        }
    }

    public enum Species {
        DOG, CAT;
    }

    public void enqueue(Animal animal) {
        AnimalRegistration reg = new AnimalRegistration(animal, order++);
        if (!animalQueues.containsKey(animal.species)) {
            animalQueues.put(animal.species, new Queue<>());
        }
        animalQueues.get(animal.species).enqueue(reg);
    }

    public Animal dequeue() {
        Animal oldest = oldestAnimal();
        if (oldest == null) {
            return null;
        }
        return animalQueues.get(oldest.species).dequeue().animal;
    }

    public Animal dequeue(Species species) {
        if (!animalQueues.containsKey(species) || animalQueues.get(species).isEmpty()) {
            return null;
        }
        return animalQueues.get(species).dequeue().animal;
    }

    private Animal oldestAnimal() {
        AnimalRegistration oldest = null;
        for (Queue<AnimalRegistration> animalQueue : animalQueues.values()) {
            if (oldest == null || animalQueue.poll() != null && animalQueue.poll().order < oldest.order) {
                oldest = animalQueue.poll();
            }
        }
        return oldest == null? null : oldest.animal;
    }

    private static class AnimalRegistration {
        Animal animal;
        int order;

        public AnimalRegistration(Animal animal, int order) {
            this.animal = animal;
            this.order = order;
        }
    }
}
