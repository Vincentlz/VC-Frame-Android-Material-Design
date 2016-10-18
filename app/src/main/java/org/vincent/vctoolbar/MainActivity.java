package org.vincent.vctoolbar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
	private DrawerLayout mDrawerLayout;
	private ActionBarDrawerToggle mDrawerToggle;
	private PagerSlidingTabStrip tabs;
	private ViewPager pager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
        Toolbar boolBar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
		boolBar.setTitle("VC框架");
		setSupportActionBar(boolBar);
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, boolBar,R.string.drawer_open, R.string.drawer_close);
		mDrawerToggle.syncState();
		mDrawerLayout.setDrawerListener(mDrawerToggle);
		
		
		tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
		pager = (ViewPager) findViewById(R.id.pager);
		MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
		pager.setAdapter(adapter);
		tabs.setViewPager(pager);
		setTabValue();
	}

	public void setTabValue(){
		tabs.setSelectedTextColor(getResources().getColor(R.color.tab_text_color_selected));
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	public class MyPagerAdapter extends FragmentPagerAdapter {
		private final String[] TITLES = { "Java", "Andorid", "IOS", "HTML5"};
		List<MyFragment> fragments = new ArrayList<MyFragment>();
		public MyPagerAdapter(FragmentManager fm) {
			super(fm);
			for(String title:TITLES){
				MyFragment fragment = new MyFragment();
				Bundle args =new Bundle();
				args.putString("param", title);
				fragment.setArguments(args);
				fragments.add(fragment);
			}
		}
		@Override
		public CharSequence getPageTitle(int position) {
			return TITLES[position];
		}
		@Override
		public int getCount() {
			return TITLES.length;
		}
		@Override
		public Fragment getItem(int position) {
			return fragments.get(position);
		}
	}
}
