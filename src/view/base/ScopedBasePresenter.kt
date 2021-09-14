package view.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

abstract class ScopedBasePresenter<T: BaseView>: BasePresenter<T> {

    val job = SupervisorJob()
    protected val uiScope = CoroutineScope(Dispatchers.Main + job)

}