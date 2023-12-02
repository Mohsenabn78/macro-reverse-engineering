package com.koushikdutta.async;

import android.annotation.TargetApi;
import android.os.Looper;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.koushikdutta.async.util.Charsets;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

@TargetApi(9)
/* loaded from: classes6.dex */
public class ByteBufferList {

    /* renamed from: a  reason: collision with root package name */
    ArrayDeque<ByteBuffer> f34765a = new ArrayDeque<>();

    /* renamed from: b  reason: collision with root package name */
    ByteOrder f34766b = ByteOrder.BIG_ENDIAN;

    /* renamed from: c  reason: collision with root package name */
    private int f34767c = 0;

    /* renamed from: d  reason: collision with root package name */
    static PriorityQueue<ByteBuffer> f34760d = new PriorityQueue<>(8, new a());

    /* renamed from: e  reason: collision with root package name */
    private static int f34761e = 1048576;
    public static int MAX_ITEM_SIZE = 262144;

    /* renamed from: f  reason: collision with root package name */
    static int f34762f = 0;

    /* renamed from: g  reason: collision with root package name */
    static int f34763g = 0;

    /* renamed from: h  reason: collision with root package name */
    private static final Object f34764h = new Object();
    public static final ByteBuffer EMPTY_BYTEBUFFER = ByteBuffer.allocate(0);

    /* loaded from: classes6.dex */
    static class a implements Comparator<ByteBuffer> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
            if (byteBuffer.capacity() == byteBuffer2.capacity()) {
                return 0;
            }
            if (byteBuffer.capacity() > byteBuffer2.capacity()) {
                return 1;
            }
            return -1;
        }
    }

    public ByteBufferList() {
    }

    private void a(int i4) {
        if (remaining() >= 0) {
            this.f34767c += i4;
        }
    }

    private static PriorityQueue<ByteBuffer> b() {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null && Thread.currentThread() == mainLooper.getThread()) {
            return null;
        }
        return f34760d;
    }

    private ByteBuffer c(int i4) {
        ByteBuffer byteBuffer;
        if (remaining() >= i4) {
            ByteBuffer peek = this.f34765a.peek();
            while (peek != null && !peek.hasRemaining()) {
                reclaim(this.f34765a.remove());
                peek = this.f34765a.peek();
            }
            if (peek == null) {
                return EMPTY_BYTEBUFFER;
            }
            if (peek.remaining() >= i4) {
                return peek.order(this.f34766b);
            }
            ByteBuffer obtain = obtain(i4);
            obtain.limit(i4);
            byte[] array = obtain.array();
            int i5 = 0;
            loop1: while (true) {
                byteBuffer = null;
                while (i5 < i4) {
                    byteBuffer = this.f34765a.remove();
                    int min = Math.min(i4 - i5, byteBuffer.remaining());
                    byteBuffer.get(array, i5, min);
                    i5 += min;
                    if (byteBuffer.remaining() == 0) {
                        break;
                    }
                }
                reclaim(byteBuffer);
            }
            if (byteBuffer != null && byteBuffer.remaining() > 0) {
                this.f34765a.addFirst(byteBuffer);
            }
            this.f34765a.addFirst(obtain);
            return obtain.order(this.f34766b);
        }
        throw new IllegalArgumentException("count : " + remaining() + RemoteSettings.FORWARD_SLASH_STRING + i4);
    }

    public static ByteBuffer obtain(int i4) {
        PriorityQueue<ByteBuffer> b4;
        ByteBuffer remove;
        if (i4 <= f34763g && (b4 = b()) != null) {
            synchronized (f34764h) {
                do {
                    if (b4.size() > 0) {
                        remove = b4.remove();
                        if (b4.size() == 0) {
                            f34763g = 0;
                        }
                        f34762f -= remove.capacity();
                    }
                } while (remove.capacity() < i4);
                return remove;
            }
        }
        return ByteBuffer.allocate(Math.max(8192, i4));
    }

    public static void obtainArray(ByteBuffer[] byteBufferArr, int i4) {
        int i5;
        PriorityQueue<ByteBuffer> b4 = b();
        int i6 = 0;
        if (b4 != null) {
            synchronized (f34764h) {
                i5 = 0;
                while (b4.size() > 0 && i6 < i4 && i5 < byteBufferArr.length - 1) {
                    ByteBuffer remove = b4.remove();
                    f34762f -= remove.capacity();
                    i6 += Math.min(i4 - i6, remove.capacity());
                    byteBufferArr[i5] = remove;
                    i5++;
                }
            }
        } else {
            i5 = 0;
        }
        if (i6 < i4) {
            byteBufferArr[i5] = ByteBuffer.allocate(Math.max(8192, i4 - i6));
            i5++;
        }
        while (i5 < byteBufferArr.length) {
            byteBufferArr[i5] = EMPTY_BYTEBUFFER;
            i5++;
        }
    }

    public static void reclaim(ByteBuffer byteBuffer) {
        PriorityQueue<ByteBuffer> b4;
        if (byteBuffer == null || byteBuffer.isDirect() || byteBuffer.arrayOffset() != 0 || byteBuffer.array().length != byteBuffer.capacity() || byteBuffer.capacity() < 8192 || byteBuffer.capacity() > MAX_ITEM_SIZE || (b4 = b()) == null) {
            return;
        }
        synchronized (f34764h) {
            while (f34762f > f34761e && b4.size() > 0 && b4.peek().capacity() < byteBuffer.capacity()) {
                f34762f -= b4.remove().capacity();
            }
            if (f34762f > f34761e) {
                return;
            }
            byteBuffer.position(0);
            byteBuffer.limit(byteBuffer.capacity());
            f34762f += byteBuffer.capacity();
            b4.add(byteBuffer);
            f34763g = Math.max(f34763g, byteBuffer.capacity());
        }
    }

    public static void setMaxItemSize(int i4) {
        MAX_ITEM_SIZE = i4;
    }

    public static void setMaxPoolSize(int i4) {
        f34761e = i4;
    }

    public static void writeOutputStream(OutputStream outputStream, ByteBuffer byteBuffer) throws IOException {
        byte[] array;
        int remaining;
        int i4;
        if (byteBuffer.isDirect()) {
            array = new byte[byteBuffer.remaining()];
            remaining = byteBuffer.remaining();
            byteBuffer.get(array);
            i4 = 0;
        } else {
            array = byteBuffer.array();
            int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
            remaining = byteBuffer.remaining();
            i4 = arrayOffset;
        }
        outputStream.write(array, i4, remaining);
    }

    public ByteBufferList add(ByteBufferList byteBufferList) {
        byteBufferList.get(this);
        return this;
    }

    public ByteBufferList addAll(ByteBuffer... byteBufferArr) {
        for (ByteBuffer byteBuffer : byteBufferArr) {
            add(byteBuffer);
        }
        return this;
    }

    public void addFirst(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= 0) {
            reclaim(byteBuffer);
            return;
        }
        a(byteBuffer.remaining());
        if (this.f34765a.size() > 0) {
            ByteBuffer first = this.f34765a.getFirst();
            if (first.position() >= byteBuffer.remaining()) {
                first.position(first.position() - byteBuffer.remaining());
                first.mark();
                first.put(byteBuffer);
                first.reset();
                reclaim(byteBuffer);
                return;
            }
        }
        this.f34765a.addFirst(byteBuffer);
    }

    public byte get() {
        byte b4 = c(1).get();
        this.f34767c--;
        return b4;
    }

    public ByteBuffer getAll() {
        if (remaining() == 0) {
            return EMPTY_BYTEBUFFER;
        }
        c(remaining());
        return remove();
    }

    public ByteBuffer[] getAllArray() {
        ByteBuffer[] byteBufferArr = (ByteBuffer[]) this.f34765a.toArray(new ByteBuffer[this.f34765a.size()]);
        this.f34765a.clear();
        this.f34767c = 0;
        return byteBufferArr;
    }

    public byte[] getAllByteArray() {
        if (this.f34765a.size() == 1) {
            ByteBuffer peek = this.f34765a.peek();
            if (peek.capacity() == remaining() && peek.isDirect()) {
                this.f34767c = 0;
                return this.f34765a.remove().array();
            }
        }
        byte[] bArr = new byte[remaining()];
        get(bArr);
        return bArr;
    }

    public char getByteChar() {
        char c4 = (char) c(1).get();
        this.f34767c--;
        return c4;
    }

    public byte[] getBytes(int i4) {
        byte[] bArr = new byte[i4];
        get(bArr);
        return bArr;
    }

    public int getInt() {
        int i4 = c(4).getInt();
        this.f34767c -= 4;
        return i4;
    }

    public long getLong() {
        long j4 = c(8).getLong();
        this.f34767c -= 8;
        return j4;
    }

    public short getShort() {
        short s3 = c(2).getShort();
        this.f34767c -= 2;
        return s3;
    }

    public boolean hasRemaining() {
        if (remaining() > 0) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if (this.f34767c == 0) {
            return true;
        }
        return false;
    }

    public ByteOrder order() {
        return this.f34766b;
    }

    public byte[] peekBytes(int i4) {
        byte[] bArr = new byte[i4];
        c(i4).duplicate().get(bArr);
        return bArr;
    }

    public int peekInt() {
        return c(4).duplicate().getInt();
    }

    public long peekLong() {
        return c(8).duplicate().getLong();
    }

    public short peekShort() {
        return c(2).duplicate().getShort();
    }

    public String peekString() {
        return peekString(null);
    }

    public String readString() {
        return readString(null);
    }

    public void recycle() {
        while (this.f34765a.size() > 0) {
            reclaim(this.f34765a.remove());
        }
        this.f34767c = 0;
    }

    public int remaining() {
        return this.f34767c;
    }

    public ByteBuffer remove() {
        ByteBuffer remove = this.f34765a.remove();
        this.f34767c -= remove.remaining();
        return remove;
    }

    public int size() {
        return this.f34765a.size();
    }

    public ByteBufferList skip(int i4) {
        get(null, 0, i4);
        return this;
    }

    public void spewString() {
        System.out.println(peekString());
    }

    public void trim() {
        c(0);
    }

    public ByteBufferList add(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= 0) {
            reclaim(byteBuffer);
            return this;
        }
        a(byteBuffer.remaining());
        if (this.f34765a.size() > 0) {
            ByteBuffer last = this.f34765a.getLast();
            if (last.capacity() - last.limit() >= byteBuffer.remaining()) {
                last.mark();
                last.position(last.limit());
                last.limit(last.capacity());
                last.put(byteBuffer);
                last.limit(last.position());
                last.reset();
                reclaim(byteBuffer);
                trim();
                return this;
            }
        }
        this.f34765a.add(byteBuffer);
        trim();
        return this;
    }

    public ByteBufferList order(ByteOrder byteOrder) {
        this.f34766b = byteOrder;
        return this;
    }

    public String peekString(Charset charset) {
        byte[] array;
        int remaining;
        int i4;
        if (charset == null) {
            charset = Charsets.US_ASCII;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<ByteBuffer> it = this.f34765a.iterator();
        while (it.hasNext()) {
            ByteBuffer next = it.next();
            if (next.isDirect()) {
                array = new byte[next.remaining()];
                remaining = next.remaining();
                next.get(array);
                i4 = 0;
            } else {
                array = next.array();
                int arrayOffset = next.arrayOffset() + next.position();
                remaining = next.remaining();
                i4 = arrayOffset;
            }
            sb.append(new String(array, i4, remaining, charset));
        }
        return sb.toString();
    }

    public String readString(Charset charset) {
        String peekString = peekString(charset);
        recycle();
        return peekString;
    }

    public ByteBufferList addAll(ByteBufferList... byteBufferListArr) {
        for (ByteBufferList byteBufferList : byteBufferListArr) {
            byteBufferList.get(this);
        }
        return this;
    }

    public void get(byte[] bArr) {
        get(bArr, 0, bArr.length);
    }

    public void get(byte[] bArr, int i4, int i5) {
        if (remaining() >= i5) {
            int i6 = i5;
            while (i6 > 0) {
                ByteBuffer peek = this.f34765a.peek();
                int min = Math.min(peek.remaining(), i6);
                if (bArr != null) {
                    peek.get(bArr, i4, min);
                } else {
                    peek.position(peek.position() + min);
                }
                i6 -= min;
                i4 += min;
                if (peek.remaining() == 0) {
                    this.f34765a.remove();
                    reclaim(peek);
                }
            }
            this.f34767c -= i5;
            return;
        }
        throw new IllegalArgumentException("length");
    }

    public ByteBufferList(ByteBuffer... byteBufferArr) {
        addAll(byteBufferArr);
    }

    public ByteBufferList(byte[] bArr) {
        add(ByteBuffer.wrap(bArr));
    }

    public void get(ByteBufferList byteBufferList, int i4) {
        if (remaining() >= i4) {
            int i5 = 0;
            while (true) {
                if (i5 >= i4) {
                    break;
                }
                ByteBuffer remove = this.f34765a.remove();
                int remaining = remove.remaining();
                if (remaining == 0) {
                    reclaim(remove);
                } else {
                    int i6 = remaining + i5;
                    if (i6 > i4) {
                        int i7 = i4 - i5;
                        ByteBuffer obtain = obtain(i7);
                        obtain.limit(i7);
                        remove.get(obtain.array(), 0, i7);
                        byteBufferList.add(obtain);
                        this.f34765a.addFirst(remove);
                        break;
                    }
                    byteBufferList.add(remove);
                    i5 = i6;
                }
            }
            this.f34767c -= i4;
            return;
        }
        throw new IllegalArgumentException("length");
    }

    public void get(ByteBufferList byteBufferList) {
        get(byteBufferList, remaining());
    }

    public ByteBufferList get(int i4) {
        ByteBufferList byteBufferList = new ByteBufferList();
        get(byteBufferList, i4);
        return byteBufferList.order(this.f34766b);
    }
}
