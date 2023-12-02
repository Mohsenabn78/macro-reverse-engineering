package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzews {
    public static void zza(AtomicReference atomicReference, zzewr zzewrVar) {
        Object obj = atomicReference.get();
        if (obj == null) {
            return;
        }
        try {
            zzewrVar.zza(obj);
        } catch (RemoteException e4) {
            zzbzr.zzl("#007 Could not call remote method.", e4);
        } catch (NullPointerException e5) {
            zzbzr.zzk("NullPointerException occurs when invoking a method from a delegating listener.", e5);
        }
    }
}
