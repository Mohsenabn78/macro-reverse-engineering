package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.ResultReceiver;
import java.lang.ref.WeakReference;
import java.util.concurrent.CancellationException;

/* compiled from: com.android.billingclient:billing@@5.2.0 */
/* loaded from: classes2.dex */
final class zzar extends com.google.android.gms.internal.play_billing.zzf {
    final WeakReference zza;
    final ResultReceiver zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzar(WeakReference weakReference, ResultReceiver resultReceiver, zzaq zzaqVar) {
        this.zza = weakReference;
        this.zzb = resultReceiver;
    }

    @Override // com.google.android.gms.internal.play_billing.zzg
    public final void zza(Bundle bundle) throws RemoteException {
        ResultReceiver resultReceiver = this.zzb;
        if (resultReceiver == null) {
            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Unable to send result for in-app messaging");
        } else if (bundle == null) {
            resultReceiver.send(0, null);
        } else {
            Activity activity = (Activity) this.zza.get();
            PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("KEY_LAUNCH_INTENT");
            if (activity != null && pendingIntent != null) {
                try {
                    Intent intent = new Intent(activity, ProxyBillingActivity.class);
                    intent.putExtra("in_app_message_result_receiver", this.zzb);
                    intent.putExtra("IN_APP_MESSAGE_INTENT", pendingIntent);
                    activity.startActivity(intent);
                    return;
                } catch (CancellationException e4) {
                    this.zzb.send(0, null);
                    com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Exception caught while launching intent for in-app messaging.", e4);
                    return;
                }
            }
            this.zzb.send(0, null);
            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Unable to launch intent for in-app messaging");
        }
    }
}
