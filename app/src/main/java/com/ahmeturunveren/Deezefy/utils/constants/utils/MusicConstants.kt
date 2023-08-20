package com.ahmeturunveren.Deezefy.utils.constants.utils

import android.media.MediaPlayer
import com.ahmeturunveren.Deezefy.data.models.Like
import com.ahmeturunveren.Deezefy.domain.models.PlayMusic
import com.ahmeturunveren.Deezefy.domain.models.Track
import kotlinx.coroutines.flow.MutableStateFlow

object MusicConstants {
    val trackingController: MutableStateFlow<Boolean> = MutableStateFlow(value = false)
    val playingController: MutableStateFlow<Boolean> = MutableStateFlow(value = false)
    var likeList: List<Like> = emptyList()
    var trackList: List<Track> = emptyList()
    var playMusic: PlayMusic? = null
    var mediaPlayer: MediaPlayer? = null
}