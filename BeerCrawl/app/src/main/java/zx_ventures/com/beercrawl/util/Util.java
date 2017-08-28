package zx_ventures.com.beercrawl.util;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by ivo on 28/12/16.
 */

public class Util {
    public static void setPicture(ImageView imageView, String image) {
        Glide.with(BeerCrawlApplication.getAppContext())
                .load(image)
                //.placeholder(R.drawable.placeholder_image)
                .into(imageView);
    }

    public static void crossfade(final View out, View in) {
        int mShortAnimationDuration = 400; //duration of animation
        if (in != null) {
            in.setAlpha(0f);
            in.setVisibility(View.VISIBLE);
            in.animate()
                    .alpha(1f)
                    .setDuration(mShortAnimationDuration)
                    .setListener(null);
        }

        if (out != null) {
            out.animate()
                    .alpha(0f)
                    .setDuration(mShortAnimationDuration)
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            out.setVisibility(View.GONE);
                            out.setAlpha(1f);
                        }
                    });
        }
    }
}
