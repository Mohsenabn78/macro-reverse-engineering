package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.Key;
import javax.crypto.Mac;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgnc extends ThreadLocal {
    final /* synthetic */ zzgnd zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgnc(zzgnd zzgndVar) {
        this.zza = zzgndVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.lang.ThreadLocal
    /* renamed from: zza */
    public final Mac initialValue() {
        String str;
        Key key;
        try {
            zzgmq zzgmqVar = zzgmq.zzb;
            str = this.zza.zzb;
            Mac mac = (Mac) zzgmqVar.zza(str);
            key = this.zza.zzc;
            mac.init(key);
            return mac;
        } catch (GeneralSecurityException e4) {
            throw new IllegalStateException(e4);
        }
    }
}
