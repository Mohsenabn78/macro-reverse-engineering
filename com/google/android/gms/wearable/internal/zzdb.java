package com.google.android.gms.wearable.internal;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataClient;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.PutDataRequest;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public final class zzdb extends DataClient {
    public static final /* synthetic */ int zza = 0;

    /* renamed from: a  reason: collision with root package name */
    private final DataApi f22743a;

    public zzdb(@NonNull Activity activity, @NonNull GoogleApi.Settings settings) {
        super(activity, settings);
        this.f22743a = new zzct();
    }

    private final Task a(final DataClient.OnDataChangedListener onDataChangedListener, final IntentFilter[] intentFilterArr) {
        final ListenerHolder createListenerHolder = ListenerHolders.createListenerHolder(onDataChangedListener, getLooper(), "DataListener");
        return doRegisterEventListener(RegistrationMethods.builder().withHolder(createListenerHolder).register(new RemoteCall() { // from class: com.google.android.gms.wearable.internal.zzcy
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                ((zzim) obj).zzr(new zzhj((TaskCompletionSource) obj2), DataClient.OnDataChangedListener.this, createListenerHolder, intentFilterArr);
            }
        }).unregister(new RemoteCall() { // from class: com.google.android.gms.wearable.internal.zzcz
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                ((zzim) obj).zzz(new zzhi((TaskCompletionSource) obj2), DataClient.OnDataChangedListener.this);
            }
        }).setMethodKey(24015).build());
    }

    @Override // com.google.android.gms.wearable.DataClient
    public final Task<Void> addListener(@NonNull DataClient.OnDataChangedListener onDataChangedListener) {
        return a(onDataChangedListener, new IntentFilter[]{zzhl.zza("com.google.android.gms.wearable.DATA_CHANGED")});
    }

    @Override // com.google.android.gms.wearable.DataClient
    public final Task<Integer> deleteDataItems(@NonNull Uri uri) {
        return PendingResultUtil.toTask(((zzct) this.f22743a).deleteDataItems(asGoogleApiClient(), uri, 0), zzcv.zza);
    }

    @Override // com.google.android.gms.wearable.DataClient
    public final Task<DataItem> getDataItem(@NonNull Uri uri) {
        DataApi dataApi = this.f22743a;
        GoogleApiClient asGoogleApiClient = asGoogleApiClient();
        return PendingResultUtil.toTask(asGoogleApiClient.enqueue(new zzci((zzct) dataApi, asGoogleApiClient, uri)), zzcu.zza);
    }

    @Override // com.google.android.gms.wearable.DataClient
    public final Task<DataItemBuffer> getDataItems() {
        DataApi dataApi = this.f22743a;
        GoogleApiClient asGoogleApiClient = asGoogleApiClient();
        return PendingResultUtil.toTask(asGoogleApiClient.enqueue(new zzcj((zzct) dataApi, asGoogleApiClient)), zzcw.zza);
    }

    @Override // com.google.android.gms.wearable.DataClient
    public final Task<DataClient.GetFdForAssetResponse> getFdForAsset(@NonNull Asset asset) {
        DataApi dataApi = this.f22743a;
        GoogleApiClient asGoogleApiClient = asGoogleApiClient();
        if (asset != null) {
            if (asset.getDigest() != null) {
                if (asset.zza() == null) {
                    return PendingResultUtil.toTask(asGoogleApiClient.enqueue(new zzcm((zzct) dataApi, asGoogleApiClient, asset)), zzcx.zza);
                }
                throw new IllegalArgumentException("invalid asset");
            }
            throw new IllegalArgumentException("invalid asset");
        }
        throw new IllegalArgumentException("asset is null");
    }

    @Override // com.google.android.gms.wearable.DataClient
    public final Task<DataItem> putDataItem(@NonNull PutDataRequest putDataRequest) {
        DataApi dataApi = this.f22743a;
        GoogleApiClient asGoogleApiClient = asGoogleApiClient();
        return PendingResultUtil.toTask(asGoogleApiClient.enqueue(new zzch((zzct) dataApi, asGoogleApiClient, putDataRequest)), zzcu.zza);
    }

    @Override // com.google.android.gms.wearable.DataClient
    public final Task<Boolean> removeListener(@NonNull DataClient.OnDataChangedListener onDataChangedListener) {
        return doUnregisterEventListener((ListenerHolder.ListenerKey) Preconditions.checkNotNull(ListenerHolders.createListenerHolder(onDataChangedListener, getLooper(), "DataListener").getListenerKey(), "Key must not be null"), 24005);
    }

    public zzdb(@NonNull Context context, @NonNull GoogleApi.Settings settings) {
        super(context, settings);
        this.f22743a = new zzct();
    }

    @Override // com.google.android.gms.wearable.DataClient
    public final Task<Void> addListener(@NonNull DataClient.OnDataChangedListener onDataChangedListener, @NonNull Uri uri, int i4) {
        boolean z3;
        Asserts.checkNotNull(uri, "uri must not be null");
        if (i4 != 0) {
            if (i4 != 1) {
                z3 = false;
                Preconditions.checkArgument(z3, "invalid filter type");
                return a(onDataChangedListener, new IntentFilter[]{zzhl.zzb("com.google.android.gms.wearable.DATA_CHANGED", uri, i4)});
            }
            i4 = 1;
        }
        z3 = true;
        Preconditions.checkArgument(z3, "invalid filter type");
        return a(onDataChangedListener, new IntentFilter[]{zzhl.zzb("com.google.android.gms.wearable.DATA_CHANGED", uri, i4)});
    }

    @Override // com.google.android.gms.wearable.DataClient
    public final Task<Integer> deleteDataItems(@NonNull Uri uri, int i4) {
        return PendingResultUtil.toTask(this.f22743a.deleteDataItems(asGoogleApiClient(), uri, i4), zzcv.zza);
    }

    @Override // com.google.android.gms.wearable.DataClient
    public final Task<DataItemBuffer> getDataItems(@NonNull Uri uri) {
        return PendingResultUtil.toTask(((zzct) this.f22743a).getDataItems(asGoogleApiClient(), uri, 0), zzcw.zza);
    }

    @Override // com.google.android.gms.wearable.DataClient
    public final Task<DataItemBuffer> getDataItems(@NonNull Uri uri, int i4) {
        return PendingResultUtil.toTask(this.f22743a.getDataItems(asGoogleApiClient(), uri, i4), zzcw.zza);
    }

    @Override // com.google.android.gms.wearable.DataClient
    public final Task<DataClient.GetFdForAssetResponse> getFdForAsset(@NonNull DataItemAsset dataItemAsset) {
        DataApi dataApi = this.f22743a;
        GoogleApiClient asGoogleApiClient = asGoogleApiClient();
        return PendingResultUtil.toTask(asGoogleApiClient.enqueue(new zzcn((zzct) dataApi, asGoogleApiClient, dataItemAsset)), zzcx.zza);
    }
}
