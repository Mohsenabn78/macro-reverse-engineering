package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class zzg extends zzc {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public zzg(java.lang.String r7, java.lang.String r8) {
        /*
            r6 = this;
            byte[] r7 = com.google.android.gms.nearby.messages.internal.zzc.zzd(r7)
            int r0 = r7.length
            byte[] r8 = com.google.android.gms.nearby.messages.internal.zzc.zzd(r8)
            r1 = 2
            byte[][] r1 = new byte[r1]
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Namespace length("
            r2.append(r3)
            r2.append(r0)
            java.lang.String r3 = " bytes) must be 10 bytes."
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r3 = 10
            r4 = 1
            r5 = 0
            if (r0 != r3) goto L2a
            r0 = 1
            goto L2b
        L2a:
            r0 = 0
        L2b:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r0, r2)
            r1[r5] = r7
            int r7 = r8.length
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Instance length("
            r0.append(r2)
            r0.append(r7)
            java.lang.String r2 = " bytes) must be 6 bytes."
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r2 = 6
            if (r7 != r2) goto L4b
            r5 = 1
        L4b:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r5, r0)
            r1[r4] = r8
            byte[] r7 = com.google.android.gms.common.util.ArrayUtils.concatByteArrays(r1)
            a(r7)
            r6.<init>(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.nearby.messages.internal.zzg.<init>(java.lang.String, java.lang.String):void");
    }

    private static byte[] a(byte[] bArr) {
        int length = bArr.length;
        boolean z3 = true;
        if (length != 10 && length != 16) {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "Bytes must be a namespace (10 bytes), or a namespace plus instance (16 bytes).");
        return bArr;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzc
    public final String toString() {
        String zza = zza();
        return "EddystoneUidPrefix{bytes=" + zza + "}";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzg(byte[] bArr) {
        super(bArr);
        a(bArr);
    }
}
