package capstone.code.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainScreenControllerr {
    @GetMapping("/mainscreen")
    public void mainScreen() {}

}
