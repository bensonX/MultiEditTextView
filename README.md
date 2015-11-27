# MultiEditTextView
##Android自定义复合视图,动态增加View

`<public List<String> getFriendNames() {

		List<String> names = new ArrayList<String>();
		for (int i = 0; i < getChildCount(); i++) {
			View v = getChildAt(i);
			if (v instanceof EditText) {
				names.add(((EditText) v).getText().toString());
			}

		}
		return names;
	}
>`	


