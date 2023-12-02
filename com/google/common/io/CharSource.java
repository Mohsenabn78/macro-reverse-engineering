package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@J2ktIncompatible
@GwtIncompatible
/* loaded from: classes5.dex */
public abstract class CharSource {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public final class AsByteSource extends ByteSource {

        /* renamed from: a  reason: collision with root package name */
        final Charset f27984a;

        AsByteSource(Charset charset) {
            this.f27984a = (Charset) Preconditions.checkNotNull(charset);
        }

        @Override // com.google.common.io.ByteSource
        public CharSource asCharSource(Charset charset) {
            if (charset.equals(this.f27984a)) {
                return CharSource.this;
            }
            return super.asCharSource(charset);
        }

        @Override // com.google.common.io.ByteSource
        public InputStream openStream() throws IOException {
            return new ReaderInputStream(CharSource.this.openStream(), this.f27984a, 8192);
        }

        public String toString() {
            return CharSource.this.toString() + ".asByteSource(" + this.f27984a + ")";
        }
    }

    /* loaded from: classes5.dex */
    private static class CharSequenceCharSource extends CharSource {

        /* renamed from: b  reason: collision with root package name */
        private static final Splitter f27986b = Splitter.onPattern("\r\n|\n|\r");

        /* renamed from: a  reason: collision with root package name */
        protected final CharSequence f27987a;

        protected CharSequenceCharSource(CharSequence charSequence) {
            this.f27987a = (CharSequence) Preconditions.checkNotNull(charSequence);
        }

        private Iterator<String> c() {
            return new AbstractIterator<String>() { // from class: com.google.common.io.CharSource.CharSequenceCharSource.1

                /* renamed from: c  reason: collision with root package name */
                Iterator<String> f27988c;

                {
                    this.f27988c = CharSequenceCharSource.f27986b.split(CharSequenceCharSource.this.f27987a).iterator();
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.common.collect.AbstractIterator
                @CheckForNull
                /* renamed from: d */
                public String a() {
                    if (this.f27988c.hasNext()) {
                        String next = this.f27988c.next();
                        if (this.f27988c.hasNext() || !next.isEmpty()) {
                            return next;
                        }
                    }
                    return b();
                }
            };
        }

        @Override // com.google.common.io.CharSource
        public boolean isEmpty() {
            if (this.f27987a.length() == 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.common.io.CharSource
        public long length() {
            return this.f27987a.length();
        }

        @Override // com.google.common.io.CharSource
        public Optional<Long> lengthIfKnown() {
            return Optional.of(Long.valueOf(this.f27987a.length()));
        }

        @Override // com.google.common.io.CharSource
        public Reader openStream() {
            return new CharSequenceReader(this.f27987a);
        }

        @Override // com.google.common.io.CharSource
        public String read() {
            return this.f27987a.toString();
        }

        @Override // com.google.common.io.CharSource
        @CheckForNull
        public String readFirstLine() {
            Iterator<String> c4 = c();
            if (c4.hasNext()) {
                return c4.next();
            }
            return null;
        }

        @Override // com.google.common.io.CharSource
        public ImmutableList<String> readLines() {
            return ImmutableList.copyOf(c());
        }

        public String toString() {
            return "CharSource.wrap(" + Ascii.truncate(this.f27987a, 30, "...") + ")";
        }

        @Override // com.google.common.io.CharSource
        @ParametricNullness
        public <T> T readLines(LineProcessor<T> lineProcessor) throws IOException {
            Iterator<String> c4 = c();
            while (c4.hasNext() && lineProcessor.processLine(c4.next())) {
            }
            return lineProcessor.getResult();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class ConcatenatedCharSource extends CharSource {

        /* renamed from: a  reason: collision with root package name */
        private final Iterable<? extends CharSource> f27990a;

        ConcatenatedCharSource(Iterable<? extends CharSource> iterable) {
            this.f27990a = (Iterable) Preconditions.checkNotNull(iterable);
        }

        @Override // com.google.common.io.CharSource
        public boolean isEmpty() throws IOException {
            for (CharSource charSource : this.f27990a) {
                if (!charSource.isEmpty()) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.io.CharSource
        public long length() throws IOException {
            long j4 = 0;
            for (CharSource charSource : this.f27990a) {
                j4 += charSource.length();
            }
            return j4;
        }

        @Override // com.google.common.io.CharSource
        public Optional<Long> lengthIfKnown() {
            long j4 = 0;
            for (CharSource charSource : this.f27990a) {
                Optional<Long> lengthIfKnown = charSource.lengthIfKnown();
                if (!lengthIfKnown.isPresent()) {
                    return Optional.absent();
                }
                j4 += lengthIfKnown.get().longValue();
            }
            return Optional.of(Long.valueOf(j4));
        }

        @Override // com.google.common.io.CharSource
        public Reader openStream() throws IOException {
            return new MultiReader(this.f27990a.iterator());
        }

        public String toString() {
            return "CharSource.concat(" + this.f27990a + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class EmptyCharSource extends StringCharSource {

        /* renamed from: c  reason: collision with root package name */
        private static final EmptyCharSource f27991c = new EmptyCharSource();

        private EmptyCharSource() {
            super("");
        }

        @Override // com.google.common.io.CharSource.CharSequenceCharSource
        public String toString() {
            return "CharSource.empty()";
        }
    }

    private long a(Reader reader) throws IOException {
        long j4 = 0;
        while (true) {
            long skip = reader.skip(Long.MAX_VALUE);
            if (skip != 0) {
                j4 += skip;
            } else {
                return j4;
            }
        }
    }

    public static CharSource concat(Iterable<? extends CharSource> iterable) {
        return new ConcatenatedCharSource(iterable);
    }

    public static CharSource empty() {
        return EmptyCharSource.f27991c;
    }

    public static CharSource wrap(CharSequence charSequence) {
        if (charSequence instanceof String) {
            return new StringCharSource((String) charSequence);
        }
        return new CharSequenceCharSource(charSequence);
    }

    public ByteSource asByteSource(Charset charset) {
        return new AsByteSource(charset);
    }

    @CanIgnoreReturnValue
    public long copyTo(Appendable appendable) throws IOException {
        Preconditions.checkNotNull(appendable);
        try {
            return CharStreams.copy((Reader) Closer.create().register(openStream()), appendable);
        } finally {
        }
    }

    public boolean isEmpty() throws IOException {
        Optional<Long> lengthIfKnown = lengthIfKnown();
        boolean z3 = true;
        if (lengthIfKnown.isPresent()) {
            if (lengthIfKnown.get().longValue() == 0) {
                return true;
            }
            return false;
        }
        Closer create = Closer.create();
        try {
            if (((Reader) create.register(openStream())).read() != -1) {
                z3 = false;
            }
            return z3;
        } catch (Throwable th) {
            try {
                throw create.rethrow(th);
            } finally {
                create.close();
            }
        }
    }

    public long length() throws IOException {
        Optional<Long> lengthIfKnown = lengthIfKnown();
        if (lengthIfKnown.isPresent()) {
            return lengthIfKnown.get().longValue();
        }
        try {
            return a((Reader) Closer.create().register(openStream()));
        } finally {
        }
    }

    public Optional<Long> lengthIfKnown() {
        return Optional.absent();
    }

    public BufferedReader openBufferedStream() throws IOException {
        Reader openStream = openStream();
        if (openStream instanceof BufferedReader) {
            return (BufferedReader) openStream;
        }
        return new BufferedReader(openStream);
    }

    public abstract Reader openStream() throws IOException;

    public String read() throws IOException {
        try {
            return CharStreams.toString((Reader) Closer.create().register(openStream()));
        } finally {
        }
    }

    @CheckForNull
    public String readFirstLine() throws IOException {
        try {
            return ((BufferedReader) Closer.create().register(openBufferedStream())).readLine();
        } finally {
        }
    }

    public ImmutableList<String> readLines() throws IOException {
        try {
            BufferedReader bufferedReader = (BufferedReader) Closer.create().register(openBufferedStream());
            ArrayList newArrayList = Lists.newArrayList();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    newArrayList.add(readLine);
                } else {
                    return ImmutableList.copyOf((Collection) newArrayList);
                }
            }
        } finally {
        }
    }

    /* loaded from: classes5.dex */
    private static class StringCharSource extends CharSequenceCharSource {
        protected StringCharSource(String str) {
            super(str);
        }

        @Override // com.google.common.io.CharSource
        public long copyTo(Appendable appendable) throws IOException {
            appendable.append(this.f27987a);
            return this.f27987a.length();
        }

        @Override // com.google.common.io.CharSource.CharSequenceCharSource, com.google.common.io.CharSource
        public Reader openStream() {
            return new StringReader((String) this.f27987a);
        }

        @Override // com.google.common.io.CharSource
        public long copyTo(CharSink charSink) throws IOException {
            Closer create;
            Preconditions.checkNotNull(charSink);
            try {
                ((Writer) Closer.create().register(charSink.openStream())).write((String) this.f27987a);
                return this.f27987a.length();
            } finally {
            }
        }
    }

    public static CharSource concat(Iterator<? extends CharSource> it) {
        return concat(ImmutableList.copyOf(it));
    }

    public static CharSource concat(CharSource... charSourceArr) {
        return concat(ImmutableList.copyOf(charSourceArr));
    }

    @CanIgnoreReturnValue
    public long copyTo(CharSink charSink) throws IOException {
        Preconditions.checkNotNull(charSink);
        Closer create = Closer.create();
        try {
            return CharStreams.copy((Reader) create.register(openStream()), (Writer) create.register(charSink.openStream()));
        } finally {
        }
    }

    @CanIgnoreReturnValue
    @ParametricNullness
    public <T> T readLines(LineProcessor<T> lineProcessor) throws IOException {
        Preconditions.checkNotNull(lineProcessor);
        try {
            return (T) CharStreams.readLines((Reader) Closer.create().register(openStream()), lineProcessor);
        } finally {
        }
    }
}
