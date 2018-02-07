package base.mvp;

import android.app.Service;
import android.content.Intent;
import android.databinding.ViewDataBinding;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;

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
        int LAYOUT_FLAG;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            LAYOUT_FLAG = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
        } else {
            LAYOUT_FLAG = WindowManager.LayoutParams.TYPE_PHONE;
        }

        WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                LAYOUT_FLAG,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);
        setupParams(params);

        ViewGroup container = createContainer();

        mBinding = inflateView(
                (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE),
                container
        );
        mBinding.setVariable(base.mvp.BR.presenter, mPresenter);
        mBinding.setVariable(base.mvp.BR.viewModel, mViewModel);
        mBinding.executePendingBindings();

        WindowManager windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        windowManager.addView(mBinding.getRoot(), params);

        return START_STICKY;
    }

    public ViewGroup createContainer() {
        return new FrameLayout(this);
    }

    @Override
    public void onDestroy() {

        super.onDestroy();
    }

    protected void setupParams(WindowManager.LayoutParams params) {
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.gravity = Gravity.TOP;
    }

    protected abstract VDB inflateView(LayoutInflater layoutInflater, ViewGroup container);
}
