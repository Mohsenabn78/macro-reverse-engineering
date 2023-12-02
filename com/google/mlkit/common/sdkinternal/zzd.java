package com.google.mlkit.common.sdkinternal;

import com.google.mlkit.common.sdkinternal.Cleaner;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Set;

/* compiled from: com.google.mlkit:common@@18.5.0 */
/* loaded from: classes5.dex */
final class zzd extends PhantomReference implements Cleaner.Cleanable {

    /* renamed from: a  reason: collision with root package name */
    private final Set f33045a;

    /* renamed from: b  reason: collision with root package name */
    private final Runnable f33046b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzd(Object obj, ReferenceQueue referenceQueue, Set set, Runnable runnable, zzc zzcVar) {
        super(obj, referenceQueue);
        this.f33045a = set;
        this.f33046b = runnable;
    }

    @Override // com.google.mlkit.common.sdkinternal.Cleaner.Cleanable
    public final void clean() {
        if (!this.f33045a.remove(this)) {
            return;
        }
        clear();
        this.f33046b.run();
    }
}
