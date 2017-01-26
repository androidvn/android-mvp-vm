package base.mvp;

import android.support.annotation.NonNull;

import base.domain.UseCaseExecutor;

public abstract class BaseCleanPresenter<VM extends BaseContract.ViewModel> extends BasePresenter<VM> {

    @NonNull
    protected final UseCaseExecutor mUseCaseExecutor;

    protected BaseCleanPresenter(
            @NonNull VM viewModel,
            @NonNull UseCaseExecutor useCaseExecutor) {
        super(viewModel);
        mUseCaseExecutor = useCaseExecutor;
    }
}
