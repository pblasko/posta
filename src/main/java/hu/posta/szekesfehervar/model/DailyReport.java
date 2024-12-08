package hu.posta.szekesfehervar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DailyReport {

    private Report basicReport;
    private Report actualReport;
    private List<Case> cases;

}
