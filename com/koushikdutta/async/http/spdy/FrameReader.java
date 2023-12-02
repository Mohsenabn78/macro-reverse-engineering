package com.koushikdutta.async.http.spdy;

import com.koushikdutta.async.ByteBufferList;
import java.util.List;

/* loaded from: classes6.dex */
interface FrameReader {

    /* loaded from: classes6.dex */
    public interface Handler {
        void ackSettings();

        void alternateService(int i4, String str, a aVar, String str2, int i5, long j4);

        void data(boolean z3, int i4, ByteBufferList byteBufferList);

        void error(Exception exc);

        void goAway(int i4, b bVar, a aVar);

        void headers(boolean z3, boolean z4, int i4, int i5, List<d> list, HeadersMode headersMode);

        void ping(boolean z3, int i4, int i5);

        void priority(int i4, int i5, int i6, boolean z3);

        void pushPromise(int i4, int i5, List<d> list);

        void rstStream(int i4, b bVar);

        void settings(boolean z3, j jVar);

        void windowUpdate(int i4, long j4);
    }
}
