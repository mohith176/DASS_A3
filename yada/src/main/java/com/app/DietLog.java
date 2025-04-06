package com.app;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DietLog {
    private static final String LOG_PATH = "dietLog.json";
    private List<LogEntry> entries;
    private Stack<UndoAction> undoStack;
    private FoodDatabase foodDB;
    
    public DietLog(FoodDatabase foodDB) {
        this.entries = new ArrayList<>();
        this.undoStack = new Stack<>();
        this.foodDB = foodDB;
        loadLog();
    }
    
    public void loadLog() {
        try {
            if (!Files.exists(Paths.get(LOG_PATH)) || Files.size(Paths.get(LOG_PATH)) == 0) {
                return;
            }
            
            JSONParser parser = new JSONParser();
            try (FileReader reader = new FileReader(LOG_PATH)) {
                JSONArray logArray = (JSONArray) parser.parse(reader);
                
                for (Object obj : logArray) {
                    JSONObject entryJson = (JSONObject) obj;
                    int entryId = ((Long) entryJson.get("entryId")).intValue();
                    String username = (String) entryJson.get("username");
                    LocalDate date = LocalDate.parse((String) entryJson.get("date"));
                    String foodName = (String) entryJson.get("foodName");
                    double servings = ((Number) entryJson.get("servings")).doubleValue();
                    
                    Food food = foodDB.getFoodByName(foodName);
                    if (food != null) {
                        entries.add(new LogEntry(username, date, food, servings, entryId));
                    }
                }
            }
        } catch (IOException | ParseException e) {
            System.err.println("Error loading diet log: " + e.getMessage());
        }
    }
    
    public void saveLog() {
        try {
            JSONArray logArray = new JSONArray();
            
            for (LogEntry entry : entries) {
                logArray.add(entry.toJSON());
            }
            
            try (FileWriter file = new FileWriter(LOG_PATH)) {
                file.write(logArray.toJSONString());
                file.flush();
            }
            
            System.out.println("Diet log saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving diet log: " + e.getMessage());
        }
    }
    
    public void addEntry(String username, LocalDate date, Food food, double servings) {
        LogEntry entry = new LogEntry(username, date, food, servings);
        
        // Save the action for potential undo
        undoStack.push(new UndoAction(UndoActionType.ADD, entry, null));
        
        entries.add(entry);
    }
    
    public boolean deleteEntry(int entryId) {
        for (int i = 0; i < entries.size(); i++) {
            if (entries.get(i).getEntryId() == entryId) {
                LogEntry removedEntry = entries.get(i);
                
                // Save the action for potential undo
                undoStack.push(new UndoAction(UndoActionType.DELETE, null, removedEntry));
                
                entries.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public List<LogEntry> getEntriesForDate(String username, LocalDate date) {
        return entries.stream()
                .filter(entry -> entry.getUsername().equals(username) && entry.getDate().equals(date))
                .collect(Collectors.toList());
    }
    
    public List<LocalDate> getDatesWithEntries(String username) {
        List<LocalDate> dates = entries.stream()
                .filter(entry -> entry.getUsername().equals(username))
                .map(LogEntry::getDate)
                .distinct()
                .collect(Collectors.toList());
        
        Collections.sort(dates);
        return dates;
    }
    
    public int getTotalCaloriesForDate(String username, LocalDate date) {
        return entries.stream()
                .filter(entry -> entry.getUsername().equals(username) && entry.getDate().equals(date))
                .mapToInt(LogEntry::getTotalCalories)
                .sum();
    }
    
    public boolean canUndo() {
        return !undoStack.isEmpty();
    }
    
    public void undo() {
        if (undoStack.isEmpty()) {
            return;
        }
        
        UndoAction action = undoStack.pop();
        
        switch (action.getType()) {
            case ADD:
                // Remove the entry that was added
                entries.removeIf(e -> e.getEntryId() == action.getAddedEntry().getEntryId());
                break;
                
            case DELETE:
                // Add back the entry that was deleted
                entries.add(action.getDeletedEntry());
                break;
        }
    }
    
    // Inner classes for undo functionality
    private enum UndoActionType {
        ADD, DELETE
    }
    
    private class UndoAction {
        private UndoActionType type;
        private LogEntry addedEntry;
        private LogEntry deletedEntry;
        
        public UndoAction(UndoActionType type, LogEntry addedEntry, LogEntry deletedEntry) {
            this.type = type;
            this.addedEntry = addedEntry;
            this.deletedEntry = deletedEntry;
        }
        
        public UndoActionType getType() {
            return type;
        }
        
        public LogEntry getAddedEntry() {
            return addedEntry;
        }
        
        public LogEntry getDeletedEntry() {
            return deletedEntry;
        }
    }
}