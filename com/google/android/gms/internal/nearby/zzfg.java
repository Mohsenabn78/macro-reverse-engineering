package com.google.android.gms.internal.nearby;

import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class zzfg {
    private static final Map zza = new ArrayMap();
    private final Map zzb = new ArrayMap();
    private final Set zzc = new ArraySet();
    private final Map zzd = new ArrayMap();

    private zzfg() {
    }

    public static synchronized zzfg zzd(GoogleApi googleApi, @Nullable Api.ApiOptions apiOptions) {
        zzfg zzfgVar;
        synchronized (zzfg.class) {
            zzff zzffVar = new zzff(googleApi, null);
            Map map = zza;
            if (!map.containsKey(zzffVar)) {
                map.put(zzffVar, new zzfg());
            }
            zzfgVar = (zzfg) map.get(zzffVar);
        }
        return zzfgVar;
    }

    private final Object zzi(String str) {
        if (!this.zzd.containsKey(str)) {
            this.zzd.put(str, new Object());
        }
        return this.zzd.get(str);
    }

    public final synchronized ListenerHolder.ListenerKey zza(String str, String str2) {
        return ListenerHolders.createListenerKey(zzi(str), "connection");
    }

    public final synchronized ListenerHolder zzb(GoogleApi googleApi, Object obj, String str) {
        ListenerHolder registerListener;
        Preconditions.checkNotNull(obj);
        registerListener = googleApi.registerListener(obj, str);
        ListenerHolder.ListenerKey listenerKey = (ListenerHolder.ListenerKey) Preconditions.checkNotNull(registerListener.getListenerKey(), "Key must not be null");
        Set set = (Set) this.zzb.get(str);
        if (set == null) {
            set = new ArraySet();
            this.zzb.put(str, set);
        }
        set.add(listenerKey);
        return registerListener;
    }

    public final synchronized ListenerHolder zzc(GoogleApi googleApi, String str, String str2) {
        return zzb(googleApi, zzi(str), "connection");
    }

    public final synchronized Task zze(GoogleApi googleApi, RegistrationMethods registrationMethods) {
        ListenerHolder.ListenerKey listenerKey;
        listenerKey = (ListenerHolder.ListenerKey) Preconditions.checkNotNull(registrationMethods.register.getListenerKey(), "Key must not be null");
        return googleApi.doRegisterEventListener(registrationMethods).addOnFailureListener(new zzfe(this, googleApi, listenerKey, this.zzc.add(listenerKey)));
    }

    public final synchronized Task zzf(GoogleApi googleApi, String str) {
        ArraySet arraySet = new ArraySet();
        Set set = (Set) this.zzb.get(str);
        if (set == null) {
            return Tasks.whenAll(arraySet);
        }
        Iterator it = new ArraySet(set).iterator();
        while (it.hasNext()) {
            ListenerHolder.ListenerKey listenerKey = (ListenerHolder.ListenerKey) it.next();
            if (this.zzc.contains(listenerKey)) {
                arraySet.add(zzg(googleApi, listenerKey));
            }
        }
        this.zzb.remove(str);
        return Tasks.whenAll(arraySet);
    }

    public final synchronized Task zzg(GoogleApi googleApi, ListenerHolder.ListenerKey listenerKey) {
        String str;
        this.zzc.remove(listenerKey);
        Iterator it = this.zzb.keySet().iterator();
        while (true) {
            if (it.hasNext()) {
                str = (String) it.next();
                Set set = (Set) this.zzb.get(str);
                if (set.contains(listenerKey)) {
                    set.remove(listenerKey);
                    break;
                }
            } else {
                str = null;
                break;
            }
        }
        if (str != null) {
            Iterator it2 = this.zzd.entrySet().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it2.next();
                if (ListenerHolders.createListenerKey(entry.getValue(), str).equals(listenerKey)) {
                    this.zzd.remove(entry.getKey());
                    break;
                }
            }
        }
        return googleApi.doUnregisterEventListener(listenerKey);
    }
}
