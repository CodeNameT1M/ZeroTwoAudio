/*
 * Copyright (C) 2017-2018 Tristan Marsell, All rights reserved.
 *
 * This code is licensed under the BSD-3-Clause License
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY
 * AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package projectmeli.yandereaudio.pdesire.core.yanderecore.activities

/**
 * Created by PDesire on 20.05.2017.
 */

import android.content.Context
import android.os.Bundle
import android.preference.PreferenceActivity
import projectmeli.yandereaudio.pdesire.core.pdesirecore.activityimplementation.PDesirePreferenceActivity
import projectmeli.yandereaudio.pdesire.core.yanderecore.fragments.AudioSettingsFragment

import projectmeli.yandereaudio.pdesire.R

/**
 * A [PreferenceActivity] that presents a set of application settings. On
 * handset devices, settings are presented as a single list. On tablets,
 * settings are split by category, with category headers shown to the left of
 * the list of settings.
 *
 *
 * See [
   * Android Design: Settings](http://developer.android.com/design/patterns/settings.html) for design guidelines and the [Settings
   * API Guide](http://developer.android.com/guide/topics/ui/settings.html) for more information on developing a Settings UI.
 */
class AudioSettingsActivity : PDesirePreferenceActivity() {

    private val PREFS_NAME = "prefs"
    private val PREF_NEW_THEME = "new_theme"

    override fun onCreate(savedInstanceState: Bundle?) {
        // Use the chosen theme
        val useNewTheme = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
                            .getBoolean(PREF_NEW_THEME, false)

        if (useNewTheme) {
            setTheme(R.style.AppTheme_New)
        }

        super.onCreate(savedInstanceState)

        fragmentManager.beginTransaction().add(android.R.id.content, AudioSettingsFragment()).commit()
    }

    public override fun onStart() {
        super.onStart()// ATTENTION: This was auto-generated to implement the App Indexing API.
    }

    public override fun onStop() {
        super.onStop()// ATTENTION: This was auto-generated to implement the App Indexing API.
    }
}
