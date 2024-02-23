package ru.job4j.validation.repository;

import ru.job4j.validation.model.Sample;

import java.util.Collection;
import java.util.Optional;

public interface SampleRepository {
    Sample save(Sample sample);

    boolean deleteById(int id);

    boolean update(Sample sample);

    Optional<Sample> findById(int id);

    Collection<Sample> findAll();
}
