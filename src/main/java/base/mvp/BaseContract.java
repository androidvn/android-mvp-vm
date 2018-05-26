package base.mvp;

import android.databinding.Observable;

public interface BaseContract {

    interface View<P extends Presenter, VM extends ViewModel> {

        void setPresenter(P presenter);

        void setViewModel(VM viewModel);

    }

    interface Presenter {

        void start();

        void resume();

        void pause();

        void stop();

    }

    interface ViewModel extends Observable {

        void onPropertyChanged(int propertyId, Runnable action);
    }
}
