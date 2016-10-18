package org.vincent.vctoolbar;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.framget_layout, container,false);
		TextView title = (TextView)view.findViewById(R.id.title);
		title.setText(getArguments().getString("param"));
		return view;
	}

}
