package com.google.android.gms.internal.play_billing;

import com.google.android.gms.internal.play_billing.zzaj;
import com.google.android.gms.internal.play_billing.zzak;
import java.io.IOException;

/* compiled from: com.android.billingclient:billing@@5.2.0 */
/* loaded from: classes4.dex */
public abstract class zzak<MessageType extends zzak<MessageType, BuilderType>, BuilderType extends zzaj<MessageType, BuilderType>> implements zzdf {
    protected int zza = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public int zza(zzdp zzdpVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.play_billing.zzdf
    public final zzba zzb() {
        try {
            int zzd = zzd();
            zzba zzbaVar = zzba.zzb;
            byte[] bArr = new byte[zzd];
            zzbi zzz = zzbi.zzz(bArr, 0, zzd);
            zzq(zzz);
            zzz.zzA();
            return new zzax(bArr);
        } catch (IOException e4) {
            String name = getClass().getName();
            throw new RuntimeException("Serializing " + name + " to a ByteString threw an IOException (should never happen).", e4);
        }
    }
}
