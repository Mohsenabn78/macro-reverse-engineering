package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@J2ktIncompatible
@GwtIncompatible
/* loaded from: classes5.dex */
public final class LineReader {

    /* renamed from: a  reason: collision with root package name */
    private final Readable f28023a;
    @CheckForNull

    /* renamed from: b  reason: collision with root package name */
    private final Reader f28024b;

    /* renamed from: c  reason: collision with root package name */
    private final CharBuffer f28025c;

    /* renamed from: d  reason: collision with root package name */
    private final char[] f28026d;

    /* renamed from: e  reason: collision with root package name */
    private final Queue<String> f28027e;

    /* renamed from: f  reason: collision with root package name */
    private final LineBuffer f28028f;

    public LineReader(Readable readable) {
        Reader reader;
        CharBuffer c4 = CharStreams.c();
        this.f28025c = c4;
        this.f28026d = c4.array();
        this.f28027e = new ArrayDeque();
        this.f28028f = new LineBuffer() { // from class: com.google.common.io.LineReader.1
            @Override // com.google.common.io.LineBuffer
            protected void d(String str, String str2) {
                LineReader.this.f28027e.add(str);
            }
        };
        this.f28023a = (Readable) Preconditions.checkNotNull(readable);
        if (readable instanceof Reader) {
            reader = (Reader) readable;
        } else {
            reader = null;
        }
        this.f28024b = reader;
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public String readLine() throws IOException {
        int read;
        while (true) {
            if (this.f28027e.peek() != null) {
                break;
            }
            Java8Compatibility.a(this.f28025c);
            Reader reader = this.f28024b;
            if (reader != null) {
                char[] cArr = this.f28026d;
                read = reader.read(cArr, 0, cArr.length);
            } else {
                read = this.f28023a.read(this.f28025c);
            }
            if (read == -1) {
                this.f28028f.b();
                break;
            }
            this.f28028f.a(this.f28026d, 0, read);
        }
        return this.f28027e.poll();
    }
}
