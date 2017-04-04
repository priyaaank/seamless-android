package seamless.com.seamless.view.onboarding;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import seamless.com.seamless.R;
import seamless.com.seamless.domain.settings.PreferencesStore;

public class StorageSelectionFragment extends Fragment implements StorageSelectionView {

	@BindView(R.id.selectProfileButton)
	Button selectProfileButton;
	@BindView(R.id.awsDetails)
	LinearLayout awsDetails;
	@BindView(R.id.accessSecretValue)
	EditText accessSecretValue;
	@BindView(R.id.accessKeyValue)
	EditText accessKeyValue;


	private StorageSelectionPresenter storageSelectionPresenter;

	public static StorageSelectionFragment getInstance() {
		return new StorageSelectionFragment();
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.select_storage_layout, container, false);
		ButterKnife.bind(this, view);
		this.storageSelectionPresenter = new StorageSelectionPresenter(this, new PreferencesStore(this.getActivity().getApplicationContext()));
		return view;
	}

	@OnClick(R.id.selectProfileButton)
	public void selectProfile() {
		this.storageSelectionPresenter.selectProfile();
	}

	@OnCheckedChanged(R.id.s3StorageRadio)
	public void awsSelected() {
		this.storageSelectionPresenter.awsSelected();
	}

	@OnTextChanged(R.id.accessKeyValue)
	public void accessKeyValueChanged() {
		this.storageSelectionPresenter.accessKeyValueChanged(this.accessKeyValue.getText().toString());
	}

	@OnTextChanged(R.id.accessSecretValue)
	public void accessSecretValueChanged() {
		this.storageSelectionPresenter.accessSecretValueChanged(this.accessSecretValue.getText().toString());
	}

	@Override
	public void showProfileSelectionView() {
		((OnBoardingView) getActivity()).showProfileSelectionView();
	}

	public void manageAwsDetailsVisibility(final Boolean isVisible) {
		this.awsDetails.setVisibility(isVisible ? View.VISIBLE : View.INVISIBLE);
	}

	public void toggleProfileSelectionButton(final Boolean isEnabled) {
		this.selectProfileButton.setEnabled(isEnabled);
	}
}
