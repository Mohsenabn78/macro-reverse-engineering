package com.koushikdutta.async.http.body;

import com.koushikdutta.async.http.BasicNameValuePair;
import com.koushikdutta.async.http.NameValuePair;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/* loaded from: classes6.dex */
public class FilePart extends StreamPart {

    /* renamed from: d  reason: collision with root package name */
    File f35107d;

    /* loaded from: classes6.dex */
    class a extends ArrayList<NameValuePair> {
        final /* synthetic */ File val$file;

        a(File file) {
            this.val$file = file;
            add(new BasicNameValuePair("filename", file.getName()));
        }
    }

    public FilePart(String str, File file) {
        super(str, (int) file.length(), new a(file));
        this.f35107d = file;
    }

    @Override // com.koushikdutta.async.http.body.StreamPart
    protected InputStream a() throws IOException {
        return new FileInputStream(this.f35107d);
    }
}
