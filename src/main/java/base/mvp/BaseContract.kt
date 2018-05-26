package base.mvp

import android.databinding.Observable

interface BaseContract {

    interface Presenter {

        fun start()

        fun resume()

        fun pause()

        fun stop()

    }

    interface ViewModel : Observable {

        fun onPropertyChanged(propertyId: Int, action: () -> Unit)
    }
}
