package seamless.com.seamless.view.onboarding;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import seamless.com.seamless.R;
import seamless.com.seamless.domain.settings.PreferencesStore;

public class ProfileSelectionFragment extends Fragment implements ProfileSelectionView {

	@BindView(R.id.profileNameText)
	EditText profileName;
	@BindView(R.id.finishOnBoardingButton)
	Button finishButton;

	public static ProfileSelectionFragment getInstance() {
		return new ProfileSelectionFragment();
	}

	private ProfileSelectionPresenter profileSelectionPresenter;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.select_profile_layout, container, false);
		ButterKnife.bind(this, view);
		this.profileSelectionPresenter = new ProfileSelectionPresenter(this, new PreferencesStore(this.getActivity().getApplicationContext()));
		this.profileSelectionPresenter.init();
		return view;
	}

	@OnClick(R.id.changeStorageButton)
	public void selectProfileHandler() {
		this.profileSelectionPresenter.changeStorage();
	}

	@OnClick(R.id.finishOnBoardingButton)
	public void finishOnBoardingHandler() {
		this.profileSelectionPresenter.finishOnBoarding();
	}

	@Override
	public void showStorageSelectionView() {
		((OnBoardingView) this.getActivity()).showStorageSelectionView();
	}

	@Override
	public void finishOnBoarding() {
		((OnBoardingView) this.getActivity()).finishOnBoarding();
	}

	@Override
	public void toggleFinishButton(boolean isEnabled) {
		this.finishButton.setEnabled(isEnabled);
	}

	@OnTextChanged(R.id.profileNameText)
	public void profileNameUpdated() {
		this.profileSelectionPresenter.profileNameUpdated(profileName.getText().toString());
	}

}
