package seamless.com.seamless.view.onboarding;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import seamless.com.seamless.R;
import seamless.com.seamless.view.HomeActivity;

public class OnboardingActivity extends AppCompatActivity implements OnBoardingView {

	private OnBoardingPresenter onBoardingPresenter;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.onboarding_layout);
		this.onBoardingPresenter = new OnBoardingPresenter(this);
		this.onBoardingPresenter.onCreate();
	}

	@Override
	public void setupToolbar() {
		Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
		setSupportActionBar(myToolbar);
	}

	@Override
	public void showStorageSelectionView() {
		StorageSelectionFragment storageSelectionFragment = StorageSelectionFragment.getInstance();
		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		fragmentTransaction.add(R.id.onboarding_fragment_container, storageSelectionFragment, "SelectStorage");
		fragmentTransaction.commit();
	}

	@Override
	public void showProfileSelectionView() {
		ProfileSelectionFragment profileSelectionFragment = ProfileSelectionFragment.getInstance();
		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		fragmentTransaction.replace(R.id.onboarding_fragment_container, profileSelectionFragment, "SelectProfile");
		fragmentTransaction.commit();
	}

	@Override
	public void finishOnBoarding() {
		Intent homeActivity = new Intent(this, HomeActivity.class);
		startActivity(homeActivity);
	}

}
