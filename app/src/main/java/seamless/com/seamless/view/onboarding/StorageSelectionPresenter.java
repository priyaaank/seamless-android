package seamless.com.seamless.view.onboarding;

import seamless.com.seamless.domain.settings.PreferencesStore;

public class StorageSelectionPresenter {

	private static String AWS_KEY = "aws_access_key";
	private static String AWS_SECRET = "aws_access_secret";
	private StorageSelectionView storageSelectionView;
	private PreferencesStore preferencesStore;
	private String keyValue;
	private String secretValue;
	private StorageType selectedStorage;

	public StorageSelectionPresenter(StorageSelectionView storageSelectionView, PreferencesStore preferencesStore) {
		this.storageSelectionView = storageSelectionView;
		this.preferencesStore = preferencesStore;
	}

	public void selectProfile() {
		this.storageSelectionView.showProfileSelectionView();
	}

	public void awsSelected() {
		this.selectedStorage = StorageType.AWS;
		this.storageSelectionView.manageAwsDetailsVisibility(Boolean.TRUE);
	}

	public void accessKeyValueChanged(String newValue) {
		keyValue = newValue;
		this.preferencesStore.add(AWS_KEY, newValue);
		validateMandatoryFields();
	}

	public void accessSecretValueChanged(String newValue) {
		secretValue = newValue;
		this.preferencesStore.add(AWS_SECRET, newValue);
		validateMandatoryFields();
	}

	private void validateMandatoryFields() {
		if(selectedStorage.equals(StorageType.AWS)) {
			boolean enableProfileSelection = (keyValue != null && keyValue.trim().length() > 0 &&
					secretValue != null && secretValue.trim().length() > 0);
			this.storageSelectionView.toggleProfileSelectionButton(enableProfileSelection);
		}
	}
}
