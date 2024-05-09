package ru.skillbox.saver.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.skillbox.saver.dao.entity.WordEntity;
import ru.skillbox.saver.dao.repository.WordRepository;
import ru.skillbox.saver.dto.WordRequest;
import ru.skillbox.saver.validator.WordValidator;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
@Slf4j
public class WordController {

    private final WordValidator wordValidator;
    private final WordRepository wordRepository;

    @Value("${error.text}")
    private String errorText;

    @Value("${success.text}")
    private String successText;

    @RequestMapping(value = "/addWord", method = RequestMethod.POST)
    public String addWord(@ModelAttribute WordRequest wordRequest, Model model) {
        if (!wordValidator.isValid(wordRequest.getWord())) {
            log.error("Word {} is not valid", wordRequest.getWord());
            model.addAttribute("error", errorText);
        } else {
            wordRepository.save(new WordEntity(UUID.randomUUID(), wordRequest.getWord()));
            model.addAttribute("success", successText);
        }
        return "app_title";
    }
}
