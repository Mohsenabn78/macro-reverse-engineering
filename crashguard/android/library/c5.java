package crashguard.android.library;

import com.facebook.stetho.dumpapp.Framer;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

/* loaded from: classes6.dex */
final class c5 {

    /* renamed from: a  reason: collision with root package name */
    static final String f38686a = new String(new byte[]{48, Framer.STDERR_FRAME_PREFIX, 58, 48, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48});

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:100:0x015c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:103:0x00d0 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a() {
        /*
            Method dump skipped, instructions count: 359
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: crashguard.android.library.c5.a():java.lang.String");
    }

    private static String b(LinkedList linkedList) {
        LinkedList<Inet4Address> linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            InetAddress inetAddress = (InetAddress) it.next();
            if (inetAddress instanceof Inet4Address) {
                linkedList2.add((Inet4Address) inetAddress);
            }
        }
        for (Inet4Address inet4Address : linkedList2) {
            String hostAddress = inet4Address.getHostAddress();
            if (hostAddress != null) {
                return hostAddress.toUpperCase(Locale.ENGLISH);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c() {
        String str = new String(new byte[]{114, 109, 110, 101, 116, Framer.STDIN_REQUEST_FRAME_PREFIX, 100, 97, 116, 97});
        LinkedList<NetworkInterface> linkedList = new LinkedList();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if (nextElement.getName().contains(str)) {
                    linkedList.add(nextElement);
                }
            }
        } catch (Throwable unused) {
        }
        LinkedList linkedList2 = new LinkedList();
        try {
            for (NetworkInterface networkInterface : linkedList) {
                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement2 = inetAddresses.nextElement();
                    if (!nextElement2.isLoopbackAddress() && nextElement2.getHostAddress() != null) {
                        linkedList2.add(nextElement2);
                    }
                }
            }
        } catch (Throwable unused2) {
        }
        try {
            return b(linkedList2);
        } catch (Throwable unused3) {
            return null;
        }
    }

    private static String d(LinkedList linkedList) {
        String hostAddress;
        String hostAddress2;
        LinkedList<Inet6Address> linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            InetAddress inetAddress = (InetAddress) it.next();
            if (inetAddress instanceof Inet6Address) {
                linkedList2.add((Inet6Address) inetAddress);
            }
        }
        for (Inet6Address inet6Address : linkedList2) {
            if (!inet6Address.isLinkLocalAddress() && (hostAddress2 = inet6Address.getHostAddress()) != null) {
                String upperCase = hostAddress2.toUpperCase(Locale.ENGLISH);
                int indexOf = upperCase.indexOf(37);
                if (indexOf >= 0) {
                    return upperCase.substring(0, indexOf);
                }
                return upperCase;
            }
        }
        for (Inet6Address inet6Address2 : linkedList2) {
            String hostAddress3 = inet6Address2.getHostAddress();
            if (hostAddress3 != null) {
                String upperCase2 = hostAddress3.toUpperCase(Locale.ENGLISH);
                int indexOf2 = upperCase2.indexOf(37);
                if (indexOf2 >= 0) {
                    return upperCase2.substring(0, indexOf2);
                }
                return upperCase2;
            }
        }
        if (linkedList2.size() > 0 && (hostAddress = ((InetAddress) linkedList2.get(0)).getHostAddress()) != null) {
            String upperCase3 = hostAddress.toUpperCase(Locale.ENGLISH);
            int indexOf3 = upperCase3.indexOf(37);
            if (indexOf3 >= 0) {
                return upperCase3.substring(0, indexOf3);
            }
            return upperCase3;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String e() {
        String str = new String(new byte[]{114, 109, 110, 101, 116, Framer.STDIN_REQUEST_FRAME_PREFIX, 100, 97, 116, 97});
        LinkedList<NetworkInterface> linkedList = new LinkedList();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if (nextElement.getName().contains(str)) {
                    linkedList.add(nextElement);
                }
            }
        } catch (Throwable unused) {
        }
        LinkedList linkedList2 = new LinkedList();
        try {
            for (NetworkInterface networkInterface : linkedList) {
                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement2 = inetAddresses.nextElement();
                    if (!nextElement2.isLoopbackAddress() && nextElement2.getHostAddress() != null) {
                        linkedList2.add(nextElement2);
                    }
                }
            }
        } catch (Throwable unused2) {
        }
        try {
            return d(linkedList2);
        } catch (Throwable unused3) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String f() {
        String str = "wlan";
        LinkedList<NetworkInterface> linkedList = new LinkedList();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if (nextElement.getName().contains(str)) {
                    linkedList.add(nextElement);
                }
            }
        } catch (Throwable unused) {
        }
        LinkedList linkedList2 = new LinkedList();
        try {
            for (NetworkInterface networkInterface : linkedList) {
                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement2 = inetAddresses.nextElement();
                    if (!nextElement2.isLoopbackAddress() && nextElement2.getHostAddress() != null) {
                        linkedList2.add(nextElement2);
                    }
                }
            }
        } catch (Throwable unused2) {
        }
        try {
            return b(linkedList2);
        } catch (Throwable unused3) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String g() {
        String str = "wlan";
        LinkedList<NetworkInterface> linkedList = new LinkedList();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if (nextElement.getName().contains(str)) {
                    linkedList.add(nextElement);
                }
            }
        } catch (Throwable unused) {
        }
        LinkedList linkedList2 = new LinkedList();
        try {
            for (NetworkInterface networkInterface : linkedList) {
                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement2 = inetAddresses.nextElement();
                    if (!nextElement2.isLoopbackAddress() && nextElement2.getHostAddress() != null) {
                        linkedList2.add(nextElement2);
                    }
                }
            }
        } catch (Throwable unused2) {
        }
        try {
            return d(linkedList2);
        } catch (Throwable unused3) {
            return null;
        }
    }
}
