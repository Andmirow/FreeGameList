package com.example.freegamelist.presentation

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.freegamelist.data.retrofit.GameApi
import com.example.freegamelist.data.retrofit.Platform
import com.example.freegamelist.data.retrofit.Tag
import com.example.freegamelist.domain.GameBl
import com.example.freegamelist.domain.GameRepository
import com.example.freegamelist.domain.GamesInterface
import com.example.freegamelist.domain.MapperGame
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

class MainViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val gamesRepository: GameRepository
) : ViewModel() {


    private val _selected = MutableLiveData<List<GameBl>>()
    val selected: LiveData<List<GameBl>>
        get() = _selected


    private val platformLiveData = savedStateHandle.getLiveData(KEY_PLATFORM, Platform.all)
    private val tagLiveData = savedStateHandle.getLiveData(KEY_TAG, Tag.all)


    var platform: Platform?
        get() = platformLiveData.value
        set(value) {
            platformLiveData.value = value
        }

    var tag: Tag?
        get() = tagLiveData.value
        set(value) {
            tagLiveData.value = value
        }



    val launchesFlow = tagLiveData.asFlow()
        .distinctUntilChanged()
        .flatMapLatest {
            gamesRepository.getGames(it.toString())
        }
        .cachedIn(viewModelScope)






    private companion object {
        const val KEY_PLATFORM = "KEY_PLATFORM"
        const val KEY_TAG = "KEY_TAG"
    }
}