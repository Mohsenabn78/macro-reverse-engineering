package com.google.android.gms.ads.internal.util;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbd {

    /* renamed from: a  reason: collision with root package name */
    private final List f19287a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final List f19288b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private final List f19289c = new ArrayList();

    public final zzbd zza(String str, double d4, double d5) {
        int i4 = 0;
        while (i4 < this.f19287a.size()) {
            double doubleValue = ((Double) this.f19289c.get(i4)).doubleValue();
            double doubleValue2 = ((Double) this.f19288b.get(i4)).doubleValue();
            if (d4 < doubleValue || (doubleValue == d4 && d5 < doubleValue2)) {
                break;
            }
            i4++;
        }
        this.f19287a.add(i4, str);
        this.f19289c.add(i4, Double.valueOf(d4));
        this.f19288b.add(i4, Double.valueOf(d5));
        return this;
    }

    public final zzbf zzb() {
        return new zzbf(this, null);
    }
}
