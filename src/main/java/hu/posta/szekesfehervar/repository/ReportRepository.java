package hu.posta.szekesfehervar.repository;

import hu.posta.szekesfehervar.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Long> {

    Report findById(long id);

}
