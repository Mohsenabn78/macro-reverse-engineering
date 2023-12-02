package com.facebook.stetho.common;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes3.dex */
public class Util {
    public static void awaitUninterruptibly(CountDownLatch countDownLatch) {
        while (true) {
            try {
                countDownLatch.await();
                return;
            } catch (InterruptedException unused) {
            }
        }
    }

    public static void close(Closeable closeable, boolean z3) throws IOException {
        if (closeable != null) {
            if (z3) {
                try {
                    closeable.close();
                    return;
                } catch (IOException e4) {
                    LogUtil.e(e4, "Hiding IOException because another is pending");
                    return;
                }
            }
            closeable.close();
        }
    }

    public static void copy(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static <T> T getUninterruptibly(Future<T> future, long j4, TimeUnit timeUnit) throws TimeoutException, ExecutionException {
        long millis = timeUnit.toMillis(j4);
        while (true) {
            try {
                return future.get(millis, TimeUnit.MILLISECONDS);
            } catch (InterruptedException unused) {
                millis -= System.currentTimeMillis() - System.currentTimeMillis();
            }
        }
    }

    public static void joinUninterruptibly(Thread thread) {
        while (true) {
            try {
                thread.join();
                return;
            } catch (InterruptedException unused) {
            }
        }
    }

    public static String readAsUTF8(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copy(inputStream, byteArrayOutputStream, new byte[1024]);
        return byteArrayOutputStream.toString("UTF-8");
    }

    public static void sleepUninterruptibly(long j4) {
        long currentTimeMillis = System.currentTimeMillis();
        do {
            try {
                Thread.sleep(j4);
                return;
            } catch (InterruptedException unused) {
                j4 -= System.currentTimeMillis() - currentTimeMillis;
                if (j4 <= 0) {
                }
            }
        } while (j4 <= 0);
    }

    public static void throwIf(boolean z3) {
        if (!z3) {
            return;
        }
        throw new IllegalStateException();
    }

    public static void throwIfNot(boolean z3) {
        if (!z3) {
            throw new IllegalStateException();
        }
    }

    public static void throwIfNotNull(Object obj) {
        if (obj == null) {
            return;
        }
        throw new IllegalStateException();
    }

    public static <T> T throwIfNull(T t3) {
        t3.getClass();
        return t3;
    }

    public static void throwIfNot(boolean z3, String str, Object... objArr) {
        if (!z3) {
            throw new IllegalStateException(String.format(str, objArr));
        }
    }

    public static <T1, T2> void throwIfNull(T1 t12, T2 t22) {
        throwIfNull(t12);
        throwIfNull(t22);
    }

    public static <T1, T2, T3> void throwIfNull(T1 t12, T2 t22, T3 t3) {
        throwIfNull(t12);
        throwIfNull(t22);
        throwIfNull(t3);
    }

    public static <T> T getUninterruptibly(Future<T> future) throws ExecutionException {
        while (true) {
            try {
                return future.get();
            } catch (InterruptedException unused) {
            }
        }
    }
}
