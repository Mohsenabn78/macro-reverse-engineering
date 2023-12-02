package com.google.android.gms.ads.internal;

import android.content.Context;
import com.google.android.gms.internal.ads.zzaqr;
import com.google.android.gms.internal.ads.zzaqs;
import com.google.android.gms.internal.ads.zzbzx;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzo implements Callable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzs f19397a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzo(zzs zzsVar) {
        this.f19397a = zzsVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzbzx zzbzxVar;
        Context context;
        zzs zzsVar = this.f19397a;
        zzbzxVar = zzsVar.f19405a;
        String str = zzbzxVar.zza;
        context = zzsVar.f19408d;
        return new zzaqs(zzaqr.zzt(str, context, false));
    }
}
