package com.koushikdutta.ion;

import android.graphics.Bitmap;
import com.koushikdutta.async.future.TransformFuture;
import com.koushikdutta.ion.bitmap.BitmapInfo;

/* compiled from: BitmapInfoToBitmap.java */
/* loaded from: classes6.dex */
class c extends TransformFuture<Bitmap, BitmapInfo> {

    /* renamed from: i  reason: collision with root package name */
    d f35821i;

    public c(d dVar) {
        this.f35821i = dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.koushikdutta.async.future.TransformFuture
    /* renamed from: l */
    public void k(BitmapInfo bitmapInfo) throws Exception {
        if (this.f35821i.c() != null) {
            cancel();
            return;
        }
        Exception exc = bitmapInfo.exception;
        if (exc != null) {
            setComplete(exc);
        } else {
            setComplete((c) bitmapInfo.bitmap);
        }
    }
}
