package com.google.android.gms.internal.icing;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes4.dex */
public final class zzbe {
    private final ContentResolver zzc;
    private final ContentObserver zzd;
    @GuardedBy("ConfigurationContentLoader.class")
    private static final Map<Uri, zzbe> zzb = new ArrayMap();
    public static final String[] zza = {"key", "value"};

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void zza() {
        synchronized (zzbe.class) {
            Map<Uri, zzbe> map = zzb;
            Iterator<zzbe> it = map.values().iterator();
            if (!it.hasNext()) {
                map.clear();
            } else {
                ContentResolver contentResolver = it.next().zzc;
                throw null;
            }
        }
    }
}
