package com.google.android.gms.ads.mediation.customevent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
@Deprecated
/* loaded from: classes4.dex */
public final class CustomEventExtras {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap f19458a = new HashMap();

    @Nullable
    public Object getExtra(@NonNull String str) {
        return this.f19458a.get(str);
    }

    public void setExtra(@NonNull String str, @NonNull Object obj) {
        this.f19458a.put(str, obj);
    }
}
