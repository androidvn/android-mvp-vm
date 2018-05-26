package base.mvp;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public abstract class BaseMvpDialogFragment<P extends BaseContract.Presenter, VM extends BaseContract.ViewModel, VDB extends ViewDataBinding>
        extends DialogFragment
        implements BaseContract.View<P, VM> {

    protected P mPresenter;
    protected VM mViewModel;
    protected VDB mBinding;


    @Override
    public void onAttach(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // Perform injection here for M (API 23) due to deprecation of onAttach(Activity).
            AndroidSupportInjection.inject(this);
        }
        super.onAttach(context);
    }

    @Override
    @Inject
    public void setPresenter(P presenter) {
        mPresenter = presenter;
    }

    @Override
    @Inject
    public void setViewModel(VM viewModel) {
        mViewModel = viewModel;
    }

    @Override
    public android.view.View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = inflateDataBinding(inflater, container);
        mBinding.setVariable(base.mvp.BR.presenter, mPresenter);
        mBinding.setVariable(base.mvp.BR.viewModel, mViewModel);
        mBinding.executePendingBindings();
        return mBinding.getRoot();
    }

    protected abstract VDB inflateDataBinding(LayoutInflater inflater, ViewGroup container);

    @Override
    public void onStart() {
        super.onStart();
        mPresenter.start();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.pause();
    }

    @Override
    public void onStop() {
        super.onStop();
        mPresenter.stop();
    }

}
