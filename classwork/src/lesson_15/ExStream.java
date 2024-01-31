package lesson_15;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ExStream {
    public void printSpecies(List<SeaCreature> seaCreatures) {
        List<Species> sortedSpecies = seaCreatures.stream()
                .filter(sc -> sc.getWeight() >= 10)
                .map(SeaCreature::getSpecies)
                .distinct()
                .sorted(Comparator.comparingInt(Species::getPopulation))
                .collect(Collectors.toList());

        sortedSpecies.forEach(s -> System.out.println(s.getName()));
    }
}
