package ru.job4j.validation.service;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.validation.model.Sample;
import ru.job4j.validation.repository.SampleRepository;

import java.util.Collection;
import java.util.Optional;

@Service
@ThreadSafe
public class SimpleSampleService implements SampleService {
    private final SampleRepository sampleRepository;


    public SimpleSampleService(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    @Override
    public Sample save(Sample sample) {
        return sampleRepository.save(sample);
    }

    @Override
    public boolean deleteById(int id) {
        var result = false;
        var vacancyOptional = findById(id);
        if (vacancyOptional.isPresent()) {
            sampleRepository.deleteById(id);
            result = true;
        }
        return result;
    }

    @Override
    public boolean update(Sample sample) {
            return sampleRepository.update(sample);
    }

    @Override
    public Optional<Sample> findById(int id) {
        return sampleRepository.findById(id);
    }

    @Override
    public Collection<Sample> findAll() {
        return sampleRepository.findAll();
    }
}
