package base.mvp;

import android.app.Fragment;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public abstract class BaseMvpFragment<P extends BaseContract.Presenter, VM extends BaseContract.ViewModel, VDB extends ViewDataBinding> extends Fragment implements BaseContract.View<P, VM> {

    protected P mPresenter;
    protected VM mViewModel;
    protected VDB mBinding;

    @Override
    public void setPresenter(P presenter) {
        mPresenter = presenter;
    }

    @Override
    public void setViewModel(VM viewModel) {
        mViewModel = viewModel;
    }

    protected abstract VDB inflateDataBinding(LayoutInflater inflater, ViewGroup container);

    @Override
    public android.view.View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = inflateDataBinding(inflater, container);
        return mBinding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        mBinding.setVariable(base.mvp.BR.presenter, mPresenter);
        mBinding.setVariable(base.mvp.BR.viewModel, mViewModel);

        mPresenter.start();
    }
}
