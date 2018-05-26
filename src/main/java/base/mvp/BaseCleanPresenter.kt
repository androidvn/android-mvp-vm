package base.mvp

import base.domain.UseCaseExecutor

abstract class BaseCleanPresenter<VM : BaseContract.ViewModel>(
        viewModel: VM,
        protected val mUseCaseExecutor: UseCaseExecutor) : BasePresenter<VM>(viewModel)
