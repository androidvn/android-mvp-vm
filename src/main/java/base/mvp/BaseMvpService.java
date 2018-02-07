package base.mvp;

import android.app.Service;
import android.content.Intent;
import android.databinding.ViewDataBinding;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.Toast;

public abstract class BaseMvpService <P extends BaseContract.Presenter, VM extends BaseContract.ViewModel, VDB extends ViewDataBinding> extends Service implements BaseContract.View<P, VM>  {

    protected P mPresenter;
    protected VM mViewModel;
    protected VDB mBinding;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void setPresenter(P presenter) {
        mPresenter = presenter;
    }

    @Override
    public void setViewModel(VM viewModel) {
        mViewModel = viewModel;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Started Overlay", Toast.LENGTH_SHORT).show();

        WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY,
                WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH,
                PixelFormat.TRANSLUCENT);
        setupParams(params);

        mBinding = inflateView((LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE));

        mBinding.setVariable(BR.presenter, mPresenter);
        mBinding.setVariable(BR.viewModel, mViewModel);

        WindowManager windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        windowManager.addView(mBinding.getRoot(), params);

        return START_STICKY;
    }

    protected void setupParams(WindowManager.LayoutParams params) {

    }

    protected abstract VDB inflateView(LayoutInflater layoutInflater);
}
