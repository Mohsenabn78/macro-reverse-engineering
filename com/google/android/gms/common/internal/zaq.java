package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.Response;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
final class zaq implements PendingResultUtil.ResultConverter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Response f20532a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zaq(Response response) {
        this.f20532a = response;
    }

    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final /* bridge */ /* synthetic */ Object convert(Result result) {
        this.f20532a.setResult(result);
        return this.f20532a;
    }
}
