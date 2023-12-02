package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzlc implements zzlo {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzlh f22033a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlc(zzlh zzlhVar) {
        this.f22033a = zzlhVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzlo
    public final void a(String str, String str2, Bundle bundle) {
        zzgd zzgdVar;
        zzgd zzgdVar2;
        if (TextUtils.isEmpty(str)) {
            zzlh zzlhVar = this.f22033a;
            zzgdVar = zzlhVar.f22052l;
            if (zzgdVar != null) {
                zzgdVar2 = zzlhVar.f22052l;
                zzgdVar2.zzaA().zzd().zzb("AppId not known when logging event", "_err");
                return;
            }
            return;
        }
        this.f22033a.zzaB().zzp(new zzlb(this, str, "_err", bundle));
    }
}
