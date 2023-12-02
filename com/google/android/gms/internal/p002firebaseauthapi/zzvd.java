package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.interfaces.ECPublicKey;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvd  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzvd implements zzbl {
    private final zzvf zza;
    private final String zzb;
    private final byte[] zzc;
    private final zzvb zzd;

    public zzvd(ECPublicKey eCPublicKey, byte[] bArr, String str, int i4, zzvb zzvbVar) throws GeneralSecurityException {
        zzjz.zzb(eCPublicKey.getW(), eCPublicKey.getParams().getCurve());
        this.zza = new zzvf(eCPublicKey);
        this.zzc = bArr;
        this.zzb = str;
        this.zzd = zzvbVar;
    }
}
