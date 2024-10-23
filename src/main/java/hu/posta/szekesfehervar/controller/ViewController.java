package hu.posta.szekesfehervar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ViewController {

    @GetMapping(value = "/")
    public String landing() {
        return "Székesfehérvár Depó - Magyar Posta Zrt";
    }

}
