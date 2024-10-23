package hu.posta.szekesfehervar.controller;

import hu.posta.szekesfehervar.service.ExcelWriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ViewController {

    @Autowired
    private ExcelWriterService excelWriterService;

    @GetMapping(value = "/")
    public String landing() {
        return "Székesfehérvár Depó - Magyar Posta Zrt";
    }

    @GetMapping(value = "/excel")
    public String excelWrite() {
        excelWriterService.excelWriter();
        return "Success";
    }

}
