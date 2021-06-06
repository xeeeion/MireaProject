package com.mirea.denisignatenko.mireaproject.ui.notes;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Cell {
    @PrimaryKey(autoGenerate = true)
    public long id;
    public String text;
}
