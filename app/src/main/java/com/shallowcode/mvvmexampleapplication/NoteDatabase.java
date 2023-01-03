package com.shallowcode.mvvmexampleapplication;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Note.class}, version = 1)
public abstract class NoteDatabase extends RoomDatabase {

    private static NoteDatabase instance;

    /**
     * This is the DAO interface we created earlier
     * this is the abstract method that will be implemented by Room
     */
    public abstract NoteDao noteDao();


    /**
     * synchronized means only one thread can access this method at a time
     */
    public static synchronized NoteDatabase getInstance(Context context) {

        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), NoteDatabase.class, "note_table")
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return instance;
    }


}
