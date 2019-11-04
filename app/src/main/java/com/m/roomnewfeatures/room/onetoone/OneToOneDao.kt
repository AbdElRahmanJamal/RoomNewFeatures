package com.m.roomnewfeatures.room.onetoone

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface OneToOneDao {

    @Query("SELECT * FROM Club")
    fun getClubPlayerOneToOneRelation(): List<ClubPlayerOneToOneRelation>

    @Insert
    fun insertClub(clubEntityOneToOneRelation: ClubEntityOneToOneRelation)

    @Insert
    fun insertPlayer(playerEntityOneToOneRelation: PlayerEntityOneToOneRelation)

}