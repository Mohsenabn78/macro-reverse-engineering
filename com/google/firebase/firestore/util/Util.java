package com.google.firebase.firestore.util;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.cloud.datastore.core.number.NumberComparisonHelper;
import com.google.firebase.firestore.FieldPath;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.protobuf.ByteString;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.StatusRuntimeException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.SortedSet;

/* loaded from: classes5.dex */
public class Util {

    /* renamed from: a  reason: collision with root package name */
    private static final Random f31300a = new SecureRandom();

    /* renamed from: b  reason: collision with root package name */
    private static final Continuation<Void, Void> f31301b = new Continuation() { // from class: com.google.firebase.firestore.util.t
        @Override // com.google.android.gms.tasks.Continuation
        public final Object then(Task task) {
            Void l4;
            l4 = Util.l(task);
            return l4;
        }
    };

    public static String autoId() {
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < 20; i4++) {
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".charAt(f31300a.nextInt(62)));
        }
        return sb.toString();
    }

    public static List<Object> collectUpdateArguments(int i4, Object obj, Object obj2, Object... objArr) {
        if (objArr.length % 2 != 1) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(obj);
            arrayList.add(obj2);
            Collections.addAll(arrayList, objArr);
            for (int i5 = 0; i5 < arrayList.size(); i5 += 2) {
                Object obj3 = arrayList.get(i5);
                if (!(obj3 instanceof String) && !(obj3 instanceof FieldPath)) {
                    throw new IllegalArgumentException("Excepted field name at argument position " + (i5 + i4 + 1) + " but got " + obj3 + " in call to update.  The arguments to update should alternate between field names and values");
                }
            }
            return arrayList;
        }
        throw new IllegalArgumentException("Missing value in call to update().  There must be an even number of arguments that alternate between field names and values");
    }

    public static <T extends Comparable<T>> Comparator<T> comparator() {
        return new Comparator() { // from class: com.google.firebase.firestore.util.s
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((Comparable) obj).compareTo((Comparable) obj2);
            }
        };
    }

    public static int compareBooleans(boolean z3, boolean z4) {
        if (z3 == z4) {
            return 0;
        }
        if (z3) {
            return 1;
        }
        return -1;
    }

    public static int compareByteArrays(byte[] bArr, byte[] bArr2) {
        int min = Math.min(bArr.length, bArr2.length);
        for (int i4 = 0; i4 < min; i4++) {
            int i5 = bArr[i4] & 255;
            int i6 = bArr2[i4] & 255;
            if (i5 < i6) {
                return -1;
            }
            if (i5 > i6) {
                return 1;
            }
        }
        return compareIntegers(bArr.length, bArr2.length);
    }

    public static int compareByteStrings(ByteString byteString, ByteString byteString2) {
        int min = Math.min(byteString.size(), byteString2.size());
        for (int i4 = 0; i4 < min; i4++) {
            int byteAt = byteString.byteAt(i4) & 255;
            int byteAt2 = byteString2.byteAt(i4) & 255;
            if (byteAt < byteAt2) {
                return -1;
            }
            if (byteAt > byteAt2) {
                return 1;
            }
        }
        return compareIntegers(byteString.size(), byteString2.size());
    }

    public static int compareDoubles(double d4, double d5) {
        return NumberComparisonHelper.firestoreCompareDoubles(d4, d5);
    }

    public static int compareIntegers(int i4, int i5) {
        if (i4 < i5) {
            return -1;
        }
        if (i4 > i5) {
            return 1;
        }
        return 0;
    }

    public static int compareLongs(long j4, long j5) {
        return NumberComparisonHelper.compareLongs(j4, j5);
    }

    public static int compareMixed(double d4, long j4) {
        return NumberComparisonHelper.firestoreCompareDoubleWithLong(d4, j4);
    }

    public static Exception convertThrowableToException(Throwable th) {
        if (th instanceof Exception) {
            return g((Exception) th);
        }
        return new Exception(th);
    }

    @SuppressLint({"ThreadPoolCreation"})
    public static void crashMainThread(final RuntimeException runtimeException) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.google.firebase.firestore.util.r
            @Override // java.lang.Runnable
            public final void run() {
                Util.i(runtimeException);
            }
        });
    }

    public static <T> void diffCollections(Collection<T> collection, Collection<T> collection2, Comparator<T> comparator, Consumer<T> consumer, Consumer<T> consumer2) {
        ArrayList arrayList = new ArrayList(collection);
        Collections.sort(arrayList, comparator);
        ArrayList arrayList2 = new ArrayList(collection2);
        Collections.sort(arrayList2, comparator);
        h(arrayList.iterator(), arrayList2.iterator(), comparator, consumer, consumer2);
    }

    public static FirebaseFirestoreException exceptionFromStatus(Status status) {
        StatusException asException = status.asException();
        return new FirebaseFirestoreException(asException.getMessage(), FirebaseFirestoreException.Code.fromValue(status.getCode().value()), asException);
    }

    @Nullable
    private static <T> T f(Iterator<T> it) {
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> Map<K, V> firstNEntries(Map<K, V> map, int i4, final Comparator<V> comparator) {
        if (map.size() <= i4) {
            return map;
        }
        ArrayList arrayList = new ArrayList(map.entrySet());
        Collections.sort(arrayList, new Comparator() { // from class: com.google.firebase.firestore.util.v
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int k4;
                k4 = Util.k(comparator, (Map.Entry) obj, (Map.Entry) obj2);
                return k4;
            }
        });
        HashMap hashMap = new HashMap();
        for (int i5 = 0; i5 < i4; i5++) {
            hashMap.put(((Map.Entry) arrayList.get(i5)).getKey(), ((Map.Entry) arrayList.get(i5)).getValue());
        }
        return hashMap;
    }

    private static Exception g(Exception exc) {
        if (exc instanceof StatusException) {
            return exceptionFromStatus(((StatusException) exc).getStatus());
        }
        if (exc instanceof StatusRuntimeException) {
            return exceptionFromStatus(((StatusRuntimeException) exc).getStatus());
        }
        return exc;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001b, code lost:
        if (r4 > 0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x001e, code lost:
        if (r0 != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0021, code lost:
        r2 = true;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x002d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0025 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static <T> void h(java.util.Iterator<T> r5, java.util.Iterator<T> r6, java.util.Comparator<? super T> r7, com.google.firebase.firestore.util.Consumer<T> r8, com.google.firebase.firestore.util.Consumer<T> r9) {
        /*
            java.lang.Object r0 = f(r5)
            java.lang.Object r1 = f(r6)
        L8:
            if (r0 != 0) goto Le
            if (r1 == 0) goto Ld
            goto Le
        Ld:
            return
        Le:
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L1e
            if (r1 == 0) goto L1e
            int r4 = r7.compare(r0, r1)
            if (r4 >= 0) goto L1b
            goto L23
        L1b:
            if (r4 <= 0) goto L22
            goto L21
        L1e:
            if (r0 == 0) goto L21
            goto L23
        L21:
            r2 = 1
        L22:
            r3 = 0
        L23:
            if (r2 == 0) goto L2d
            r8.accept(r1)
            java.lang.Object r1 = f(r6)
            goto L8
        L2d:
            if (r3 == 0) goto L37
            r9.accept(r0)
            java.lang.Object r0 = f(r5)
            goto L8
        L37:
            java.lang.Object r0 = f(r5)
            java.lang.Object r1 = f(r6)
            goto L8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.firestore.util.Util.h(java.util.Iterator, java.util.Iterator, java.util.Comparator, com.google.firebase.firestore.util.Consumer, com.google.firebase.firestore.util.Consumer):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int k(Comparator comparator, Map.Entry entry, Map.Entry entry2) {
        return comparator.compare(entry.getValue(), entry2.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void l(Task task) throws Exception {
        if (task.isSuccessful()) {
            return (Void) task.getResult();
        }
        Exception g4 = g(task.getException());
        if (g4 instanceof FirebaseFirestoreException) {
            throw g4;
        }
        throw new FirebaseFirestoreException(g4.getMessage(), FirebaseFirestoreException.Code.UNKNOWN, g4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Iterator m(Iterable iterable) {
        final Iterator it = iterable.iterator();
        return new Iterator() { // from class: com.google.firebase.firestore.util.Util.1
            @Override // java.util.Iterator
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override // java.util.Iterator
            public Object next() {
                return ((Map.Entry) it.next()).getValue();
            }
        };
    }

    public static StringBuilder repeatSequence(CharSequence charSequence, int i4, CharSequence charSequence2) {
        StringBuilder sb = new StringBuilder();
        if (i4 != 0) {
            sb.append(charSequence);
            for (int i5 = 1; i5 < i4; i5++) {
                sb.append(charSequence2);
                sb.append(charSequence);
            }
        }
        return sb;
    }

    public static String toDebugString(ByteString byteString) {
        int size = byteString.size();
        StringBuilder sb = new StringBuilder(size * 2);
        for (int i4 = 0; i4 < size; i4++) {
            int byteAt = byteString.byteAt(i4) & 255;
            sb.append(Character.forDigit(byteAt >>> 4, 16));
            sb.append(Character.forDigit(byteAt & 15, 16));
        }
        return sb.toString();
    }

    public static String typeName(@Nullable Object obj) {
        if (obj == null) {
            return "null";
        }
        return obj.getClass().getName();
    }

    public static <K, V> Iterable<V> values(final Iterable<Map.Entry<K, V>> iterable) {
        return new Iterable() { // from class: com.google.firebase.firestore.util.q
            @Override // java.lang.Iterable
            public final Iterator iterator() {
                Iterator m4;
                m4 = Util.m(iterable);
                return m4;
            }
        };
    }

    public static Continuation<Void, Void> voidErrorTransformer() {
        return f31301b;
    }

    public static <T extends Comparable<T>> void diffCollections(SortedSet<T> sortedSet, SortedSet<T> sortedSet2, Consumer<T> consumer, Consumer<T> consumer2) {
        h(sortedSet.iterator(), sortedSet2.iterator(), sortedSet.comparator() != null ? sortedSet.comparator() : new Comparator() { // from class: com.google.firebase.firestore.util.u
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int compareTo;
                compareTo = ((Comparable) obj).compareTo((Comparable) obj2);
                return compareTo;
            }
        }, consumer, consumer2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i(RuntimeException runtimeException) {
        throw runtimeException;
    }
}
