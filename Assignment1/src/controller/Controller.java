package controller;

import model.Animal;
import repository.AnimalRepository;
import repository.RepositoryException;
import java.util.Arrays;

public class Controller {
    private final AnimalRepository repository;

    public Controller(AnimalRepository repository) {
        this.repository = repository;
    }

    public void addAnimal(Animal animal) throws RepositoryException {
        repository.add(animal);
    }

    public void removeAnimal(int position) throws RepositoryException {
        repository.remove(position);
    }

    public Animal[] getAnimalsHeavierThan(double minWeight) {
        Animal[] all = repository.getAll();
        Animal[] result = new Animal[all.length];
        int count = 0;
        for (Animal animal : all) {
            if (animal.getWeight() > minWeight) {
                result[count] = animal;
                count++;
            }
        }
        return Arrays.copyOf(result, count);
    }
}
