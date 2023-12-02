package com.koushikdutta.async;

import android.util.Log;
import com.koushikdutta.async.callback.DataCallback;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;

/* loaded from: classes6.dex */
public class PushParser implements DataCallback {

    /* renamed from: n  reason: collision with root package name */
    static Hashtable<Class, Method> f34790n = new Hashtable<>();

    /* renamed from: i  reason: collision with root package name */
    DataEmitter f34799i;

    /* renamed from: a  reason: collision with root package name */
    private p f34791a = new a(0);

    /* renamed from: b  reason: collision with root package name */
    private p f34792b = new b(1);

    /* renamed from: c  reason: collision with root package name */
    private p f34793c = new c(2);

    /* renamed from: d  reason: collision with root package name */
    private p f34794d = new d(4);

    /* renamed from: e  reason: collision with root package name */
    private p f34795e = new e(8);

    /* renamed from: f  reason: collision with root package name */
    private ParseCallback<byte[]> f34796f = new f();

    /* renamed from: g  reason: collision with root package name */
    private ParseCallback<ByteBufferList> f34797g = new g();

    /* renamed from: h  reason: collision with root package name */
    private ParseCallback<byte[]> f34798h = new h();

    /* renamed from: j  reason: collision with root package name */
    private LinkedList<p> f34800j = new LinkedList<>();

    /* renamed from: k  reason: collision with root package name */
    private ArrayList<Object> f34801k = new ArrayList<>();

    /* renamed from: l  reason: collision with root package name */
    ByteOrder f34802l = ByteOrder.BIG_ENDIAN;

    /* renamed from: m  reason: collision with root package name */
    ByteBufferList f34803m = new ByteBufferList();

    /* loaded from: classes6.dex */
    public interface ParseCallback<T> {
        void parsed(T t3);
    }

    /* loaded from: classes6.dex */
    class a extends p {
        a(int i4) {
            super(i4);
        }

        @Override // com.koushikdutta.async.PushParser.p
        public p a(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            PushParser.this.f34801k.add(null);
            return null;
        }
    }

    /* loaded from: classes6.dex */
    class b extends p {
        b(int i4) {
            super(i4);
        }

        @Override // com.koushikdutta.async.PushParser.p
        public p a(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            PushParser.this.f34801k.add(Byte.valueOf(byteBufferList.get()));
            return null;
        }
    }

    /* loaded from: classes6.dex */
    class c extends p {
        c(int i4) {
            super(i4);
        }

        @Override // com.koushikdutta.async.PushParser.p
        public p a(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            PushParser.this.f34801k.add(Short.valueOf(byteBufferList.getShort()));
            return null;
        }
    }

    /* loaded from: classes6.dex */
    class d extends p {
        d(int i4) {
            super(i4);
        }

        @Override // com.koushikdutta.async.PushParser.p
        public p a(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            PushParser.this.f34801k.add(Integer.valueOf(byteBufferList.getInt()));
            return null;
        }
    }

    /* loaded from: classes6.dex */
    class e extends p {
        e(int i4) {
            super(i4);
        }

        @Override // com.koushikdutta.async.PushParser.p
        public p a(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            PushParser.this.f34801k.add(Long.valueOf(byteBufferList.getLong()));
            return null;
        }
    }

    /* loaded from: classes6.dex */
    class f implements ParseCallback<byte[]> {
        f() {
        }

        @Override // com.koushikdutta.async.PushParser.ParseCallback
        /* renamed from: a */
        public void parsed(byte[] bArr) {
            PushParser.this.f34801k.add(bArr);
        }
    }

    /* loaded from: classes6.dex */
    class g implements ParseCallback<ByteBufferList> {
        g() {
        }

        @Override // com.koushikdutta.async.PushParser.ParseCallback
        /* renamed from: a */
        public void parsed(ByteBufferList byteBufferList) {
            PushParser.this.f34801k.add(byteBufferList);
        }
    }

    /* loaded from: classes6.dex */
    class h implements ParseCallback<byte[]> {
        h() {
        }

        @Override // com.koushikdutta.async.PushParser.ParseCallback
        /* renamed from: a */
        public void parsed(byte[] bArr) {
            PushParser.this.f34801k.add(new String(bArr));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class i extends p {

        /* renamed from: b  reason: collision with root package name */
        ParseCallback<byte[]> f34812b;

        public i(int i4, ParseCallback<byte[]> parseCallback) {
            super(i4);
            if (i4 > 0) {
                this.f34812b = parseCallback;
                return;
            }
            throw new IllegalArgumentException("length should be > 0");
        }

        @Override // com.koushikdutta.async.PushParser.p
        public p a(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            byte[] bArr = new byte[this.f34821a];
            byteBufferList.get(bArr);
            this.f34812b.parsed(bArr);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class j extends p {

        /* renamed from: b  reason: collision with root package name */
        ParseCallback<ByteBufferList> f34813b;

        public j(int i4, ParseCallback<ByteBufferList> parseCallback) {
            super(i4);
            if (i4 > 0) {
                this.f34813b = parseCallback;
                return;
            }
            throw new IllegalArgumentException("length should be > 0");
        }

        @Override // com.koushikdutta.async.PushParser.p
        public p a(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            this.f34813b.parsed(byteBufferList.get(this.f34821a));
            return null;
        }
    }

    /* loaded from: classes6.dex */
    static class k extends p {

        /* renamed from: b  reason: collision with root package name */
        ParseCallback<Integer> f34814b;

        public k(ParseCallback<Integer> parseCallback) {
            super(4);
            this.f34814b = parseCallback;
        }

        @Override // com.koushikdutta.async.PushParser.p
        public p a(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            this.f34814b.parsed(Integer.valueOf(byteBufferList.getInt()));
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class l extends p {

        /* renamed from: b  reason: collision with root package name */
        private final ParseCallback<byte[]> f34815b;

        public l(ParseCallback<byte[]> parseCallback) {
            super(4);
            this.f34815b = parseCallback;
        }

        @Override // com.koushikdutta.async.PushParser.p
        public p a(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            int i4 = byteBufferList.getInt();
            if (i4 == 0) {
                this.f34815b.parsed(new byte[0]);
                return null;
            }
            return new i(i4, this.f34815b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class m extends p {

        /* renamed from: b  reason: collision with root package name */
        private final ParseCallback<ByteBufferList> f34816b;

        public m(ParseCallback<ByteBufferList> parseCallback) {
            super(4);
            this.f34816b = parseCallback;
        }

        @Override // com.koushikdutta.async.PushParser.p
        public p a(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            return new j(byteBufferList.getInt(), this.f34816b);
        }
    }

    /* loaded from: classes6.dex */
    private class n extends p {

        /* renamed from: b  reason: collision with root package name */
        private final TapCallback f34817b;

        public n(TapCallback tapCallback) {
            super(0);
            this.f34817b = tapCallback;
        }

        @Override // com.koushikdutta.async.PushParser.p
        public p a(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            Method b4 = PushParser.b(this.f34817b);
            b4.setAccessible(true);
            try {
                b4.invoke(this.f34817b, PushParser.this.f34801k.toArray());
            } catch (Exception e4) {
                Log.e("PushParser", "Error while invoking tap callback", e4);
            }
            PushParser.this.f34801k.clear();
            return null;
        }
    }

    /* loaded from: classes6.dex */
    static class o extends p {

        /* renamed from: b  reason: collision with root package name */
        byte f34819b;

        /* renamed from: c  reason: collision with root package name */
        DataCallback f34820c;

        public o(byte b4, DataCallback dataCallback) {
            super(1);
            this.f34819b = b4;
            this.f34820c = dataCallback;
        }

        @Override // com.koushikdutta.async.PushParser.p
        public p a(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            ByteBufferList byteBufferList2 = new ByteBufferList();
            boolean z3 = true;
            while (true) {
                if (byteBufferList.size() <= 0) {
                    break;
                }
                ByteBuffer remove = byteBufferList.remove();
                remove.mark();
                int i4 = 0;
                while (remove.remaining() > 0) {
                    if (remove.get() == this.f34819b) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z3) {
                        break;
                    }
                    i4++;
                }
                remove.reset();
                if (z3) {
                    byteBufferList.addFirst(remove);
                    byteBufferList.get(byteBufferList2, i4);
                    byteBufferList.get();
                    break;
                }
                byteBufferList2.add(remove);
            }
            this.f34820c.onDataAvailable(dataEmitter, byteBufferList2);
            if (z3) {
                return null;
            }
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static abstract class p {

        /* renamed from: a  reason: collision with root package name */
        int f34821a;

        public p(int i4) {
            this.f34821a = i4;
        }

        public abstract p a(DataEmitter dataEmitter, ByteBufferList byteBufferList);
    }

    public PushParser(DataEmitter dataEmitter) {
        this.f34799i = dataEmitter;
        dataEmitter.setDataCallback(this);
    }

    static Method b(TapCallback tapCallback) {
        Method[] methods;
        Method method = f34790n.get(tapCallback.getClass());
        if (method != null) {
            return method;
        }
        for (Method method2 : tapCallback.getClass().getMethods()) {
            if ("tap".equals(method2.getName())) {
                f34790n.put(tapCallback.getClass(), method2);
                return method2;
            }
        }
        Method[] declaredMethods = tapCallback.getClass().getDeclaredMethods();
        if (declaredMethods.length == 1) {
            return declaredMethods[0];
        }
        throw new AssertionError("-keep class * extends com.koushikdutta.async.TapCallback {\n    *;\n}\n");
    }

    public PushParser noop() {
        this.f34800j.add(this.f34791a);
        return this;
    }

    @Override // com.koushikdutta.async.callback.DataCallback
    public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
        byteBufferList.get(this.f34803m);
        while (this.f34800j.size() > 0 && this.f34803m.remaining() >= this.f34800j.peek().f34821a) {
            this.f34803m.order(this.f34802l);
            p a4 = this.f34800j.poll().a(dataEmitter, this.f34803m);
            if (a4 != null) {
                this.f34800j.addFirst(a4);
            }
        }
        if (this.f34800j.size() == 0) {
            this.f34803m.get(byteBufferList);
        }
    }

    public PushParser readByte() {
        this.f34800j.add(this.f34792b);
        return this;
    }

    public PushParser readByteArray(int i4, ParseCallback<byte[]> parseCallback) {
        this.f34800j.add(new i(i4, parseCallback));
        return this;
    }

    public PushParser readByteBufferList(int i4, ParseCallback<ByteBufferList> parseCallback) {
        this.f34800j.add(new j(i4, parseCallback));
        return this;
    }

    public PushParser readInt(ParseCallback<Integer> parseCallback) {
        this.f34800j.add(new k(parseCallback));
        return this;
    }

    public PushParser readLenByteArray() {
        this.f34800j.add(new l(this.f34796f));
        return this;
    }

    public PushParser readLenByteBufferList() {
        return readLenByteBufferList(this.f34797g);
    }

    public PushParser readLong() {
        this.f34800j.add(this.f34795e);
        return this;
    }

    public PushParser readShort() {
        this.f34800j.add(this.f34793c);
        return this;
    }

    public PushParser readString() {
        this.f34800j.add(new l(this.f34798h));
        return this;
    }

    public PushParser setOrder(ByteOrder byteOrder) {
        this.f34802l = byteOrder;
        return this;
    }

    public void tap(TapCallback tapCallback) {
        this.f34800j.add(new n(tapCallback));
    }

    public PushParser until(byte b4, DataCallback dataCallback) {
        this.f34800j.add(new o(b4, dataCallback));
        return this;
    }

    public PushParser readByteArray(int i4) {
        return i4 == -1 ? readLenByteArray() : readByteArray(i4, this.f34796f);
    }

    public PushParser readByteBufferList(int i4) {
        return i4 == -1 ? readLenByteBufferList() : readByteBufferList(i4, this.f34797g);
    }

    public PushParser readInt() {
        this.f34800j.add(this.f34794d);
        return this;
    }

    public PushParser readLenByteBufferList(ParseCallback<ByteBufferList> parseCallback) {
        this.f34800j.add(new m(parseCallback));
        return this;
    }
}
