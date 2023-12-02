package com.google.android.gms.dynamic;

import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class zaa implements OnDelegateCreatedListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DeferredLifecycleHelper f20814a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zaa(DeferredLifecycleHelper deferredLifecycleHelper) {
        this.f20814a = deferredLifecycleHelper;
    }

    @Override // com.google.android.gms.dynamic.OnDelegateCreatedListener
    public final void onDelegateCreated(LifecycleDelegate lifecycleDelegate) {
        LinkedList linkedList;
        LinkedList linkedList2;
        LifecycleDelegate lifecycleDelegate2;
        this.f20814a.f20807a = lifecycleDelegate;
        linkedList = this.f20814a.f20809c;
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            lifecycleDelegate2 = this.f20814a.f20807a;
            ((zah) it.next()).a(lifecycleDelegate2);
        }
        linkedList2 = this.f20814a.f20809c;
        linkedList2.clear();
        this.f20814a.f20808b = null;
    }
}
