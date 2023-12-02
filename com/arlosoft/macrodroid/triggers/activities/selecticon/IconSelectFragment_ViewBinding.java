package com.arlosoft.macrodroid.triggers.activities.selecticon;

import android.content.Context;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public class IconSelectFragment_ViewBinding implements Unbinder {
    @UiThread
    @Deprecated
    public IconSelectFragment_ViewBinding(IconSelectFragment iconSelectFragment, View view) {
        this(iconSelectFragment, view.getContext());
    }

    @UiThread
    public IconSelectFragment_ViewBinding(IconSelectFragment iconSelectFragment, Context context) {
        iconSelectFragment.userIconSize = context.getResources().getDimensionPixelSize(R.dimen.user_icon_size);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
    }
}
