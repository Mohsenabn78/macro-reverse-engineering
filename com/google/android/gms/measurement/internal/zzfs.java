package com.google.android.gms.measurement.internal;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* loaded from: classes4.dex */
final class zzfs implements com.google.android.gms.internal.measurement.zzr {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzfu f21621a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfs(zzfu zzfuVar) {
        this.f21621a = zzfuVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void zza(int i4, String str, List list, boolean z3, boolean z4) {
        zzer zzc;
        int i5 = i4 - 1;
        if (i5 != 0) {
            if (i5 != 1) {
                if (i5 != 3) {
                    if (i5 != 4) {
                        zzc = this.f21621a.f21734a.zzaA().zzi();
                    } else if (z3) {
                        zzc = this.f21621a.f21734a.zzaA().zzm();
                    } else if (!z4) {
                        zzc = this.f21621a.f21734a.zzaA().zzl();
                    } else {
                        zzc = this.f21621a.f21734a.zzaA().zzk();
                    }
                } else {
                    zzc = this.f21621a.f21734a.zzaA().zzj();
                }
            } else if (z3) {
                zzc = this.f21621a.f21734a.zzaA().zzh();
            } else if (!z4) {
                zzc = this.f21621a.f21734a.zzaA().zze();
            } else {
                zzc = this.f21621a.f21734a.zzaA().zzd();
            }
        } else {
            zzc = this.f21621a.f21734a.zzaA().zzc();
        }
        int size = list.size();
        if (size != 1) {
            if (size != 2) {
                if (size != 3) {
                    zzc.zza(str);
                    return;
                } else {
                    zzc.zzd(str, list.get(0), list.get(1), list.get(2));
                    return;
                }
            }
            zzc.zzc(str, list.get(0), list.get(1));
            return;
        }
        zzc.zzb(str, list.get(0));
    }
}
