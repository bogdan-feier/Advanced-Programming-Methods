import controller.Controller;
import repository.AnimalRepository;
import repository.ArrayAnimalRepository;
import view.View;

public class Main {
    public static void main(String[] args) {
        AnimalRepository repository = new ArrayAnimalRepository(5);
        Controller controller = new Controller(repository);
        View view = new View(controller);
        view.run();
    }
}