package edu.uc.cech.soit.myclassjournal.dto;

import lombok.Data;

public @Data class JournalEntry {
    int journalEntryID;
    private String notes;
    private String date;
}
