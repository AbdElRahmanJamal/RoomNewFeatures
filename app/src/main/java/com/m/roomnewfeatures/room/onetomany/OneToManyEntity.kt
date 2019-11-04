package com.m.roomnewfeatures.room.onetomany

import androidx.room.*

//here one to many relation
//club has many player
@Entity(tableName = "Club")
data class ClubEntityOneToManyRelation(
    @PrimaryKey(autoGenerate = true)
    val clubID: Int = 0,
    val clubName: String,
    val clubNationality: String
)

@Entity(
    tableName = "Player",
    foreignKeys = [
        ForeignKey(
            entity = ClubEntityOneToManyRelation::class,
            parentColumns = ["clubID"],
            childColumns = ["clubPlayerID"]
        )
    ]
)
data class PlayerEntityOneToManyRelation(
    @PrimaryKey(autoGenerate = true)
    val playerID: Int = 0,
    val clubPlayerID: Int, //forging key
    val name: String
)

data class ClubPlayerOneToManyRelation(
    @Embedded
    val clubEntityOneToManyRelation: ClubEntityOneToManyRelation,
    @Relation(
        parentColumn = "clubID",
        entity = PlayerEntityOneToManyRelation::class,
        entityColumn = "clubPlayerID"
    )
    val playerEntityOneToManyRelation: List<PlayerEntityOneToManyRelation>
)

