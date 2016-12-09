package base.mvp;

import android.support.annotation.NonNull;
import android.util.Log;

import base.domain.*;
import base.domain.BuildConfig;

public abstract class BaseCleanPresenter<V extends BaseContract.View, VM extends BaseContract.ViewModel> implements BaseContract.Presenter<V, VM> {

    private static final String TAG = BaseCleanPresenter.class.getSimpleName();
    @NonNull
    protected final V mView;
    @NonNull
    protected final VM mViewModel;
    @NonNull
    protected final UseCaseExecutor mUseCaseExecutor;

    protected BaseCleanPresenter(
            @NonNull V view,
            @NonNull VM viewModel,
            @NonNull UseCaseExecutor useCaseExecutor) {
        mView = view;
        mViewModel = viewModel;
        mUseCaseExecutor = useCaseExecutor;
    }

    @Override
    public void start() {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "started: " + this.getClass().getSimpleName());
        }
    }

    @Override
    public void resume() {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "resumed: " + this.getClass().getSimpleName());
        }
    }

    @Override
    public void pause() {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "paused: " + this.getClass().getSimpleName());
        }
    }

    @Override
    public void stop() {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "stopped: " + this.getClass().getSimpleName());
        }
    }
}
