package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgrk {
    private final ArrayDeque zza = new ArrayDeque();

    private zzgrk() {
    }

    public static /* bridge */ /* synthetic */ zzgoe zza(zzgrk zzgrkVar, zzgoe zzgoeVar, zzgoe zzgoeVar2) {
        zzgrkVar.zzb(zzgoeVar);
        zzgrkVar.zzb(zzgoeVar2);
        zzgoe zzgoeVar3 = (zzgoe) zzgrkVar.zza.pop();
        while (!zzgrkVar.zza.isEmpty()) {
            zzgoeVar3 = new zzgro((zzgoe) zzgrkVar.zza.pop(), zzgoeVar3);
        }
        return zzgoeVar3;
    }

    private final void zzb(zzgoe zzgoeVar) {
        zzgoe zzgoeVar2;
        zzgoe zzgoeVar3;
        if (zzgoeVar.zzh()) {
            int zzc = zzc(zzgoeVar.zzd());
            int zzc2 = zzgro.zzc(zzc + 1);
            if (!this.zza.isEmpty() && ((zzgoe) this.zza.peek()).zzd() < zzc2) {
                int zzc3 = zzgro.zzc(zzc);
                zzgoe zzgoeVar4 = (zzgoe) this.zza.pop();
                while (!this.zza.isEmpty() && ((zzgoe) this.zza.peek()).zzd() < zzc3) {
                    zzgoeVar4 = new zzgro((zzgoe) this.zza.pop(), zzgoeVar4);
                }
                zzgro zzgroVar = new zzgro(zzgoeVar4, zzgoeVar);
                while (!this.zza.isEmpty()) {
                    if (((zzgoe) this.zza.peek()).zzd() >= zzgro.zzc(zzc(zzgroVar.zzd()) + 1)) {
                        break;
                    }
                    zzgroVar = new zzgro((zzgoe) this.zza.pop(), zzgroVar);
                }
                this.zza.push(zzgroVar);
                return;
            }
            this.zza.push(zzgoeVar);
        } else if (zzgoeVar instanceof zzgro) {
            zzgro zzgroVar2 = (zzgro) zzgoeVar;
            zzgoeVar2 = zzgroVar2.zzd;
            zzb(zzgoeVar2);
            zzgoeVar3 = zzgroVar2.zze;
            zzb(zzgoeVar3);
        } else {
            throw new IllegalArgumentException("Has a new type of ByteString been created? Found ".concat(String.valueOf(zzgoeVar.getClass())));
        }
    }

    private static final int zzc(int i4) {
        int binarySearch = Arrays.binarySearch(zzgro.zza, i4);
        if (binarySearch < 0) {
            return (-(binarySearch + 1)) - 1;
        }
        return binarySearch;
    }

    public /* synthetic */ zzgrk(zzgrj zzgrjVar) {
    }
}
