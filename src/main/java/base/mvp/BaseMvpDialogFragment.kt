package base.mvp

import android.content.Context
import android.databinding.ViewDataBinding
import android.os.Build
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.ViewGroup
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

abstract class BaseMvpDialogFragment<P : BaseContract.Presenter, VM : BaseContract.ViewModel, VDB : ViewDataBinding> : DialogFragment() {

    @Inject
    protected lateinit var presenter: P
    @Inject
    protected lateinit var viewModel: VM
    protected var binding: VDB? = null


    override fun onAttach(context: Context?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // Perform injection here for M (API 23) due to deprecation of onAttach(Activity).
            AndroidSupportInjection.inject(this)
        }
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): android.view.View? {
        binding = inflateDataBinding(inflater, container)
        binding?.setVariable(base.mvp.BR.presenter, presenter)
        binding?.setVariable(base.mvp.BR.viewModel, viewModel)
        binding?.executePendingBindings()
        return binding?.root
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

    protected abstract fun inflateDataBinding(inflater: LayoutInflater, container: ViewGroup?): VDB

    override fun onStart() {
        super.onStart()
        presenter.start()
    }

    override fun onResume() {
        super.onResume()
        presenter.resume()
    }

    override fun onPause() {
        super.onPause()
        presenter.pause()
    }

    override fun onStop() {
        super.onStop()
        presenter.stop()
    }

}
