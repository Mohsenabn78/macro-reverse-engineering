package com.google.android.gms.wearable;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.EntityBuffer;
import com.google.android.gms.wearable.internal.zzdd;
import org.apache.http.cookie.ClientCookie;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public class DataEventBuffer extends EntityBuffer<DataEvent> implements Result {

    /* renamed from: c  reason: collision with root package name */
    private final Status f22630c;

    public DataEventBuffer(@NonNull DataHolder dataHolder) {
        super(dataHolder);
        this.f22630c = new Status(dataHolder.getStatusCode());
    }

    @Override // com.google.android.gms.common.data.EntityBuffer
    @NonNull
    protected final /* bridge */ /* synthetic */ DataEvent c(int i4, int i5) {
        return new zzdd(this.mDataHolder, i4, i5);
    }

    @Override // com.google.android.gms.common.data.EntityBuffer
    @NonNull
    protected final String d() {
        return ClientCookie.PATH_ATTR;
    }

    @Override // com.google.android.gms.common.api.Result
    @NonNull
    public Status getStatus() {
        return this.f22630c;
    }
}
