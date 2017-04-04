package seamless.com.seamless.view.onboarding;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class OnBoardingPagerAdapter extends FragmentStatePagerAdapter {

	private final Integer pageCount;

	public OnBoardingPagerAdapter(FragmentManager fm, Integer pageCount) {
		super(fm);
		this.pageCount = pageCount;
	}

	@Override
	public Fragment getItem(int position) {
		return position == 0 ? StorageSelectionFragment.getInstance() : ProfileSelectionFragment.getInstance();
	}

	@Override
	public int getCount() {
		return this.pageCount;
	}

}
