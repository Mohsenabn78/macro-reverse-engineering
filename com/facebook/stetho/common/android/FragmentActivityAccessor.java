package com.facebook.stetho.common.android;

import android.app.Activity;
import javax.annotation.Nullable;

/* loaded from: classes3.dex */
public interface FragmentActivityAccessor<FRAGMENT_ACTIVITY extends Activity, FRAGMENT_MANAGER> {
    @Nullable
    FRAGMENT_MANAGER getFragmentManager(FRAGMENT_ACTIVITY fragment_activity);
}
