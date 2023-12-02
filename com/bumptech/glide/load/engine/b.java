package com.bumptech.glide.load.engine;

/* compiled from: CallbackException.java */
/* loaded from: classes3.dex */
final class b extends RuntimeException {
    private static final long serialVersionUID = -7530898992688511851L;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Throwable th) {
        super("Unexpected exception thrown by non-Glide code", th);
    }
}
