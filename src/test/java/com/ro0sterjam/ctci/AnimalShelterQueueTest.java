package com.ro0sterjam.ctci;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by kenwang on 2016-04-03.
 */
public class AnimalShelterQueueTest {

    @Test
    public void testDequeue_emptyQueue() {
        AnimalShelterQueue queue = new AnimalShelterQueue();
        assertEquals(null, queue.dequeue());
    }

    @Test
    public void testDequeueCat_emptyQueue() {
        AnimalShelterQueue queue = new AnimalShelterQueue();
        assertEquals(null, queue.dequeue(AnimalShelterQueue.Species.CAT));
    }

    @Test
    public void testDequeueCat_singleCatInShelter() {
        AnimalShelterQueue queue = new AnimalShelterQueue();
        AnimalShelterQueue.Animal cat = new AnimalShelterQueue.Animal(AnimalShelterQueue.Species.CAT);
        queue.enqueue(cat);
        assertEquals(cat, queue.dequeue(AnimalShelterQueue.Species.CAT));
    }

    @Test
    public void testDequeueDog_singleCatInShelter() {
        AnimalShelterQueue queue = new AnimalShelterQueue();
        AnimalShelterQueue.Animal cat = new AnimalShelterQueue.Animal(AnimalShelterQueue.Species.CAT);
        queue.enqueue(cat);
        assertEquals(null, queue.dequeue(AnimalShelterQueue.Species.DOG));
    }

    @Test
    public void testDequeueCat_dogThenCatSheltered() {
        AnimalShelterQueue queue = new AnimalShelterQueue();
        queue.enqueue(new AnimalShelterQueue.Animal(AnimalShelterQueue.Species.DOG));
        AnimalShelterQueue.Animal cat = new AnimalShelterQueue.Animal(AnimalShelterQueue.Species.CAT);
        queue.enqueue(cat);
        assertEquals(cat, queue.dequeue(AnimalShelterQueue.Species.CAT));
    }

    @Test
    public void testDequeueCat_catThenDogSheltered() {
        AnimalShelterQueue queue = new AnimalShelterQueue();
        AnimalShelterQueue.Animal cat = new AnimalShelterQueue.Animal(AnimalShelterQueue.Species.CAT);
        queue.enqueue(cat);
        queue.enqueue(new AnimalShelterQueue.Animal(AnimalShelterQueue.Species.DOG));
        assertEquals(cat, queue.dequeue(AnimalShelterQueue.Species.CAT));
    }

    @Test
    public void testDequeue_catThenDogSheltered() {
        AnimalShelterQueue queue = new AnimalShelterQueue();
        AnimalShelterQueue.Animal cat = new AnimalShelterQueue.Animal(AnimalShelterQueue.Species.CAT);
        queue.enqueue(cat);
        queue.enqueue(new AnimalShelterQueue.Animal(AnimalShelterQueue.Species.DOG));
        assertEquals(cat, queue.dequeue());
    }

    @Test
    public void testDequeue_randomEnqueuesAndDequeues() {
        AnimalShelterQueue queue = new AnimalShelterQueue();
        AnimalShelterQueue.Animal cat1 = new AnimalShelterQueue.Animal(AnimalShelterQueue.Species.CAT);
        AnimalShelterQueue.Animal cat2 = new AnimalShelterQueue.Animal(AnimalShelterQueue.Species.CAT);
        AnimalShelterQueue.Animal cat3 = new AnimalShelterQueue.Animal(AnimalShelterQueue.Species.CAT);
        AnimalShelterQueue.Animal cat4 = new AnimalShelterQueue.Animal(AnimalShelterQueue.Species.CAT);
        AnimalShelterQueue.Animal dog1 = new AnimalShelterQueue.Animal(AnimalShelterQueue.Species.DOG);
        AnimalShelterQueue.Animal dog2 = new AnimalShelterQueue.Animal(AnimalShelterQueue.Species.DOG);
        AnimalShelterQueue.Animal dog3 = new AnimalShelterQueue.Animal(AnimalShelterQueue.Species.DOG);
        AnimalShelterQueue.Animal dog4 = new AnimalShelterQueue.Animal(AnimalShelterQueue.Species.DOG);
        queue.enqueue(cat1);
        queue.enqueue(dog2);
        queue.enqueue(cat3);
        queue.dequeue();
        queue.enqueue(cat2);
        queue.enqueue(dog3);
        queue.dequeue(AnimalShelterQueue.Species.CAT);
        queue.enqueue(cat4);
        queue.enqueue(dog1);
        queue.enqueue(dog4);
        assertEquals(dog2, queue.dequeue());
        assertEquals(dog3, queue.dequeue(AnimalShelterQueue.Species.DOG));
        assertEquals(cat2, queue.dequeue(AnimalShelterQueue.Species.CAT));
        assertEquals(dog1, queue.dequeue(AnimalShelterQueue.Species.DOG));
        assertEquals(cat4, queue.dequeue());
        assertEquals(dog4, queue.dequeue());
    }

}