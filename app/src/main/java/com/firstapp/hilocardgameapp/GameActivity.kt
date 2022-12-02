package com.firstapp.hilocardgameapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class GameActivity : AppCompatActivity() {

    lateinit var scoreStreak: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_activity)

        val sharedPref = getSharedPreferences("game", Context.MODE_PRIVATE)
        val arrowsUpDown = findViewById<ImageView>(R.id.arrowUpDown)

        scoreStreak = findViewById<TextView>(R.id.scoreStreak)
        val highScoreText = findViewById<TextView>(R.id.highScoreText)


        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        //Back button to go back to main menu(activity 1)

        val button2 = findViewById<Button>(R.id.pointsButton)
        button2.setOnClickListener {
            val intent2 = Intent(this, PointsActivity::class.java)
            startActivity(intent2)
        }
        val higherButton = findViewById<Button>(R.id.higherButton)
        val lowerButton = findViewById<Button>(R.id.lowerButton)
        val startGameButton = findViewById<Button>(R.id.startGameButton)
        val nextPointsView=findViewById<TextView>(R.id.textView)
        var lastCard = 0
        var score = 0



        startGameButton.setOnClickListener {        // Start game function


            val drawCardValue=drawCard()
            lastCard=drawCardValue //my change
            if(drawCardValue==1)
            {
                lowerButton.text="Same"
                higherButton.text="Higher"
            }
            else if(drawCardValue==13)
            {
                lowerButton.text="Lower"
                higherButton.text="Same"
            }
            else{
                lowerButton.text="Lower\nor\nSame"
                higherButton.text="Higher\nor\nSame"
            }
            highScoreText.visibility = View.VISIBLE
            scoreStreak.visibility = View.VISIBLE
            higherButton.visibility = View.VISIBLE
            lowerButton.visibility = View.VISIBLE
            nextPointsView.visibility = View.VISIBLE
            arrowsUpDown.visibility = View.VISIBLE          // This is for the buttons to be invincible until you click start game
            startGameButton.visibility = View.INVISIBLE
            val temp=14-lastCard
            nextPointsView.text="Points:+$lastCard(H) or +$temp(L)"


        }

        higherButton.setOnClickListener {           // HigherButton function using a if statement, the current card is lower or equal to next one you will then get a point etc.. same with LowerButton.
            val newCard = drawCard()
            val temp=14-newCard
            nextPointsView.text="Points:+$newCard(H) or +$temp(L)"
            if(newCard==1)
            {
                lowerButton.text="Same"
                higherButton.text="Higher"
            }
            else if(newCard==13)
            {
                lowerButton.text="Lower"
                higherButton.text="Same"
            }
            else{
                lowerButton.text="Lower\nor\nSame"
                higherButton.text="Higher\nor\nSame"
            }
            if (lastCard <= newCard) {

                score+=lastCard
                val hiScore = sharedPref.getInt("hiscore", 0)
                if (score > hiScore) {
                    sharedPref.edit().apply {
                        this.putInt("hiscore", score)
                        commit()
                    }
                }
            } else {
                score = 0       // reset score to 0
            }
            lastCard = newCard
            scoreStreak.text = score.toString()
        }

        lowerButton.setOnClickListener {
            val newCard = drawCard()
            val temp=14-newCard
            nextPointsView.text="Points:+$newCard(H) or +$temp(L)"
            if(newCard==1)
            {
                lowerButton.text="Same"
                higherButton.text="Higher"
            }
            else if(newCard==13)
            {
                lowerButton.text="Lower"
                higherButton.text="Same"
            }
            else{
                lowerButton.text="Lower\nor\nSame"
                higherButton.text="Higher\nor\nSame"
            }
            if (lastCard >= newCard) {

                score+=(14-lastCard)
                val hiScore = sharedPref.getInt("hiscore", 0)
                if (score > hiScore) {
                    sharedPref.edit().apply {
                        this.putInt("hiscore", score)
                        commit()
                    }
                }
            } else {
                score = 0
            }
            lastCard = newCard
            scoreStreak.text = score.toString()
        }
    }

    private fun drawCard(): Int  {
        val random = (1..52).random()
        val showCard: ImageView =
            findViewById(R.id.cardBackSide)               // Random draw function for card deck
        when (random) {
            1 -> showCard.setImageResource(R.drawable.c1)
            2 -> showCard.setImageResource(R.drawable.c2)
            3 -> showCard.setImageResource(R.drawable.c3)
            4 -> showCard.setImageResource(R.drawable.c4)
            5 -> showCard.setImageResource(R.drawable.c5)
            6 -> showCard.setImageResource(R.drawable.c6)
            7 -> showCard.setImageResource(R.drawable.c7)
            8 -> showCard.setImageResource(R.drawable.c8)
            9 -> showCard.setImageResource(R.drawable.c9)
            10 -> showCard.setImageResource(R.drawable.c10)
            11 -> showCard.setImageResource(R.drawable.c11)
            12 -> showCard.setImageResource(R.drawable.c12)
            13 -> showCard.setImageResource(R.drawable.c13)
            14 -> showCard.setImageResource(R.drawable.c14)
            15 -> showCard.setImageResource(R.drawable.c15)
            16 -> showCard.setImageResource(R.drawable.c16)
            17 -> showCard.setImageResource(R.drawable.c17)
            18 -> showCard.setImageResource(R.drawable.c18)
            19 -> showCard.setImageResource(R.drawable.c19)
            20 -> showCard.setImageResource(R.drawable.c20)
            21 -> showCard.setImageResource(R.drawable.c21)
            22 -> showCard.setImageResource(R.drawable.c22)
            23 -> showCard.setImageResource(R.drawable.c23)
            24 -> showCard.setImageResource(R.drawable.c24)
            25 -> showCard.setImageResource(R.drawable.c25)
            26 -> showCard.setImageResource(R.drawable.c26)
            27 -> showCard.setImageResource(R.drawable.c27)
            28 -> showCard.setImageResource(R.drawable.c28)
            29 -> showCard.setImageResource(R.drawable.c29)
            30 -> showCard.setImageResource(R.drawable.c30)
            31 -> showCard.setImageResource(R.drawable.c31)
            32 -> showCard.setImageResource(R.drawable.c32)
            33 -> showCard.setImageResource(R.drawable.c33)
            34 -> showCard.setImageResource(R.drawable.c34)
            35 -> showCard.setImageResource(R.drawable.c35)
            36 -> showCard.setImageResource(R.drawable.c36)
            37 -> showCard.setImageResource(R.drawable.c37)
            38 -> showCard.setImageResource(R.drawable.c38)
            39 -> showCard.setImageResource(R.drawable.c39)
            40 -> showCard.setImageResource(R.drawable.c40)
            41 -> showCard.setImageResource(R.drawable.c41)
            42 -> showCard.setImageResource(R.drawable.c42)
            43 -> showCard.setImageResource(R.drawable.c43)
            44 -> showCard.setImageResource(R.drawable.c44)
            45 -> showCard.setImageResource(R.drawable.c45)
            46 -> showCard.setImageResource(R.drawable.c46)
            47 -> showCard.setImageResource(R.drawable.c47)
            48 -> showCard.setImageResource(R.drawable.c48)
            49 -> showCard.setImageResource(R.drawable.c49)
            50 -> showCard.setImageResource(R.drawable.c50)
            51 -> showCard.setImageResource(R.drawable.c51)
            52 -> showCard.setImageResource(R.drawable.c52)
        }
        if(random in 14..26)
        {
            return random-13
        }
        else if(random in 27..39)
        {
            return random-26
        }
        else if(random in 40..52)
        {
            return random-39
        }
        return random
    }
}
