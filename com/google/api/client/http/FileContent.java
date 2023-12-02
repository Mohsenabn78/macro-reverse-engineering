package com.google.api.client.http;

import com.google.api.client.util.Preconditions;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* loaded from: classes5.dex */
public final class FileContent extends AbstractInputStreamContent {

    /* renamed from: c  reason: collision with root package name */
    private final File f25759c;

    public FileContent(String str, File file) {
        super(str);
        this.f25759c = (File) Preconditions.checkNotNull(file);
    }

    public File getFile() {
        return this.f25759c;
    }

    @Override // com.google.api.client.http.AbstractInputStreamContent
    public InputStream getInputStream() throws FileNotFoundException {
        return new FileInputStream(this.f25759c);
    }

    @Override // com.google.api.client.http.HttpContent
    public long getLength() {
        return this.f25759c.length();
    }

    @Override // com.google.api.client.http.HttpContent
    public boolean retrySupported() {
        return true;
    }

    @Override // com.google.api.client.http.AbstractInputStreamContent
    public FileContent setCloseInputStream(boolean z3) {
        return (FileContent) super.setCloseInputStream(z3);
    }

    @Override // com.google.api.client.http.AbstractInputStreamContent
    public FileContent setType(String str) {
        return (FileContent) super.setType(str);
    }
}
