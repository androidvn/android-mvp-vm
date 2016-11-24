package base.mvp;

import android.databinding.Observable;

public interface BaseContract {

    interface View<P extends Presenter, VM extends ViewModel> {

        void closeScreen();

        void setPresenter(P presenter);

        void setViewModel(VM viewModel);

    }

    interface Presenter {

        void start();

    }

    interface ViewModel extends Observable {

        boolean isLoading();

    }
}
