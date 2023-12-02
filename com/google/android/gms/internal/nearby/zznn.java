package com.google.android.gms.internal.nearby;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.internal.Update;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class zznn extends com.google.android.gms.nearby.messages.internal.zzn {
    private final ListenerHolder zza;

    public zznn(ListenerHolder listenerHolder) {
        this.zza = listenerHolder;
    }

    public static void zzb(Intent intent, MessageListener messageListener) {
        Iterable parcelableArrayList;
        Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.nearby.messages.UPDATES");
        if (bundleExtra == null) {
            parcelableArrayList = Collections.emptyList();
        } else {
            parcelableArrayList = bundleExtra.getParcelableArrayList("com.google.android.gms.nearby.messages.UPDATES");
        }
        if (parcelableArrayList == null) {
            return;
        }
        zzc(parcelableArrayList, messageListener);
    }

    public static void zzc(Iterable iterable, MessageListener messageListener) {
        com.google.android.gms.nearby.messages.internal.zza zzaVar;
        com.google.android.gms.nearby.messages.internal.zze zzeVar;
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            Update update = (Update) it.next();
            if (update.zza(1)) {
                messageListener.onFound(update.zzc);
            }
            if (update.zza(2)) {
                messageListener.onLost(update.zzc);
            }
            if (update.zza(4) && (zzeVar = update.zzd) != null) {
                messageListener.onDistanceChanged(update.zzc, zzeVar);
            }
            if (update.zza(8) && (zzaVar = update.zze) != null) {
                messageListener.onBleSignalChanged(update.zzc, zzaVar);
            }
            update.zza(16);
        }
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzo
    public final void zzd(List list) throws RemoteException {
        this.zza.notifyListener(new zznm(this, list));
    }
}
