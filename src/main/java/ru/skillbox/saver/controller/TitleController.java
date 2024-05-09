package ru.skillbox.saver.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.skillbox.saver.dto.WordRequest;

@Controller
@RequiredArgsConstructor
@Slf4j
public class TitleController {

    @RequestMapping(value = "/app_title", method = RequestMethod.GET)
    public String title(Model model) {
        model.addAttribute("wordRequest", new WordRequest());
        return "app_title";
    }


}
