package com.google.android.gms.common.providers;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@KeepForSdk
@Deprecated
/* loaded from: classes4.dex */
public class PooledExecutorsProvider {

    /* renamed from: a  reason: collision with root package name */
    private static PooledExecutorFactory f20638a;

    /* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    /* loaded from: classes4.dex */
    public interface PooledExecutorFactory {
        @NonNull
        @KeepForSdk
        @Deprecated
        ScheduledExecutorService newSingleThreadScheduledExecutor();
    }

    private PooledExecutorsProvider() {
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public static synchronized PooledExecutorFactory getInstance() {
        PooledExecutorFactory pooledExecutorFactory;
        synchronized (PooledExecutorsProvider.class) {
            if (f20638a == null) {
                f20638a = new zza();
            }
            pooledExecutorFactory = f20638a;
        }
        return pooledExecutorFactory;
    }
}
