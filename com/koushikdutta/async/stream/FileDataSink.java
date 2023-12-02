package com.koushikdutta.async.stream;

import com.koushikdutta.async.AsyncServer;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes6.dex */
public class FileDataSink extends OutputStreamDataSink {

    /* renamed from: h  reason: collision with root package name */
    File f35644h;

    public FileDataSink(AsyncServer asyncServer, File file) {
        super(asyncServer);
        this.f35644h = file;
    }

    @Override // com.koushikdutta.async.stream.OutputStreamDataSink
    public OutputStream getOutputStream() throws IOException {
        OutputStream outputStream = super.getOutputStream();
        if (outputStream == null) {
            FileOutputStream fileOutputStream = new FileOutputStream(this.f35644h);
            setOutputStream(fileOutputStream);
            return fileOutputStream;
        }
        return outputStream;
    }
}
