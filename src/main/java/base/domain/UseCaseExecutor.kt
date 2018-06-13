package base.domain

import android.util.Log
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UseCaseExecutor @Inject constructor() {

    fun <T> execute(
            useCase: UseCase<T>,
            onResult: (T) -> Unit = getResultLogger(useCase),
            onError: (Throwable) -> Unit = getErrorLogger(useCase),
            onCompleted: () -> Unit = getOnCompleteLogger(useCase),
            executorScheduler: Scheduler = Schedulers.computation(),
            callbackScheduler: Scheduler = AndroidSchedulers.mainThread()) {

        Observable.just(useCase)
                .map<T> { it.execute() }
                .subscribeOn(executorScheduler)
                .observeOn(callbackScheduler)
                .subscribe(onResult, onError, onCompleted)

    }

    private fun <T> getResultLogger(useCase: UseCase<T>): (T) -> Unit =
            { Log.d("USE-CASE", useCase.javaClass.simpleName + " - RESULT: " + it) }


    private fun <T> getErrorLogger(useCase: UseCase<T>): (Throwable) -> Unit =
            { Log.d("USE-CASE", useCase.javaClass.simpleName + " - ERROR: " + it.message) }


    private fun <T> getOnCompleteLogger(useCase: UseCase<T>): () -> Unit =
            { Log.d("USE-CASE", useCase.javaClass.simpleName + " - COMPLETED") }

}
