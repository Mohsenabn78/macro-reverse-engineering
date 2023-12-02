package com.obsez.android.lib.filechooser.internals;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.MimeTypeMap;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;

/* loaded from: classes6.dex */
public final class UiUtil {
    public static int dip2px(int i4) {
        return Float.valueOf((i4 * Resources.getSystem().getDisplayMetrics().density) + 0.5f).intValue();
    }

    public static void ensureVisible(@Nullable ListView listView, int i4) {
        if (listView != null && listView.getAdapter() != null && i4 >= 0 && i4 < listView.getAdapter().getCount()) {
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            int lastVisiblePosition = listView.getLastVisiblePosition();
            if (i4 < firstVisiblePosition) {
                listView.setSelection(i4);
            } else if (i4 >= lastVisiblePosition) {
                listView.setSelection((i4 + 1) - (lastVisiblePosition - firstVisiblePosition));
            }
        }
    }

    public static int getListYScroll(@NonNull ListView listView) {
        View childAt = listView.getChildAt(0);
        if (childAt == null) {
            return -1;
        }
        return listView.getPaddingTop() + ((listView.getFirstVisiblePosition() * childAt.getHeight()) - childAt.getTop());
    }

    public static String getMimeType(@NonNull Context context, Uri uri) {
        if (uri.getScheme().equals(FirebaseAnalytics.Param.CONTENT)) {
            return context.getApplicationContext().getContentResolver().getType(uri);
        }
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(uri.toString()).toLowerCase());
    }

    public static void hideKeyboard(@NonNull Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus == null) {
            currentFocus = new View(activity);
        }
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }

    public static void hideKeyboardFrom(@NonNull Context context, @NonNull View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static int px2dip(int i4) {
        return (int) ((i4 / Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static Drawable resolveFileTypeIcon(@NonNull Context context, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(uri, getMimeType(context, uri));
        PackageManager packageManager = context.getPackageManager();
        Iterator<ResolveInfo> it = packageManager.queryIntentActivities(intent, 0).iterator();
        if (it.hasNext()) {
            return it.next().loadIcon(packageManager);
        }
        return null;
    }

    public static float dip2px(float f4) {
        return (f4 * Resources.getSystem().getDisplayMetrics().density) + 0.5f;
    }
}
