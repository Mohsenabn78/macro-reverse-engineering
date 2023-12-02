package com.google.android.gms.internal.nearby;

import android.os.ParcelUuid;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.Hex;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class zznh {
    private static final ParcelUuid zza = ParcelUuid.fromString("00000000-0000-1000-8000-00805F9B34FB");
    private final int zzb;
    @Nullable
    private final List zzc;
    @Nullable
    private final SparseArray zzd;
    @Nullable
    private final Map zze;
    private final int zzf;
    @Nullable
    private final String zzg;
    private final byte[] zzh;

    private zznh(@Nullable List list, @Nullable SparseArray sparseArray, @Nullable Map map, int i4, int i5, @Nullable String str, byte[] bArr) {
        this.zzc = list;
        this.zzd = sparseArray;
        this.zze = map;
        this.zzg = str;
        this.zzb = i4;
        this.zzf = i5;
        this.zzh = bArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0091  */
    @androidx.annotation.Nullable
    @androidx.annotation.VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.nearby.zznh zza(@androidx.annotation.Nullable byte[] r13) {
        /*
            r0 = 0
            if (r13 != 0) goto L4
            return r0
        L4:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            android.util.SparseArray r4 = new android.util.SparseArray
            r4.<init>()
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            r2 = -1
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = 0
            r9 = r0
            r7 = -1
            r8 = -2147483648(0xffffffff80000000, float:-0.0)
        L1b:
            int r2 = r13.length     // Catch: java.lang.Exception -> L9d
            if (r6 >= r2) goto L88
            int r2 = r6 + 1
            r3 = r13[r6]     // Catch: java.lang.Exception -> L9d
            r6 = 255(0xff, float:3.57E-43)
            r3 = r3 & r6
            if (r3 != 0) goto L28
            goto L88
        L28:
            int r3 = r3 + (-1)
            int r10 = r2 + 1
            r2 = r13[r2]     // Catch: java.lang.Exception -> L9d
            r2 = r2 & r6
            r11 = 22
            r12 = 2
            if (r2 == r11) goto L72
            if (r2 == r6) goto L5b
            switch(r2) {
                case 1: goto L56;
                case 2: goto L52;
                case 3: goto L52;
                case 4: goto L4d;
                case 5: goto L4d;
                case 6: goto L47;
                case 7: goto L47;
                case 8: goto L3d;
                case 9: goto L3d;
                case 10: goto L3a;
                default: goto L39;
            }     // Catch: java.lang.Exception -> L9d
        L39:
            goto L85
        L3a:
            r8 = r13[r10]     // Catch: java.lang.Exception -> L9d
            goto L85
        L3d:
            java.lang.String r9 = new java.lang.String     // Catch: java.lang.Exception -> L9d
            byte[] r2 = zzd(r13, r10, r3)     // Catch: java.lang.Exception -> L9d
            r9.<init>(r2)     // Catch: java.lang.Exception -> L9d
            goto L85
        L47:
            r2 = 16
            zzb(r13, r10, r3, r2, r1)     // Catch: java.lang.Exception -> L9d
            goto L85
        L4d:
            r2 = 4
            zzb(r13, r10, r3, r2, r1)     // Catch: java.lang.Exception -> L9d
            goto L85
        L52:
            zzb(r13, r10, r3, r12, r1)     // Catch: java.lang.Exception -> L9d
            goto L85
        L56:
            r2 = r13[r10]     // Catch: java.lang.Exception -> L9d
            r7 = r2 & 255(0xff, float:3.57E-43)
            goto L85
        L5b:
            int r2 = r10 + 1
            r2 = r13[r2]     // Catch: java.lang.Exception -> L9d
            r2 = r2 & r6
            r11 = r13[r10]     // Catch: java.lang.Exception -> L9d
            int r2 = r2 << 8
            r6 = r6 & r11
            int r11 = r10 + 2
            int r12 = r3 + (-2)
            byte[] r11 = zzd(r13, r11, r12)     // Catch: java.lang.Exception -> L9d
            int r2 = r2 + r6
            r4.put(r2, r11)     // Catch: java.lang.Exception -> L9d
            goto L85
        L72:
            byte[] r2 = zzd(r13, r10, r12)     // Catch: java.lang.Exception -> L9d
            android.os.ParcelUuid r2 = zzc(r2)     // Catch: java.lang.Exception -> L9d
            int r6 = r10 + 2
            int r11 = r3 + (-2)
            byte[] r6 = zzd(r13, r6, r11)     // Catch: java.lang.Exception -> L9d
            r5.put(r2, r6)     // Catch: java.lang.Exception -> L9d
        L85:
            int r6 = r10 + r3
            goto L1b
        L88:
            boolean r2 = r1.isEmpty()     // Catch: java.lang.Exception -> L9d
            r3 = 1
            if (r3 == r2) goto L91
            r3 = r1
            goto L92
        L91:
            r3 = r0
        L92:
            com.google.android.gms.internal.nearby.zznh r1 = new com.google.android.gms.internal.nearby.zznh     // Catch: java.lang.Exception -> L9d
            r2 = r1
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r13
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Exception -> L9d
            return r1
        L9d:
            r1 = move-exception
            java.lang.String r13 = java.util.Arrays.toString(r13)
            java.lang.String r13 = java.lang.String.valueOf(r13)
            java.lang.String r2 = "BleRecord"
            java.lang.String r3 = "Unable to parse scan record: "
            java.lang.String r13 = r3.concat(r13)
            android.util.Log.w(r2, r13, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.nearby.zznh.zza(byte[]):com.google.android.gms.internal.nearby.zznh");
    }

    private static int zzb(byte[] bArr, int i4, int i5, int i6, List list) {
        while (i5 > 0) {
            list.add(zzc(zzd(bArr, i4, i6)));
            i5 -= i6;
            i4 += i6;
        }
        return i4;
    }

    private static ParcelUuid zzc(byte[] bArr) {
        long j4;
        int length = bArr.length;
        if (length != 2 && length != 4 && length != 16) {
            throw new IllegalArgumentException("uuidBytes length invalid - " + length);
        } else if (length == 16) {
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            return new ParcelUuid(new UUID(order.getLong(8), order.getLong(0)));
        } else {
            if (length == 2) {
                j4 = (bArr[0] & 255) + ((bArr[1] & 255) << 8);
            } else {
                j4 = ((bArr[3] & 255) << 24) + (bArr[0] & 255) + ((bArr[1] & 255) << 8) + ((bArr[2] & 255) << 16);
            }
            ParcelUuid parcelUuid = zza;
            return new ParcelUuid(new UUID(parcelUuid.getUuid().getMostSignificantBits() + (j4 << 32), parcelUuid.getUuid().getLeastSignificantBits()));
        }
    }

    private static byte[] zzd(byte[] bArr, int i4, int i5) {
        byte[] bArr2 = new byte[i5];
        System.arraycopy(bArr, i4, bArr2, 0, i5);
        return bArr2;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zznh)) {
            return false;
        }
        return Arrays.equals(this.zzh, ((zznh) obj).zzh);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zzh);
    }

    public final String toString() {
        String sb;
        String bytesToStringUppercase;
        String bytesToStringUppercase2;
        int i4 = this.zzb;
        String valueOf = String.valueOf(this.zzc);
        SparseArray sparseArray = this.zzd;
        StringBuilder sb2 = new StringBuilder();
        String str = "{}";
        int i5 = 0;
        if (sparseArray.size() <= 0) {
            sb = "{}";
        } else {
            sb2.append('{');
            for (int i6 = 0; i6 < sparseArray.size(); i6++) {
                if (i6 > 0) {
                    sb2.append(", ");
                }
                int keyAt = sparseArray.keyAt(i6);
                byte[] bArr = (byte[]) sparseArray.valueAt(i6);
                sb2.append(keyAt);
                sb2.append(SignatureVisitor.INSTANCEOF);
                if (bArr == null) {
                    bytesToStringUppercase = null;
                } else {
                    bytesToStringUppercase = Hex.bytesToStringUppercase(bArr);
                }
                sb2.append(bytesToStringUppercase);
            }
            sb2.append('}');
            sb = sb2.toString();
        }
        Map map = this.zze;
        StringBuilder sb3 = new StringBuilder();
        if (!map.keySet().isEmpty()) {
            sb3.append('{');
            for (Map.Entry entry : map.entrySet()) {
                if (i5 > 0) {
                    sb3.append(", ");
                }
                sb3.append(entry.getKey());
                sb3.append(SignatureVisitor.INSTANCEOF);
                byte[] bArr2 = (byte[]) entry.getValue();
                if (bArr2 == null) {
                    bytesToStringUppercase2 = null;
                } else {
                    bytesToStringUppercase2 = Hex.bytesToStringUppercase(bArr2);
                }
                sb3.append(bytesToStringUppercase2);
                i5++;
            }
            sb3.append('}');
            str = sb3.toString();
        }
        return "BleRecord [mAdvertiseFlags=" + i4 + ", mServiceUuids=" + valueOf + ", mManufacturerSpecificData=" + sb + ", mServiceData=" + str + ", mTxPowerLevel=" + this.zzf + ", mDeviceName=" + this.zzg + "]";
    }
}
