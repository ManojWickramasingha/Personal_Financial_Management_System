package edu.icet.pim.service;

import edu.icet.pim.model.Recurre;

import java.util.List;

public interface RecurrService {

    Boolean addRecurring(Recurre recurre);
    List<Recurre> getAll();
}
