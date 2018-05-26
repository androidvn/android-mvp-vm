package base.mvp;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Observable;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseViewModel extends BaseObservable implements BaseContract.ViewModel {

    @NonNull
    protected final Context mContext;

    private Map<Integer, List<Runnable>> mOnChangeObservers = new HashMap<>();


    public BaseViewModel(@NonNull Context context) {
        mContext = context;
        addOnPropertyChangedCallback(new OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                if (mOnChangeObservers.containsKey(propertyId)) {
                    for (Runnable action : mOnChangeObservers.get(propertyId)) {
                        action.run();
                    }
                }
            }
        });
    }

    @Override
    public void onPropertyChanged(int propertyId, Runnable action) {
        if (mOnChangeObservers.containsKey(propertyId)) {
            mOnChangeObservers.get(propertyId).add(action);
        } else {
            List<Runnable> observers = new ArrayList<>();
            observers.add(action);
            mOnChangeObservers.put(propertyId, observers);
        }
    }
}
