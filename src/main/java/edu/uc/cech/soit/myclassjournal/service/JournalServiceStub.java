package edu.uc.cech.soit.myclassjournal.service;

import edu.uc.cech.soit.myclassjournal.dao.JournalDAO;
import edu.uc.cech.soit.myclassjournal.dto.JournalEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalServiceStub implements IJournalService {
    @Autowired
    private JournalDAO journalServiceDAO;

    public JournalServiceStub() {

    }

    public JournalServiceStub(JournalDAO journalServiceDAO) {
        this.journalServiceDAO = journalServiceDAO;
    }

    @Override
    public JournalEntry save(JournalEntry journalEntry) {
        return journalServiceDAO.save(journalEntry);
    }

    @Override
    public List<JournalEntry> fetchAll() {
        return journalServiceDAO.fetchAll();
    }
}
