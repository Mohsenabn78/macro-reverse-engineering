package com.google.mlkit.common.sdkinternal;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.mlkit:common@@18.5.0 */
@KeepForSdk
/* loaded from: classes5.dex */
public abstract class LazyInstanceMap<K, V> {
    @GuardedBy("instances")
    private final Map zza = new HashMap();

    @NonNull
    @KeepForSdk
    protected abstract V create(@NonNull K k4);

    @NonNull
    @KeepForSdk
    public V get(@NonNull K k4) {
        synchronized (this.zza) {
            if (this.zza.containsKey(k4)) {
                return (V) this.zza.get(k4);
            }
            V create = create(k4);
            this.zza.put(k4, create);
            return create;
        }
    }
}
