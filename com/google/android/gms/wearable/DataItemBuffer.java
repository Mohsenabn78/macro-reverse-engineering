package com.google.android.gms.wearable;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.EntityBuffer;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.wearable.internal.zzdk;
import org.apache.http.cookie.ClientCookie;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
@VisibleForTesting
/* loaded from: classes4.dex */
public class DataItemBuffer extends EntityBuffer<DataItem> implements Result {

    /* renamed from: c  reason: collision with root package name */
    private final Status f22631c;

    public DataItemBuffer(@NonNull DataHolder dataHolder) {
        super(dataHolder);
        this.f22631c = new Status(dataHolder.getStatusCode());
    }

    @Override // com.google.android.gms.common.data.EntityBuffer
    @NonNull
    protected final /* bridge */ /* synthetic */ DataItem c(int i4, int i5) {
        return new zzdk(this.mDataHolder, i4, i5);
    }

    @Override // com.google.android.gms.common.data.EntityBuffer
    @NonNull
    protected final String d() {
        return ClientCookie.PATH_ATTR;
    }

    @Override // com.google.android.gms.common.api.Result
    @NonNull
    public Status getStatus() {
        return this.f22631c;
    }
}
