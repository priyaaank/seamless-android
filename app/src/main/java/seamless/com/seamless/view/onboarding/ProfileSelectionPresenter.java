package seamless.com.seamless.view.onboarding;

import seamless.com.seamless.domain.settings.PreferencesStore;

public class ProfileSelectionPresenter {


	private static final String PROFILE_NAME = "profile_name";
	private ProfileSelectionView profileSelectionView;
	private PreferencesStore preferencesStore;
	private String profileName;

	public ProfileSelectionPresenter(ProfileSelectionView profileSelectionView, PreferencesStore preferencesStore) {
		this.profileSelectionView = profileSelectionView;
		this.preferencesStore = preferencesStore;
	}

	public void init() {
		validateProfileName();
	}

	public void changeStorage() {
		this.profileSelectionView.showStorageSelectionView();
	}

	public void finishOnBoarding() {
		this.profileSelectionView.finishOnBoarding();
	}

	public void profileNameUpdated(String profileName) {
		this.profileName = profileName;
		this.preferencesStore.add(PROFILE_NAME, this.profileName);
		validateProfileName();
	}

	private void validateProfileName() {
		boolean isValidInput = this.profileName != null && this.profileName.trim().length() > 0;
		profileSelectionView.toggleFinishButton(isValidInput);
	}

}
