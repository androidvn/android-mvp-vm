package base.mvp;

import android.support.annotation.NonNull;
import android.util.Log;

public abstract class BasePresenter<VM extends BaseContract.ViewModel> implements BaseContract.Presenter {

    private static final String TAG = BasePresenter.class.getSimpleName();
    @NonNull
    protected final VM mViewModel;

    protected BasePresenter(@NonNull VM viewModel) {
        mViewModel = viewModel;
    }

    @Override
    public void start() {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "started: " + this.getClass().getSimpleName() + "@" + this.hashCode());
        }
    }

    @Override
    public void resume() {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "resumed: " + this.getClass().getSimpleName() + "@" + this.hashCode());
        }
    }

    @Override
    public void pause() {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "paused: " + this.getClass().getSimpleName() + "@" + this.hashCode());
        }
    }

    @Override
    public void stop() {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "stopped: " + this.getClass().getSimpleName() + "@" + this.hashCode());
        }
    }
}
