package projectmeli.yandereaudio.pdesire

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.widget.TextView

class SocialActivity : Activity() {

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

        setContentView(R.layout.social_main)
        window.decorView.setBackgroundColor(Color.WHITE)

        if (getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).getBoolean(PREF_FONT, false)) {
            val font = Typeface.createFromAsset(assets, "fonts/Oxygen-Regular.ttf")
            val title_big = findViewById<TextView>(R.id.title_big)
            title_big.typeface = font
        }
    }
}