package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzot  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzot {
    private final zzom zza;
    private final List zzb;
    @Nullable
    private final Integer zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzot(zzom zzomVar, List list, Integer num, zzos zzosVar) {
        this.zza = zzomVar;
        this.zzb = list;
        this.zzc = num;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzot)) {
            return false;
        }
        zzot zzotVar = (zzot) obj;
        if (this.zza.equals(zzotVar.zza) && this.zzb.equals(zzotVar.zzb)) {
            Integer num = this.zzc;
            Integer num2 = zzotVar.zzc;
            if (num != num2) {
                if (num != null && num.equals(num2)) {
                    return true;
                }
            } else {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb});
    }

    public final String toString() {
        return String.format("(annotations=%s, entries=%s, primaryKeyId=%s)", this.zza, this.zzb, this.zzc);
    }
}
