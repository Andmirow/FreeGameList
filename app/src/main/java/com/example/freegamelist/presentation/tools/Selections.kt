package com.example.freegamelist.presentation.tools

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map

class Selections : SelectionState {

    private val checkedIds = mutableSetOf<Int>()
    private val checkedIdsFlow = MutableStateFlow(OnChange(checkedIds))


    fun flow(): Flow<SelectionState> = checkedIdsFlow.map { this }

    override fun isFavorite(id: Int)= checkedIds.contains(id)

    fun toggle(id: Int) {
        if (checkedIds.contains(id)) {
            checkedIds.remove(id)
        } else {
            checkedIds.add(id)
        }
        checkedIdsFlow.value = OnChange(checkedIds)
    }

}


class OnChange<T>(
    val value: T
)