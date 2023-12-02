package com.google.api.client.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Beta
/* loaded from: classes5.dex */
public final class PemReader {

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f26147b = Pattern.compile("-----BEGIN ([A-Z ]+)-----");

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f26148c = Pattern.compile("-----END ([A-Z ]+)-----");

    /* renamed from: a  reason: collision with root package name */
    private BufferedReader f26149a;

    /* loaded from: classes5.dex */
    public static final class Section {

        /* renamed from: a  reason: collision with root package name */
        private final String f26150a;

        /* renamed from: b  reason: collision with root package name */
        private final byte[] f26151b;

        Section(String str, byte[] bArr) {
            this.f26150a = (String) Preconditions.checkNotNull(str);
            this.f26151b = (byte[]) Preconditions.checkNotNull(bArr);
        }

        public byte[] getBase64DecodedBytes() {
            return this.f26151b;
        }

        public String getTitle() {
            return this.f26150a;
        }
    }

    public PemReader(Reader reader) {
        this.f26149a = new BufferedReader(reader);
    }

    public static Section readFirstSectionAndClose(Reader reader) throws IOException {
        return readFirstSectionAndClose(reader, null);
    }

    public void close() throws IOException {
        this.f26149a.close();
    }

    public Section readNextSection() throws IOException {
        return readNextSection(null);
    }

    public static Section readFirstSectionAndClose(Reader reader, String str) throws IOException {
        PemReader pemReader = new PemReader(reader);
        try {
            return pemReader.readNextSection(str);
        } finally {
            pemReader.close();
        }
    }

    public Section readNextSection(String str) throws IOException {
        StringBuilder sb = null;
        String str2 = null;
        while (true) {
            String readLine = this.f26149a.readLine();
            if (readLine == null) {
                Preconditions.checkArgument(str2 == null, "missing end tag (%s)", str2);
                return null;
            } else if (sb == null) {
                Matcher matcher = f26147b.matcher(readLine);
                if (matcher.matches()) {
                    String group = matcher.group(1);
                    if (str == null || group.equals(str)) {
                        sb = new StringBuilder();
                        str2 = group;
                    }
                }
            } else {
                Matcher matcher2 = f26148c.matcher(readLine);
                if (matcher2.matches()) {
                    String group2 = matcher2.group(1);
                    Preconditions.checkArgument(group2.equals(str2), "end tag (%s) doesn't match begin tag (%s)", group2, str2);
                    return new Section(str2, Base64.decodeBase64(sb.toString()));
                }
                sb.append(readLine);
            }
        }
    }
}
