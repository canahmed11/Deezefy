package com.ahmeturunveren.Deezefy.presentation.music_categories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahmeturunveren.Deezefy.data.response.BeatifyResponse
import com.ahmeturunveren.Deezefy.domain.models.Genre
import com.ahmeturunveren.Deezefy.domain.remote.use_cases.AllGenresUseCase
import com.ahmeturunveren.Deezefy.utils.network.Connection
import com.ahmeturunveren.Deezefy.utils.network.NetworkConnection
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MusicCategoriesVM(
    networkConnection: NetworkConnection, private val allGenresUseCase: AllGenresUseCase
) : ViewModel() {
    private var _connObserver: Flow<Connection.Status>? = null

    private val connObserver: Flow<Connection.Status> get() = _connObserver!!

    private var _genres: MutableStateFlow<BeatifyResponse<List<Genre>>>? = null
    val genres: StateFlow<BeatifyResponse<List<Genre>>>
        get() = _genres!!.asStateFlow()

    private var allGenresJob: Job? = null

    init {
        _connObserver = networkConnection.observe()
        _genres = MutableStateFlow(value = BeatifyResponse.Loading())
    }

    suspend fun fetchData() {
        viewModelScope.launch(context = Dispatchers.Unconfined) {
            connObserver.collect {
                when (it) {
                    Connection.Status.Available -> allGenres()
                    Connection.Status.Losing -> _genres?.emit(value = BeatifyResponse.Loading())
                    Connection.Status.Unavailable, Connection.Status.Lost -> _genres?.emit(
                        value = BeatifyResponse.Failure(
                            code = 404
                        )
                    )
                }
            }
        }
    }

    private fun allGenres() {
        allGenresJob = viewModelScope.launch(context = Dispatchers.IO) {
            try {
                allGenresUseCase().also { genreList: List<Genre> ->
                    _genres?.emit(value = BeatifyResponse.Success(genreList, code = 200))
                }
            } catch (e: Exception) {
                _genres?.emit(value = BeatifyResponse.Failure(code = 404))
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        allGenresJob = null

        _connObserver = null
        _genres = null
    }

}