package com.m.roomnewfeatures.room.onetomany

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.m.roomnewfeatures.room.onetoone.ClubEntityOneToOneRelation
import com.m.roomnewfeatures.room.onetoone.PlayerEntityOneToOneRelation

@Dao
interface OneToManyDao {

    @Query("SELECT * FROM Club")
    fun getClubPlayerOneToManyRelation(): List<ClubPlayerOneToManyRelation>

    @Insert
    fun insertClub(clubEntityOneToManyRelation: ClubEntityOneToManyRelation)

    @Insert
    fun insertPlayer(playerEntityOneToManyRelation: PlayerEntityOneToManyRelation)
}