package com.m.roomnewfeatures.room.manytomany

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ManyToManyDao {

    @Query("SELECT * FROM Club")
    fun getClubPlayerManyToManyRelation(): List<ClubPlayerManyToManyRelation>

    @Insert
    fun insertClub(clubEntityManyToManyRelation: ClubEntityManyToManyRelation)

    @Insert
    fun insertPlayer(playerEntityManyToManyRelation: PlayerEntityManyToManyRelation)

    @Insert
    fun insertPlayersClubs(clubsPlayers: ClubsPlayers)
}