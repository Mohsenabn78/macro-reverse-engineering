package com.google.firebase.firestore.bundle;

import androidx.annotation.Nullable;
import com.google.firebase.firestore.util.Logger;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class BundleReader {

    /* renamed from: g  reason: collision with root package name */
    private static final Charset f30282g = Charset.forName("UTF-8");

    /* renamed from: a  reason: collision with root package name */
    private final BundleSerializer f30283a;

    /* renamed from: b  reason: collision with root package name */
    private final InputStream f30284b;

    /* renamed from: c  reason: collision with root package name */
    private final InputStreamReader f30285c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    BundleMetadata f30286d;

    /* renamed from: e  reason: collision with root package name */
    private ByteBuffer f30287e;

    /* renamed from: f  reason: collision with root package name */
    long f30288f;

    public BundleReader(BundleSerializer bundleSerializer, InputStream inputStream) {
        this.f30283a = bundleSerializer;
        this.f30284b = inputStream;
        this.f30285c = new InputStreamReader(inputStream);
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        this.f30287e = allocate;
        allocate.flip();
    }

    private IllegalArgumentException a(String str) throws IOException {
        close();
        throw new IllegalArgumentException("Invalid bundle: " + str);
    }

    private BundleElement b(String str) throws JSONException, IOException {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("metadata")) {
            BundleMetadata decodeBundleMetadata = this.f30283a.decodeBundleMetadata(jSONObject.getJSONObject("metadata"));
            Logger.debug("BundleElement", "BundleMetadata element loaded", new Object[0]);
            return decodeBundleMetadata;
        } else if (jSONObject.has("namedQuery")) {
            NamedQuery decodeNamedQuery = this.f30283a.decodeNamedQuery(jSONObject.getJSONObject("namedQuery"));
            Logger.debug("BundleElement", "Query loaded: " + decodeNamedQuery.getName(), new Object[0]);
            return decodeNamedQuery;
        } else if (jSONObject.has("documentMetadata")) {
            BundledDocumentMetadata decodeBundledDocumentMetadata = this.f30283a.decodeBundledDocumentMetadata(jSONObject.getJSONObject("documentMetadata"));
            Logger.debug("BundleElement", "Document metadata loaded: " + decodeBundledDocumentMetadata.getKey(), new Object[0]);
            return decodeBundledDocumentMetadata;
        } else if (jSONObject.has("document")) {
            BundleDocument d4 = this.f30283a.d(jSONObject.getJSONObject("document"));
            Logger.debug("BundleElement", "Document loaded: " + d4.getKey(), new Object[0]);
            return d4;
        } else {
            throw a("Cannot decode unknown Bundle element: " + str);
        }
    }

    private int c() {
        this.f30287e.mark();
        for (int i4 = 0; i4 < this.f30287e.remaining(); i4++) {
            try {
                if (this.f30287e.get() == 123) {
                    return i4;
                }
            } finally {
                this.f30287e.reset();
            }
        }
        this.f30287e.reset();
        return -1;
    }

    private boolean d() throws IOException {
        boolean z3;
        this.f30287e.compact();
        int read = this.f30284b.read(this.f30287e.array(), this.f30287e.arrayOffset() + this.f30287e.position(), this.f30287e.remaining());
        if (read > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            ByteBuffer byteBuffer = this.f30287e;
            byteBuffer.position(byteBuffer.position() + read);
        }
        this.f30287e.flip();
        return z3;
    }

    private String e(int i4) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (i4 > 0) {
            if (this.f30287e.remaining() == 0 && !d()) {
                throw a("Reached the end of bundle when more data was expected.");
            }
            int min = Math.min(i4, this.f30287e.remaining());
            byteArrayOutputStream.write(this.f30287e.array(), this.f30287e.arrayOffset() + this.f30287e.position(), min);
            ByteBuffer byteBuffer = this.f30287e;
            byteBuffer.position(byteBuffer.position() + min);
            i4 -= min;
        }
        return byteArrayOutputStream.toString(f30282g.name());
    }

    @Nullable
    private String f() throws IOException {
        int c4;
        do {
            c4 = c();
            if (c4 != -1) {
                break;
            }
        } while (d());
        if (this.f30287e.remaining() == 0) {
            return null;
        }
        if (c4 != -1) {
            byte[] bArr = new byte[c4];
            this.f30287e.get(bArr);
            return f30282g.decode(ByteBuffer.wrap(bArr)).toString();
        }
        throw a("Reached the end of bundle when a length string is expected.");
    }

    @Nullable
    private BundleElement g() throws IOException, JSONException {
        int parseInt;
        String f4 = f();
        if (f4 == null) {
            return null;
        }
        String e4 = e(Integer.parseInt(f4));
        this.f30288f += f4.getBytes(f30282g).length + parseInt;
        return b(e4);
    }

    public void close() throws IOException {
        this.f30284b.close();
    }

    public BundleMetadata getBundleMetadata() throws IOException, JSONException {
        BundleMetadata bundleMetadata = this.f30286d;
        if (bundleMetadata != null) {
            return bundleMetadata;
        }
        BundleElement g4 = g();
        if (g4 instanceof BundleMetadata) {
            BundleMetadata bundleMetadata2 = (BundleMetadata) g4;
            this.f30286d = bundleMetadata2;
            this.f30288f = 0L;
            return bundleMetadata2;
        }
        throw a("Expected first element in bundle to be a metadata object");
    }

    public long getBytesRead() {
        return this.f30288f;
    }

    public BundleElement getNextElement() throws IOException, JSONException {
        getBundleMetadata();
        return g();
    }
}
