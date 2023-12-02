package com.google.android.gms.internal.base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public interface zaq {
    ExecutorService zaa(ThreadFactory threadFactory, int i4);

    ExecutorService zab(int i4, int i5);

    ExecutorService zac(int i4, ThreadFactory threadFactory, int i5);
}
