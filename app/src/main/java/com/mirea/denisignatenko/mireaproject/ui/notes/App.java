package com.mirea.denisignatenko.mireaproject.ui.notes;

import android.app.Application;

import androidx.room.Room;

public class App extends Application {
    public static com.mirea.denisignatenko.mireaproject.ui.notes.App instance;
    private AppData database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, AppData.class, "database")
                .allowMainThreadQueries()
                .build();
    }

    public static com.mirea.denisignatenko.mireaproject.ui.notes.App getInstance() {
        return instance;
    }

    public AppData getDatabase() {
        return database;
    }
}