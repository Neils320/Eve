/*
 * Create by BobEve on 17-12-20 下午8:31
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-20 下午8:31
 */

package bob.eve.walle.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.View;
import bob.eve.walle.ui.activity.EveWebActivity;
import bob.eve.walle.ui.activity.ImageDetailActivity;

/**
 * Created by Bob on 17/12/20.
 */

public class Navigation {
	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {

		private String title;
		private String url;
		private String imgUrl;
		private String id;
		private String category;
		private View shareView;
		private Context mContext;
		private Activity mActivity;

		public Builder builder() {
			return this;
		}

		public Builder setContext(Context mContext) {
			this.mContext = mContext;
			return this;
		}

		public Builder setTitle(String title) {
			this.title = title;
			return this;
		}

		public Builder setUrl(String url) {
			this.url = url;
			return this;
		}

		public Builder setImgUrl(String imgUrl) {
			this.imgUrl = imgUrl;
			return this;
		}

		public Builder setId(String id) {
			this.id = id;
			return this;
		}

		public Builder setCategorye(String category) {
			this.category = category;
			return this;
		}

		public Builder setAnimConfig(Activity mActivity, View shareView) {
			this.mActivity = mActivity;
			this.shareView = shareView;
			return this;
		}
	}

	public static void navToEveWeb(Builder builder) {
		Intent intent = new Intent();
		intent.setClass(builder.mContext, EveWebActivity.class);
		intent.putExtra(EveWebActivity.INTENT_IT_CICLE_DETAIL_URL, builder.url);
		intent.putExtra(EveWebActivity.INTENT_IT_CICLE_DETAIL_IMG_URL, builder.imgUrl);
		intent.putExtra(EveWebActivity.INTENT_IT_CICLE_DETAIL_TITLE, builder.title);
		intent.putExtra(EveWebActivity.INTENT_IT_CICLE_DETAIL_ID, builder.id);
		intent.putExtra(EveWebActivity.INTENT_IT_CICLE_DETAIL_CATEGORY, builder.category);
		//		ActivityOptionsCompat options = ActivityOptionsCompat.makeCustomAnimation(builder.mContext,
		//																																							R.anim.dock_bottom_enter,
		//																																							R.anim.dock_bottom_exit);
		ActivityOptionsCompat options =
				ActivityOptionsCompat.makeSceneTransitionAnimation(builder.mActivity, builder.shareView,
																													 "shareView");
		ActivityCompat.startActivity(builder.mActivity, intent, options.toBundle());
	}

	public static void navToImageDetail(Builder builder) {
		Intent intent = new Intent();
		intent.setClass(builder.mContext, ImageDetailActivity.class);
		intent.putExtra(EveWebActivity.INTENT_IT_CICLE_DETAIL_URL, builder.url);
		intent.putExtra(EveWebActivity.INTENT_IT_CICLE_DETAIL_IMG_URL, builder.imgUrl);
		intent.putExtra(EveWebActivity.INTENT_IT_CICLE_DETAIL_TITLE, builder.title);
		intent.putExtra(EveWebActivity.INTENT_IT_CICLE_DETAIL_ID, builder.id);
		intent.putExtra(EveWebActivity.INTENT_IT_CICLE_DETAIL_CATEGORY, builder.category);
		ActivityOptionsCompat options =
				ActivityOptionsCompat.makeSceneTransitionAnimation(builder.mActivity, builder.shareView,
																													 "shareView");
		ActivityCompat.startActivity(builder.mActivity, intent, options.toBundle());
	}
}
