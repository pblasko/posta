package hu.posta.szekesfehervar.service;

import hu.posta.szekesfehervar.model.DailyReport;
import hu.posta.szekesfehervar.repository.CaseRepository;
import hu.posta.szekesfehervar.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;
    @Autowired
    private CaseRepository caseRepository;

    public DailyReport createDailyReport () {
        DailyReport newDailyReport = new DailyReport();
        newDailyReport.setBasicReport(reportRepository.findById(1));
        newDailyReport.setActualReport(reportRepository.findById(2));
        newDailyReport.setCases(caseRepository.findAll());
        return newDailyReport;
    }

}
