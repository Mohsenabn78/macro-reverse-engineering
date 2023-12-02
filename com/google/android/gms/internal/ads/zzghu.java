package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzghu {
    private final zzghn zza;
    private final List zzb;
    @Nullable
    private final Integer zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzghu(zzghn zzghnVar, List list, Integer num, zzght zzghtVar) {
        this.zza = zzghnVar;
        this.zzb = list;
        this.zzc = num;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzghu)) {
            return false;
        }
        zzghu zzghuVar = (zzghu) obj;
        if (this.zza.equals(zzghuVar.zza) && this.zzb.equals(zzghuVar.zzb)) {
            Integer num = this.zzc;
            Integer num2 = zzghuVar.zzc;
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
