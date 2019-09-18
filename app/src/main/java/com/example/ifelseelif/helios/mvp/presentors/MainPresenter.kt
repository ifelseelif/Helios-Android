package com.example.ifelseelif.helios.mvp.presentors

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.ifelseelif.helios.mvp.views.MainView
import java.util.*

@InjectViewState
class MainPresenter : MvpPresenter<MainView>() {

    private val stackBNM = Stack<Int>()

    fun selectItem(itemId: Int) {
        stackBNM.add(itemId)
    }

    fun changeBNM() {
        if(stackBNM.size == 1){
            viewState.closeApp()
            return
        }
        stackBNM.pop()
        viewState.selectOnBNM(stackBNM.pop())
    }
}