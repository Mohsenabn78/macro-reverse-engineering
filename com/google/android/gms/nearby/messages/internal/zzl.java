package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.nio.ByteBuffer;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class zzl extends zzc {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public zzl(java.util.UUID r5, @androidx.annotation.Nullable java.lang.Short r6, @androidx.annotation.Nullable java.lang.Short r7) {
        /*
            r4 = this;
            r0 = 0
            r1 = 2
            if (r6 != 0) goto L6
            r2 = 0
            goto L7
        L6:
            r2 = 2
        L7:
            if (r7 != 0) goto La
            goto Lb
        La:
            r0 = 2
        Lb:
            int r2 = r2 + 16
            int r2 = r2 + r0
            java.nio.ByteBuffer r0 = java.nio.ByteBuffer.allocate(r2)
            long r1 = r5.getMostSignificantBits()
            java.nio.ByteBuffer r1 = r0.putLong(r1)
            long r2 = r5.getLeastSignificantBits()
            r1.putLong(r2)
            if (r6 == 0) goto L2a
            short r5 = r6.shortValue()
            r0.putShort(r5)
        L2a:
            if (r7 == 0) goto L33
            short r5 = r7.shortValue()
            r0.putShort(r5)
        L33:
            byte[] r5 = r0.array()
            a(r5)
            r4.<init>(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.nearby.messages.internal.zzl.<init>(java.util.UUID, java.lang.Short, java.lang.Short):void");
    }

    private static byte[] a(byte[] bArr) {
        int length = bArr.length;
        boolean z3 = true;
        if (length != 16 && length != 18 && length != 20) {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "Prefix must be a UUID, a UUID and a major, or a UUID, a major, and a minor.");
        return bArr;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzc
    public final String toString() {
        String obj = zzg().toString();
        Short zze = zze();
        Short zzf = zzf();
        return "IBeaconIdPrefix{proximityUuid=" + obj + ", major=" + zze + ", minor=" + zzf + "}";
    }

    public final Short zze() {
        byte[] zzc = zzc();
        if (zzc.length >= 18) {
            return Short.valueOf(ByteBuffer.wrap(zzc).getShort(16));
        }
        return null;
    }

    public final Short zzf() {
        byte[] zzc = zzc();
        if (zzc.length == 20) {
            return Short.valueOf(ByteBuffer.wrap(zzc).getShort(18));
        }
        return null;
    }

    public final UUID zzg() {
        ByteBuffer wrap = ByteBuffer.wrap(zzc());
        return new UUID(wrap.getLong(), wrap.getLong());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzl(byte[] bArr) {
        super(bArr);
        a(bArr);
    }
}
