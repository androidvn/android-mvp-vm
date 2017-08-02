package base.mvp;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public abstract class BaseMvpLayout<P, VM extends BaseContract.ViewModel, VDB extends ViewDataBinding> {

    protected P mPresenter;
    protected VM mViewModel;
    protected VDB mBinding;

    public BaseMvpLayout(Context context) {
        mBinding = inflateDataBinding(LayoutInflater.from(context), null);
    }

    public void setup(P presenter, VM viewModel) {
        mPresenter = presenter;
        mViewModel = viewModel;

        mBinding.setVariable(BR.presenter, this.mPresenter);
        mBinding.setVariable(BR.viewModel, this.mViewModel);
        mBinding.executePendingBindings();
    }

    protected abstract VDB inflateDataBinding(LayoutInflater inflater, ViewGroup container);
}
