package com.koushikdutta.async.http.spdy;

import com.koushikdutta.async.ByteBufferList;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;

/* compiled from: FrameWriter.java */
/* loaded from: classes6.dex */
interface c extends Closeable {
    void a(j jVar) throws IOException;

    void ackSettings() throws IOException;

    void connectionPreface() throws IOException;

    void data(boolean z3, int i4, ByteBufferList byteBufferList) throws IOException;

    void ping(boolean z3, int i4, int i5) throws IOException;

    void pushPromise(int i4, int i5, List<d> list) throws IOException;

    void rstStream(int i4, b bVar) throws IOException;

    void synStream(boolean z3, boolean z4, int i4, int i5, List<d> list) throws IOException;

    void windowUpdate(int i4, long j4) throws IOException;
}
