package com.google.android.gms.internal.icing;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes4.dex */
final class zzch extends zzci {
    private final byte[] zza;
    private int zzb;
    private int zzc;
    private int zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzch(byte[] bArr, int i4, int i5, boolean z3, zzcg zzcgVar) {
        super(null);
        this.zzd = Integer.MAX_VALUE;
        this.zza = bArr;
        this.zzb = 0;
    }

    public final int zza(int i4) throws zzdj {
        int i5 = this.zzd;
        this.zzd = 0;
        int i6 = this.zzb + this.zzc;
        this.zzb = i6;
        if (i6 > 0) {
            this.zzc = i6;
            this.zzb = 0;
        } else {
            this.zzc = 0;
        }
        return i5;
    }
}
