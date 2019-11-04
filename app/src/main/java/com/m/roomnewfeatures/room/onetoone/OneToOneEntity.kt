package com.m.roomnewfeatures.room.onetoone

import androidx.room.*

//here one to one relation
//club has one player
@Entity(tableName = "Club")
data class ClubEntityOneToOneRelation(
    @PrimaryKey(autoGenerate = true)
    val clubID: Int = 0,
    val clubName: String,
    val clubNationality: String
)

@Entity(
    tableName = "Player",
    foreignKeys = [
        ForeignKey(
            entity = ClubEntityOneToOneRelation::class,
            parentColumns = ["clubID"],
            childColumns = ["clubPlayerID"]
        )
    ]
)
data class PlayerEntityOneToOneRelation(
    @PrimaryKey(autoGenerate = true)
    val playerID: Int = 0,
    val clubPlayerID: Int, //forging key
    val name: String
)

data class ClubPlayerOneToOneRelation(
    @Embedded
    val clubEntityOneToOneRelation: ClubEntityOneToOneRelation,
    @Relation(
        parentColumn = "clubID",
        entityColumn = "clubPlayerID"
    )
    val playerEntityOneToOneRelation: PlayerEntityOneToOneRelation
)

