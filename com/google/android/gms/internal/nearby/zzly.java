package com.google.android.gms.internal.nearby;

import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "ParcelByteArrayCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzly extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzly> CREATOR = new zzlv();
    private byte[] zza;
    @Nullable
    @SafeParcelable.Field(getter = "getDataPfd", id = 1)
    private ParcelFileDescriptor zzb;

    private zzly() {
        this.zza = new byte[0];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public static byte[] zzd(ParcelFileDescriptor parcelFileDescriptor) {
        DataInputStream dataInputStream = new DataInputStream(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor));
        try {
            try {
                byte[] bArr = new byte[dataInputStream.readInt()];
                dataInputStream.read(bArr);
                return bArr;
            } catch (IOException e4) {
                throw new IllegalStateException("Could not read from parcel file descriptor", e4);
            }
        } finally {
            zze(dataInputStream);
        }
    }

    private static void zze(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e4) {
            Log.w("ParcelByteArray", "Could not close stream", e4);
        }
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzly) {
            return Arrays.equals(this.zza, ((zzly) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zza);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b1, code lost:
        if (r5 == null) goto L27;
     */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x00bb: MOVE  (r2 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:41:0x00bb */
    @Override // android.os.Parcelable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void writeToParcel(android.os.Parcel r8, int r9) {
        /*
            r7 = this;
            java.lang.String r0 = "ParcelByteArray"
            byte[] r1 = r7.zza
            r2 = 0
            if (r1 == 0) goto Lc2
            android.os.ParcelFileDescriptor r3 = r7.zzb
            if (r3 == 0) goto Ld
            goto Lc2
        Ld:
            java.io.File r3 = com.google.android.gms.internal.nearby.zzme.zzb()     // Catch: java.lang.Throwable -> L78 java.io.IOException -> L7a java.lang.IllegalStateException -> L97
            if (r3 == 0) goto L70
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L67 java.lang.Throwable -> L78 java.lang.IllegalStateException -> L97
            java.lang.String r5 = "teleporter"
            r4.<init>(r5)     // Catch: java.io.IOException -> L67 java.lang.Throwable -> L78 java.lang.IllegalStateException -> L97
            long r5 = android.os.SystemClock.elapsedRealtime()     // Catch: java.io.IOException -> L67 java.lang.Throwable -> L78 java.lang.IllegalStateException -> L97
            r4.append(r5)     // Catch: java.io.IOException -> L67 java.lang.Throwable -> L78 java.lang.IllegalStateException -> L97
            java.lang.String r4 = r4.toString()     // Catch: java.io.IOException -> L67 java.lang.Throwable -> L78 java.lang.IllegalStateException -> L97
            java.lang.String r5 = ".tmp"
            java.io.File r3 = java.io.File.createTempFile(r4, r5, r3)     // Catch: java.io.IOException -> L67 java.lang.Throwable -> L78 java.lang.IllegalStateException -> L97
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch: java.io.FileNotFoundException -> L5e java.lang.Throwable -> L78 java.io.IOException -> L7a java.lang.IllegalStateException -> L97
            r4.<init>(r3)     // Catch: java.io.FileNotFoundException -> L5e java.lang.Throwable -> L78 java.io.IOException -> L7a java.lang.IllegalStateException -> L97
            r5 = 268435456(0x10000000, float:2.5243549E-29)
            android.os.ParcelFileDescriptor r5 = android.os.ParcelFileDescriptor.open(r3, r5)     // Catch: java.io.FileNotFoundException -> L5e java.lang.Throwable -> L78 java.io.IOException -> L7a java.lang.IllegalStateException -> L97
            r3.delete()     // Catch: java.lang.Throwable -> L78 java.io.IOException -> L7a java.lang.IllegalStateException -> L97
            android.util.Pair r3 = android.util.Pair.create(r4, r5)     // Catch: java.lang.Throwable -> L78 java.io.IOException -> L7a java.lang.IllegalStateException -> L97
            java.io.BufferedOutputStream r4 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L78 java.io.IOException -> L7a java.lang.IllegalStateException -> L97
            java.lang.Object r5 = r3.first     // Catch: java.lang.Throwable -> L78 java.io.IOException -> L7a java.lang.IllegalStateException -> L97
            java.io.OutputStream r5 = (java.io.OutputStream) r5     // Catch: java.lang.Throwable -> L78 java.io.IOException -> L7a java.lang.IllegalStateException -> L97
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L78 java.io.IOException -> L7a java.lang.IllegalStateException -> L97
            java.io.DataOutputStream r5 = new java.io.DataOutputStream     // Catch: java.lang.Throwable -> L78 java.io.IOException -> L7a java.lang.IllegalStateException -> L97
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L78 java.io.IOException -> L7a java.lang.IllegalStateException -> L97
            int r4 = r1.length     // Catch: java.io.IOException -> L5a java.lang.IllegalStateException -> L5c java.lang.Throwable -> Lba
            r5.writeInt(r4)     // Catch: java.io.IOException -> L5a java.lang.IllegalStateException -> L5c java.lang.Throwable -> Lba
            r5.write(r1)     // Catch: java.io.IOException -> L5a java.lang.IllegalStateException -> L5c java.lang.Throwable -> Lba
            java.lang.Object r1 = r3.second     // Catch: java.io.IOException -> L5a java.lang.IllegalStateException -> L5c java.lang.Throwable -> Lba
            android.os.ParcelFileDescriptor r1 = (android.os.ParcelFileDescriptor) r1     // Catch: java.io.IOException -> L5a java.lang.IllegalStateException -> L5c java.lang.Throwable -> Lba
            zze(r5)
            goto Lb7
        L5a:
            r1 = move-exception
            goto L7c
        L5c:
            r1 = move-exception
            goto L99
        L5e:
            r1 = move-exception
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L78 java.io.IOException -> L7a java.lang.IllegalStateException -> L97
            java.lang.String r4 = "Temporary file is somehow already deleted"
            r3.<init>(r4, r1)     // Catch: java.lang.Throwable -> L78 java.io.IOException -> L7a java.lang.IllegalStateException -> L97
            throw r3     // Catch: java.lang.Throwable -> L78 java.io.IOException -> L7a java.lang.IllegalStateException -> L97
        L67:
            r1 = move-exception
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L78 java.io.IOException -> L7a java.lang.IllegalStateException -> L97
            java.lang.String r4 = "Could not create temporary file"
            r3.<init>(r4, r1)     // Catch: java.lang.Throwable -> L78 java.io.IOException -> L7a java.lang.IllegalStateException -> L97
            throw r3     // Catch: java.lang.Throwable -> L78 java.io.IOException -> L7a java.lang.IllegalStateException -> L97
        L70:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L78 java.io.IOException -> L7a java.lang.IllegalStateException -> L97
            java.lang.String r3 = "Must set temp dir before writing this object to a parcel"
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L78 java.io.IOException -> L7a java.lang.IllegalStateException -> L97
            throw r1     // Catch: java.lang.Throwable -> L78 java.io.IOException -> L7a java.lang.IllegalStateException -> L97
        L78:
            r8 = move-exception
            goto Lbc
        L7a:
            r1 = move-exception
            r5 = r2
        L7c:
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lba
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lba
            r3.<init>()     // Catch: java.lang.Throwable -> Lba
            java.lang.String r4 = "Could not write into unlinked file. "
            r3.append(r4)     // Catch: java.lang.Throwable -> Lba
            r3.append(r1)     // Catch: java.lang.Throwable -> Lba
            java.lang.String r1 = r3.toString()     // Catch: java.lang.Throwable -> Lba
            android.util.Log.e(r0, r1)     // Catch: java.lang.Throwable -> Lba
            if (r5 == 0) goto Lb6
            goto Lb3
        L97:
            r1 = move-exception
            r5 = r2
        L99:
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lba
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lba
            r3.<init>()     // Catch: java.lang.Throwable -> Lba
            java.lang.String r4 = "Could not create unlinked file. "
            r3.append(r4)     // Catch: java.lang.Throwable -> Lba
            r3.append(r1)     // Catch: java.lang.Throwable -> Lba
            java.lang.String r1 = r3.toString()     // Catch: java.lang.Throwable -> Lba
            android.util.Log.e(r0, r1)     // Catch: java.lang.Throwable -> Lba
            if (r5 == 0) goto Lb6
        Lb3:
            zze(r5)
        Lb6:
            r1 = r2
        Lb7:
            r7.zzb = r1
            goto Lc2
        Lba:
            r8 = move-exception
            r2 = r5
        Lbc:
            if (r2 == 0) goto Lc1
            zze(r2)
        Lc1:
            throw r8
        Lc2:
            r0 = 1
            r9 = r9 | r0
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.beginObjectHeader(r8)
            android.os.ParcelFileDescriptor r3 = r7.zzb
            r4 = 0
            com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeParcelable(r8, r0, r3, r9, r4)
            com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.finishObjectHeader(r8, r1)
            r7.zzb = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.nearby.zzly.writeToParcel(android.os.Parcel, int):void");
    }

    public final byte[] zzc() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzly(@Nullable @SafeParcelable.Param(id = 1) ParcelFileDescriptor parcelFileDescriptor) {
        this.zza = new byte[0];
        this.zzb = parcelFileDescriptor;
    }
}
