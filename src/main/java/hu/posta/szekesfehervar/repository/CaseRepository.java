package hu.posta.szekesfehervar.repository;

import hu.posta.szekesfehervar.model.Case;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CaseRepository extends JpaRepository<Case, Long> {

    List<Case> findAll();

    @Override
    Optional<Case> findById(Long id);

}
