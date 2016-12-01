package base.mvp;

import android.support.annotation.NonNull;

import base.domain.UseCaseExecutor;

public abstract class BaseCleanPresenter<V extends BaseContract.View, VM extends BaseContract.ViewModel> implements BaseContract.Presenter<V, VM> {

    @NonNull
    protected final V mView;
    @NonNull
    protected final VM mViewModel;
    @NonNull
    protected final UseCaseExecutor mUseCaseExecutor;

    protected BaseCleanPresenter(
            V view,
            VM viewModel,
            UseCaseExecutor useCaseExecutor) {
        mView = view;
        mViewModel = viewModel;
        mUseCaseExecutor = useCaseExecutor;
    }
}
