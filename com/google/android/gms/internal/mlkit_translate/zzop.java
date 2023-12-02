package com.google.android.gms.internal.mlkit_translate;

import com.google.android.gms.common.internal.Preconditions;
import javax.annotation.concurrent.Immutable;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
@Immutable
/* loaded from: classes4.dex */
public final class zzop {
    private final String zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzop(String str) {
        boolean z3;
        boolean z4;
        boolean z5;
        Preconditions.checkNotNull(str, "Null FID");
        int length = str.length();
        if (length == 22) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "Invalid FID: must be exactly 22 characters: ".concat(str));
        char charAt = str.charAt(0);
        if (charAt >= 'c' && charAt <= 'f') {
            z4 = true;
        } else {
            z4 = false;
        }
        Preconditions.checkArgument(z4, "Invalid FID: must start with [c-f]: ".concat(str));
        for (int i4 = 0; i4 < length; i4++) {
            char charAt2 = str.charAt(i4);
            if ((charAt2 >= '0' && charAt2 <= '9') || ((charAt2 >= 'a' && charAt2 <= 'z') || ((charAt2 >= 'A' && charAt2 <= 'Z') || charAt2 == '-' || charAt2 == '_'))) {
                z5 = true;
            } else {
                z5 = false;
            }
            Preconditions.checkArgument(z5, "Invalid FID: must contain only URL-safe base-64 characters: ".concat(str));
        }
        this.zza = str;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzop)) {
            return false;
        }
        return this.zza.equals(((zzop) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String zza() {
        return this.zza;
    }
}
