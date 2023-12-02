package com.stericson.RootTools.internal;

import android.content.Context;
import android.util.Log;
import com.stericson.RootShell.execution.Command;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Installer.java */
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    Context f37549a;

    /* renamed from: b  reason: collision with root package name */
    String f37550b;

    public a(Context context) throws IOException {
        this.f37549a = context;
        this.f37550b = context.getFilesDir().getCanonicalPath();
    }

    private void a(Command command) {
        synchronized (command) {
            try {
                if (!command.isFinished()) {
                    command.wait(2000L);
                }
            } catch (InterruptedException e4) {
                Log.e("RootTools::Installer", e4.toString());
            }
        }
    }

    protected String b(File file) {
        try {
            return c(new FileInputStream(file));
        } catch (FileNotFoundException e4) {
            Log.e("RootTools::Installer", e4.toString());
            return "";
        }
    }

    protected String c(InputStream inputStream) {
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                while (-1 != new DigestInputStream(inputStream, messageDigest).read(new byte[4096])) {
                }
                byte[] digest = messageDigest.digest();
                StringBuffer stringBuffer = new StringBuffer();
                for (byte b4 : digest) {
                    stringBuffer.append(Integer.toHexString(b4 & 255));
                }
                String stringBuffer2 = stringBuffer.toString();
                try {
                    inputStream.close();
                    return stringBuffer2;
                } catch (IOException unused) {
                    return stringBuffer2;
                }
            } catch (IOException e4) {
                Log.e("RootTools::Installer", e4.toString());
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                    return "";
                }
            } catch (NoSuchAlgorithmException e5) {
                Log.e("RootTools::Installer", e5.toString());
                inputStream.close();
            }
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException unused3) {
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:100:0x017a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0171 A[Catch: all -> 0x016a, TRY_LEAVE, TryCatch #6 {all -> 0x016a, blocks: (B:14:0x0071, B:63:0x016d, B:65:0x0171), top: B:88:0x005a }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0185 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean d(int r23, java.lang.String r24, java.lang.String r25) {
        /*
            Method dump skipped, instructions count: 398
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stericson.RootTools.internal.a.d(int, java.lang.String, java.lang.String):boolean");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean e(String str) {
        return new File(this.f37550b + File.separator + str).exists();
    }
}
