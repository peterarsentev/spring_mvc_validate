package ru.job4j.validation.controller;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.job4j.validation.model.Sample;
import ru.job4j.validation.service.SampleService;

import javax.validation.Valid;

@Controller
@RequestMapping("/samples")
@ThreadSafe
public class SampleController {
    private final SampleService sampleService;

    public SampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("samples", sampleService.findAll());
        return "examples/list";
    }

    @GetMapping("/create")
    public String getCreationPage(Model model) {
        model.addAttribute("sample", new Sample());
        return "examples/create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute Sample sample, BindingResult errors, Model model) {
        if (errors.hasErrors()) {
            return "examples/create";
        }
        try {
            sampleService.save(sample);
            return "redirect:/samples";
        } catch (Exception exception) {
            model.addAttribute("message", exception.getMessage());
            return "errors/404";
        }
    }

    @GetMapping("/{id}")
    public String getById(Model model, @PathVariable int id) {
        var vacancyOptional = sampleService.findById(id);
        if (vacancyOptional.isEmpty()) {
            model.addAttribute("message", "Пример с указанным идентификатором не найден");
            return "errors/404";
        }
        model.addAttribute("sample", vacancyOptional.get());
        return "examples/one";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute Sample sample, BindingResult errors, Model model) {
        if (errors.hasErrors()) {
            return "examples/one";
        }
        try {
            var isUpdated = sampleService.update(sample);
            if (!isUpdated) {
                model.addAttribute("message", "Пример с указанным идентификатором не найден");
                return "errors/404";
            }
            return "redirect:/samples";
        } catch (Exception exception) {
            model.addAttribute("message", exception.getMessage());
            return "errors/404";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable int id) {
        var isDeleted = sampleService.deleteById(id);
        if (!isDeleted) {
            model.addAttribute("message", "Пример с указанным идентификатором не найден");
            return "errors/404";
        }
        return "redirect:/samples";
    }
}
