package com.benson.multiedittextview;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MultiEditTextView extends LinearLayout {

	private int mFriendCount;
	private int mEditTextResId;

	public MultiEditTextView(Context context) {
		super(context);
	}

	public MultiEditTextView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);

	}

	@SuppressLint("NewApi")
	public MultiEditTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		setOrientation(VERTICAL);

	}

	public int getmEditTextResId() {
		return mEditTextResId;
	}

	public void setmEditTextResId(int mEditTextResId) {
		this.mEditTextResId = mEditTextResId;
	}

	public int getFriendCount() {
		return mFriendCount;
	}

	public void setFriendCount(int friendCount) {
		if (friendCount != mFriendCount) {
			mFriendCount = friendCount;
			removeAllViews();
			for (int i = 0; i < friendCount; i++) {
				addView(createEditText());
			}
		}
	}

	public void removeView() {
		if (getChildCount() != 0) {
			removeViewAt(getChildCount() - 1);
		}
	}

	public void addView() {

		addView(createEditText());

	}

	private View createEditText() {
		View v;
		if (mEditTextResId > 0) {
			LayoutInflater inflater = LayoutInflater.from(getContext());
			v = inflater.inflate(mEditTextResId, this, true);
		} else {
			EditText et = new EditText(getContext());
			et.setHint("好友信息");
			v = et;
		}
		return v;

	}

	public List<String> getFriendNames() {

		List<String> names = new ArrayList<String>();
		for (int i = 0; i < getChildCount(); i++) {
			View v = getChildAt(i);
			if (v instanceof EditText) {
				names.add(((EditText) v).getText().toString());
			}

		}
		return names;
	}

}
