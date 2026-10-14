package view;

import controller.Controller;
import model.Animal;
import model.Cow;
import model.Pig;
import model.Poultry;
import repository.RepositoryException;

public class View {
    private final Controller controller;

    public View(Controller controller) {
        this.controller = controller;
    }

    public void run() {
        System.out.println("Adding animals...");
        tryAdd(new Cow(450.0));
        tryAdd(new Pig(120.5));
        tryAdd(new Poultry(2.0));
        tryAdd(new Poultry(3.0));
        tryAdd(new Poultry(3.5));

        System.out.println();
        System.out.println("Animals heavier than 3 kg:");
        printAnimals(controller.getAnimalsHeavierThan(3.0));

        System.out.println();
        System.out.println("Adding one more animal (the repository is full)...");
        tryAdd(new Pig(80.0));

        System.out.println();
        System.out.println("Removing the animal at position 0...");
        tryRemove(0);
        System.out.println("Removing the animal at position 10...");
        tryRemove(10);

        System.out.println();
        System.out.println("Animals heavier than 3 kg:");
        printAnimals(controller.getAnimalsHeavierThan(3.0));
    }

    private void tryAdd(Animal animal) {
        try {
            controller.addAnimal(animal);
        } catch (RepositoryException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void tryRemove(int position) {
        try {
            controller.removeAnimal(position);
        } catch (RepositoryException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void printAnimals(Animal[] animals) {
        if (animals.length == 0) {
            System.out.println("  (none)");
            return;
        }
        for (Animal animal : animals) {
            System.out.println(" " + animal);
        }
    }
}
