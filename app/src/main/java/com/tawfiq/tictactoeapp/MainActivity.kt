package com.tawfiq.tictactoeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    var flag = true
    private var status = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        status = intent.getStringExtra("multi")!!
    }

    fun buSelect(view: View) {
        val buselected = view as Button
        var cellID = 0

        when (buselected.id) {
            R.id.bu1 -> cellID = 1
            R.id.bu2 -> cellID = 2
            R.id.bu3 -> cellID = 3
            R.id.bu4 -> cellID = 4
            R.id.bu5 -> cellID = 5
            R.id.bu6 -> cellID = 6
            R.id.bu7 -> cellID = 7
            R.id.bu8 -> cellID = 8
            R.id.bu9 -> cellID = 9
        }
        if (flag) {
            playgame(cellID, buselected)
        }
    }

    var activeplayer = 1
    var player1cells = ArrayList<Int>()
    var player2cells = ArrayList<Int>()

    fun playgame(cellid: Int, buselected: Button) {

        if (activeplayer == 1) {

            buselected.text = "X"
            buselected.textSize = 40F
            buselected.setBackgroundResource(R.color.p1color)
            player1cells.add(cellid)
            activeplayer = 2
            if (status == "false")
                autoplay()

        } else {
            buselected.text = "O"
            buselected.textSize = 40F
            buselected.setBackgroundResource(R.color.p2color)
            player2cells.add(cellid)
            activeplayer = 1
        }
        buselected.isEnabled = false
        checkwinner()
    }

    fun checkwinner() {

        var winner = -1

        //Rows
        if (player1cells.contains(1) && player1cells.contains(2) && player1cells.contains(3)) {
            winner = 1
        }
        if (player2cells.contains(1) && player2cells.contains(2) && player2cells.contains(3)) {
            winner = 2
        }

        if (player1cells.contains(4) && player1cells.contains(5) && player1cells.contains(6)) {
            winner = 1
        }
        if (player2cells.contains(4) && player2cells.contains(5) && player2cells.contains(6)) {
            winner = 2
        }

        if (player1cells.contains(7) && player1cells.contains(8) && player1cells.contains(9)) {
            winner = 1
        }
        if (player2cells.contains(7) && player2cells.contains(8) && player2cells.contains(9)) {
            winner = 2
        }

        //Coloumn
        if (player1cells.contains(1) && player1cells.contains(4) && player1cells.contains(7)) {
            winner = 1
        }
        if (player2cells.contains(1) && player2cells.contains(4) && player2cells.contains(7)) {
            winner = 2
        }

        if (player1cells.contains(2) && player1cells.contains(5) && player1cells.contains(8)) {
            winner = 1
        }
        if (player2cells.contains(2) && player2cells.contains(5) && player2cells.contains(8)) {
            winner = 2
        }

        if (player1cells.contains(3) && player1cells.contains(6) && player1cells.contains(9)) {
            winner = 1
        }
        if (player2cells.contains(3) && player2cells.contains(6) && player2cells.contains(9)) {
            winner = 2
        }

        if (player1cells.contains(1) && player1cells.contains(5) && player1cells.contains(9)) {
            winner = 1
        }
        if (player2cells.contains(1) && player2cells.contains(5) && player2cells.contains(9)) {
            winner = 2
        }
        if (player1cells.contains(3) && player1cells.contains(5) && player1cells.contains(7)) {
            winner = 1
        }
        if (player2cells.contains(3) && player2cells.contains(5) && player2cells.contains(7)) {
            winner = 2
        }

        if (winner > 0)
            flag = false
        if (winner == 1) {
            p1winscount++
            Toast.makeText(this, "Player 1 wins", Toast.LENGTH_LONG).show()
            restartgame()
        } else if (winner == 2) {
            p2winscount++
            Toast.makeText(this, "Player 2 wins", Toast.LENGTH_LONG).show()
            restartgame()
        }

    }

    fun autoplay() {

        var emptycells = ArrayList<Int>()

        for (cell in 1..9) {
            if (!(player1cells.contains(cell) || player2cells.contains(cell))) {
                emptycells.add(cell)
            }
        }

        if (emptycells.size > 0) {
            val r = Random()
            val randomindex = r.nextInt(emptycells.size)
            val cellid = emptycells[randomindex]

            var buttonselected: Button?
            buttonselected = when (cellid) {
                1 -> bu1
                2 -> bu2
                3 -> bu3
                4 -> bu4
                5 -> bu5
                6 -> bu6
                7 -> bu7
                8 -> bu8
                9 -> bu9
                else -> {
                    bu1
                }
            }
            playgame(cellid, buttonselected)
        }
    }

    var p1winscount = 0
    var p2winscount = 0

    fun restartgame() {
        activeplayer = 1
        player1cells.clear()
        player2cells.clear()
        flag=true

        for (cellid in 1..9) {
            var buttonselected: Button?
            buttonselected = when (cellid) {
                1 -> bu1
                2 -> bu2
                3 -> bu3
                4 -> bu4
                5 -> bu5
                6 -> bu6
                7 -> bu7
                8 -> bu8
                9 -> bu9
                else -> {
                    bu1
                }
            }
            //Thread.sleep(1000)
            buttonselected!!.text = ""
            buttonselected!!.setBackgroundResource(R.color.bucolor)
            buttonselected!!.isEnabled = true
        }
        Toast.makeText(
            this,
            "Player 1 wins = $p1winscount   &   Player 2 wins = $p2winscount ",
            Toast.LENGTH_LONG
        ).show()

    }


}
