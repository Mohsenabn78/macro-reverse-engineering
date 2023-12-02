package com.sun.mail.pop3;

import java.io.File;
import java.io.IOException;

/* compiled from: TempFile.java */
/* loaded from: classes6.dex */
class e {

    /* renamed from: a  reason: collision with root package name */
    private File f37951a;

    /* renamed from: b  reason: collision with root package name */
    private f f37952b;

    public e(File file) throws IOException {
        File createTempFile = File.createTempFile("pop3.", ".mbox", file);
        this.f37951a = createTempFile;
        createTempFile.deleteOnExit();
        this.f37952b = new f(this.f37951a);
    }

    public void a() {
        try {
            this.f37952b.close();
        } catch (IOException unused) {
        }
        this.f37951a.delete();
    }

    public a b() throws IOException {
        return this.f37952b.b();
    }

    protected void finalize() throws Throwable {
        try {
            a();
        } finally {
            super.finalize();
        }
    }
}
