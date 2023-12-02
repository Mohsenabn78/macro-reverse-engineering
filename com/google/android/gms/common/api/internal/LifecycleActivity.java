package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.ContextWrapper;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@KeepForSdk
/* loaded from: classes4.dex */
public class LifecycleActivity {

    /* renamed from: a  reason: collision with root package name */
    private final Object f20073a;

    public LifecycleActivity(@NonNull Activity activity) {
        Preconditions.checkNotNull(activity, "Activity must not be null");
        this.f20073a = activity;
    }

    @NonNull
    public final Activity zza() {
        return (Activity) this.f20073a;
    }

    @NonNull
    public final FragmentActivity zzb() {
        return (FragmentActivity) this.f20073a;
    }

    public final boolean zzc() {
        return this.f20073a instanceof Activity;
    }

    public final boolean zzd() {
        return this.f20073a instanceof FragmentActivity;
    }

    @KeepForSdk
    public LifecycleActivity(@NonNull ContextWrapper contextWrapper) {
        throw new UnsupportedOperationException();
    }
}
