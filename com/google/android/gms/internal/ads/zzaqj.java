package com.google.android.gms.internal.ads;

import java.io.File;
import java.security.GeneralSecurityException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaqj implements zzfkw {
    final /* synthetic */ zzfiw zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaqj(zzaql zzaqlVar, zzfiw zzfiwVar) {
        this.zza = zzfiwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfkw
    public final boolean zza(File file) {
        try {
            return this.zza.zza(file);
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }
}
