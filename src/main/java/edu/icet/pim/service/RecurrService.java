package edu.icet.pim.service;

import edu.icet.pim.model.Expense;
import edu.icet.pim.model.Recurre;

import java.util.List;

public interface RecurrService {

    Boolean addRecurring(Recurre recurre);
    List<Recurre> getAll();

    Boolean updateRecurring(Recurre recurre);

    Boolean deleteRecurr(Long id);


}
