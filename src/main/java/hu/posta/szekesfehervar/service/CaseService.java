package hu.posta.szekesfehervar.service;

import hu.posta.szekesfehervar.model.Case;
import hu.posta.szekesfehervar.model.Report;
import hu.posta.szekesfehervar.repository.CaseRepository;
import hu.posta.szekesfehervar.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CaseService {

    @Autowired
    private CaseRepository caseRepository;
    @Autowired
    private ReportRepository reportRepository;

    public String addNewCase(Case newcase) {
        Case newCase = new Case();
        newCase.setCategory(newcase.getCategory());
        newCase.setLicensePlate(newcase.getLicensePlate());
        newCase.setType(newcase.getType());
        newCase.setDescription(newcase.getDescription());
        newCase.setSolution(newcase.getSolution());
        caseRepository.save(newCase);
        settingReportData(newcase.getCategory());
        return "successful saving new case";
    }

    private void settingReportData(long id) {
        Report oldReport = reportRepository.findById(2);
        if (id == 1) {
            oldReport.setInGarage(oldReport.getInGarage() + 1);
            oldReport.setInService(oldReport.getInService() - 1);
            oldReport.setInPackage(oldReport.getInPackage() + 1);
        } else {
            oldReport.setInGarage(oldReport.getInGarage() - 1);
            oldReport.setInService(oldReport.getInService() + 1);
            oldReport.setInPackage(oldReport.getInPackage() - 1);
        }
        reportRepository.save(oldReport);
    }

    public String deleteCase(Case oldcase) {
        Optional<Case> optionalCase = caseRepository.findById(oldcase.getId());
        Case oldCase;
        if (optionalCase.isPresent()) {
            oldCase = optionalCase.get();
            changingReportData(oldCase.getCategory());
        } else {
            throw new NoSuchElementException("Case not found!");
        }
        caseRepository.deleteById(oldcase.getId());
        return "successful deleting case";
    }

    private void changingReportData(long id) {
        Report oldReport = reportRepository.findById(2);
        if (id == 1) {
            oldReport.setInGarage(oldReport.getInGarage() - 1);
            oldReport.setInService(oldReport.getInService() + 1);
            oldReport.setInPackage(oldReport.getInPackage() - 1);
        } else {
            oldReport.setInGarage(oldReport.getInGarage() + 1);
            oldReport.setInService(oldReport.getInService() - 1);
            oldReport.setInPackage(oldReport.getInPackage() + 1);
        }
        reportRepository.save(oldReport);
    }

    public String settingCase(Case oldcase) {
        Optional<Case> optionalCase = caseRepository.findById(oldcase.getId());
        Case oldCase;
        if (optionalCase.isPresent()) {
            oldCase = optionalCase.get();
            changingReportData(oldCase.getCategory());
            settingReportData(oldcase.getCategory());
        } else {
            throw new NoSuchElementException("Case not found!");
        }
        oldCase.setLicensePlate(oldcase.getLicensePlate());
        oldCase.setCategory(oldcase.getCategory());
        oldCase.setType(oldcase.getType());
        oldCase.setDescription(oldcase.getDescription());
        oldCase.setSolution(oldcase.getSolution());
        caseRepository.save(oldCase);
        return "successful setting case";
    }

}
