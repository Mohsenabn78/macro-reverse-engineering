package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzagc extends zzage {
    public final long zza;
    public final List zzb;
    public final List zzc;

    public zzagc(int i4, long j4) {
        super(i4);
        this.zza = j4;
        this.zzb = new ArrayList();
        this.zzc = new ArrayList();
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final String toString() {
        String zzf = zzage.zzf(this.zzd);
        String arrays = Arrays.toString(this.zzb.toArray());
        String arrays2 = Arrays.toString(this.zzc.toArray());
        return zzf + " leaves: " + arrays + " containers: " + arrays2;
    }

    @Nullable
    public final zzagc zza(int i4) {
        int size = this.zzc.size();
        for (int i5 = 0; i5 < size; i5++) {
            zzagc zzagcVar = (zzagc) this.zzc.get(i5);
            if (zzagcVar.zzd == i4) {
                return zzagcVar;
            }
        }
        return null;
    }

    @Nullable
    public final zzagd zzb(int i4) {
        int size = this.zzb.size();
        for (int i5 = 0; i5 < size; i5++) {
            zzagd zzagdVar = (zzagd) this.zzb.get(i5);
            if (zzagdVar.zzd == i4) {
                return zzagdVar;
            }
        }
        return null;
    }

    public final void zzc(zzagc zzagcVar) {
        this.zzc.add(zzagcVar);
    }

    public final void zzd(zzagd zzagdVar) {
        this.zzb.add(zzagdVar);
    }
}
