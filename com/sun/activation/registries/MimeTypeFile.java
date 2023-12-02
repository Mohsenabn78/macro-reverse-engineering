package com.sun.activation.registries;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Hashtable;
import java.util.StringTokenizer;

/* loaded from: classes6.dex */
public class MimeTypeFile {

    /* renamed from: a  reason: collision with root package name */
    private String f37567a;

    /* renamed from: b  reason: collision with root package name */
    private Hashtable f37568b;

    public MimeTypeFile(String str) throws IOException {
        this.f37567a = null;
        this.f37568b = new Hashtable();
        this.f37567a = str;
        FileReader fileReader = new FileReader(new File(this.f37567a));
        try {
            a(new BufferedReader(fileReader));
        } finally {
            try {
                fileReader.close();
            } catch (IOException unused) {
            }
        }
    }

    private void a(BufferedReader bufferedReader) throws IOException {
        String str;
        String readLine;
        loop0: while (true) {
            str = null;
            while (true) {
                readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break loop0;
                }
                if (str != null) {
                    readLine = str + readLine;
                }
                int length = readLine.length();
                if (readLine.length() > 0) {
                    int i4 = length - 1;
                    if (readLine.charAt(i4) == '\\') {
                        str = readLine.substring(0, i4);
                    }
                }
            }
            b(readLine);
        }
        if (str != null) {
            b(str);
        }
    }

    private void b(String str) {
        MimeTypeEntry mimeTypeEntry;
        String str2;
        MimeTypeEntry mimeTypeEntry2;
        String trim = str.trim();
        if (trim.length() == 0 || trim.charAt(0) == '#') {
            return;
        }
        if (trim.indexOf(61) > 0) {
            a aVar = new a(trim);
            String str3 = null;
            while (aVar.a()) {
                String b4 = aVar.b();
                if (aVar.a() && aVar.b().equals("=") && aVar.a()) {
                    str2 = aVar.b();
                } else {
                    str2 = null;
                }
                if (str2 == null) {
                    if (LogSupport.isLoggable()) {
                        LogSupport.log("Bad .mime.types entry: " + trim);
                        return;
                    }
                    return;
                } else if (b4.equals("type")) {
                    str3 = str2;
                } else if (b4.equals("exts")) {
                    StringTokenizer stringTokenizer = new StringTokenizer(str2, ",");
                    while (stringTokenizer.hasMoreTokens()) {
                        String nextToken = stringTokenizer.nextToken();
                        this.f37568b.put(nextToken, new MimeTypeEntry(str3, nextToken));
                        if (LogSupport.isLoggable()) {
                            LogSupport.log("Added: " + mimeTypeEntry2.toString());
                        }
                    }
                }
            }
            return;
        }
        StringTokenizer stringTokenizer2 = new StringTokenizer(trim);
        if (stringTokenizer2.countTokens() == 0) {
            return;
        }
        String nextToken2 = stringTokenizer2.nextToken();
        while (stringTokenizer2.hasMoreTokens()) {
            String nextToken3 = stringTokenizer2.nextToken();
            this.f37568b.put(nextToken3, new MimeTypeEntry(nextToken2, nextToken3));
            if (LogSupport.isLoggable()) {
                LogSupport.log("Added: " + mimeTypeEntry.toString());
            }
        }
    }

    public void appendToRegistry(String str) {
        try {
            a(new BufferedReader(new StringReader(str)));
        } catch (IOException unused) {
        }
    }

    public String getMIMETypeString(String str) {
        MimeTypeEntry mimeTypeEntry = getMimeTypeEntry(str);
        if (mimeTypeEntry != null) {
            return mimeTypeEntry.getMIMEType();
        }
        return null;
    }

    public MimeTypeEntry getMimeTypeEntry(String str) {
        return (MimeTypeEntry) this.f37568b.get(str);
    }

    public MimeTypeFile(InputStream inputStream) throws IOException {
        this.f37567a = null;
        this.f37568b = new Hashtable();
        a(new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1")));
    }

    public MimeTypeFile() {
        this.f37567a = null;
        this.f37568b = new Hashtable();
    }
}
