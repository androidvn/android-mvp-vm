package base.mvp

import android.util.Log

abstract class BasePresenter<VM : BaseContract.ViewModel> (protected val mViewModel: VM) : BaseContract.Presenter {

    override fun start() {
        if (BuildConfig.DEBUG) {
            Log.d(this.javaClass.simpleName, "started: " + javaClass.simpleName + "@" + hashCode())
        }
    }

    override fun resume() {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "resumed: " + javaClass.simpleName + "@" + hashCode())
        }
    }

    override fun pause() {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "paused: " + javaClass.simpleName + "@" + hashCode())
        }
    }

    override fun stop() {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "stopped: " + this.javaClass.simpleName + "@" + hashCode())
        }
    }


        private val TAG = javaClass.simpleName
}
