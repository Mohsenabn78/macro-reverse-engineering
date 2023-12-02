package com.google.android.gms.internal.places;

import com.google.android.gms.nearby.uwb.RangingPosition;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes4.dex */
public abstract class zzaj extends zzt {
    private static final Logger logger = Logger.getLogger(zzaj.class.getName());
    private static final boolean zzer = zzdy.zzdl();
    zzam zzes;

    /* loaded from: classes4.dex */
    static class zzb extends zzaj {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        zzb(byte[] bArr, int i4, int i5) {
            super();
            if (bArr != null) {
                int i6 = i5 + 0;
                if ((i5 | 0 | (bArr.length - i6)) >= 0) {
                    this.buffer = bArr;
                    this.offset = 0;
                    this.position = 0;
                    this.limit = i6;
                    return;
                }
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i5)));
            }
            throw new NullPointerException("buffer");
        }

        private final void write(byte[] bArr, int i4, int i5) throws IOException {
            try {
                System.arraycopy(bArr, i4, this.buffer, this.position, i5);
                this.position += i5;
            } catch (IndexOutOfBoundsException e4) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i5)), e4);
            }
        }

        @Override // com.google.android.gms.internal.places.zzaj
        public final int zzak() {
            return this.limit - this.position;
        }

        @Override // com.google.android.gms.internal.places.zzaj
        public final void zzb(int i4, long j4) throws IOException {
            zzc(i4, 0);
            zzc(j4);
        }

        @Override // com.google.android.gms.internal.places.zzaj
        public final void zzc(int i4, int i5) throws IOException {
            zzo((i4 << 3) | i5);
        }

        @Override // com.google.android.gms.internal.places.zzaj
        public final void zzd(int i4, int i5) throws IOException {
            zzc(i4, 0);
            zzn(i5);
        }

        @Override // com.google.android.gms.internal.places.zzaj
        public final void zze(int i4, int i5) throws IOException {
            zzc(i4, 0);
            zzo(i5);
        }

        @Override // com.google.android.gms.internal.places.zzaj
        public final void zzg(int i4, int i5) throws IOException {
            zzc(i4, 5);
            zzq(i5);
        }

        @Override // com.google.android.gms.internal.places.zzaj
        public final void zzj(String str) throws IOException {
            int i4 = this.position;
            try {
                int zzt = zzaj.zzt(str.length() * 3);
                int zzt2 = zzaj.zzt(str.length());
                if (zzt2 == zzt) {
                    int i5 = i4 + zzt2;
                    this.position = i5;
                    int zzb = zzea.zzb(str, this.buffer, i5, zzak());
                    this.position = i4;
                    zzo((zzb - i4) - zzt2);
                    this.position = zzb;
                    return;
                }
                zzo(zzea.zzb(str));
                this.position = zzea.zzb(str, this.buffer, this.position, zzak());
            } catch (zzee e4) {
                this.position = i4;
                zzb(str, e4);
            } catch (IndexOutOfBoundsException e5) {
                throw new zzc(e5);
            }
        }

        @Override // com.google.android.gms.internal.places.zzaj
        public final void zzn(int i4) throws IOException {
            if (i4 >= 0) {
                zzo(i4);
            } else {
                zzc(i4);
            }
        }

        @Override // com.google.android.gms.internal.places.zzaj
        public final void zzo(int i4) throws IOException {
            if (zzaj.zzer && !zzp.zzy() && zzak() >= 5) {
                if ((i4 & RangingPosition.RSSI_UNKNOWN) == 0) {
                    byte[] bArr = this.buffer;
                    int i5 = this.position;
                    this.position = i5 + 1;
                    zzdy.zzb(bArr, i5, (byte) i4);
                    return;
                }
                byte[] bArr2 = this.buffer;
                int i6 = this.position;
                this.position = i6 + 1;
                zzdy.zzb(bArr2, i6, (byte) (i4 | 128));
                int i7 = i4 >>> 7;
                if ((i7 & RangingPosition.RSSI_UNKNOWN) == 0) {
                    byte[] bArr3 = this.buffer;
                    int i8 = this.position;
                    this.position = i8 + 1;
                    zzdy.zzb(bArr3, i8, (byte) i7);
                    return;
                }
                byte[] bArr4 = this.buffer;
                int i9 = this.position;
                this.position = i9 + 1;
                zzdy.zzb(bArr4, i9, (byte) (i7 | 128));
                int i10 = i7 >>> 7;
                if ((i10 & RangingPosition.RSSI_UNKNOWN) == 0) {
                    byte[] bArr5 = this.buffer;
                    int i11 = this.position;
                    this.position = i11 + 1;
                    zzdy.zzb(bArr5, i11, (byte) i10);
                    return;
                }
                byte[] bArr6 = this.buffer;
                int i12 = this.position;
                this.position = i12 + 1;
                zzdy.zzb(bArr6, i12, (byte) (i10 | 128));
                int i13 = i10 >>> 7;
                if ((i13 & RangingPosition.RSSI_UNKNOWN) == 0) {
                    byte[] bArr7 = this.buffer;
                    int i14 = this.position;
                    this.position = i14 + 1;
                    zzdy.zzb(bArr7, i14, (byte) i13);
                    return;
                }
                byte[] bArr8 = this.buffer;
                int i15 = this.position;
                this.position = i15 + 1;
                zzdy.zzb(bArr8, i15, (byte) (i13 | 128));
                byte[] bArr9 = this.buffer;
                int i16 = this.position;
                this.position = i16 + 1;
                zzdy.zzb(bArr9, i16, (byte) (i13 >>> 7));
                return;
            }
            while ((i4 & RangingPosition.RSSI_UNKNOWN) != 0) {
                try {
                    byte[] bArr10 = this.buffer;
                    int i17 = this.position;
                    this.position = i17 + 1;
                    bArr10[i17] = (byte) ((i4 & 127) | 128);
                    i4 >>>= 7;
                } catch (IndexOutOfBoundsException e4) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e4);
                }
            }
            byte[] bArr11 = this.buffer;
            int i18 = this.position;
            this.position = i18 + 1;
            bArr11[i18] = (byte) i4;
        }

        @Override // com.google.android.gms.internal.places.zzaj
        public final void zzq(int i4) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i5 = this.position;
                int i6 = i5 + 1;
                bArr[i5] = (byte) i4;
                int i7 = i6 + 1;
                bArr[i6] = (byte) (i4 >> 8);
                int i8 = i7 + 1;
                bArr[i7] = (byte) (i4 >> 16);
                this.position = i8 + 1;
                bArr[i8] = (byte) (i4 >>> 24);
            } catch (IndexOutOfBoundsException e4) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e4);
            }
        }

        @Override // com.google.android.gms.internal.places.zzaj
        public final void zzc(int i4, boolean z3) throws IOException {
            zzc(i4, 0);
            zzd(z3 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.places.zzaj
        public final void zzb(int i4, String str) throws IOException {
            zzc(i4, 2);
            zzj(str);
        }

        @Override // com.google.android.gms.internal.places.zzaj
        public final void zzd(int i4, long j4) throws IOException {
            zzc(i4, 1);
            zze(j4);
        }

        @Override // com.google.android.gms.internal.places.zzaj
        public final void zze(byte[] bArr, int i4, int i5) throws IOException {
            zzo(i5);
            write(bArr, 0, i5);
        }

        @Override // com.google.android.gms.internal.places.zzaj
        public final void zzc(int i4, zzw zzwVar) throws IOException {
            zzc(1, 3);
            zze(2, i4);
            zzb(3, zzwVar);
            zzc(1, 4);
        }

        @Override // com.google.android.gms.internal.places.zzaj
        public final void zzb(int i4, zzw zzwVar) throws IOException {
            zzc(i4, 2);
            zzb(zzwVar);
        }

        @Override // com.google.android.gms.internal.places.zzaj
        public final void zzd(byte b4) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                bArr[i4] = b4;
            } catch (IndexOutOfBoundsException e4) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e4);
            }
        }

        @Override // com.google.android.gms.internal.places.zzaj
        public final void zze(long j4) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i4 = this.position;
                int i5 = i4 + 1;
                bArr[i4] = (byte) j4;
                int i6 = i5 + 1;
                bArr[i5] = (byte) (j4 >> 8);
                int i7 = i6 + 1;
                bArr[i6] = (byte) (j4 >> 16);
                int i8 = i7 + 1;
                bArr[i7] = (byte) (j4 >> 24);
                int i9 = i8 + 1;
                bArr[i8] = (byte) (j4 >> 32);
                int i10 = i9 + 1;
                bArr[i9] = (byte) (j4 >> 40);
                int i11 = i10 + 1;
                bArr[i10] = (byte) (j4 >> 48);
                this.position = i11 + 1;
                bArr[i11] = (byte) (j4 >> 56);
            } catch (IndexOutOfBoundsException e4) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e4);
            }
        }

        @Override // com.google.android.gms.internal.places.zzaj
        public final void zzb(zzw zzwVar) throws IOException {
            zzo(zzwVar.size());
            zzwVar.zzb(this);
        }

        @Override // com.google.android.gms.internal.places.zzaj
        public final void zzc(zzck zzckVar) throws IOException {
            zzo(zzckVar.zzbh());
            zzckVar.zzc(this);
        }

        @Override // com.google.android.gms.internal.places.zzaj
        final void zzb(int i4, zzck zzckVar, zzda zzdaVar) throws IOException {
            zzc(i4, 2);
            zzm zzmVar = (zzm) zzckVar;
            int zzw = zzmVar.zzw();
            if (zzw == -1) {
                zzw = zzdaVar.zzn(zzmVar);
                zzmVar.zze(zzw);
            }
            zzo(zzw);
            zzdaVar.zzb(zzckVar, this.zzes);
        }

        @Override // com.google.android.gms.internal.places.zzaj
        public final void zzc(long j4) throws IOException {
            if (zzaj.zzer && zzak() >= 10) {
                while ((j4 & (-128)) != 0) {
                    byte[] bArr = this.buffer;
                    int i4 = this.position;
                    this.position = i4 + 1;
                    zzdy.zzb(bArr, i4, (byte) ((((int) j4) & 127) | 128));
                    j4 >>>= 7;
                }
                byte[] bArr2 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                zzdy.zzb(bArr2, i5, (byte) j4);
                return;
            }
            while ((j4 & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.buffer;
                    int i6 = this.position;
                    this.position = i6 + 1;
                    bArr3[i6] = (byte) ((((int) j4) & 127) | 128);
                    j4 >>>= 7;
                } catch (IndexOutOfBoundsException e4) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e4);
                }
            }
            byte[] bArr4 = this.buffer;
            int i7 = this.position;
            this.position = i7 + 1;
            bArr4[i7] = (byte) j4;
        }

        @Override // com.google.android.gms.internal.places.zzaj
        public final void zzb(int i4, zzck zzckVar) throws IOException {
            zzc(1, 3);
            zze(2, i4);
            zzc(3, 2);
            zzc(zzckVar);
            zzc(1, 4);
        }

        @Override // com.google.android.gms.internal.places.zzt
        public final void zzb(byte[] bArr, int i4, int i5) throws IOException {
            write(bArr, i4, i5);
        }
    }

    /* loaded from: classes4.dex */
    public static class zzc extends IOException {
        zzc() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        zzc(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        zzc(java.lang.String r3, java.lang.Throwable r4) {
            /*
                r2 = this;
                java.lang.String r0 = "CodedOutputStream was writing to a flat byte array and ran out of space.: "
                java.lang.String r3 = java.lang.String.valueOf(r3)
                int r1 = r3.length()
                if (r1 == 0) goto L11
                java.lang.String r3 = r0.concat(r3)
                goto L16
            L11:
                java.lang.String r3 = new java.lang.String
                r3.<init>(r0)
            L16:
                r2.<init>(r3, r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.places.zzaj.zzc.<init>(java.lang.String, java.lang.Throwable):void");
        }
    }

    private zzaj() {
    }

    public static int zzc(double d4) {
        return 8;
    }

    public static int zzd(boolean z3) {
        return 1;
    }

    public static int zze(float f4) {
        return 4;
    }

    public static int zzg(long j4) {
        int i4;
        if (((-128) & j4) == 0) {
            return 1;
        }
        if (j4 < 0) {
            return 10;
        }
        if (((-34359738368L) & j4) != 0) {
            j4 >>>= 28;
            i4 = 6;
        } else {
            i4 = 2;
        }
        if (((-2097152) & j4) != 0) {
            i4 += 2;
            j4 >>>= 14;
        }
        return (j4 & (-16384)) != 0 ? i4 + 1 : i4;
    }

    public static int zzh(int i4, int i5) {
        return zzr(i4) + zzs(i5);
    }

    public static int zzi(long j4) {
        return 8;
    }

    public static int zzj(long j4) {
        return 8;
    }

    private static long zzk(long j4) {
        return (j4 >> 63) ^ (j4 << 1);
    }

    public static int zzl(int i4, int i5) {
        return zzr(i4) + 4;
    }

    public static int zzm(int i4, int i5) {
        return zzr(i4) + zzs(i5);
    }

    public static int zzr(int i4) {
        return zzt(i4 << 3);
    }

    public static int zzs(int i4) {
        if (i4 >= 0) {
            return zzt(i4);
        }
        return 10;
    }

    public static int zzt(int i4) {
        if ((i4 & RangingPosition.RSSI_UNKNOWN) == 0) {
            return 1;
        }
        if ((i4 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i4) == 0) {
            return 3;
        }
        if ((i4 & (-268435456)) == 0) {
            return 4;
        }
        return 5;
    }

    public static int zzu(int i4) {
        return zzt(zzy(i4));
    }

    public static int zzv(int i4) {
        return 4;
    }

    public static int zzw(int i4) {
        return 4;
    }

    public static int zzx(int i4) {
        return zzs(i4);
    }

    private static int zzy(int i4) {
        return (i4 >> 31) ^ (i4 << 1);
    }

    @Deprecated
    public static int zzz(int i4) {
        return zzt(i4);
    }

    public abstract int zzak();

    public final void zzb(int i4, float f4) throws IOException {
        zzg(i4, Float.floatToRawIntBits(f4));
    }

    public abstract void zzb(int i4, long j4) throws IOException;

    public abstract void zzb(int i4, zzck zzckVar) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzb(int i4, zzck zzckVar, zzda zzdaVar) throws IOException;

    public abstract void zzb(int i4, zzw zzwVar) throws IOException;

    public abstract void zzb(int i4, String str) throws IOException;

    public abstract void zzb(zzw zzwVar) throws IOException;

    public abstract void zzc(int i4, int i5) throws IOException;

    public abstract void zzc(int i4, zzw zzwVar) throws IOException;

    public abstract void zzc(int i4, boolean z3) throws IOException;

    public abstract void zzc(long j4) throws IOException;

    public abstract void zzc(zzck zzckVar) throws IOException;

    public abstract void zzd(byte b4) throws IOException;

    public abstract void zzd(int i4, int i5) throws IOException;

    public abstract void zzd(int i4, long j4) throws IOException;

    public abstract void zze(int i4, int i5) throws IOException;

    public abstract void zze(long j4) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zze(byte[] bArr, int i4, int i5) throws IOException;

    public final void zzf(int i4, int i5) throws IOException {
        zze(i4, zzy(i5));
    }

    public abstract void zzg(int i4, int i5) throws IOException;

    public abstract void zzj(String str) throws IOException;

    public abstract void zzn(int i4) throws IOException;

    public abstract void zzo(int i4) throws IOException;

    public final void zzp(int i4) throws IOException {
        zzo(zzy(i4));
    }

    public abstract void zzq(int i4) throws IOException;

    public static zzaj zzc(byte[] bArr) {
        return new zzb(bArr, 0, bArr.length);
    }

    public static int zze(int i4, long j4) {
        return zzr(i4) + zzg(j4);
    }

    public static int zzf(int i4, long j4) {
        return zzr(i4) + zzg(j4);
    }

    public static int zzg(int i4, long j4) {
        return zzr(i4) + zzg(zzk(j4));
    }

    public static int zzh(int i4, long j4) {
        return zzr(i4) + 8;
    }

    public static int zzi(int i4, int i5) {
        return zzr(i4) + zzt(i5);
    }

    public static int zzj(int i4, int i5) {
        return zzr(i4) + zzt(zzy(i5));
    }

    public static int zzk(int i4, int i5) {
        return zzr(i4) + 4;
    }

    public final void zzb(int i4, double d4) throws IOException {
        zzd(i4, Double.doubleToRawLongBits(d4));
    }

    public final void zzd(long j4) throws IOException {
        zzc(zzk(j4));
    }

    public static int zzf(long j4) {
        return zzg(j4);
    }

    public static int zzh(long j4) {
        return zzg(zzk(j4));
    }

    public static int zzi(int i4, long j4) {
        return zzr(i4) + 8;
    }

    public static int zzk(String str) {
        int length;
        try {
            length = zzea.zzb(str);
        } catch (zzee unused) {
            length = str.getBytes(zzbd.UTF_8).length;
        }
        return zzt(length) + length;
    }

    public final void zzb(double d4) throws IOException {
        zze(Double.doubleToRawLongBits(d4));
    }

    public final void zzd(float f4) throws IOException {
        zzq(Float.floatToRawIntBits(f4));
    }

    public static int zzb(int i4, zzbp zzbpVar) {
        int zzr = zzr(i4);
        int zzbh = zzbpVar.zzbh();
        return zzr + zzt(zzbh) + zzbh;
    }

    public static int zzd(int i4, boolean z3) {
        return zzr(i4) + 1;
    }

    public static int zze(int i4, zzw zzwVar) {
        return (zzr(1) << 1) + zzi(2, i4) + zzd(3, zzwVar);
    }

    public final void zzc(int i4, long j4) throws IOException {
        zzb(i4, zzk(j4));
    }

    public static int zzd(int i4, zzw zzwVar) {
        int zzr = zzr(i4);
        int size = zzwVar.size();
        return zzr + zzt(size) + size;
    }

    public final void zzc(boolean z3) throws IOException {
        zzd(z3 ? (byte) 1 : (byte) 0);
    }

    public static int zzc(int i4, float f4) {
        return zzr(i4) + 4;
    }

    public static int zzb(zzbp zzbpVar) {
        int zzbh = zzbpVar.zzbh();
        return zzt(zzbh) + zzbh;
    }

    public static int zzc(int i4, double d4) {
        return zzr(i4) + 8;
    }

    @Deprecated
    public static int zze(zzck zzckVar) {
        return zzckVar.zzbh();
    }

    public static int zzc(int i4, String str) {
        return zzr(i4) + zzk(str);
    }

    public static int zzd(byte[] bArr) {
        int length = bArr.length;
        return zzt(length) + length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(zzck zzckVar, zzda zzdaVar) {
        zzm zzmVar = (zzm) zzckVar;
        int zzw = zzmVar.zzw();
        if (zzw == -1) {
            zzw = zzdaVar.zzn(zzmVar);
            zzmVar.zze(zzw);
        }
        return zzt(zzw) + zzw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(int i4, zzck zzckVar, zzda zzdaVar) {
        return zzr(i4) + zzb(zzckVar, zzdaVar);
    }

    public static int zzc(int i4, zzck zzckVar) {
        return (zzr(1) << 1) + zzi(2, i4) + zzr(3) + zzd(zzckVar);
    }

    public static int zzd(zzck zzckVar) {
        int zzbh = zzckVar.zzbh();
        return zzt(zzbh) + zzbh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public static int zzd(int i4, zzck zzckVar, zzda zzdaVar) {
        int zzr = zzr(i4) << 1;
        zzm zzmVar = (zzm) zzckVar;
        int zzw = zzmVar.zzw();
        if (zzw == -1) {
            zzw = zzdaVar.zzn(zzmVar);
            zzmVar.zze(zzw);
        }
        return zzr + zzw;
    }

    public static int zzc(int i4, zzbp zzbpVar) {
        return (zzr(1) << 1) + zzi(2, i4) + zzb(3, zzbpVar);
    }

    final void zzb(String str, zzee zzeeVar) throws IOException {
        logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzeeVar);
        byte[] bytes = str.getBytes(zzbd.UTF_8);
        try {
            zzo(bytes.length);
            zzb(bytes, 0, bytes.length);
        } catch (zzc e4) {
            throw e4;
        } catch (IndexOutOfBoundsException e5) {
            throw new zzc(e5);
        }
    }

    public static int zzc(zzw zzwVar) {
        int size = zzwVar.size();
        return zzt(size) + size;
    }
}
