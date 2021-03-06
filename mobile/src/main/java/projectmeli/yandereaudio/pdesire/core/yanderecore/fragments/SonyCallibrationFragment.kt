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
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import projectmeli.yandereaudio.pdesire.core.yanderecore.framework.os.YandereCommandHandler
import projectmeli.yandereaudio.pdesire.core.yanderecore.framework.app.YandereOutputWrapper
import projectmeli.yandereaudio.pdesire.R

class SonyCallibrationFragment : PreferenceFragment() {

    private val PREFS_NAME = "prefs"
    private val PREF_PDESIRE_CLEARAUDIO = "pdesire_clearaudio"
    private val PREF_TREBLE_CLEARAUDIO= "treble_clearaudio"
    private val PREF_BASS_CLEARAUDIO= "bass_clearaudio"
    private val PREF_PDESIRE_SSR = "pdesire_ssr"
    private val PREF_HTC_SSR = "htc_ssr"
    private val PREF_ADS = "ads"

    private lateinit var mInterstitialAd: InterstitialAd

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    override fun onCreate(savedInstanceState: Bundle?) {
        val mOutputWrapper : YandereOutputWrapper? = YandereOutputWrapper(activity)
        super.onCreate(savedInstanceState)

        addPreferencesFromResource(R.xml.pref_sony)
        setHasOptionsMenu(true)

        val preferences = activity.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val usePDesire = preferences.getBoolean(PREF_PDESIRE_CLEARAUDIO, false)
        val useBass = preferences.getBoolean(PREF_BASS_CLEARAUDIO, false)
        val useTreble = preferences.getBoolean(PREF_TREBLE_CLEARAUDIO, false)
        val usePDesireSSR = preferences.getBoolean(PREF_PDESIRE_SSR, false)
        val useHTC = preferences.getBoolean(PREF_HTC_SSR, false)
        val useAds = preferences.getBoolean(PREF_ADS, true)
        val editor = activity.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit()

        if (useAds) {
            mInterstitialAd = InterstitialAd(activity)
            mInterstitialAd.adUnitId = "ca-app-pub-6207390033733991/6525356424"
            mInterstitialAd.loadAd(AdRequest.Builder().build())
        }

        val treble = findPreference("treble_clearaudio_switch")
        val bass = findPreference("bass_clearaudio_switch")
        val pdesire = findPreference("pdesire_clearaudio_switch")
        val htc = findPreference("htc_ssr_switch")
        val pdesire_ssr = findPreference("pdesire_ssr_switch")

        if (usePDesireSSR)
            htc.isEnabled = false
        else if (useHTC)
            pdesire_ssr.isEnabled = false

        if (usePDesire) {
            treble.isEnabled = false
            bass.isEnabled = false
        } else if (useBass) {
            treble.isEnabled = false
            pdesire.isEnabled = false
        } else if (useTreble) {
            pdesire.isEnabled = false
            bass.isEnabled = false
        }

        treble.onPreferenceChangeListener = Preference.OnPreferenceChangeListener { preference, _ ->
            val switched = (preference as SwitchPreference)
                    .isChecked
            if (!switched) {
                YandereCommandHandler.copy( "/system/Yuno/Sony/ClearAudio/Treble", "effect_params.data","/system/etc/sony_effect")
                pdesire.isEnabled = false
                bass.isEnabled = false
                editor.putBoolean(PREF_TREBLE_CLEARAUDIO, true)
                editor.apply()
                mOutputWrapper!!.addNotification(getString(R.string.treble_clearaudio_enabled), getString(R.string.treble_clearaudio_enabled_description))
                if (mInterstitialAd.isLoaded && useAds) {
                    mInterstitialAd.show()
                }
            } else {
                setStock()
                pdesire.isEnabled = true
                bass.isEnabled = true
            }
            true
        }

        bass.onPreferenceChangeListener = Preference.OnPreferenceChangeListener { preference, _ ->
            val switched = (preference as SwitchPreference)
                    .isChecked
            if (!switched) {
                YandereCommandHandler.copy( "/system/Yuno/Sony/ClearAudio/Bass", "effect_params.data","/system/etc/sony_effect")
                treble.isEnabled = false
                pdesire.isEnabled = false
                editor.putBoolean(PREF_BASS_CLEARAUDIO, true)
                editor.apply()
                mOutputWrapper!!.addNotification(getString(R.string.bass_clearaudio_enabled), getString(R.string.bass_clearaudio_enabled_description))
                if (mInterstitialAd.isLoaded && useAds) {
                    mInterstitialAd.show()
                }
            } else {
                setStock()
                treble.isEnabled = true
                pdesire.isEnabled = true
            }
            true
        }

        pdesire.onPreferenceChangeListener = Preference.OnPreferenceChangeListener { preference, _ ->
            val switched = (preference as SwitchPreference)
                    .isChecked
            if (!switched) {
                YandereCommandHandler.copy("/system/Yuno/Sony/ClearAudio/PDesire", "effect_params.data","/system/etc/sony_effect")
                treble.isEnabled = false
                bass.isEnabled = false
                editor.putBoolean(PREF_PDESIRE_CLEARAUDIO, true)
                editor.apply()
                mOutputWrapper!!.addNotification(getString(R.string.pdesire_clearaudio_enabled), getString(R.string.pdesire_clearaudio_enabled_description))
                if (mInterstitialAd.isLoaded && useAds) {
                    mInterstitialAd.show()
                }
            } else {
                setStock()
                treble.isEnabled = true
                bass.isEnabled = true
            }
            true
        }

        htc.onPreferenceChangeListener = Preference.OnPreferenceChangeListener { preference, _ ->
            val switched = (preference as SwitchPreference)
                    .isChecked
            if (!switched) {
                YandereCommandHandler.copy("/system/Yuno/Sony/SSR/HTC", "surround_sound_rec_AZ.cfg", "/system/etc/surround_sound_3mic")
                pdesire.isEnabled = false
                editor.putBoolean(PREF_HTC_SSR, true)
                editor.apply()
                mOutputWrapper!!.addNotification(getString(R.string.htc_ssr_enabled), getString(R.string.htc_ssr_enabled_description))
            } else {
                setStockSSR()
                pdesire_ssr.isEnabled = true
            }
            true
        }

        pdesire_ssr.onPreferenceChangeListener = Preference.OnPreferenceChangeListener { preference, _ ->
            val switched = (preference as SwitchPreference)
                    .isChecked
            if (!switched) {
                YandereCommandHandler.copy("/system/Yuno/Sony/SSR/PDesire", "surround_sound_rec_AZ.cfg", "/system/etc/surround_sound_3mic")
                htc.isEnabled = false
                editor.putBoolean(PREF_PDESIRE_SSR, true)
                editor.apply()
                mOutputWrapper!!.addNotification(getString(R.string.pdesire_ssr_enabled), getString(R.string.pdesire_ssr_enabled_description))
            } else {
                setStockSSR()
                htc.isEnabled = true
            }
            true
        }
    }

    private fun setStockSSR() {
        YandereCommandHandler.copy("/system/Yuno/Sony/SSR/stock", "surround_sound_rec_AZ.cfg", "/system/etc/surround_sound_3mic")
        val editor = activity.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit()
        editor.putBoolean(PREF_HTC_SSR, false)
        editor.apply()
        editor.putBoolean(PREF_PDESIRE_SSR, false)
        editor.apply()
    }

    private fun setStock() {
        YandereCommandHandler.copy("/system/Yuno/Sony/ClearAudio/stock", "effect_params.data","/system/etc/sony_effect")
        val preferences = activity.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val useAds = preferences.getBoolean(PREF_ADS, true)
        val editor = activity.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit()
        editor.putBoolean(PREF_PDESIRE_CLEARAUDIO, false)
        editor.putBoolean(PREF_BASS_CLEARAUDIO, false)
        editor.putBoolean(PREF_TREBLE_CLEARAUDIO, false)
        editor.apply()
        if (mInterstitialAd.isLoaded && useAds) {
            mInterstitialAd.show()
        }
    }
}