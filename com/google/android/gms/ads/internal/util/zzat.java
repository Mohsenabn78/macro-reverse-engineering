package com.google.android.gms.ads.internal.util;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.client.zzcz;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzat extends zzcz {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f19272a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzaw f19273b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzat(zzaw zzawVar, Context context) {
        this.f19273b = zzawVar;
        this.f19272a = context;
    }

    @Override // com.google.android.gms.ads.internal.client.zzda
    public final void zze(@Nullable com.google.android.gms.ads.internal.client.zze zzeVar) {
        if (zzeVar == null) {
            return;
        }
        this.f19273b.a(this.f19272a, zzeVar.zzb, true, true);
    }
}
