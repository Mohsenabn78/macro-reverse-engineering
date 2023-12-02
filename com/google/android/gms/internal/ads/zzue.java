package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzue implements zztm, zztl {
    private final zztm[] zza;
    @Nullable
    private zztl zze;
    @Nullable
    private zzvn zzf;
    private final zzsz zzi;
    private final ArrayList zzc = new ArrayList();
    private final HashMap zzd = new HashMap();
    private zzvh zzh = new zzsy(new zzvh[0]);
    private final IdentityHashMap zzb = new IdentityHashMap();
    private zztm[] zzg = new zztm[0];

    public zzue(zzsz zzszVar, long[] jArr, zztm... zztmVarArr) {
        this.zzi = zzszVar;
        this.zza = zztmVarArr;
        for (int i4 = 0; i4 < zztmVarArr.length; i4++) {
            long j4 = jArr[i4];
            if (j4 != 0) {
                this.zza[i4] = new zzuc(zztmVarArr[i4], j4);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zztm
    public final long zza(long j4, zzlm zzlmVar) {
        zztm zztmVar;
        zztm[] zztmVarArr = this.zzg;
        if (zztmVarArr.length > 0) {
            zztmVar = zztmVarArr[0];
        } else {
            zztmVar = this.zza[0];
        }
        return zztmVar.zza(j4, zzlmVar);
    }

    @Override // com.google.android.gms.internal.ads.zztm, com.google.android.gms.internal.ads.zzvh
    public final long zzb() {
        return this.zzh.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zztm, com.google.android.gms.internal.ads.zzvh
    public final long zzc() {
        return this.zzh.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zztm
    public final long zzd() {
        zztm[] zztmVarArr;
        zztm[] zztmVarArr2;
        long j4 = -9223372036854775807L;
        for (zztm zztmVar : this.zzg) {
            long zzd = zztmVar.zzd();
            if (zzd != -9223372036854775807L) {
                if (j4 == -9223372036854775807L) {
                    for (zztm zztmVar2 : this.zzg) {
                        if (zztmVar2 == zztmVar) {
                            break;
                        } else if (zztmVar2.zze(zzd) != zzd) {
                            throw new IllegalStateException("Unexpected child seekToUs result.");
                        }
                    }
                    j4 = zzd;
                } else if (zzd != j4) {
                    throw new IllegalStateException("Conflicting discontinuities.");
                }
            } else if (j4 != -9223372036854775807L && zztmVar.zze(j4) != j4) {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
        }
        return j4;
    }

    @Override // com.google.android.gms.internal.ads.zztm
    public final long zze(long j4) {
        long zze = this.zzg[0].zze(j4);
        int i4 = 1;
        while (true) {
            zztm[] zztmVarArr = this.zzg;
            if (i4 < zztmVarArr.length) {
                if (zztmVarArr[i4].zze(zze) == zze) {
                    i4++;
                } else {
                    throw new IllegalStateException("Unexpected child seekToUs result.");
                }
            } else {
                return zze;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zztm
    public final long zzf(zzxa[] zzxaVarArr, boolean[] zArr, zzvf[] zzvfVarArr, boolean[] zArr2, long j4) {
        int length;
        zzxa zzxaVar;
        zzxa zzxaVar2;
        int intValue;
        int length2 = zzxaVarArr.length;
        int[] iArr = new int[length2];
        int[] iArr2 = new int[length2];
        int i4 = 0;
        while (true) {
            length = zzxaVarArr.length;
            zzxaVar = null;
            Integer num = null;
            if (i4 >= length) {
                break;
            }
            zzvf zzvfVar = zzvfVarArr[i4];
            if (zzvfVar != null) {
                num = (Integer) this.zzb.get(zzvfVar);
            }
            if (num == null) {
                intValue = -1;
            } else {
                intValue = num.intValue();
            }
            iArr[i4] = intValue;
            zzxa zzxaVar3 = zzxaVarArr[i4];
            if (zzxaVar3 != null) {
                String str = zzxaVar3.zze().zzc;
                iArr2[i4] = Integer.parseInt(str.substring(0, str.indexOf(":")));
            } else {
                iArr2[i4] = -1;
            }
            i4++;
        }
        this.zzb.clear();
        zzvf[] zzvfVarArr2 = new zzvf[length];
        zzvf[] zzvfVarArr3 = new zzvf[length];
        zzxa[] zzxaVarArr2 = new zzxa[length];
        ArrayList arrayList = new ArrayList(this.zza.length);
        long j5 = j4;
        int i5 = 0;
        while (i5 < this.zza.length) {
            for (int i6 = 0; i6 < zzxaVarArr.length; i6++) {
                if (iArr[i6] == i5) {
                    zzxaVar2 = zzvfVarArr[i6];
                } else {
                    zzxaVar2 = zzxaVar;
                }
                zzvfVarArr3[i6] = zzxaVar2;
                if (iArr2[i6] == i5) {
                    zzxa zzxaVar4 = zzxaVarArr[i6];
                    zzxaVar4.getClass();
                    zzcy zzcyVar = (zzcy) this.zzd.get(zzxaVar4.zze());
                    zzcyVar.getClass();
                    zzxaVarArr2[i6] = new zzub(zzxaVar4, zzcyVar);
                } else {
                    zzxaVarArr2[i6] = zzxaVar;
                }
            }
            int i7 = i5;
            ArrayList arrayList2 = arrayList;
            zzvf[] zzvfVarArr4 = zzvfVarArr3;
            zzxa[] zzxaVarArr3 = zzxaVarArr2;
            long zzf = this.zza[i5].zzf(zzxaVarArr2, zArr, zzvfVarArr3, zArr2, j5);
            if (i7 == 0) {
                j5 = zzf;
            } else if (zzf != j5) {
                throw new IllegalStateException("Children enabled at different positions.");
            }
            boolean z3 = false;
            for (int i8 = 0; i8 < zzxaVarArr.length; i8++) {
                boolean z4 = true;
                if (iArr2[i8] == i7) {
                    zzvf zzvfVar2 = zzvfVarArr4[i8];
                    zzvfVar2.getClass();
                    zzvfVarArr2[i8] = zzvfVar2;
                    this.zzb.put(zzvfVar2, Integer.valueOf(i7));
                    z3 = true;
                } else if (iArr[i8] == i7) {
                    if (zzvfVarArr4[i8] != null) {
                        z4 = false;
                    }
                    zzdy.zzf(z4);
                }
            }
            if (z3) {
                arrayList2.add(this.zza[i7]);
            }
            i5 = i7 + 1;
            arrayList = arrayList2;
            zzvfVarArr3 = zzvfVarArr4;
            zzxaVarArr2 = zzxaVarArr3;
            zzxaVar = null;
        }
        System.arraycopy(zzvfVarArr2, 0, zzvfVarArr, 0, length);
        zztm[] zztmVarArr = (zztm[]) arrayList.toArray(new zztm[0]);
        this.zzg = zztmVarArr;
        this.zzh = new zzsy(zztmVarArr);
        return j5;
    }

    @Override // com.google.android.gms.internal.ads.zzvg
    public final /* bridge */ /* synthetic */ void zzg(zzvh zzvhVar) {
        zztm zztmVar = (zztm) zzvhVar;
        zztl zztlVar = this.zze;
        zztlVar.getClass();
        zztlVar.zzg(this);
    }

    @Override // com.google.android.gms.internal.ads.zztm
    public final zzvn zzh() {
        zzvn zzvnVar = this.zzf;
        zzvnVar.getClass();
        return zzvnVar;
    }

    @Override // com.google.android.gms.internal.ads.zztl
    public final void zzi(zztm zztmVar) {
        this.zzc.remove(zztmVar);
        if (!this.zzc.isEmpty()) {
            return;
        }
        int i4 = 0;
        for (zztm zztmVar2 : this.zza) {
            i4 += zztmVar2.zzh().zzc;
        }
        zzcy[] zzcyVarArr = new zzcy[i4];
        int i5 = 0;
        int i6 = 0;
        while (true) {
            zztm[] zztmVarArr = this.zza;
            if (i5 < zztmVarArr.length) {
                zzvn zzh = zztmVarArr[i5].zzh();
                int i7 = zzh.zzc;
                int i8 = 0;
                while (i8 < i7) {
                    zzcy zzb = zzh.zzb(i8);
                    zzcy zzc = zzb.zzc(i5 + ":" + zzb.zzc);
                    this.zzd.put(zzc, zzb);
                    zzcyVarArr[i6] = zzc;
                    i8++;
                    i6++;
                }
                i5++;
            } else {
                this.zzf = new zzvn(zzcyVarArr);
                zztl zztlVar = this.zze;
                zztlVar.getClass();
                zztlVar.zzi(this);
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zztm
    public final void zzj(long j4, boolean z3) {
        for (zztm zztmVar : this.zzg) {
            zztmVar.zzj(j4, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zztm
    public final void zzk() throws IOException {
        for (zztm zztmVar : this.zza) {
            zztmVar.zzk();
        }
    }

    @Override // com.google.android.gms.internal.ads.zztm
    public final void zzl(zztl zztlVar, long j4) {
        this.zze = zztlVar;
        Collections.addAll(this.zzc, this.zza);
        for (zztm zztmVar : this.zza) {
            zztmVar.zzl(this, j4);
        }
    }

    @Override // com.google.android.gms.internal.ads.zztm, com.google.android.gms.internal.ads.zzvh
    public final void zzm(long j4) {
        this.zzh.zzm(j4);
    }

    public final zztm zzn(int i4) {
        zztm zztmVar;
        zztm zztmVar2 = this.zza[i4];
        if (zztmVar2 instanceof zzuc) {
            zztmVar = ((zzuc) zztmVar2).zza;
            return zztmVar;
        }
        return zztmVar2;
    }

    @Override // com.google.android.gms.internal.ads.zztm, com.google.android.gms.internal.ads.zzvh
    public final boolean zzo(long j4) {
        if (!this.zzc.isEmpty()) {
            int size = this.zzc.size();
            for (int i4 = 0; i4 < size; i4++) {
                ((zztm) this.zzc.get(i4)).zzo(j4);
            }
            return false;
        }
        return this.zzh.zzo(j4);
    }

    @Override // com.google.android.gms.internal.ads.zztm, com.google.android.gms.internal.ads.zzvh
    public final boolean zzp() {
        return this.zzh.zzp();
    }
}
