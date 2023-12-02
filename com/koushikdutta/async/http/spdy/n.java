package com.koushikdutta.async.http.spdy;

import com.koushikdutta.async.BufferedDataSink;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.http.spdy.FrameReader;

/* compiled from: Variant.java */
/* loaded from: classes6.dex */
interface n {
    c a(BufferedDataSink bufferedDataSink, boolean z3);

    FrameReader b(DataEmitter dataEmitter, FrameReader.Handler handler, boolean z3);
}
