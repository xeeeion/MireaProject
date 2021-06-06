package com.mirea.denisignatenko.mireaproject.ui.notes;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NoteDAO {
    @Query("SELECT * FROM Cell")
    List<com.mirea.denisignatenko.mireaproject.ui.notes.Cell> getAll();

    @Query("SELECT * FROM Cell WHERE id = :id")
    com.mirea.denisignatenko.mireaproject.ui.notes.Cell getById(long id);

    @Insert
    void insert(com.mirea.denisignatenko.mireaproject.ui.notes.Cell cell);

    @Update
    void update(com.mirea.denisignatenko.mireaproject.ui.notes.Cell cell);

    @Delete
    void delete(com.mirea.denisignatenko.mireaproject.ui.notes.Cell cell);

}
