package seamless.com.seamless.view.onboarding;

public class OnBoardingPresenter {

	private OnBoardingView view;

	public OnBoardingPresenter(final OnBoardingView view) {
		this.view = view;
	}

	public void onCreate() {
		this.view.setupToolbar();
		this.view.showStorageSelectionView();
	}

}
