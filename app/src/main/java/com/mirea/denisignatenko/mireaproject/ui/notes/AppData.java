package com.mirea.denisignatenko.mireaproject.ui.notes;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Cell.class}, version = 1)
public abstract class AppData extends RoomDatabase {
    public abstract NoteDAO storyDao();
}

