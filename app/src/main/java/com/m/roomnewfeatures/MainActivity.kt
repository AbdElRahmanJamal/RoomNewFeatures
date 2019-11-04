package com.m.roomnewfeatures

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.m.roomnewfeatures.room.AppDatabase
import com.m.roomnewfeatures.room.manytomany.ClubEntityManyToManyRelation
import com.m.roomnewfeatures.room.manytomany.ClubsPlayers
import com.m.roomnewfeatures.room.manytomany.PlayerEntityManyToManyRelation
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val db = AppDatabase(this)

        GlobalScope.launch {
//            db.ManyToManyDao().insertClub(
//                ClubEntityManyToManyRelation(
//                    clubID = 2,
//                    clubName = "Liverpool",
//                    clubNationality = "England"
//                )
//            )
//            db.ManyToManyDao().insertPlayer(
//                PlayerEntityManyToManyRelation(
//                    playerID = 2,
//                    name = "Firmo"
//                )
//            )
//            db.ManyToManyDao().insertPlayersClubs(
//                ClubsPlayers(
//                    playerID = 2,
//                    clubID = 1
//                )
//            )
//            db.ManyToManyDao().insertPlayersClubs(
//                ClubsPlayers(
//                    playerID = 1,
//                    clubID = 2
//                )
//            )

            Log.d(
                "Data", db.ManyToManyDao().getClubPlayerManyToManyRelation()
                    .toString()
            )


        }

    }
}
