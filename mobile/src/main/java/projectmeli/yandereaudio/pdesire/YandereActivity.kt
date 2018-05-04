package projectmeli.yandereaudio.pdesire

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.net.Uri
import android.os.Bundle
import android.support.v7.widget.CardView
import android.widget.TextView
import projectmeli.yandereaudio.pdesire.core.yanderecore.activities.AudioSettingsActivity
import projectmeli.yandereaudio.pdesire.core.yanderecore.activities.EngineActivity

class YandereActivity : Activity() {

    private val PREFS_NAME = "prefs"
    private val PREF_NEW_THEME = "new_theme"
    private val PREF_FONT = "font"

    override fun onCreate(savedInstanceState: Bundle?) {
        val useNewTheme = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
                .getBoolean(PREF_NEW_THEME, false)

        if (useNewTheme) {
            setTheme(R.style.AppTheme_New)
        }

        super.onCreate(savedInstanceState)

        setContentView(R.layout.yandere_main)
        window.decorView.setBackgroundColor(Color.WHITE)

        if (getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).getBoolean(PREF_FONT, false)) {
            val font = Typeface.createFromAsset(assets, "fonts/Oxygen-Regular.ttf")
            val title_big = findViewById<TextView>(R.id.title_big)
            title_big.typeface = font
        }

        val cardview_intro = findViewById<CardView>(R.id.intro)
        val cardview_secd = findViewById<CardView>(R.id.secd)

        cardview_intro.setOnClickListener {
            val intent = Intent(applicationContext, AudioSettingsActivity::class.java)
            startActivity(intent)
        }

        cardview_secd.setOnClickListener {
            val intent = Intent(applicationContext, EngineActivity::class.java)
            startActivity(intent)
        }
    }
}