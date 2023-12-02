package com.google.common.net;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.CharMatcher;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.hash.Hashing;
import com.google.common.io.ByteStreams;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import javax.annotation.CheckForNull;
import kotlin.UShort;

@J2ktIncompatible
@GwtIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class InetAddresses {

    /* renamed from: a  reason: collision with root package name */
    private static final CharMatcher f28100a = CharMatcher.is('.');

    /* renamed from: b  reason: collision with root package name */
    private static final CharMatcher f28101b = CharMatcher.is(':');

    /* renamed from: c  reason: collision with root package name */
    private static final Inet4Address f28102c = (Inet4Address) forString("127.0.0.1");

    /* renamed from: d  reason: collision with root package name */
    private static final Inet4Address f28103d = (Inet4Address) forString("0.0.0.0");

    /* loaded from: classes5.dex */
    public static final class TeredoInfo {

        /* renamed from: a  reason: collision with root package name */
        private final Inet4Address f28104a;

        /* renamed from: b  reason: collision with root package name */
        private final Inet4Address f28105b;

        /* renamed from: c  reason: collision with root package name */
        private final int f28106c;

        /* renamed from: d  reason: collision with root package name */
        private final int f28107d;

        public TeredoInfo(@CheckForNull Inet4Address inet4Address, @CheckForNull Inet4Address inet4Address2, int i4, int i5) {
            boolean z3;
            boolean z4 = true;
            if (i4 >= 0 && i4 <= 65535) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "port '%s' is out of range (0 <= port <= 0xffff)", i4);
            Preconditions.checkArgument((i5 < 0 || i5 > 65535) ? false : false, "flags '%s' is out of range (0 <= flags <= 0xffff)", i5);
            this.f28104a = (Inet4Address) MoreObjects.firstNonNull(inet4Address, InetAddresses.f28103d);
            this.f28105b = (Inet4Address) MoreObjects.firstNonNull(inet4Address2, InetAddresses.f28103d);
            this.f28106c = i4;
            this.f28107d = i5;
        }

        public Inet4Address getClient() {
            return this.f28105b;
        }

        public int getFlags() {
            return this.f28107d;
        }

        public int getPort() {
            return this.f28106c;
        }

        public Inet4Address getServer() {
            return this.f28104a;
        }
    }

    private InetAddresses() {
    }

    private static InetAddress b(byte[] bArr) {
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException e4) {
            throw new AssertionError(e4);
        }
    }

    private static void c(int[] iArr) {
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        for (int i7 = 0; i7 < iArr.length + 1; i7++) {
            if (i7 < iArr.length && iArr[i7] == 0) {
                if (i6 < 0) {
                    i6 = i7;
                }
            } else if (i6 >= 0) {
                int i8 = i7 - i6;
                if (i8 > i4) {
                    i5 = i6;
                    i4 = i8;
                }
                i6 = -1;
            }
        }
        if (i4 >= 2) {
            Arrays.fill(iArr, i5, i4 + i5, -1);
        }
    }

    public static int coerceToInteger(InetAddress inetAddress) {
        return ByteStreams.newDataInput(getCoercedIPv4Address(inetAddress).getAddress()).readInt();
    }

    @CheckForNull
    private static String d(String str) {
        int lastIndexOf = str.lastIndexOf(58) + 1;
        String substring = str.substring(0, lastIndexOf);
        byte[] m4 = m(str.substring(lastIndexOf));
        if (m4 == null) {
            return null;
        }
        String hexString = Integer.toHexString(((m4[0] & 255) << 8) | (m4[1] & 255));
        String hexString2 = Integer.toHexString((m4[3] & 255) | ((m4[2] & 255) << 8));
        return substring + hexString + ":" + hexString2;
    }

    public static InetAddress decrement(InetAddress inetAddress) {
        boolean z3;
        byte[] address = inetAddress.getAddress();
        int length = address.length - 1;
        while (length >= 0 && address[length] == 0) {
            address[length] = -1;
            length--;
        }
        if (length >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "Decrementing %s would wrap.", inetAddress);
        address[length] = (byte) (address[length] - 1);
        return b(address);
    }

    @CheckForNull
    private static InetAddress e(String str) {
        int i4;
        Preconditions.checkNotNull(str);
        if (str.startsWith("[") && str.endsWith("]")) {
            str = str.substring(1, str.length() - 1);
            i4 = 16;
        } else {
            i4 = 4;
        }
        byte[] j4 = j(str);
        if (j4 != null && j4.length == i4) {
            return b(j4);
        }
        return null;
    }

    private static IllegalArgumentException f(String str, Object... objArr) {
        return new IllegalArgumentException(String.format(Locale.ROOT, str, objArr));
    }

    @CanIgnoreReturnValue
    public static InetAddress forString(String str) {
        byte[] j4 = j(str);
        if (j4 != null) {
            return b(j4);
        }
        throw f("'%s' is not an IP string literal.", str);
    }

    public static InetAddress forUriString(String str) {
        InetAddress e4 = e(str);
        if (e4 != null) {
            return e4;
        }
        throw f("Not a valid URI IP literal: '%s'", str);
    }

    public static Inet4Address fromIPv4BigInteger(BigInteger bigInteger) {
        return (Inet4Address) g(bigInteger, false);
    }

    public static Inet6Address fromIPv6BigInteger(BigInteger bigInteger) {
        return (Inet6Address) g(bigInteger, true);
    }

    public static Inet4Address fromInteger(int i4) {
        return h(Ints.toByteArray(i4));
    }

    public static InetAddress fromLittleEndianByteArray(byte[] bArr) throws UnknownHostException {
        byte[] bArr2 = new byte[bArr.length];
        for (int i4 = 0; i4 < bArr.length; i4++) {
            bArr2[i4] = bArr[(bArr.length - i4) - 1];
        }
        return InetAddress.getByAddress(bArr2);
    }

    private static InetAddress g(BigInteger bigInteger, boolean z3) {
        boolean z4;
        int i4;
        if (bigInteger.signum() >= 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        Preconditions.checkArgument(z4, "BigInteger must be greater than or equal to 0");
        if (z3) {
            i4 = 16;
        } else {
            i4 = 4;
        }
        byte[] byteArray = bigInteger.toByteArray();
        byte[] bArr = new byte[i4];
        int max = Math.max(0, byteArray.length - i4);
        int length = byteArray.length - max;
        int i5 = i4 - length;
        for (int i6 = 0; i6 < max; i6++) {
            if (byteArray[i6] != 0) {
                throw f("BigInteger cannot be converted to InetAddress because it has more than %d bytes: %s", Integer.valueOf(i4), bigInteger);
            }
        }
        System.arraycopy(byteArray, max, bArr, i5, length);
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException e4) {
            throw new AssertionError(e4);
        }
    }

    public static Inet4Address get6to4IPv4Address(Inet6Address inet6Address) {
        Preconditions.checkArgument(is6to4Address(inet6Address), "Address '%s' is not a 6to4 address.", toAddrString(inet6Address));
        return h(Arrays.copyOfRange(inet6Address.getAddress(), 2, 6));
    }

    public static Inet4Address getCoercedIPv4Address(InetAddress inetAddress) {
        boolean z3;
        long j4;
        if (inetAddress instanceof Inet4Address) {
            return (Inet4Address) inetAddress;
        }
        byte[] address = inetAddress.getAddress();
        int i4 = 0;
        while (true) {
            if (i4 < 15) {
                if (address[i4] != 0) {
                    z3 = false;
                    break;
                }
                i4++;
            } else {
                z3 = true;
                break;
            }
        }
        if (z3 && address[15] == 1) {
            return f28102c;
        }
        if (z3 && address[15] == 0) {
            return f28103d;
        }
        Inet6Address inet6Address = (Inet6Address) inetAddress;
        if (hasEmbeddedIPv4ClientAddress(inet6Address)) {
            j4 = getEmbeddedIPv4ClientAddress(inet6Address).hashCode();
        } else {
            j4 = ByteBuffer.wrap(inet6Address.getAddress(), 0, 8).getLong();
        }
        int asInt = Hashing.murmur3_32_fixed().hashLong(j4).asInt() | (-536870912);
        if (asInt == -1) {
            asInt = -2;
        }
        return h(Ints.toByteArray(asInt));
    }

    public static Inet4Address getCompatIPv4Address(Inet6Address inet6Address) {
        Preconditions.checkArgument(isCompatIPv4Address(inet6Address), "Address '%s' is not IPv4-compatible.", toAddrString(inet6Address));
        return h(Arrays.copyOfRange(inet6Address.getAddress(), 12, 16));
    }

    public static Inet4Address getEmbeddedIPv4ClientAddress(Inet6Address inet6Address) {
        if (isCompatIPv4Address(inet6Address)) {
            return getCompatIPv4Address(inet6Address);
        }
        if (is6to4Address(inet6Address)) {
            return get6to4IPv4Address(inet6Address);
        }
        if (isTeredoAddress(inet6Address)) {
            return getTeredoInfo(inet6Address).getClient();
        }
        throw f("'%s' has no embedded IPv4 address.", toAddrString(inet6Address));
    }

    public static Inet4Address getIsatapIPv4Address(Inet6Address inet6Address) {
        Preconditions.checkArgument(isIsatapAddress(inet6Address), "Address '%s' is not an ISATAP address.", toAddrString(inet6Address));
        return h(Arrays.copyOfRange(inet6Address.getAddress(), 12, 16));
    }

    public static TeredoInfo getTeredoInfo(Inet6Address inet6Address) {
        Preconditions.checkArgument(isTeredoAddress(inet6Address), "Address '%s' is not a Teredo address.", toAddrString(inet6Address));
        byte[] address = inet6Address.getAddress();
        Inet4Address h4 = h(Arrays.copyOfRange(address, 4, 8));
        int readShort = ByteStreams.newDataInput(address, 8).readShort() & UShort.MAX_VALUE;
        int i4 = 65535 & (~ByteStreams.newDataInput(address, 10).readShort());
        byte[] copyOfRange = Arrays.copyOfRange(address, 12, 16);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) (~copyOfRange[i5]);
        }
        return new TeredoInfo(h4, h(copyOfRange), i4, readShort);
    }

    private static Inet4Address h(byte[] bArr) {
        boolean z3;
        if (bArr.length == 4) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "Byte array has invalid length for an IPv4 address: %s != 4.", bArr.length);
        return (Inet4Address) b(bArr);
    }

    public static boolean hasEmbeddedIPv4ClientAddress(Inet6Address inet6Address) {
        if (!isCompatIPv4Address(inet6Address) && !is6to4Address(inet6Address) && !isTeredoAddress(inet6Address)) {
            return false;
        }
        return true;
    }

    private static String i(int[] iArr) {
        boolean z3;
        StringBuilder sb = new StringBuilder(39);
        int i4 = 0;
        boolean z4 = false;
        while (i4 < iArr.length) {
            if (iArr[i4] >= 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                if (z4) {
                    sb.append(':');
                }
                sb.append(Integer.toHexString(iArr[i4]));
            } else if (i4 == 0 || z4) {
                sb.append("::");
            }
            i4++;
            z4 = z3;
        }
        return sb.toString();
    }

    public static InetAddress increment(InetAddress inetAddress) {
        boolean z3;
        byte[] address = inetAddress.getAddress();
        int length = address.length - 1;
        while (true) {
            z3 = false;
            if (length < 0 || address[length] != -1) {
                break;
            }
            address[length] = 0;
            length--;
        }
        if (length >= 0) {
            z3 = true;
        }
        Preconditions.checkArgument(z3, "Incrementing %s would wrap.", inetAddress);
        address[length] = (byte) (address[length] + 1);
        return b(address);
    }

    public static boolean is6to4Address(Inet6Address inet6Address) {
        byte[] address = inet6Address.getAddress();
        if (address[0] != 32 || address[1] != 2) {
            return false;
        }
        return true;
    }

    public static boolean isCompatIPv4Address(Inet6Address inet6Address) {
        byte b4;
        if (!inet6Address.isIPv4CompatibleAddress()) {
            return false;
        }
        byte[] address = inet6Address.getAddress();
        if (address[12] == 0 && address[13] == 0 && address[14] == 0 && ((b4 = address[15]) == 0 || b4 == 1)) {
            return false;
        }
        return true;
    }

    public static boolean isInetAddress(String str) {
        if (j(str) != null) {
            return true;
        }
        return false;
    }

    public static boolean isIsatapAddress(Inet6Address inet6Address) {
        if (isTeredoAddress(inet6Address)) {
            return false;
        }
        byte[] address = inet6Address.getAddress();
        if ((address[8] | 3) != 3 || address[9] != 0 || address[10] != 94 || address[11] != -2) {
            return false;
        }
        return true;
    }

    public static boolean isMappedIPv4Address(String str) {
        byte[] j4 = j(str);
        if (j4 == null || j4.length != 16) {
            return false;
        }
        int i4 = 0;
        while (true) {
            if (i4 < 10) {
                if (j4[i4] != 0) {
                    return false;
                }
                i4++;
            } else {
                for (int i5 = 10; i5 < 12; i5++) {
                    if (j4[i5] != -1) {
                        return false;
                    }
                }
                return true;
            }
        }
    }

    public static boolean isMaximum(InetAddress inetAddress) {
        for (byte b4 : inetAddress.getAddress()) {
            if (b4 != -1) {
                return false;
            }
        }
        return true;
    }

    public static boolean isTeredoAddress(Inet6Address inet6Address) {
        byte[] address = inet6Address.getAddress();
        if (address[0] != 32 || address[1] != 1 || address[2] != 0 || address[3] != 0) {
            return false;
        }
        return true;
    }

    public static boolean isUriInetAddress(String str) {
        if (e(str) != null) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0032, code lost:
        if (r3 == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0034, code lost:
        if (r2 == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0036, code lost:
        r9 = d(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003a, code lost:
        if (r9 != null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003c, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003d, code lost:
        if (r1 == (-1)) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003f, code lost:
        r9 = r9.substring(0, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0047, code lost:
        return n(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0048, code lost:
        if (r2 == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x004a, code lost:
        if (r1 == (-1)) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x004c, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0051, code lost:
        return m(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0052, code lost:
        return null;
     */
    @javax.annotation.CheckForNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static byte[] j(java.lang.String r9) {
        /*
            r0 = 0
            r1 = 0
            r2 = 0
            r3 = 0
        L4:
            int r4 = r9.length()
            r5 = 0
            r6 = -1
            if (r1 >= r4) goto L31
            char r4 = r9.charAt(r1)
            r7 = 46
            r8 = 1
            if (r4 != r7) goto L17
            r2 = 1
            goto L2e
        L17:
            r7 = 58
            if (r4 != r7) goto L20
            if (r2 == 0) goto L1e
            return r5
        L1e:
            r3 = 1
            goto L2e
        L20:
            r7 = 37
            if (r4 != r7) goto L25
            goto L32
        L25:
            r7 = 16
            int r4 = java.lang.Character.digit(r4, r7)
            if (r4 != r6) goto L2e
            return r5
        L2e:
            int r1 = r1 + 1
            goto L4
        L31:
            r1 = -1
        L32:
            if (r3 == 0) goto L48
            if (r2 == 0) goto L3d
            java.lang.String r9 = d(r9)
            if (r9 != 0) goto L3d
            return r5
        L3d:
            if (r1 == r6) goto L43
            java.lang.String r9 = r9.substring(r0, r1)
        L43:
            byte[] r9 = n(r9)
            return r9
        L48:
            if (r2 == 0) goto L52
            if (r1 == r6) goto L4d
            return r5
        L4d:
            byte[] r9 = m(r9)
            return r9
        L52:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.net.InetAddresses.j(java.lang.String):byte[]");
    }

    private static short k(String str, int i4, int i5) {
        int i6 = i5 - i4;
        if (i6 > 0 && i6 <= 4) {
            int i7 = 0;
            while (i4 < i5) {
                i7 = (i7 << 4) | Character.digit(str.charAt(i4), 16);
                i4++;
            }
            return (short) i7;
        }
        throw new NumberFormatException();
    }

    private static byte l(String str, int i4, int i5) {
        int i6 = i5 - i4;
        if (i6 > 0 && i6 <= 3) {
            if (i6 > 1 && str.charAt(i4) == '0') {
                throw new NumberFormatException();
            }
            int i7 = 0;
            while (i4 < i5) {
                int i8 = i7 * 10;
                int digit = Character.digit(str.charAt(i4), 10);
                if (digit >= 0) {
                    i7 = i8 + digit;
                    i4++;
                } else {
                    throw new NumberFormatException();
                }
            }
            if (i7 <= 255) {
                return (byte) i7;
            }
            throw new NumberFormatException();
        }
        throw new NumberFormatException();
    }

    @CheckForNull
    private static byte[] m(String str) {
        if (f28100a.countIn(str) + 1 != 4) {
            return null;
        }
        byte[] bArr = new byte[4];
        int i4 = 0;
        for (int i5 = 0; i5 < 4; i5++) {
            int indexOf = str.indexOf(46, i4);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            try {
                bArr[i5] = l(str, i4, indexOf);
                i4 = indexOf + 1;
            } catch (NumberFormatException unused) {
                return null;
            }
        }
        return bArr;
    }

    @CheckForNull
    private static byte[] n(String str) {
        int countIn = f28101b.countIn(str);
        if (countIn >= 2 && countIn <= 8) {
            int i4 = 1;
            int i5 = countIn + 1;
            int i6 = 8 - i5;
            boolean z3 = false;
            for (int i7 = 0; i7 < str.length() - 1; i7++) {
                if (str.charAt(i7) == ':' && str.charAt(i7 + 1) == ':') {
                    if (z3) {
                        return null;
                    }
                    i6++;
                    if (i7 == 0) {
                        i6++;
                    }
                    if (i7 == str.length() - 2) {
                        i6++;
                    }
                    z3 = true;
                }
            }
            if (str.charAt(0) == ':' && str.charAt(1) != ':') {
                return null;
            }
            if (str.charAt(str.length() - 1) == ':' && str.charAt(str.length() - 2) != ':') {
                return null;
            }
            if (z3 && i6 <= 0) {
                return null;
            }
            if (!z3 && i5 != 8) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(16);
            try {
                if (str.charAt(0) != ':') {
                    i4 = 0;
                }
                while (i4 < str.length()) {
                    int indexOf = str.indexOf(58, i4);
                    if (indexOf == -1) {
                        indexOf = str.length();
                    }
                    if (str.charAt(i4) == ':') {
                        for (int i8 = 0; i8 < i6; i8++) {
                            allocate.putShort((short) 0);
                        }
                    } else {
                        allocate.putShort(k(str, i4, indexOf));
                    }
                    i4 = indexOf + 1;
                }
                return allocate.array();
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public static String toAddrString(InetAddress inetAddress) {
        Preconditions.checkNotNull(inetAddress);
        if (inetAddress instanceof Inet4Address) {
            return inetAddress.getHostAddress();
        }
        Preconditions.checkArgument(inetAddress instanceof Inet6Address);
        byte[] address = inetAddress.getAddress();
        int[] iArr = new int[8];
        for (int i4 = 0; i4 < 8; i4++) {
            int i5 = i4 * 2;
            iArr[i4] = Ints.fromBytes((byte) 0, (byte) 0, address[i5], address[i5 + 1]);
        }
        c(iArr);
        return i(iArr);
    }

    public static BigInteger toBigInteger(InetAddress inetAddress) {
        return new BigInteger(1, inetAddress.getAddress());
    }

    public static String toUriString(InetAddress inetAddress) {
        if (inetAddress instanceof Inet6Address) {
            return "[" + toAddrString(inetAddress) + "]";
        }
        return toAddrString(inetAddress);
    }
}
