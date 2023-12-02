package com.samsung.android.sdk;

import android.content.Context;

/* loaded from: classes6.dex */
public interface SsdkInterface {
    int getVersionCode();

    String getVersionName();

    void initialize(Context context) throws SsdkUnsupportedException;

    boolean isFeatureEnabled(int i4);
}
