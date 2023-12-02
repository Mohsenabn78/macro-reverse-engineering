package com.google.android.gms.common.moduleinstall.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.moduleinstall.ModuleAvailabilityResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallIntentResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public abstract class zad extends com.google.android.gms.internal.base.zab implements zae {
    public zad() {
        super("com.google.android.gms.common.moduleinstall.internal.IModuleInstallCallbacks");
    }

    @Override // com.google.android.gms.internal.base.zab
    protected final boolean zaa(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 != 4) {
                        return false;
                    }
                    com.google.android.gms.internal.base.zac.zab(parcel);
                    zab((Status) com.google.android.gms.internal.base.zac.zaa(parcel, Status.CREATOR));
                } else {
                    com.google.android.gms.internal.base.zac.zab(parcel);
                    zac((Status) com.google.android.gms.internal.base.zac.zaa(parcel, Status.CREATOR), (ModuleInstallIntentResponse) com.google.android.gms.internal.base.zac.zaa(parcel, ModuleInstallIntentResponse.CREATOR));
                }
            } else {
                com.google.android.gms.internal.base.zac.zab(parcel);
                zad((Status) com.google.android.gms.internal.base.zac.zaa(parcel, Status.CREATOR), (ModuleInstallResponse) com.google.android.gms.internal.base.zac.zaa(parcel, ModuleInstallResponse.CREATOR));
            }
        } else {
            com.google.android.gms.internal.base.zac.zab(parcel);
            zae((Status) com.google.android.gms.internal.base.zac.zaa(parcel, Status.CREATOR), (ModuleAvailabilityResponse) com.google.android.gms.internal.base.zac.zaa(parcel, ModuleAvailabilityResponse.CREATOR));
        }
        return true;
    }
}
