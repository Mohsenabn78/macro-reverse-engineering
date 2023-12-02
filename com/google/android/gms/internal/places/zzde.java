package com.google.android.gms.internal.places;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzde extends zzdb {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzde(int i4) {
        super(i4, null);
    }

    @Override // com.google.android.gms.internal.places.zzdb
    public final void zzab() {
        if (!isImmutable()) {
            for (int i4 = 0; i4 < zzcu(); i4++) {
                Map.Entry zzam = zzam(i4);
                if (((zzax) zzam.getKey()).zzaz()) {
                    zzam.setValue(Collections.unmodifiableList((List) zzam.getValue()));
                }
            }
            for (Map.Entry entry : zzcv()) {
                if (((zzax) entry.getKey()).zzaz()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zzab();
    }
}
