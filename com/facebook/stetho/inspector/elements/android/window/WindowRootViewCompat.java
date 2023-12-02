package com.facebook.stetho.inspector.elements.android.window;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.facebook.stetho.common.Util;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class WindowRootViewCompat {
    private static WindowRootViewCompat sInstance;

    public static WindowRootViewCompat get(Context context) {
        WindowRootViewCompat windowRootViewCompat = sInstance;
        if (windowRootViewCompat != null) {
            return windowRootViewCompat;
        }
        Util.throwIfNull(context);
        WindowRootViewCompactV19Impl windowRootViewCompactV19Impl = new WindowRootViewCompactV19Impl();
        sInstance = windowRootViewCompactV19Impl;
        return windowRootViewCompactV19Impl;
    }

    @NonNull
    public abstract List<View> getRootViews();
}
