package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvh  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzvh implements zzbd {
    private final zzvz zza;
    private final zzce zzb;
    private final int zzc;

    public zzvh(zzvz zzvzVar, zzce zzceVar, int i4) {
        this.zza = zzvzVar;
        this.zzb = zzceVar;
        this.zzc = i4;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbd
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i4 = this.zzc;
        if (length >= i4) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, length - i4);
            this.zzb.zza(Arrays.copyOfRange(bArr, length - this.zzc, length), zzuz.zzb(bArr2, copyOfRange, Arrays.copyOf(ByteBuffer.allocate(8).putLong(0L).array(), 8)));
            return this.zza.zza(copyOfRange);
        }
        throw new GeneralSecurityException("ciphertext too short");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbd
    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        throw null;
    }
}
