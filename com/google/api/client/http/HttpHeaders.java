package com.google.api.client.http;

import com.google.api.client.util.ArrayValueMap;
import com.google.api.client.util.Base64;
import com.google.api.client.util.ClassInfo;
import com.google.api.client.util.Data;
import com.google.api.client.util.FieldInfo;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.StringUtils;
import com.google.api.client.util.Throwables;
import com.google.api.client.util.Types;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes5.dex */
public class HttpHeaders extends GenericData {
    @Key(com.google.common.net.HttpHeaders.ACCEPT)
    private List<String> accept;
    @Key(com.google.common.net.HttpHeaders.ACCEPT_ENCODING)
    private List<String> acceptEncoding;
    @Key(com.google.common.net.HttpHeaders.AGE)
    private List<Long> age;
    @Key("WWW-Authenticate")
    private List<String> authenticate;
    @Key("Authorization")
    private List<String> authorization;
    @Key(com.google.common.net.HttpHeaders.CACHE_CONTROL)
    private List<String> cacheControl;
    @Key("Content-Encoding")
    private List<String> contentEncoding;
    @Key("Content-Length")
    private List<Long> contentLength;
    @Key(com.google.common.net.HttpHeaders.CONTENT_MD5)
    private List<String> contentMD5;
    @Key(com.google.common.net.HttpHeaders.CONTENT_RANGE)
    private List<String> contentRange;
    @Key("Content-Type")
    private List<String> contentType;
    @Key("Cookie")
    private List<String> cookie;
    @Key("Date")
    private List<String> date;
    @Key(com.google.common.net.HttpHeaders.ETAG)
    private List<String> etag;
    @Key(com.google.common.net.HttpHeaders.EXPIRES)
    private List<String> expires;
    @Key(com.google.common.net.HttpHeaders.IF_MATCH)
    private List<String> ifMatch;
    @Key(com.google.common.net.HttpHeaders.IF_MODIFIED_SINCE)
    private List<String> ifModifiedSince;
    @Key(com.google.common.net.HttpHeaders.IF_NONE_MATCH)
    private List<String> ifNoneMatch;
    @Key(com.google.common.net.HttpHeaders.IF_RANGE)
    private List<String> ifRange;
    @Key(com.google.common.net.HttpHeaders.IF_UNMODIFIED_SINCE)
    private List<String> ifUnmodifiedSince;
    @Key(com.google.common.net.HttpHeaders.LAST_MODIFIED)
    private List<String> lastModified;
    @Key(com.google.common.net.HttpHeaders.LOCATION)
    private List<String> location;
    @Key("MIME-Version")
    private List<String> mimeVersion;
    @Key(com.google.common.net.HttpHeaders.RANGE)
    private List<String> range;
    @Key(com.google.common.net.HttpHeaders.RETRY_AFTER)
    private List<String> retryAfter;
    @Key("User-Agent")
    private List<String> userAgent;

    /* loaded from: classes5.dex */
    private static class HeaderParsingFakeLevelHttpRequest extends LowLevelHttpRequest {

        /* renamed from: e  reason: collision with root package name */
        private final HttpHeaders f25775e;

        /* renamed from: f  reason: collision with root package name */
        private final ParseHeaderState f25776f;

        HeaderParsingFakeLevelHttpRequest(HttpHeaders httpHeaders, ParseHeaderState parseHeaderState) {
            this.f25775e = httpHeaders;
            this.f25776f = parseHeaderState;
        }

        @Override // com.google.api.client.http.LowLevelHttpRequest
        public void addHeader(String str, String str2) {
            this.f25775e.e(str, str2, this.f25776f);
        }

        @Override // com.google.api.client.http.LowLevelHttpRequest
        public LowLevelHttpResponse execute() throws IOException {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class ParseHeaderState {

        /* renamed from: a  reason: collision with root package name */
        final ArrayValueMap f25777a;

        /* renamed from: b  reason: collision with root package name */
        final StringBuilder f25778b;

        /* renamed from: c  reason: collision with root package name */
        final ClassInfo f25779c;

        /* renamed from: d  reason: collision with root package name */
        final List<Type> f25780d;

        public ParseHeaderState(HttpHeaders httpHeaders, StringBuilder sb) {
            Class<?> cls = httpHeaders.getClass();
            this.f25780d = Arrays.asList(cls);
            this.f25779c = ClassInfo.of(cls, true);
            this.f25778b = sb;
            this.f25777a = new ArrayValueMap(httpHeaders);
        }

        void a() {
            this.f25777a.setValues();
        }
    }

    public HttpHeaders() {
        super(EnumSet.of(GenericData.Flags.IGNORE_CASE));
        this.acceptEncoding = new ArrayList(Collections.singleton("gzip"));
    }

    private static void a(Logger logger, StringBuilder sb, StringBuilder sb2, LowLevelHttpRequest lowLevelHttpRequest, String str, Object obj, Writer writer) throws IOException {
        String str2;
        if (obj != null && !Data.isNull(obj)) {
            String i4 = i(obj);
            if ((!"Authorization".equalsIgnoreCase(str) && !"Cookie".equalsIgnoreCase(str)) || (logger != null && logger.isLoggable(Level.ALL))) {
                str2 = i4;
            } else {
                str2 = "<Not Logged>";
            }
            if (sb != null) {
                sb.append(str);
                sb.append(": ");
                sb.append(str2);
                sb.append(StringUtils.LINE_SEPARATOR);
            }
            if (sb2 != null) {
                sb2.append(" -H '");
                sb2.append(str);
                sb2.append(": ");
                sb2.append(str2);
                sb2.append("'");
            }
            if (lowLevelHttpRequest != null) {
                lowLevelHttpRequest.addHeader(str, i4);
            }
            if (writer != null) {
                writer.write(str);
                writer.write(": ");
                writer.write(i4);
                writer.write("\r\n");
            }
        }
    }

    private <T> List<T> c(T t3) {
        if (t3 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(t3);
        return arrayList;
    }

    private <T> T d(List<T> list) {
        if (list == null) {
            return null;
        }
        return list.get(0);
    }

    private static Object f(Type type, List<Type> list, String str) {
        return Data.parsePrimitiveValue(Data.resolveWildcardTypeOrTypeVariable(list, type), str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void g(HttpHeaders httpHeaders, StringBuilder sb, StringBuilder sb2, Logger logger, LowLevelHttpRequest lowLevelHttpRequest) throws IOException {
        h(httpHeaders, sb, sb2, logger, lowLevelHttpRequest, null);
    }

    static void h(HttpHeaders httpHeaders, StringBuilder sb, StringBuilder sb2, Logger logger, LowLevelHttpRequest lowLevelHttpRequest, Writer writer) throws IOException {
        HashSet hashSet = new HashSet();
        for (Map.Entry<String, Object> entry : httpHeaders.entrySet()) {
            String key = entry.getKey();
            Preconditions.checkArgument(hashSet.add(key), "multiple headers of the same name (headers are case insensitive): %s", key);
            Object value = entry.getValue();
            if (value != null) {
                FieldInfo fieldInfo = httpHeaders.getClassInfo().getFieldInfo(key);
                if (fieldInfo != null) {
                    key = fieldInfo.getName();
                }
                String str = key;
                Class<?> cls = value.getClass();
                if (!(value instanceof Iterable) && !cls.isArray()) {
                    a(logger, sb, sb2, lowLevelHttpRequest, str, value, writer);
                } else {
                    for (Object obj : Types.iterableOf(value)) {
                        a(logger, sb, sb2, lowLevelHttpRequest, str, obj, writer);
                    }
                }
            }
        }
        if (writer != null) {
            writer.flush();
        }
    }

    private static String i(Object obj) {
        if (obj instanceof Enum) {
            return FieldInfo.of((Enum) obj).getName();
        }
        return obj.toString();
    }

    public static void serializeHeadersForMultipartRequests(HttpHeaders httpHeaders, StringBuilder sb, Logger logger, Writer writer) throws IOException {
        h(httpHeaders, sb, null, logger, null, writer);
    }

    void e(String str, String str2, ParseHeaderState parseHeaderState) {
        Type iterableParameter;
        List<Type> list = parseHeaderState.f25780d;
        ClassInfo classInfo = parseHeaderState.f25779c;
        ArrayValueMap arrayValueMap = parseHeaderState.f25777a;
        StringBuilder sb = parseHeaderState.f25778b;
        if (sb != null) {
            String valueOf = String.valueOf(str);
            String valueOf2 = String.valueOf(str2);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 2 + valueOf2.length());
            sb2.append(valueOf);
            sb2.append(": ");
            sb2.append(valueOf2);
            sb.append(sb2.toString());
            sb.append(StringUtils.LINE_SEPARATOR);
        }
        FieldInfo fieldInfo = classInfo.getFieldInfo(str);
        if (fieldInfo != null) {
            Type resolveWildcardTypeOrTypeVariable = Data.resolveWildcardTypeOrTypeVariable(list, fieldInfo.getGenericType());
            if (Types.isArray(resolveWildcardTypeOrTypeVariable)) {
                Class<?> rawArrayComponentType = Types.getRawArrayComponentType(list, Types.getArrayComponentType(resolveWildcardTypeOrTypeVariable));
                arrayValueMap.put(fieldInfo.getField(), rawArrayComponentType, f(rawArrayComponentType, list, str2));
                return;
            } else if (Types.isAssignableToOrFrom(Types.getRawArrayComponentType(list, resolveWildcardTypeOrTypeVariable), Iterable.class)) {
                Collection<Object> collection = (Collection) fieldInfo.getValue(this);
                if (collection == null) {
                    collection = Data.newCollectionInstance(resolveWildcardTypeOrTypeVariable);
                    fieldInfo.setValue(this, collection);
                }
                if (resolveWildcardTypeOrTypeVariable == Object.class) {
                    iterableParameter = null;
                } else {
                    iterableParameter = Types.getIterableParameter(resolveWildcardTypeOrTypeVariable);
                }
                collection.add(f(iterableParameter, list, str2));
                return;
            } else {
                fieldInfo.setValue(this, f(resolveWildcardTypeOrTypeVariable, list, str2));
                return;
            }
        }
        ArrayList arrayList = (ArrayList) get(str);
        if (arrayList == null) {
            arrayList = new ArrayList();
            set(str, (Object) arrayList);
        }
        arrayList.add(str2);
    }

    public final void fromHttpHeaders(HttpHeaders httpHeaders) {
        try {
            ParseHeaderState parseHeaderState = new ParseHeaderState(this, null);
            g(httpHeaders, null, null, null, new HeaderParsingFakeLevelHttpRequest(this, parseHeaderState));
            parseHeaderState.a();
        } catch (IOException e4) {
            throw Throwables.propagate(e4);
        }
    }

    public final void fromHttpResponse(LowLevelHttpResponse lowLevelHttpResponse, StringBuilder sb) throws IOException {
        clear();
        ParseHeaderState parseHeaderState = new ParseHeaderState(this, sb);
        int headerCount = lowLevelHttpResponse.getHeaderCount();
        for (int i4 = 0; i4 < headerCount; i4++) {
            e(lowLevelHttpResponse.getHeaderName(i4), lowLevelHttpResponse.getHeaderValue(i4), parseHeaderState);
        }
        parseHeaderState.a();
    }

    public final String getAccept() {
        return (String) d(this.accept);
    }

    public final String getAcceptEncoding() {
        return (String) d(this.acceptEncoding);
    }

    public final Long getAge() {
        return (Long) d(this.age);
    }

    public final String getAuthenticate() {
        return (String) d(this.authenticate);
    }

    public final List<String> getAuthenticateAsList() {
        return this.authenticate;
    }

    public final String getAuthorization() {
        return (String) d(this.authorization);
    }

    public final List<String> getAuthorizationAsList() {
        return this.authorization;
    }

    public final String getCacheControl() {
        return (String) d(this.cacheControl);
    }

    public final String getContentEncoding() {
        return (String) d(this.contentEncoding);
    }

    public final Long getContentLength() {
        return (Long) d(this.contentLength);
    }

    public final String getContentMD5() {
        return (String) d(this.contentMD5);
    }

    public final String getContentRange() {
        return (String) d(this.contentRange);
    }

    public final String getContentType() {
        return (String) d(this.contentType);
    }

    public final String getCookie() {
        return (String) d(this.cookie);
    }

    public final String getDate() {
        return (String) d(this.date);
    }

    public final String getETag() {
        return (String) d(this.etag);
    }

    public final String getExpires() {
        return (String) d(this.expires);
    }

    public String getFirstHeaderStringValue(String str) {
        Object obj = get(str.toLowerCase());
        if (obj == null) {
            return null;
        }
        Class<?> cls = obj.getClass();
        if ((obj instanceof Iterable) || cls.isArray()) {
            Iterator it = Types.iterableOf(obj).iterator();
            if (it.hasNext()) {
                return i(it.next());
            }
        }
        return i(obj);
    }

    public List<String> getHeaderStringValues(String str) {
        Object obj = get(str.toLowerCase());
        if (obj == null) {
            return Collections.emptyList();
        }
        Class<?> cls = obj.getClass();
        if (!(obj instanceof Iterable) && !cls.isArray()) {
            return Collections.singletonList(i(obj));
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : Types.iterableOf(obj)) {
            arrayList.add(i(obj2));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final String getIfMatch() {
        return (String) d(this.ifMatch);
    }

    public final String getIfModifiedSince() {
        return (String) d(this.ifModifiedSince);
    }

    public final String getIfNoneMatch() {
        return (String) d(this.ifNoneMatch);
    }

    public final String getIfRange() {
        return (String) d(this.ifRange);
    }

    public final String getIfUnmodifiedSince() {
        return (String) d(this.ifUnmodifiedSince);
    }

    public final String getLastModified() {
        return (String) d(this.lastModified);
    }

    public final String getLocation() {
        return (String) d(this.location);
    }

    public final String getMimeVersion() {
        return (String) d(this.mimeVersion);
    }

    public final String getRange() {
        return (String) d(this.range);
    }

    public final String getRetryAfter() {
        return (String) d(this.retryAfter);
    }

    public final String getUserAgent() {
        return (String) d(this.userAgent);
    }

    public HttpHeaders setAccept(String str) {
        this.accept = c(str);
        return this;
    }

    public HttpHeaders setAcceptEncoding(String str) {
        this.acceptEncoding = c(str);
        return this;
    }

    public HttpHeaders setAge(Long l4) {
        this.age = c(l4);
        return this;
    }

    public HttpHeaders setAuthenticate(String str) {
        this.authenticate = c(str);
        return this;
    }

    public HttpHeaders setAuthorization(String str) {
        return setAuthorization(c(str));
    }

    public HttpHeaders setBasicAuthentication(String str, String str2) {
        String str3;
        String valueOf = String.valueOf((String) Preconditions.checkNotNull(str));
        String valueOf2 = String.valueOf((String) Preconditions.checkNotNull(str2));
        StringBuilder sb = new StringBuilder(valueOf.length() + 1 + valueOf2.length());
        sb.append(valueOf);
        sb.append(":");
        sb.append(valueOf2);
        String valueOf3 = String.valueOf(Base64.encodeBase64String(StringUtils.getBytesUtf8(sb.toString())));
        if (valueOf3.length() != 0) {
            str3 = "Basic ".concat(valueOf3);
        } else {
            str3 = new String("Basic ");
        }
        return setAuthorization(str3);
    }

    public HttpHeaders setCacheControl(String str) {
        this.cacheControl = c(str);
        return this;
    }

    public HttpHeaders setContentEncoding(String str) {
        this.contentEncoding = c(str);
        return this;
    }

    public HttpHeaders setContentLength(Long l4) {
        this.contentLength = c(l4);
        return this;
    }

    public HttpHeaders setContentMD5(String str) {
        this.contentMD5 = c(str);
        return this;
    }

    public HttpHeaders setContentRange(String str) {
        this.contentRange = c(str);
        return this;
    }

    public HttpHeaders setContentType(String str) {
        this.contentType = c(str);
        return this;
    }

    public HttpHeaders setCookie(String str) {
        this.cookie = c(str);
        return this;
    }

    public HttpHeaders setDate(String str) {
        this.date = c(str);
        return this;
    }

    public HttpHeaders setETag(String str) {
        this.etag = c(str);
        return this;
    }

    public HttpHeaders setExpires(String str) {
        this.expires = c(str);
        return this;
    }

    public HttpHeaders setIfMatch(String str) {
        this.ifMatch = c(str);
        return this;
    }

    public HttpHeaders setIfModifiedSince(String str) {
        this.ifModifiedSince = c(str);
        return this;
    }

    public HttpHeaders setIfNoneMatch(String str) {
        this.ifNoneMatch = c(str);
        return this;
    }

    public HttpHeaders setIfRange(String str) {
        this.ifRange = c(str);
        return this;
    }

    public HttpHeaders setIfUnmodifiedSince(String str) {
        this.ifUnmodifiedSince = c(str);
        return this;
    }

    public HttpHeaders setLastModified(String str) {
        this.lastModified = c(str);
        return this;
    }

    public HttpHeaders setLocation(String str) {
        this.location = c(str);
        return this;
    }

    public HttpHeaders setMimeVersion(String str) {
        this.mimeVersion = c(str);
        return this;
    }

    public HttpHeaders setRange(String str) {
        this.range = c(str);
        return this;
    }

    public HttpHeaders setRetryAfter(String str) {
        this.retryAfter = c(str);
        return this;
    }

    public HttpHeaders setUserAgent(String str) {
        this.userAgent = c(str);
        return this;
    }

    @Override // com.google.api.client.util.GenericData
    public HttpHeaders set(String str, Object obj) {
        return (HttpHeaders) super.set(str, obj);
    }

    public HttpHeaders setAuthorization(List<String> list) {
        this.authorization = list;
        return this;
    }

    @Override // com.google.api.client.util.GenericData, java.util.AbstractMap
    public HttpHeaders clone() {
        return (HttpHeaders) super.clone();
    }
}
