package com.sun.mail.imap.protocol;

import java.util.ArrayList;
import java.util.StringTokenizer;

/* loaded from: classes6.dex */
public class UIDSet {
    public long end;
    public long start;

    public UIDSet() {
    }

    public UIDSet(long j4, long j5) {
        this.start = j4;
        this.end = j5;
    }

    private static long a(UIDSet[] uIDSetArr, long j4) {
        long j5;
        if (uIDSetArr == null) {
            return 0L;
        }
        long j6 = 0;
        for (UIDSet uIDSet : uIDSetArr) {
            if (j4 < 0) {
                j5 = uIDSet.size();
            } else {
                long j7 = uIDSet.start;
                if (j7 <= j4) {
                    long j8 = uIDSet.end;
                    if (j8 < j4) {
                        j6 += (j8 - j7) + 1;
                    } else {
                        j5 = (j4 - j7) + 1;
                    }
                }
            }
            j6 += j5;
        }
        return j6;
    }

    public static UIDSet[] createUIDSets(long[] jArr) {
        if (jArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        while (i4 < jArr.length) {
            UIDSet uIDSet = new UIDSet();
            uIDSet.start = jArr[i4];
            do {
                i4++;
                if (i4 < jArr.length) {
                }
                int i5 = i4 - 1;
                uIDSet.end = jArr[i5];
                arrayList.add(uIDSet);
                i4 = i5 + 1;
            } while (jArr[i4] == jArr[i4 - 1] + 1);
            int i52 = i4 - 1;
            uIDSet.end = jArr[i52];
            arrayList.add(uIDSet);
            i4 = i52 + 1;
        }
        return (UIDSet[]) arrayList.toArray(new UIDSet[arrayList.size()]);
    }

    public static UIDSet[] parseUIDSets(String str) {
        UIDSet uIDSet;
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",:", true);
        loop0: while (true) {
            uIDSet = null;
            while (stringTokenizer.hasMoreTokens()) {
                try {
                    String nextToken = stringTokenizer.nextToken();
                    if (nextToken.equals(",")) {
                        if (uIDSet != null) {
                            arrayList.add(uIDSet);
                        }
                    } else if (!nextToken.equals(":")) {
                        long parseLong = Long.parseLong(nextToken);
                        if (uIDSet != null) {
                            uIDSet.end = parseLong;
                        } else {
                            uIDSet = new UIDSet(parseLong, parseLong);
                        }
                    }
                } catch (NumberFormatException unused) {
                }
            }
            break loop0;
        }
        if (uIDSet != null) {
            arrayList.add(uIDSet);
        }
        return (UIDSet[]) arrayList.toArray(new UIDSet[arrayList.size()]);
    }

    public static long[] toArray(UIDSet[] uIDSetArr) {
        if (uIDSetArr == null) {
            return null;
        }
        long[] jArr = new long[(int) size(uIDSetArr)];
        int i4 = 0;
        for (UIDSet uIDSet : uIDSetArr) {
            long j4 = uIDSet.start;
            while (j4 <= uIDSet.end) {
                jArr[i4] = j4;
                j4++;
                i4++;
            }
        }
        return jArr;
    }

    public static String toString(UIDSet[] uIDSetArr) {
        if (uIDSetArr == null) {
            return null;
        }
        if (uIDSetArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = uIDSetArr.length;
        int i4 = 0;
        while (true) {
            UIDSet uIDSet = uIDSetArr[i4];
            long j4 = uIDSet.start;
            long j5 = uIDSet.end;
            if (j5 > j4) {
                sb.append(j4);
                sb.append(':');
                sb.append(j5);
            } else {
                sb.append(j4);
            }
            i4++;
            if (i4 >= length) {
                return sb.toString();
            }
            sb.append(',');
        }
    }

    public long size() {
        return (this.end - this.start) + 1;
    }

    public static long size(UIDSet[] uIDSetArr) {
        long j4 = 0;
        if (uIDSetArr != null) {
            for (UIDSet uIDSet : uIDSetArr) {
                j4 += uIDSet.size();
            }
        }
        return j4;
    }

    public static long[] toArray(UIDSet[] uIDSetArr, long j4) {
        if (uIDSetArr == null) {
            return null;
        }
        long[] jArr = new long[(int) a(uIDSetArr, j4)];
        int i4 = 0;
        for (UIDSet uIDSet : uIDSetArr) {
            long j5 = uIDSet.start;
            while (j5 <= uIDSet.end && (j4 < 0 || j5 <= j4)) {
                jArr[i4] = j5;
                j5++;
                i4++;
            }
        }
        return jArr;
    }
}
