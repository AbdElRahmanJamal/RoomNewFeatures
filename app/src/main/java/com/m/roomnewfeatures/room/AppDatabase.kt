package com.m.roomnewfeatures.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.m.roomnewfeatures.room.manytomany.ClubEntityManyToManyRelation
import com.m.roomnewfeatures.room.manytomany.ClubsPlayers
import com.m.roomnewfeatures.room.manytomany.ManyToManyDao
import com.m.roomnewfeatures.room.manytomany.PlayerEntityManyToManyRelation

//here in case of one to one relation between club and player
//@Database(
//    entities = [ClubEntityOneToOneRelation::class, PlayerEntityOneToOneRelation::class],
//    version = 1
//)

//here in case of one to Many relation between club and player
//@Database(
//    entities = [ClubEntityOneToManyRelation::class, PlayerEntityOneToManyRelation::class],
//    version = 1
//)

//here in case of many to Many relation between club and player
@Database(
    entities = [ClubEntityManyToManyRelation::class, PlayerEntityManyToManyRelation::class, ClubsPlayers::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    //one to one relation
    // abstract fun OneToOneDao(): OneToOneDao

    //one to many relation
    // abstract fun OneToManyDao(): OneToManyDao

    //many to many relation
    abstract fun ManyToManyDao(): ManyToManyDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context, AppDatabase::class.java, "club_player.db")
                .allowMainThreadQueries()
                .build()
    }
}