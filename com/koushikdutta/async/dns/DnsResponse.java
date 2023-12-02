package com.koushikdutta.async.dns;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.http.Multimap;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes6.dex */
public class DnsResponse {
    public InetSocketAddress source;
    public ArrayList<InetAddress> addresses = new ArrayList<>();
    public ArrayList<String> names = new ArrayList<>();
    public Multimap txt = new Multimap();

    private static String a(ByteBufferList byteBufferList, ByteBuffer byteBuffer) {
        byte[] bArr;
        byteBufferList.order(ByteOrder.BIG_ENDIAN);
        String str = "";
        while (true) {
            int i4 = byteBufferList.get() & 255;
            if (i4 != 0) {
                if ((i4 & 192) == 192) {
                    int i5 = (byteBufferList.get() & 255) | ((i4 & 63) << 8);
                    if (str.length() > 0) {
                        str = str + ".";
                    }
                    ByteBufferList byteBufferList2 = new ByteBufferList();
                    ByteBuffer duplicate = byteBuffer.duplicate();
                    duplicate.get(new byte[i5]);
                    byteBufferList2.add(duplicate);
                    return str + a(byteBufferList2, byteBuffer);
                }
                byteBufferList.get(new byte[i4]);
                if (str.length() > 0) {
                    str = str + ".";
                }
                str = str + new String(bArr);
            } else {
                return str;
            }
        }
    }

    public static DnsResponse parse(ByteBufferList byteBufferList) {
        ByteBuffer all = byteBufferList.getAll();
        byteBufferList.add(all.duplicate());
        byteBufferList.order(ByteOrder.BIG_ENDIAN);
        byteBufferList.getShort();
        byteBufferList.getShort();
        short s3 = byteBufferList.getShort();
        short s4 = byteBufferList.getShort();
        short s5 = byteBufferList.getShort();
        short s6 = byteBufferList.getShort();
        for (int i4 = 0; i4 < s3; i4++) {
            a(byteBufferList, all);
            byteBufferList.getShort();
            byteBufferList.getShort();
        }
        DnsResponse dnsResponse = new DnsResponse();
        for (int i5 = 0; i5 < s4; i5++) {
            a(byteBufferList, all);
            short s7 = byteBufferList.getShort();
            byteBufferList.getShort();
            byteBufferList.getInt();
            int i6 = byteBufferList.getShort();
            if (s7 == 1) {
                try {
                    byte[] bArr = new byte[i6];
                    byteBufferList.get(bArr);
                    dnsResponse.addresses.add(InetAddress.getByAddress(bArr));
                } catch (Exception unused) {
                }
            } else if (s7 == 12) {
                dnsResponse.names.add(a(byteBufferList, all));
            } else if (s7 == 16) {
                ByteBufferList byteBufferList2 = new ByteBufferList();
                byteBufferList.get(byteBufferList2, i6);
                dnsResponse.b(byteBufferList2);
            } else {
                byteBufferList.get(new byte[i6]);
            }
        }
        for (int i7 = 0; i7 < s5; i7++) {
            a(byteBufferList, all);
            byteBufferList.getShort();
            byteBufferList.getShort();
            byteBufferList.getInt();
            try {
                byteBufferList.get(new byte[byteBufferList.getShort()]);
            } catch (Exception unused2) {
            }
        }
        for (int i8 = 0; i8 < s6; i8++) {
            a(byteBufferList, all);
            short s8 = byteBufferList.getShort();
            byteBufferList.getShort();
            byteBufferList.getInt();
            int i9 = byteBufferList.getShort();
            if (s8 == 16) {
                try {
                    ByteBufferList byteBufferList3 = new ByteBufferList();
                    byteBufferList.get(byteBufferList3, i9);
                    dnsResponse.b(byteBufferList3);
                } catch (Exception unused3) {
                }
            } else {
                byteBufferList.get(new byte[i9]);
            }
        }
        return dnsResponse;
    }

    void b(ByteBufferList byteBufferList) {
        while (byteBufferList.hasRemaining()) {
            byte[] bArr = new byte[byteBufferList.get() & 255];
            byteBufferList.get(bArr);
            String[] split = new String(bArr).split("=");
            this.txt.add(split[0], split[1]);
        }
    }

    public String toString() {
        Iterator<InetAddress> it;
        Iterator<String> it2;
        String str = "addresses:\n";
        while (this.addresses.iterator().hasNext()) {
            str = str + it.next().toString() + "\n";
        }
        String str2 = str + "names:\n";
        while (this.names.iterator().hasNext()) {
            str2 = str2 + it2.next() + "\n";
        }
        return str2;
    }
}
