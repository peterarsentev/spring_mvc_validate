package ru.job4j.validation.repository;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Repository;
import ru.job4j.validation.model.Sample;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
@ThreadSafe
public class MemorySampleRepository implements SampleRepository {
    private final AtomicInteger nextId = new AtomicInteger(1);

    private final Map<Integer, Sample> vacancies = new ConcurrentHashMap<>();

    public MemorySampleRepository() {
        save(new Sample(0, "Intern Java Developer", "Стажер Java разработчик", 0, "1"));
        save(new Sample(0, "Junior Java Developer", "Младший Java разработчик", 1, "2"));
    }

    @Override
    public Sample save(Sample sample) {
        sample.setId(nextId.getAndIncrement());
        vacancies.put(sample.getId(), sample);
        return sample;
    }

    @Override
    public boolean deleteById(int id) {
        return vacancies.remove(id) != null;
    }

    @Override
    public boolean update(Sample sample) {
        return vacancies.computeIfPresent(sample.getId(),
                (id, oldVacancy) -> new Sample(
                        oldVacancy.getId(),
                        sample.getTitle(),
                        sample.getDescription(),
                        sample.getNumberField(),
                        sample.getOnlyDigits()
                )) != null;
    }

    @Override
    public Optional<Sample> findById(int id) {
        return Optional.ofNullable(vacancies.get(id));
    }

    @Override
    public Collection<Sample> findAll() {
        return List.copyOf(vacancies.values());
    }
}
