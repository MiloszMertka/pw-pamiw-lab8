package com.example.api.seeder;

import com.example.api.model.Car;
import com.example.api.model.Engine;
import com.example.api.model.EquipmentOption;
import com.example.api.repository.CarRepository;
import com.example.api.repository.EngineRepository;
import com.example.api.repository.EquipmentOptionRepository;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class CarSeeder implements Seeder {

    private final CarRepository carRepository;
    private final EngineRepository engineRepository;
    private final EquipmentOptionRepository equipmentOptionRepository;
    private final Faker faker;

    @Override
    public void seed(int objectsToSeed) {
        final Set<Car> cars = HashSet.newHashSet(objectsToSeed);
        for (int i = 0; i < objectsToSeed; i++) {
            final var car = createCar();
            if (cars.contains(car)) {
                i--;
                continue;
            }
            carRepository.save(car);
            cars.add(car);
        }
    }

    private Car createCar() {
        return new Car(
                String.join(" ", faker.lorem().words(2)),
                faker.color().name(),
                getRandomEngine(),
                getListOfRandomEquipmentOptions()
        );
    }

    private Engine getRandomEngine() {
        final var engines = engineRepository.findAll();
        final var randomIndex = faker.number().numberBetween(0, engines.size());
        return engines.get(randomIndex);
    }

    private List<EquipmentOption> getListOfRandomEquipmentOptions() {
        final var listSize = faker.number().numberBetween(0, 3);
        final Set<EquipmentOption> equipmentOptions = HashSet.newHashSet(listSize);
        for (var i = 0; i < listSize; i++) {
            final var equipmentOption = getRandomEquipmentOption();
            equipmentOptions.add(equipmentOption);
        }
        return equipmentOptions.stream().toList();
    }

    private EquipmentOption getRandomEquipmentOption() {
        final var equipmentOptions = equipmentOptionRepository.findAll();
        final var randomIndex = faker.number().numberBetween(0, equipmentOptions.size());
        return equipmentOptions.get(randomIndex);
    }

}
