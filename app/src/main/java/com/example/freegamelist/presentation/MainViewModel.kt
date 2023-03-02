package com.example.freegamelist.presentation

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.freegamelist.data.retrofit.GameApi
import com.example.freegamelist.domain.GameBl
import com.example.freegamelist.domain.MapperGame
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel(application : Application) : AndroidViewModel(application) {


    private val _selected = MutableLiveData<List<GameBl>>()
    val selected: LiveData<List<GameBl>>
        get() = _selected


    fun fetchList(gameApi: GameApi?){
        gameApi?.let { gameApi ->
            val disposable =gameApi.getGamesList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        val listGameBl = MapperGame.mapListGameItemToListGameBl(it)
                        _selected.postValue(listGameBl)
                    },
                    {
                        Log.i("MyResult",it.toString())
                    })
            }

    }


    override fun onCleared() {
       // compositeDisposable.dispose()
        super.onCleared()
    }
}