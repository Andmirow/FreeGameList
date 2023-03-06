package com.example.freegamelist.presentation

import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.freegamelist.data.retrofit.Platform
import com.example.freegamelist.data.retrofit.Tag
import com.example.freegamelist.domain.GameBl
import com.example.freegamelist.domain.GameRepository
import com.example.freegamelist.domain.GamesInterface
import com.example.freegamelist.presentation.tools.SelectionState
import com.example.freegamelist.presentation.tools.Selections
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val gamesRepository: GameRepository
) : ViewModel() {

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


    //private val selections = Selections()
    private val scope = CoroutineScope(Dispatchers.IO)



    private val _selected = MutableLiveData<List<GameBl>>()
    val selected: LiveData<List<GameBl>>
        get() = _selected






    fun getList(){
        scope.launch{
            val games =  gamesRepository.getGames(platform.toString())
            selected.value = games.
        }
    }






//    val gamesFlow = tagLiveData.asFlow()
//        .distinctUntilChanged()
//        .flatMapLatest {
//            gamesRepository.getGames(it.toString())
//        }
//        .cachedIn(viewModelScope)
//
//
//    val gamesListFlow = combine(
//        gamesFlow,
//        selections.flow(),
//        ::merge
//    )
//
//    private fun merge(
//        pagingData: PagingData<GamesInterface>,
//        selections: SelectionState
//    ): PagingData<GameBl> {
//        return pagingData.map { GamesInterface ->
//            GameBl(
//                game = GamesInterface,
//                notes = "",
//                isFavorite = selections.isFavorite(GamesInterface.idRetrofit)
//            )
//        }
//    }

    override fun onCleared() {
        super.onCleared()
        scope.cancel()
    }


    private companion object {
        const val KEY_PLATFORM = "KEY_PLATFORM"
        const val KEY_TAG = "KEY_TAG"
    }
}