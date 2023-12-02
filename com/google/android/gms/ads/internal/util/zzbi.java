package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzaks;
import com.google.android.gms.internal.ads.zzalo;
import com.google.android.gms.internal.ads.zzalp;
import com.google.android.gms.internal.ads.zzamo;
import com.google.android.gms.internal.ads.zzbzq;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbi extends zzamo {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ byte[] f19297a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Map f19298b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzbzq f19299c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbi(zzbo zzboVar, int i4, String str, zzalp zzalpVar, zzalo zzaloVar, byte[] bArr, Map map, zzbzq zzbzqVar) {
        super(i4, str, zzalpVar, zzaloVar);
        this.f19297a = bArr;
        this.f19298b = map;
        this.f19299c = zzbzqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzalk
    public final Map zzl() throws zzaks {
        Map map = this.f19298b;
        if (map == null) {
            return Collections.emptyMap();
        }
        return map;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzamo, com.google.android.gms.internal.ads.zzalk
    public final /* bridge */ /* synthetic */ void zzo(Object obj) {
        zzo((String) obj);
    }

    @Override // com.google.android.gms.internal.ads.zzalk
    public final byte[] zzx() throws zzaks {
        byte[] bArr = this.f19297a;
        if (bArr == null) {
            return null;
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzamo
    public final void zzz(String str) {
        this.f19299c.zzg(str);
        super.zzo(str);
    }
}
