package edu.uc.cech.soit.myclassjournal.dao;


import edu.uc.cech.soit.myclassjournal.dto.JournalEntry;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class JournalDAOStub implements JournalDAO{
    Map<Integer, JournalEntry> allJournalEntries = new HashMap();

    @Override
    public JournalEntry save(JournalEntry journalEntry) {
        Integer journalEntryID = journalEntry.getJournalEntryID();
        allJournalEntries.put(journalEntryID, journalEntry);
        return journalEntry;
    }

    @Override
    public List<JournalEntry> fetchAll() {
        List<JournalEntry> returnJournalEntries = new ArrayList<>(allJournalEntries.values());
        return returnJournalEntries;
    }
}
