package ru.job4j.validation.service;

import ru.job4j.validation.model.Sample;

import java.util.Collection;
import java.util.Optional;

public interface SampleService {
    Sample save(Sample sample);

    boolean deleteById(int id);

    boolean update(Sample sample);

    Optional<Sample> findById(int id);

    Collection<Sample> findAll();
}
