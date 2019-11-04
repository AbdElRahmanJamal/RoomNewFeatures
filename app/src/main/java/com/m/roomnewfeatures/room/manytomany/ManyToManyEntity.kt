package com.m.roomnewfeatures.room.manytomany

import androidx.room.*

//here many to many relation
//club has many player and player has many clubs
@Entity(tableName = "Club")
data class ClubEntityManyToManyRelation(
    @PrimaryKey(autoGenerate = true)
    val clubID: Int = 0,
    val clubName: String,
    val clubNationality: String
)

@Entity(tableName = "Player")
data class PlayerEntityManyToManyRelation(
    @PrimaryKey(autoGenerate = true)
    val playerID: Int = 0,
    val name: String
)

//bcs of many to many relation
@Entity(
    primaryKeys = ["clubID", "playerID"]
)
data class ClubsPlayers(
    val playerID: Int ,
    val clubID: Int
)

data class ClubPlayerManyToManyRelation(
    @Embedded
    val clubEntityManyToManyRelation: ClubEntityManyToManyRelation,
    @Relation(
        parentColumn = "clubID",
        entity = PlayerEntityManyToManyRelation::class,
        entityColumn = "playerID",
        associateBy = Junction(ClubsPlayers::class)
    )
    val playerEntityManyToManyRelation: List<PlayerEntityManyToManyRelation>
)

