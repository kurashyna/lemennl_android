package com.lmlucas.lecoledesloustics.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.lmlucas.lecoledesloustics.Models.Eleve;

import java.util.List;

@Dao
public interface EleveDao {

    @Query("SELECT * FROM Eleves")
    List<Eleve> getAll();

    @Query("SELECT count(*) FROM Eleves")
    int count();

    @Insert
    long insert(Eleve eleve);

    @Insert
    long[] insertAll(Eleve... eleves);

    @Update
    void update(Eleve eleve);

    @Delete
    void delete(Eleve eleve);

    @Query("SELECT id FROM eleves ORDER BY id DESC LIMIT 1")
    int getLastId();
}
