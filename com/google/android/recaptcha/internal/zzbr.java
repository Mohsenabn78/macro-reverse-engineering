package com.google.android.recaptcha.internal;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzbr implements zzby {
    @NotNull
    public static final zzbr zza = new zzbr();

    private zzbr() {
    }

    @Override // com.google.android.recaptcha.internal.zzby
    public final void zza(int i4, @NotNull zzbl zzblVar, @NotNull Object... objArr) throws zzt {
        if (objArr.length == 3) {
            Object obj = objArr[0];
            if (true != (obj instanceof Integer)) {
                obj = null;
            }
            Integer num = (Integer) obj;
            if (num != null) {
                int intValue = num.intValue();
                if (intValue != 0) {
                    Object obj2 = objArr[1];
                    if (true != (obj2 instanceof Object)) {
                        obj2 = null;
                    }
                    if (obj2 != null) {
                        Object obj3 = objArr[2];
                        if (true != (obj3 instanceof Object)) {
                            obj3 = null;
                        }
                        if (obj3 != null) {
                            if (Intrinsics.areEqual(obj2, obj3)) {
                                zzblVar.zzg(zzblVar.zzb() + intValue);
                                return;
                            }
                            return;
                        }
                        throw new zzt(4, 5, null);
                    }
                    throw new zzt(4, 5, null);
                }
                throw new zzt(4, 6, null);
            }
            throw new zzt(4, 5, null);
        }
        throw new zzt(4, 3, null);
    }
}
