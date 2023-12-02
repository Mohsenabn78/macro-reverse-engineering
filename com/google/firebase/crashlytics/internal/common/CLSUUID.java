package com.google.firebase.crashlytics.internal.common;

import android.os.Process;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class CLSUUID {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicLong f29396a = new AtomicLong(0);

    /* renamed from: b  reason: collision with root package name */
    private static String f29397b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CLSUUID(IdManager idManager) {
        byte[] bArr = new byte[10];
        e(bArr);
        d(bArr);
        c(bArr);
        String sha1 = CommonUtils.sha1(idManager.getInstallIds().getCrashlyticsInstallId());
        String hexify = CommonUtils.hexify(bArr);
        Locale locale = Locale.US;
        f29397b = String.format(locale, "%s%s%s%s", hexify.substring(0, 12), hexify.substring(12, 16), hexify.subSequence(16, 20), sha1.substring(0, 12)).toUpperCase(locale);
    }

    private static byte[] a(long j4) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt((int) j4);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }

    private static byte[] b(long j4) {
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.putShort((short) j4);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }

    private void c(byte[] bArr) {
        byte[] b4 = b(Integer.valueOf(Process.myPid()).shortValue());
        bArr[8] = b4[0];
        bArr[9] = b4[1];
    }

    private void d(byte[] bArr) {
        byte[] b4 = b(f29396a.incrementAndGet());
        bArr[6] = b4[0];
        bArr[7] = b4[1];
    }

    private void e(byte[] bArr) {
        long time = new Date().getTime();
        byte[] a4 = a(time / 1000);
        bArr[0] = a4[0];
        bArr[1] = a4[1];
        bArr[2] = a4[2];
        bArr[3] = a4[3];
        byte[] b4 = b(time % 1000);
        bArr[4] = b4[0];
        bArr[5] = b4[1];
    }

    public String toString() {
        return f29397b;
    }
}
