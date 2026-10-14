package repository;

import model.Animal;
import java.util.Arrays;

public class ArrayAnimalRepository implements AnimalRepository {
    private final Animal[] animals;
    private int size;

    public ArrayAnimalRepository(int capacity) {
        this.animals = new Animal[capacity];
        this.size = 0;
    }

    @Override
    public void add(Animal animal) throws RepositoryException {
        if (size == animals.length) {
            throw new RepositoryException("The repository is full.");
        }
        animals[size] = animal;
        size++;
    }

    @Override
    public void remove(int position) throws RepositoryException {
        if (position < 0 || position >= size) {
            throw new RepositoryException("No animal at position " + position + ".");
        }
        for (int i = position; i < size - 1; i++) {
            animals[i] = animals[i + 1];
        }
        animals[size - 1] = null;
        size--;
    }

    @Override
    public Animal[] getAll() {
        return Arrays.copyOf(animals, size);
    }
}
