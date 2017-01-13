package base.mvp;

import android.content.Context;
import android.databinding.BaseObservable;
import android.support.annotation.NonNull;

public class BaseViewModel extends BaseObservable implements BaseContract.ViewModel {

    @NonNull
    protected final Context mContext;


    public BaseViewModel(@NonNull Context context) {
        mContext = context;
    }
}
