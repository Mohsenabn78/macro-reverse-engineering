package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.android.gms.common.util.Strings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaes  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzaes {
    private List zza;

    public zzaes() {
        this(null);
    }

    public final List zza() {
        return this.zza;
    }

    public zzaes(int i4, List list) {
        if (!list.isEmpty()) {
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.set(i5, Strings.emptyToNull((String) list.get(i5)));
            }
            this.zza = Collections.unmodifiableList(list);
            return;
        }
        this.zza = Collections.emptyList();
    }

    public zzaes(@Nullable List list) {
        this.zza = new ArrayList();
    }
}
