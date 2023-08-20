package com.ahmeturunveren.Deezefy.presentation.activity

import androidx.lifecycle.ViewModel
import com.ahmeturunveren.Deezefy.R
import com.ahmeturunveren.Deezefy.utils.constants.controller.BottomBarConstants.SELECT_CATEGORIES
import com.ahmeturunveren.Deezefy.utils.constants.controller.BottomBarConstants.SELECT_LIKES
import com.ahmeturunveren.Deezefy.utils.constants.utils.MusicConstants

class MainActivityVM : ViewModel() {

    fun resumeMusic() {
        MusicConstants.apply {
            mediaPlayer?.start()
            playingController.value = false
        }
    }

    fun pauseMusic() {
        MusicConstants.apply {
            mediaPlayer?.pause()
            playingController.value = true
        }
    }

    fun getCategoryIconPair(controller: Int): Pair<Int, Int> {
        return if (controller == SELECT_CATEGORIES)
            Pair(first = R.drawable.headset_f, second = R.color.nav_icon_f)
        else
            Pair(first = R.drawable.headset, second = R.color.nav_icon)
    }

    fun getLikeIconPair(controller: Int): Pair<Int, Int> {
        return if (controller == SELECT_LIKES)
            Pair(first = R.drawable.heart_f, second = R.color.nav_icon_f)
        else
            Pair(first = R.drawable.heart, second = R.color.nav_icon)
    }

    val getPlayingIcon: (Boolean) -> Int =
        { controller: Boolean -> if (controller) R.drawable.play else R.drawable.pause }

    val getMusicTitle: (String, String) -> String =
        { albumName: String, musicName: String -> "$albumName - $musicName" }

}