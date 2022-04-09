package com.lmlucas.lecoledesloustics.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.lmlucas.lecoledesloustics.Models.Question;

import java.util.List;

@Dao
public interface QuestionsDao {

    @Query("SELECT * FROM Questions")
    List<Question> getAll();

    @Insert
    void insert(Question question);

    @Insert
    void insertAll(Question... questions);

    @Update
    void update(Question question);

    @Delete
    void delete(Question question);
}
