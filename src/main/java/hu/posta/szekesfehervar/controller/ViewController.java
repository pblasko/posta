package hu.posta.szekesfehervar.controller;

import hu.posta.szekesfehervar.model.Case;
import hu.posta.szekesfehervar.model.DailyReport;
import hu.posta.szekesfehervar.service.CaseService;
import hu.posta.szekesfehervar.service.EmailService;
import hu.posta.szekesfehervar.service.ExcelWriterService;
import hu.posta.szekesfehervar.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = {"http://localhost:8100", "http://192.168.1.239:8100"})
@RestController
public class ViewController {

    @Autowired
    private ExcelWriterService excelWriterService;
    @Autowired
    private ReportService reportService;
    @Autowired
    private CaseService caseService;
    @Autowired
    private EmailService emailService;

    @GetMapping(value = "/")
    public DailyReport landing() {
        return reportService.createDailyReport();
    }

    @GetMapping(value = "/newExcel")
    public String newExcelWrite() {
        excelWriterService.createWorkSheets();
        return "New success";
    }

    @PostMapping(value = "/newCase")
    public ResponseEntity<Map<String, String>> addNewCase(@RequestBody Case newCase) {
        caseService.addNewCase(newCase);
        // JSON formátumú válasz előkészítése
        Map<String, String> response = new HashMap<>();
        response.put("message", "Email sent successfully!");
        // Visszaküldjük a JSON választ
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/deleteCase")
    public ResponseEntity<Map<String, String>> deleteCase(@RequestBody Case oldCase) {
        caseService.deleteCase(oldCase);
        // JSON formátumú válasz előkészítése
        Map<String, String> response = new HashMap<>();
        response.put("message", "Email sent successfully!");
        // Visszaküldjük a JSON választ
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/settingCase")
    public ResponseEntity<Map<String, String>> settingCase(@RequestBody Case oldCase) {
        caseService.settingCase(oldCase);
        // JSON formátumú válasz előkészítése
        Map<String, String> response = new HashMap<>();
        response.put("message", "Email sent successfully!");
        // Visszaküldjük a JSON választ
        return ResponseEntity.ok(response);
    }

    @GetMapping("/send")
    @CrossOrigin(origins = "http://192.168.1.239:8100")
    public ResponseEntity<Map<String, String>> sendEmail() {
        emailService.sendEmail();
        // JSON formátumú válasz előkészítése
        Map<String, String> response = new HashMap<>();
        response.put("message", "Email sent successfully!");
        // Visszaküldjük a JSON választ
        return ResponseEntity.ok(response);
    }

}
