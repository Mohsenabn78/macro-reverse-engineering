package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.MessageApi;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public final class zzfl implements MessageApi {
    private static final PendingResult a(GoogleApiClient googleApiClient, MessageApi.MessageListener messageListener, IntentFilter[] intentFilterArr) {
        return googleApiClient.enqueue(new zzfj(googleApiClient, messageListener, googleApiClient.registerListener(messageListener), intentFilterArr, null));
    }

    @Override // com.google.android.gms.wearable.MessageApi
    public final PendingResult<Status> addListener(GoogleApiClient googleApiClient, MessageApi.MessageListener messageListener) {
        return a(googleApiClient, messageListener, new IntentFilter[]{zzhl.zza("com.google.android.gms.wearable.MESSAGE_RECEIVED")});
    }

    @Override // com.google.android.gms.wearable.MessageApi
    public final PendingResult<Status> removeListener(GoogleApiClient googleApiClient, MessageApi.MessageListener messageListener) {
        return googleApiClient.enqueue(new zzfh(this, googleApiClient, messageListener));
    }

    @Override // com.google.android.gms.wearable.MessageApi
    public final PendingResult<MessageApi.SendMessageResult> sendMessage(GoogleApiClient googleApiClient, String str, String str2, byte[] bArr) {
        return googleApiClient.enqueue(new zzfg(this, googleApiClient, str, str2, bArr));
    }

    @Override // com.google.android.gms.wearable.MessageApi
    public final PendingResult<Status> addListener(GoogleApiClient googleApiClient, MessageApi.MessageListener messageListener, Uri uri, int i4) {
        boolean z3;
        Preconditions.checkNotNull(uri, "uri must not be null");
        if (i4 != 0) {
            if (i4 != 1) {
                z3 = false;
                Preconditions.checkArgument(z3, "invalid filter type");
                return a(googleApiClient, messageListener, new IntentFilter[]{zzhl.zzb("com.google.android.gms.wearable.MESSAGE_RECEIVED", uri, i4)});
            }
            i4 = 1;
        }
        z3 = true;
        Preconditions.checkArgument(z3, "invalid filter type");
        return a(googleApiClient, messageListener, new IntentFilter[]{zzhl.zzb("com.google.android.gms.wearable.MESSAGE_RECEIVED", uri, i4)});
    }
}
