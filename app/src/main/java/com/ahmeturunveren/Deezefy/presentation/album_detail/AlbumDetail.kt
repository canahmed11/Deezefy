package com.ahmeturunveren.Deezefy.presentation.album_detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.unit.Dp
import com.ahmeturunveren.Deezefy.data.response.BeatifyResponse
import com.ahmeturunveren.Deezefy.domain.models.Track
import com.ahmeturunveren.Deezefy.presentation.FailureMusicCategories
import com.ahmeturunveren.Deezefy.presentation.LoadingPage

@Composable
fun AlbumDetail(
    viewModel: AlbumDetailVM,
    topPadding: Dp,
    bottomPadding: Dp,
    tfSearch: MutableState<String>,
    artistName: String,
    albumName: String,
    albumId: String
) {
    val tracks: State<BeatifyResponse<List<Track>>?> = viewModel.tracks.collectAsState()

    LaunchedEffect(key1 = Unit) {
        viewModel.fetchData(albumId = albumId.toInt())
    }

    when (tracks.value) {
        is BeatifyResponse.Success -> SuccessAlbumDetail(
            viewModel = viewModel,
            albumDetail = tracks.value,
            topPadding = topPadding,
            bottomPadding = bottomPadding,
            artistName = artistName,
            tfSearch = tfSearch,
            albumName = albumName
        )

        is BeatifyResponse.Failure -> FailureMusicCategories(
            topPadding = topPadding, bottomPadding = bottomPadding, code = tracks.value?.code
        )

        is BeatifyResponse.Loading -> LoadingPage(
            controller = 4,
            topPadding = topPadding,
            bottomPadding = bottomPadding,
            oddPaddingValues = null,
            evenPaddingValues = null
        )

        else -> FailureMusicCategories(
            topPadding = topPadding, bottomPadding = bottomPadding
        )
    }
}