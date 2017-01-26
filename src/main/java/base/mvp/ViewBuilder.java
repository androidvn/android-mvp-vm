package base.mvp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public abstract class ViewBuilder {

    public <P extends BaseContract.Presenter, VM extends BaseContract.ViewModel> void setup(
            @NonNull BaseContract.View<P, VM> view,
            @NonNull Context context,
            @Nullable Bundle saveInstanceState) {
        VM viewModel = createViewModel(view, context, saveInstanceState);
        view.setViewModel(viewModel);
        view.setPresenter(createPresenter(viewModel, context, saveInstanceState));
    }

    abstract protected <P extends BaseContract.Presenter, VM extends BaseContract.ViewModel> VM createViewModel(
            @NonNull BaseContract.View<P, VM> view,
            @NonNull Context context,
            @Nullable Bundle saveInstanceState);

    abstract protected <P extends BaseContract.Presenter, VM extends BaseContract.ViewModel> P createPresenter(
            @NonNull VM viewModel,
            @NonNull Context context,
            @Nullable Bundle saveInstanceState);
}
