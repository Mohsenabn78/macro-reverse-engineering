package com.google.android.gms.internal.identity;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-identity@@17.0.1 */
/* loaded from: classes4.dex */
public final class zzd extends zzf {
    private final int zza;
    @Nullable
    private Activity zzb;

    public zzd(int i4, Activity activity) {
        this.zza = i4;
        this.zzb = activity;
    }

    @Override // com.google.android.gms.internal.identity.zzg
    public final void zzc(int i4, Bundle bundle) {
        PendingIntent pendingIntent;
        PendingIntent createPendingResult;
        if (i4 == 1) {
            Intent intent = new Intent();
            intent.putExtras(bundle);
            Activity activity = this.zzb;
            if (activity == null || (createPendingResult = activity.createPendingResult(this.zza, intent, 1073741824)) == null) {
                return;
            }
            try {
                createPendingResult.send(1);
                return;
            } catch (PendingIntent.CanceledException e4) {
                Log.w("AddressClientImpl", "Exception settng pending result", e4);
                return;
            }
        }
        if (bundle != null) {
            pendingIntent = (PendingIntent) bundle.getParcelable("com.google.android.gms.identity.intents.EXTRA_PENDING_INTENT");
        } else {
            pendingIntent = null;
        }
        ConnectionResult connectionResult = new ConnectionResult(i4, pendingIntent);
        if (connectionResult.hasResolution()) {
            try {
                connectionResult.startResolutionForResult((Activity) Preconditions.checkNotNull(this.zzb), this.zza);
                return;
            } catch (IntentSender.SendIntentException e5) {
                Log.w("AddressClientImpl", "Exception starting pending intent", e5);
                return;
            }
        }
        try {
            PendingIntent createPendingResult2 = ((Activity) Preconditions.checkNotNull(this.zzb)).createPendingResult(this.zza, new Intent(), 1073741824);
            if (createPendingResult2 != null) {
                createPendingResult2.send(1);
            }
        } catch (PendingIntent.CanceledException e6) {
            Log.w("AddressClientImpl", "Exception setting pending result", e6);
        }
    }
}
