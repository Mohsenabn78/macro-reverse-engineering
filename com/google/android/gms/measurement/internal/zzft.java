package com.google.android.gms.measurement.internal;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* loaded from: classes4.dex */
final class zzft implements com.google.android.gms.internal.measurement.zzo {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f21622a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzfu f21623b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzft(zzfu zzfuVar, String str) {
        this.f21623b = zzfuVar;
        this.f21622a = str;
    }

    @Override // com.google.android.gms.internal.measurement.zzo
    public final String zza(String str) {
        Map map;
        map = this.f21623b.f21624d;
        Map map2 = (Map) map.get(this.f21622a);
        if (map2 != null && map2.containsKey(str)) {
            return (String) map2.get(str);
        }
        return null;
    }
}
