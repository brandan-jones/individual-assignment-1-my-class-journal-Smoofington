package edu.uc.cech.soit.myclassjournal;

import edu.uc.cech.soit.myclassjournal.dto.JournalEntry;
import edu.uc.cech.soit.myclassjournal.service.IJournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MyClassJournalController {

    @Autowired
    IJournalService journalService;

    /**
     * Handle the / endpoint
     *
     * @return
     */
    @RequestMapping("/")
    public String index() {
        return "start";
    }

    /**
     * Fetches all Journal Entries
     *
     * @return a collection of Journal Entries
     */
    @GetMapping("/journal-entries")
    @ResponseBody
    public List<JournalEntry> fetchAllJournalEntries() {
        return journalService.fetchAll();
    }

    /**
     * Create a new journal entry object, given the data provided
     *
     * returns on of the following status codes:
     * 201: successfully created a new journal entry.
     * 409: unable to create a journal entry, because it already exists.
     *
     * @param journalEntry a JSON representation of a journal entry object.
     * @return the newly created journal entry object.
     */
    @PostMapping(value = "/journal-entries", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public JournalEntry createJournalEntry(@RequestBody JournalEntry journalEntry) {
        JournalEntry newJournalEntry = null;
        try {
            newJournalEntry = journalService.save(journalEntry);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newJournalEntry;
    }
}
