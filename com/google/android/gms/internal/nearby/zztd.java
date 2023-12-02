package com.google.android.gms.internal.nearby;

import java.io.IOException;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
final class zztd implements Appendable {
    final /* synthetic */ Appendable zzb;
    final /* synthetic */ String zzc = ":";
    int zza = 2;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zztd(int i4, Appendable appendable, String str) {
        this.zzb = appendable;
    }

    @Override // java.lang.Appendable
    public final Appendable append(char c4) throws IOException {
        if (this.zza == 0) {
            this.zzb.append(this.zzc);
            this.zza = 2;
        }
        this.zzb.append(c4);
        this.zza--;
        return this;
    }

    @Override // java.lang.Appendable
    public final Appendable append(@CheckForNull CharSequence charSequence) {
        throw new UnsupportedOperationException();
    }

    @Override // java.lang.Appendable
    public final Appendable append(@CheckForNull CharSequence charSequence, int i4, int i5) {
        throw new UnsupportedOperationException();
    }
}
