package view.base

//import android.os.Bundle

interface BaseView

interface BasePresenter<T : BaseView> {

    fun attach(view: T)
   // fun start(data: Bundle? = null)
    fun detach()

}