package com.google.android.recaptcha.internal;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
final class zzeq extends zzes {
    final /* synthetic */ zzez zza;
    private int zzb = 0;
    private final int zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeq(zzez zzezVar) {
        this.zza = zzezVar;
        this.zzc = zzezVar.zzd();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.zzb < this.zzc) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.recaptcha.internal.zzeu
    public final byte zza() {
        int i4 = this.zzb;
        if (i4 < this.zzc) {
            this.zzb = i4 + 1;
            return this.zza.zzb(i4);
        }
        throw new NoSuchElementException();
    }
}
