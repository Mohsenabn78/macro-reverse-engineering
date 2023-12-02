package com.koushikdutta.async.callback;

/* loaded from: classes6.dex */
public interface CompletedCallback {
    void onCompleted(Exception exc);

    /* loaded from: classes6.dex */
    public static class NullCompletedCallback implements CompletedCallback {
        @Override // com.koushikdutta.async.callback.CompletedCallback
        public void onCompleted(Exception exc) {
        }
    }
}
