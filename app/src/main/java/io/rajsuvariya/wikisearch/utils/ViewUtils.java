package io.rajsuvariya.wikisearch.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.content.res.AppCompatResources;

import io.rajsuvariya.wikisearch.R;
import saschpe.android.customtabs.CustomTabsHelper;
import saschpe.android.customtabs.WebViewFallback;

/**
 * Created by @rajsuvariya on 15/03/17.
 */

public final class ViewUtils {

    private ViewUtils() {
        // This utility class is not publicly instantiable
    }

    public static float pxToDp(float px) {
        float densityDpi = Resources.getSystem().getDisplayMetrics().densityDpi;
        return px / (densityDpi / 160f);
    }

    public static int dpToPx(float dp) {
        float density = Resources.getSystem().getDisplayMetrics().density;
        return Math.round(dp * density);
    }

    public static void changeIconDrawableToGray(Context context, Drawable drawable) {
        if (drawable != null) {
            drawable.mutate();
            drawable.setColorFilter(ContextCompat
                    .getColor(context, R.color.dark_gray), PorterDuff.Mode.SRC_ATOP);
        }
    }

    public static void creatorCustomTabs(Activity activity, String URL) {
        CustomTabsIntent customTabsIntent = getDefaultCustomTabsIntentBuilder(activity)
                .build();

        CustomTabsHelper.addKeepAliveExtra(activity, customTabsIntent.intent);

        CustomTabsHelper.openCustomTab(
                activity, customTabsIntent,
                Uri.parse(URL),
                new WebViewFallback());
    }

    public static CustomTabsIntent.Builder getDefaultCustomTabsIntentBuilder(Activity activity) {
        Bitmap backArrow = getBitmapFromVectorDrawable(R.drawable.ic_arrow_back_white_24dp, activity);
        return new CustomTabsIntent.Builder()
                .addDefaultShareMenuItem()
                .setToolbarColor(activity.getResources().getColor(R.color.colorPrimary))
                .setShowTitle(true)
                .setCloseButtonIcon(backArrow);
    }

    public static Bitmap getBitmapFromVectorDrawable(final @DrawableRes int drawableId, Activity activity) {
        Drawable drawable = AppCompatResources.getDrawable(activity, drawableId);
        if (drawable == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            drawable = (DrawableCompat.wrap(drawable)).mutate();
        }

        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }
}
