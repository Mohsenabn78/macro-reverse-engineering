package com.google.android.gms.nearby.exposurenotification;

import androidx.annotation.NonNull;
import com.google.android.gms.internal.nearby.zzst;
import java.io.File;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public class DiagnosisKeyFileProvider {

    /* renamed from: a  reason: collision with root package name */
    private int f22280a = 0;

    /* renamed from: b  reason: collision with root package name */
    private final zzst f22281b;

    public DiagnosisKeyFileProvider(@NonNull List<File> list) {
        this.f22281b = zzst.zzj(list);
    }

    @NonNull
    public final File zza() {
        int i4 = this.f22280a + 1;
        this.f22280a = i4;
        return (File) this.f22281b.get(i4 - 1);
    }

    public final boolean zzb() {
        if (this.f22281b.size() > this.f22280a) {
            return true;
        }
        return false;
    }
}
