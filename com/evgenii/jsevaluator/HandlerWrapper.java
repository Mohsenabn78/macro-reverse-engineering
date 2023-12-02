package com.evgenii.jsevaluator;

import android.os.Handler;
import com.evgenii.jsevaluator.interfaces.HandlerWrapperInterface;

/* loaded from: classes3.dex */
public class HandlerWrapper implements HandlerWrapperInterface {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f17595a = new Handler();

    @Override // com.evgenii.jsevaluator.interfaces.HandlerWrapperInterface
    public void post(Runnable runnable) {
        this.f17595a.post(runnable);
    }
}
