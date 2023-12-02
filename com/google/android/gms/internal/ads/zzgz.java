package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import dev.skomlach.biometric.compat.engine.internal.iris.samsung.SamsungIrisUnlockModule;
import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgz extends zzgx {
    public final int zzd;
    @Nullable
    public final String zze;
    public final Map zzf;
    public final byte[] zzg;

    public zzgz(int i4, @Nullable String str, @Nullable IOException iOException, Map map, zzgj zzgjVar, byte[] bArr) {
        super("Response code: " + i4, iOException, zzgjVar, SamsungIrisUnlockModule.IRIS_REQUEST_FACTORY_TEST_CAMERA_VERSION, 1);
        this.zzd = i4;
        this.zze = str;
        this.zzf = map;
        this.zzg = bArr;
    }
}
