package com.google.android.gms.internal.nearby;

import android.os.ParcelFileDescriptor;
import androidx.annotation.Nullable;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeyFileProvider;
import java.io.FileNotFoundException;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
final class zzat extends zzcu {
    final /* synthetic */ DiagnosisKeyFileProvider zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzat(zzax zzaxVar, DiagnosisKeyFileProvider diagnosisKeyFileProvider) {
        this.zza = diagnosisKeyFileProvider;
    }

    @Override // com.google.android.gms.internal.nearby.zzcv
    @Nullable
    public final ParcelFileDescriptor zzb() {
        try {
            return ParcelFileDescriptor.open(this.zza.zza(), 268435456);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.nearby.zzcv
    public final boolean zzc() {
        return this.zza.zzb();
    }
}
