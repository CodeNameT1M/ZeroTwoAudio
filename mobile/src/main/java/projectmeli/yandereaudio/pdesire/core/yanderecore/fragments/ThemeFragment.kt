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

package projectmeli.yandereaudio.pdesire.core.yanderecore.fragments

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.preference.Preference
import android.preference.PreferenceFragment
import android.preference.SwitchPreference
import projectmeli.yandereaudio.pdesire.R

class ThemeFragment : PreferenceFragment() {

    private val PREFS_NAME = "prefs"
    private val PREF_FONT = "font"


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        addPreferencesFromResource(R.xml.pref_theme)
        setHasOptionsMenu(true)

        val font = findPreference("font_switch")

        font.onPreferenceChangeListener = Preference.OnPreferenceChangeListener { preference, _ ->
            val switched = (preference as SwitchPreference)
                    .isChecked
            if (!switched) {
                val editor = activity.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit()
                editor.putBoolean(PREF_FONT, true)
                editor.apply()
            } else {
                val editor = activity.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit()
                editor.putBoolean(PREF_FONT, false)
                editor.apply()
            }
            true
        }
    }
}