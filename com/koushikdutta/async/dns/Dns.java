package com.koushikdutta.async.dns;

import com.koushikdutta.async.AsyncDatagramSocket;
import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.future.Cancellable;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.future.SimpleFuture;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Random;

/* loaded from: classes6.dex */
public class Dns {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a extends SimpleFuture<DnsResponse> {

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ AsyncDatagramSocket f34854i;

        a(AsyncDatagramSocket asyncDatagramSocket) {
            this.f34854i = asyncDatagramSocket;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.koushikdutta.async.future.SimpleCancellable
        public void b() {
            super.b();
            this.f34854i.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class b implements DataCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AsyncDatagramSocket f34855a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f34856b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ SimpleFuture f34857c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ FutureCallback f34858d;

        b(AsyncDatagramSocket asyncDatagramSocket, boolean z3, SimpleFuture simpleFuture, FutureCallback futureCallback) {
            this.f34855a = asyncDatagramSocket;
            this.f34856b = z3;
            this.f34857c = simpleFuture;
            this.f34858d = futureCallback;
        }

        @Override // com.koushikdutta.async.callback.DataCallback
        public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            try {
                DnsResponse parse = DnsResponse.parse(byteBufferList);
                parse.source = this.f34855a.getRemoteAddress();
                if (!this.f34856b) {
                    this.f34855a.close();
                    this.f34857c.setComplete((SimpleFuture) parse);
                } else {
                    this.f34858d.onCompleted(null, parse);
                }
            } catch (Exception unused) {
            }
            byteBufferList.recycle();
        }
    }

    private static void a(ByteBuffer byteBuffer, String str) {
        String[] split;
        for (String str2 : str.split("\\.")) {
            byteBuffer.put((byte) str2.length());
            byteBuffer.put(str2.getBytes());
        }
        byteBuffer.put((byte) 0);
    }

    private static int b(int i4, int i5, int i6) {
        return i4 | (i5 << i6);
    }

    private static int c(int i4) {
        return b(i4, 0, 0);
    }

    private static int d(int i4) {
        return b(i4, 1, 8);
    }

    public static Future<DnsResponse> lookup(String str) {
        return lookup(AsyncServer.getDefault(), str, false, null);
    }

    public static Cancellable multicastLookup(AsyncServer asyncServer, String str, FutureCallback<DnsResponse> futureCallback) {
        return lookup(asyncServer, str, true, futureCallback);
    }

    public static Future<DnsResponse> lookup(AsyncServer asyncServer, String str) {
        return lookup(asyncServer, str, false, null);
    }

    public static Cancellable multicastLookup(String str, FutureCallback<DnsResponse> futureCallback) {
        return multicastLookup(AsyncServer.getDefault(), str, futureCallback);
    }

    public static Future<DnsResponse> lookup(AsyncServer asyncServer, String str, boolean z3, FutureCallback<DnsResponse> futureCallback) {
        AsyncDatagramSocket openDatagram;
        ByteBuffer order = ByteBufferList.obtain(1024).order(ByteOrder.BIG_ENDIAN);
        short nextInt = (short) new Random().nextInt();
        short c4 = (short) c(0);
        if (!z3) {
            c4 = (short) d(c4);
        }
        order.putShort(nextInt);
        order.putShort(c4);
        order.putShort(z3 ? (short) 1 : (short) 2);
        order.putShort((short) 0);
        order.putShort((short) 0);
        order.putShort((short) 0);
        a(order, str);
        order.putShort(z3 ? (short) 12 : (short) 1);
        order.putShort((short) 1);
        if (!z3) {
            a(order, str);
            order.putShort((short) 28);
            order.putShort((short) 1);
        }
        order.flip();
        try {
            if (!z3) {
                openDatagram = asyncServer.connectDatagram(new InetSocketAddress("8.8.8.8", 53));
            } else {
                openDatagram = AsyncServer.getDefault().openDatagram(new InetSocketAddress(0), true);
                Field declaredField = DatagramSocket.class.getDeclaredField("impl");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(openDatagram.getSocket());
                Method declaredMethod = obj.getClass().getDeclaredMethod("join", InetAddress.class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(obj, InetAddress.getByName("224.0.0.251"));
                ((DatagramSocket) openDatagram.getSocket()).setBroadcast(true);
            }
            a aVar = new a(openDatagram);
            openDatagram.setDataCallback(new b(openDatagram, z3, aVar, futureCallback));
            if (!z3) {
                openDatagram.write(new ByteBufferList(order));
            } else {
                openDatagram.send(new InetSocketAddress("224.0.0.251", 5353), order);
            }
            return aVar;
        } catch (Exception e4) {
            SimpleFuture simpleFuture = new SimpleFuture();
            simpleFuture.setComplete(e4);
            if (z3) {
                futureCallback.onCompleted(e4, null);
            }
            return simpleFuture;
        }
    }
}
