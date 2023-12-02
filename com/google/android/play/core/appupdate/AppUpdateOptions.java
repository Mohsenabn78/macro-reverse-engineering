package com.google.android.play.core.appupdate;

import androidx.annotation.NonNull;
import com.google.android.play.core.install.model.AppUpdateType;

/* compiled from: com.google.android.play:app-update@@2.0.1 */
/* loaded from: classes5.dex */
public abstract class AppUpdateOptions {

    /* compiled from: com.google.android.play:app-update@@2.0.1 */
    /* loaded from: classes5.dex */
    public static abstract class Builder {
        @NonNull
        public abstract AppUpdateOptions build();

        @NonNull
        public abstract Builder setAllowAssetPackDeletion(boolean z3);

        @NonNull
        public abstract Builder setAppUpdateType(@AppUpdateType int i4);
    }

    @NonNull
    public static AppUpdateOptions defaultOptions(@AppUpdateType int i4) {
        return newBuilder(i4).build();
    }

    @NonNull
    public static Builder newBuilder(@AppUpdateType int i4) {
        zzv zzvVar = new zzv();
        zzvVar.setAppUpdateType(i4);
        zzvVar.setAllowAssetPackDeletion(false);
        return zzvVar;
    }

    public abstract boolean allowAssetPackDeletion();

    @AppUpdateType
    public abstract int appUpdateType();
}
