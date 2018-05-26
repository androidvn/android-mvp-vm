package base.mvp

import android.content.Context
import android.databinding.BaseObservable
import android.databinding.Observable
import android.util.SparseArray
import java.util.*

open class BaseViewModel(protected val mContext: Context) : BaseObservable(), BaseContract.ViewModel {

    private val mOnChangeObservers = SparseArray<MutableList<() -> Unit>>()


    init {
        addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable, propertyId: Int) {

                if (mOnChangeObservers[propertyId] != null) {
                    mOnChangeObservers[propertyId].forEach { it.invoke() }
                }
            }
        })
    }

    override fun onPropertyChanged(propertyId: Int, action: () -> Unit) {
        if (mOnChangeObservers[propertyId] != null) {
            mOnChangeObservers[propertyId].add(action)
        } else {
            val observers = ArrayList<() -> Unit>()
            observers.add(action)
            mOnChangeObservers.put(propertyId, observers)
        }
    }
}
