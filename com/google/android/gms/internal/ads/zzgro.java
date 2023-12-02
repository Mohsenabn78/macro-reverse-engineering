package com.google.android.gms.internal.ads;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgro extends zzgoe {
    static final int[] zza = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};
    private final int zzc;
    private final zzgoe zzd;
    private final zzgoe zze;
    private final int zzf;
    private final int zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzgoe zzC(zzgoe zzgoeVar, zzgoe zzgoeVar2) {
        if (zzgoeVar2.zzd() == 0) {
            return zzgoeVar;
        }
        if (zzgoeVar.zzd() == 0) {
            return zzgoeVar2;
        }
        int zzd = zzgoeVar.zzd() + zzgoeVar2.zzd();
        if (zzd < 128) {
            return zzD(zzgoeVar, zzgoeVar2);
        }
        if (zzgoeVar instanceof zzgro) {
            zzgro zzgroVar = (zzgro) zzgoeVar;
            if (zzgroVar.zze.zzd() + zzgoeVar2.zzd() < 128) {
                return new zzgro(zzgroVar.zzd, zzD(zzgroVar.zze, zzgoeVar2));
            } else if (zzgroVar.zzd.zzf() > zzgroVar.zze.zzf() && zzgroVar.zzg > zzgoeVar2.zzf()) {
                return new zzgro(zzgroVar.zzd, new zzgro(zzgroVar.zze, zzgoeVar2));
            }
        }
        if (zzd >= zzc(Math.max(zzgoeVar.zzf(), zzgoeVar2.zzf()) + 1)) {
            return new zzgro(zzgoeVar, zzgoeVar2);
        }
        return zzgrk.zza(new zzgrk(null), zzgoeVar, zzgoeVar2);
    }

    private static zzgoe zzD(zzgoe zzgoeVar, zzgoe zzgoeVar2) {
        int zzd = zzgoeVar.zzd();
        int zzd2 = zzgoeVar2.zzd();
        byte[] bArr = new byte[zzd + zzd2];
        zzgoeVar.zzz(bArr, 0, 0, zzd);
        zzgoeVar2.zzz(bArr, 0, zzd, zzd2);
        return new zzgoa(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(int i4) {
        int[] iArr = zza;
        int length = iArr.length;
        if (i4 >= 47) {
            return Integer.MAX_VALUE;
        }
        return iArr[i4];
    }

    @Override // com.google.android.gms.internal.ads.zzgoe
    public final boolean equals(Object obj) {
        boolean zzg;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgoe)) {
            return false;
        }
        zzgoe zzgoeVar = (zzgoe) obj;
        if (this.zzc != zzgoeVar.zzd()) {
            return false;
        }
        if (this.zzc == 0) {
            return true;
        }
        int zzr = zzr();
        int zzr2 = zzgoeVar.zzr();
        if (zzr != 0 && zzr2 != 0 && zzr != zzr2) {
            return false;
        }
        zzgrm zzgrmVar = new zzgrm(this, null);
        zzgnz next = zzgrmVar.next();
        zzgrm zzgrmVar2 = new zzgrm(zzgoeVar, null);
        zzgnz next2 = zzgrmVar2.next();
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int zzd = next.zzd() - i4;
            int zzd2 = next2.zzd() - i5;
            int min = Math.min(zzd, zzd2);
            if (i4 == 0) {
                zzg = next.zzg(next2, i5, min);
            } else {
                zzg = next2.zzg(next, i4, min);
            }
            if (!zzg) {
                return false;
            }
            i6 += min;
            int i7 = this.zzc;
            if (i6 >= i7) {
                if (i6 == i7) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (min == zzd) {
                next = zzgrmVar.next();
                i4 = 0;
            } else {
                i4 += min;
            }
            if (min == zzd2) {
                next2 = zzgrmVar2.next();
                i5 = 0;
            } else {
                i5 += min;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgoe, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzgri(this);
    }

    @Override // com.google.android.gms.internal.ads.zzgoe
    public final byte zza(int i4) {
        zzgoe.zzy(i4, this.zzc);
        return zzb(i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzgoe
    public final byte zzb(int i4) {
        int i5 = this.zzf;
        if (i4 < i5) {
            return this.zzd.zzb(i4);
        }
        return this.zze.zzb(i4 - i5);
    }

    @Override // com.google.android.gms.internal.ads.zzgoe
    public final int zzd() {
        return this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgoe
    public final void zze(byte[] bArr, int i4, int i5, int i6) {
        int i7 = i4 + i6;
        int i8 = this.zzf;
        if (i7 <= i8) {
            this.zzd.zze(bArr, i4, i5, i6);
        } else if (i4 >= i8) {
            this.zze.zze(bArr, i4 - i8, i5, i6);
        } else {
            int i9 = i8 - i4;
            this.zzd.zze(bArr, i4, i5, i9);
            this.zze.zze(bArr, 0, i5 + i9, i6 - i9);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgoe
    public final int zzf() {
        return this.zzg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgoe
    public final boolean zzh() {
        if (this.zzc >= zzc(this.zzg)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgoe
    public final int zzi(int i4, int i5, int i6) {
        int i7 = i5 + i6;
        int i8 = this.zzf;
        if (i7 <= i8) {
            return this.zzd.zzi(i4, i5, i6);
        }
        if (i5 >= i8) {
            return this.zze.zzi(i4, i5 - i8, i6);
        }
        int i9 = i8 - i5;
        return this.zze.zzi(this.zzd.zzi(i4, i5, i9), 0, i6 - i9);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgoe
    public final int zzj(int i4, int i5, int i6) {
        int i7 = i5 + i6;
        int i8 = this.zzf;
        if (i7 <= i8) {
            return this.zzd.zzj(i4, i5, i6);
        }
        if (i5 >= i8) {
            return this.zze.zzj(i4, i5 - i8, i6);
        }
        int i9 = i8 - i5;
        return this.zze.zzj(this.zzd.zzj(i4, i5, i9), 0, i6 - i9);
    }

    @Override // com.google.android.gms.internal.ads.zzgoe
    public final zzgoe zzk(int i4, int i5) {
        int zzq = zzgoe.zzq(i4, i5, this.zzc);
        if (zzq == 0) {
            return zzgoe.zzb;
        }
        if (zzq == this.zzc) {
            return this;
        }
        int i6 = this.zzf;
        if (i5 <= i6) {
            return this.zzd.zzk(i4, i5);
        }
        if (i4 >= i6) {
            return this.zze.zzk(i4 - i6, i5 - i6);
        }
        zzgoe zzgoeVar = this.zzd;
        return new zzgro(zzgoeVar.zzk(i4, zzgoeVar.zzd()), this.zze.zzk(0, i5 - this.zzf));
    }

    @Override // com.google.android.gms.internal.ads.zzgoe
    public final zzgom zzl() {
        ArrayList<ByteBuffer> arrayList = new ArrayList();
        zzgrm zzgrmVar = new zzgrm(this, null);
        while (zzgrmVar.hasNext()) {
            arrayList.add(zzgrmVar.next().zzn());
        }
        int i4 = zzgom.zzd;
        boolean z3 = false;
        int i5 = 0;
        for (ByteBuffer byteBuffer : arrayList) {
            i5 += byteBuffer.remaining();
            if (byteBuffer.hasArray()) {
                z3 |= true;
            } else if (byteBuffer.isDirect()) {
                z3 |= true;
            } else {
                z3 |= true;
            }
        }
        if (z3) {
            return new zzgoi(arrayList, i5, true, null);
        }
        return zzgom.zzH(new zzgpz(arrayList), 4096);
    }

    @Override // com.google.android.gms.internal.ads.zzgoe
    protected final String zzm(Charset charset) {
        return new String(zzA(), charset);
    }

    @Override // com.google.android.gms.internal.ads.zzgoe
    public final ByteBuffer zzn() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzgoe
    public final void zzo(zzgnt zzgntVar) throws IOException {
        this.zzd.zzo(zzgntVar);
        this.zze.zzo(zzgntVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgoe
    public final boolean zzp() {
        int zzj = this.zzd.zzj(0, 0, this.zzf);
        zzgoe zzgoeVar = this.zze;
        if (zzgoeVar.zzj(zzj, 0, zzgoeVar.zzd()) != 0) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzgoe
    public final zzgny zzs() {
        return new zzgri(this);
    }

    private zzgro(zzgoe zzgoeVar, zzgoe zzgoeVar2) {
        this.zzd = zzgoeVar;
        this.zze = zzgoeVar2;
        int zzd = zzgoeVar.zzd();
        this.zzf = zzd;
        this.zzc = zzd + zzgoeVar2.zzd();
        this.zzg = Math.max(zzgoeVar.zzf(), zzgoeVar2.zzf()) + 1;
    }
}
