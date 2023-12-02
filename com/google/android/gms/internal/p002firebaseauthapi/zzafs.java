package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafs  reason: invalid package */
/* loaded from: classes4.dex */
final class zzafs extends zzafv {
    private final int zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzafs(byte[] bArr, int i4, int i5) {
        super(bArr);
        zzafy.zzl(0, i5, bArr.length);
        this.zzc = i5;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafv, com.google.android.gms.internal.p002firebaseauthapi.zzafy
    public final byte zza(int i4) {
        int i5 = this.zzc;
        if (((i5 - (i4 + 1)) | i4) < 0) {
            if (i4 < 0) {
                throw new ArrayIndexOutOfBoundsException("Index < 0: " + i4);
            }
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i4 + ", " + i5);
        }
        return this.zza[i4];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafv, com.google.android.gms.internal.p002firebaseauthapi.zzafy
    public final byte zzb(int i4) {
        return this.zza[i4];
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafv
    protected final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafv, com.google.android.gms.internal.p002firebaseauthapi.zzafy
    public final int zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafv, com.google.android.gms.internal.p002firebaseauthapi.zzafy
    protected final void zze(byte[] bArr, int i4, int i5, int i6) {
        System.arraycopy(this.zza, 0, bArr, 0, i6);
    }
}
