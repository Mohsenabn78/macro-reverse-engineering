package com.fasterxml.jackson.core.format;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.format.InputAccessor;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import net.bytebuddy.pool.TypePool;

/* loaded from: classes3.dex */
public class DataFormatDetector {
    public static final int DEFAULT_MAX_INPUT_LOOKAHEAD = 64;

    /* renamed from: a  reason: collision with root package name */
    protected final JsonFactory[] f17699a;

    /* renamed from: b  reason: collision with root package name */
    protected final MatchStrength f17700b;

    /* renamed from: c  reason: collision with root package name */
    protected final MatchStrength f17701c;

    /* renamed from: d  reason: collision with root package name */
    protected final int f17702d;

    public DataFormatDetector(JsonFactory... jsonFactoryArr) {
        this(jsonFactoryArr, MatchStrength.SOLID_MATCH, MatchStrength.WEAK_MATCH, 64);
    }

    private DataFormatMatcher a(InputAccessor.Std std) throws IOException {
        JsonFactory[] jsonFactoryArr = this.f17699a;
        int length = jsonFactoryArr.length;
        JsonFactory jsonFactory = null;
        MatchStrength matchStrength = null;
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                break;
            }
            JsonFactory jsonFactory2 = jsonFactoryArr[i4];
            std.reset();
            MatchStrength hasFormat = jsonFactory2.hasFormat(std);
            if (hasFormat != null && hasFormat.ordinal() >= this.f17701c.ordinal() && (jsonFactory == null || matchStrength.ordinal() < hasFormat.ordinal())) {
                if (hasFormat.ordinal() >= this.f17700b.ordinal()) {
                    jsonFactory = jsonFactory2;
                    matchStrength = hasFormat;
                    break;
                }
                jsonFactory = jsonFactory2;
                matchStrength = hasFormat;
            }
            i4++;
        }
        return std.createMatcher(jsonFactory, matchStrength);
    }

    public DataFormatMatcher findFormat(InputStream inputStream) throws IOException {
        return a(new InputAccessor.Std(inputStream, new byte[this.f17702d]));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH);
        JsonFactory[] jsonFactoryArr = this.f17699a;
        int length = jsonFactoryArr.length;
        if (length > 0) {
            sb.append(jsonFactoryArr[0].getFormatName());
            for (int i4 = 1; i4 < length; i4++) {
                sb.append(", ");
                sb.append(this.f17699a[i4].getFormatName());
            }
        }
        sb.append(']');
        return sb.toString();
    }

    public DataFormatDetector withMaxInputLookahead(int i4) {
        if (i4 == this.f17702d) {
            return this;
        }
        return new DataFormatDetector(this.f17699a, this.f17700b, this.f17701c, i4);
    }

    public DataFormatDetector withMinimalMatch(MatchStrength matchStrength) {
        if (matchStrength == this.f17701c) {
            return this;
        }
        return new DataFormatDetector(this.f17699a, this.f17700b, matchStrength, this.f17702d);
    }

    public DataFormatDetector withOptimalMatch(MatchStrength matchStrength) {
        if (matchStrength == this.f17700b) {
            return this;
        }
        return new DataFormatDetector(this.f17699a, matchStrength, this.f17701c, this.f17702d);
    }

    public DataFormatDetector(Collection<JsonFactory> collection) {
        this((JsonFactory[]) collection.toArray(new JsonFactory[collection.size()]));
    }

    public DataFormatMatcher findFormat(byte[] bArr) throws IOException {
        return a(new InputAccessor.Std(bArr));
    }

    private DataFormatDetector(JsonFactory[] jsonFactoryArr, MatchStrength matchStrength, MatchStrength matchStrength2, int i4) {
        this.f17699a = jsonFactoryArr;
        this.f17700b = matchStrength;
        this.f17701c = matchStrength2;
        this.f17702d = i4;
    }

    public DataFormatMatcher findFormat(byte[] bArr, int i4, int i5) throws IOException {
        return a(new InputAccessor.Std(bArr, i4, i5));
    }
}
