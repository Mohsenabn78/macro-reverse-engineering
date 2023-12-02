package com.koushikdutta.async.callback;

import com.koushikdutta.async.future.Continuation;

/* loaded from: classes6.dex */
public interface ContinuationCallback {
    void onContinue(Continuation continuation, CompletedCallback completedCallback) throws Exception;
}
