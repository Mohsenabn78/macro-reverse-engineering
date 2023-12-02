package com.google.android.gms.ads.internal.util;

import android.graphics.Bitmap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbw {

    /* renamed from: a  reason: collision with root package name */
    final Map f19309a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    private final AtomicInteger f19310b = new AtomicInteger(0);

    public final Bitmap zza(Integer num) {
        return (Bitmap) this.f19309a.get(num);
    }
}
