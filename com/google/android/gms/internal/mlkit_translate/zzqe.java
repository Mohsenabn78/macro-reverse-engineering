package com.google.android.gms.internal.mlkit_translate;

import com.google.mlkit.common.sdkinternal.LazyInstanceMap;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
final class zzqe extends LazyInstanceMap {
    private zzqe() {
    }

    @Override // com.google.mlkit.common.sdkinternal.LazyInstanceMap
    protected final /* bridge */ /* synthetic */ Object create(Object obj) {
        zzpl zzplVar = (zzpl) obj;
        MlKitContext mlKitContext = MlKitContext.getInstance();
        return new zzps(mlKitContext.getApplicationContext(), (SharedPrefManager) mlKitContext.get(SharedPrefManager.class), new zzpm(MlKitContext.getInstance().getApplicationContext(), zzplVar), zzplVar.zzb());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzqe(zzqd zzqdVar) {
    }
}
