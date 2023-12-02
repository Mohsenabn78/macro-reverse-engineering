package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahu  reason: invalid package */
/* loaded from: classes4.dex */
final class zzahu extends zzahw {
    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzahu(zzaht zzahtVar) {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzahw
    public final List zza(Object obj, long j4) {
        int i4;
        zzahi zzahiVar = (zzahi) zzajy.zzf(obj, j4);
        if (!zzahiVar.zzc()) {
            int size = zzahiVar.size();
            if (size == 0) {
                i4 = 10;
            } else {
                i4 = size + size;
            }
            zzahi zzd = zzahiVar.zzd(i4);
            zzajy.zzs(obj, j4, zzd);
            return zzd;
        }
        return zzahiVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzahw
    public final void zzb(Object obj, long j4) {
        ((zzahi) zzajy.zzf(obj, j4)).zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzahw
    public final void zzc(Object obj, Object obj2, long j4) {
        zzahi zzahiVar = (zzahi) zzajy.zzf(obj, j4);
        zzahi zzahiVar2 = (zzahi) zzajy.zzf(obj2, j4);
        int size = zzahiVar.size();
        int size2 = zzahiVar2.size();
        if (size > 0 && size2 > 0) {
            if (!zzahiVar.zzc()) {
                zzahiVar = zzahiVar.zzd(size2 + size);
            }
            zzahiVar.addAll(zzahiVar2);
        }
        if (size > 0) {
            zzahiVar2 = zzahiVar;
        }
        zzajy.zzs(obj, j4, zzahiVar2);
    }

    private zzahu() {
        super(null);
    }
}
