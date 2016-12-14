package base.mvp;

import android.support.annotation.NonNull;

import base.domain.UseCaseExecutor;

public abstract class BaseCleanPresenter<V extends BaseContract.View, VM extends BaseContract.ViewModel> extends BasePresenter<V, VM> {

    @NonNull
    protected final UseCaseExecutor mUseCaseExecutor;

    protected BaseCleanPresenter(
            @NonNull V view,
            @NonNull VM viewModel,
            @NonNull UseCaseExecutor useCaseExecutor) {
        super(view, viewModel);
        mUseCaseExecutor = useCaseExecutor;
    }
}
