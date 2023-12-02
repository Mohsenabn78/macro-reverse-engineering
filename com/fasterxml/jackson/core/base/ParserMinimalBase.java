package com.fasterxml.jackson.core.base;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.io.NumberInput;
import com.fasterxml.jackson.core.util.VersionUtil;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.IOException;

/* loaded from: classes3.dex */
public abstract class ParserMinimalBase extends JsonParser {

    /* renamed from: b  reason: collision with root package name */
    protected JsonToken f17696b;

    /* renamed from: c  reason: collision with root package name */
    protected JsonToken f17697c;

    /* loaded from: classes3.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f17698a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            f17698a = iArr;
            try {
                iArr[JsonToken.START_OBJECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17698a[JsonToken.START_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17698a[JsonToken.END_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f17698a[JsonToken.END_ARRAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f17698a[JsonToken.VALUE_NUMBER_INT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f17698a[JsonToken.VALUE_TRUE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f17698a[JsonToken.VALUE_FALSE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f17698a[JsonToken.VALUE_NULL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f17698a[JsonToken.VALUE_EMBEDDED_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f17698a[JsonToken.VALUE_STRING.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f17698a[JsonToken.VALUE_NUMBER_FLOAT.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final String f(int i4) {
        char c4 = (char) i4;
        if (Character.isISOControl(c4)) {
            return "(CTRL-CHAR, code " + i4 + ")";
        } else if (i4 > 255) {
            return "'" + c4 + "' (code " + i4 + " / 0x" + Integer.toHexString(i4) + ")";
        } else {
            return "'" + c4 + "' (code " + i4 + ")";
        }
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public void clearCurrentToken() {
        JsonToken jsonToken = this.f17696b;
        if (jsonToken != null) {
            this.f17697c = jsonToken;
            this.f17696b = null;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonParser, java.io.Closeable, java.lang.AutoCloseable
    public abstract void close() throws IOException;

    protected final JsonParseException d(String str, Throwable th) {
        return new JsonParseException(str, getCurrentLocation(), th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x001b, code lost:
        if (r4 >= 0) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
        k(r13, r2, 0, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0020, code lost:
        if (r3 < r0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0022, code lost:
        i();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0025, code lost:
        r2 = r3 + 1;
        r3 = r11.charAt(r3);
        r6 = r13.decodeBase64Char(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
        if (r6 >= 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0031, code lost:
        k(r13, r3, 1, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0035, code lost:
        r3 = (r4 << 6) | r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0038, code lost:
        if (r2 < r0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003e, code lost:
        if (r13.usesPadding() != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0040, code lost:
        r12.append(r3 >> 4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0047, code lost:
        i();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004a, code lost:
        r4 = r2 + 1;
        r2 = r11.charAt(r2);
        r6 = r13.decodeBase64Char(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0057, code lost:
        if (r6 >= 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0059, code lost:
        if (r6 == (-2)) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005b, code lost:
        k(r13, r2, 2, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005e, code lost:
        if (r4 < r0) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0060, code lost:
        i();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0063, code lost:
        r2 = r4 + 1;
        r4 = r11.charAt(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006d, code lost:
        if (r13.usesPaddingChar(r4) != false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006f, code lost:
        k(r13, r4, 3, "expected padding character '" + r13.getPaddingChar() + "'");
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x008c, code lost:
        r12.append(r3 >> 4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0093, code lost:
        r2 = (r3 << 6) | r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0096, code lost:
        if (r4 < r0) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x009c, code lost:
        if (r13.usesPadding() != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x009e, code lost:
        r12.appendTwoBytes(r2 >> 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00a4, code lost:
        i();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a7, code lost:
        r3 = r4 + 1;
        r4 = r11.charAt(r4);
        r6 = r13.decodeBase64Char(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b1, code lost:
        if (r6 >= 0) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00b3, code lost:
        if (r6 == (-2)) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00b5, code lost:
        k(r13, r4, 3, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00b8, code lost:
        r12.appendTwoBytes(r2 >> 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00be, code lost:
        r12.appendThreeBytes((r2 << 6) | r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00c4, code lost:
        r2 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ca, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0016, code lost:
        r4 = r13.decodeBase64Char(r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void e(java.lang.String r11, com.fasterxml.jackson.core.util.ByteArrayBuilder r12, com.fasterxml.jackson.core.Base64Variant r13) throws java.io.IOException, com.fasterxml.jackson.core.JsonParseException {
        /*
            r10 = this;
            int r0 = r11.length()
            r1 = 0
            r2 = 0
        L6:
            if (r2 >= r0) goto Lca
        L8:
            int r3 = r2 + 1
            char r2 = r11.charAt(r2)
            if (r3 < r0) goto L12
            goto Lca
        L12:
            r4 = 32
            if (r2 <= r4) goto Lc7
            int r4 = r13.decodeBase64Char(r2)
            r5 = 0
            if (r4 >= 0) goto L20
            r10.k(r13, r2, r1, r5)
        L20:
            if (r3 < r0) goto L25
            r10.i()
        L25:
            int r2 = r3 + 1
            char r3 = r11.charAt(r3)
            int r6 = r13.decodeBase64Char(r3)
            if (r6 >= 0) goto L35
            r7 = 1
            r10.k(r13, r3, r7, r5)
        L35:
            int r3 = r4 << 6
            r3 = r3 | r6
            if (r2 < r0) goto L4a
            boolean r4 = r13.usesPadding()
            if (r4 != 0) goto L47
            int r11 = r3 >> 4
            r12.append(r11)
            goto Lca
        L47:
            r10.i()
        L4a:
            int r4 = r2 + 1
            char r2 = r11.charAt(r2)
            int r6 = r13.decodeBase64Char(r2)
            r7 = 3
            r8 = -2
            r9 = 2
            if (r6 >= 0) goto L93
            if (r6 == r8) goto L5e
            r10.k(r13, r2, r9, r5)
        L5e:
            if (r4 < r0) goto L63
            r10.i()
        L63:
            int r2 = r4 + 1
            char r4 = r11.charAt(r4)
            boolean r5 = r13.usesPaddingChar(r4)
            if (r5 != 0) goto L8c
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "expected padding character '"
            r5.append(r6)
            char r6 = r13.getPaddingChar()
            r5.append(r6)
            java.lang.String r6 = "'"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            r10.k(r13, r4, r7, r5)
        L8c:
            int r3 = r3 >> 4
            r12.append(r3)
            goto L6
        L93:
            int r2 = r3 << 6
            r2 = r2 | r6
            if (r4 < r0) goto La7
            boolean r3 = r13.usesPadding()
            if (r3 != 0) goto La4
            int r11 = r2 >> 2
            r12.appendTwoBytes(r11)
            goto Lca
        La4:
            r10.i()
        La7:
            int r3 = r4 + 1
            char r4 = r11.charAt(r4)
            int r6 = r13.decodeBase64Char(r4)
            if (r6 >= 0) goto Lbe
            if (r6 == r8) goto Lb8
            r10.k(r13, r4, r7, r5)
        Lb8:
            int r2 = r2 >> 2
            r12.appendTwoBytes(r2)
            goto Lc4
        Lbe:
            int r2 = r2 << 6
            r2 = r2 | r6
            r12.appendThreeBytes(r2)
        Lc4:
            r2 = r3
            goto L6
        Lc7:
            r2 = r3
            goto L8
        Lca:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.base.ParserMinimalBase.e(java.lang.String, com.fasterxml.jackson.core.util.ByteArrayBuilder, com.fasterxml.jackson.core.Base64Variant):void");
    }

    protected abstract void g() throws JsonParseException;

    @Override // com.fasterxml.jackson.core.JsonParser
    public abstract byte[] getBinaryValue(Base64Variant base64Variant) throws IOException, JsonParseException;

    @Override // com.fasterxml.jackson.core.JsonParser
    public abstract String getCurrentName() throws IOException, JsonParseException;

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonToken getCurrentToken() {
        return this.f17696b;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonToken getLastClearedToken() {
        return this.f17697c;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public abstract JsonStreamContext getParsingContext();

    @Override // com.fasterxml.jackson.core.JsonParser
    public abstract String getText() throws IOException, JsonParseException;

    @Override // com.fasterxml.jackson.core.JsonParser
    public abstract char[] getTextCharacters() throws IOException, JsonParseException;

    @Override // com.fasterxml.jackson.core.JsonParser
    public abstract int getTextLength() throws IOException, JsonParseException;

    @Override // com.fasterxml.jackson.core.JsonParser
    public abstract int getTextOffset() throws IOException, JsonParseException;

    /* JADX WARN: Removed duplicated region for block: B:13:0x0031 A[RETURN] */
    @Override // com.fasterxml.jackson.core.JsonParser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean getValueAsBoolean(boolean r4) throws java.io.IOException, com.fasterxml.jackson.core.JsonParseException {
        /*
            r3 = this;
            com.fasterxml.jackson.core.JsonToken r0 = r3.f17696b
            if (r0 == 0) goto L3c
            int[] r1 = com.fasterxml.jackson.core.base.ParserMinimalBase.a.f17698a
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 0
            r2 = 1
            switch(r0) {
                case 5: goto L34;
                case 6: goto L33;
                case 7: goto L32;
                case 8: goto L32;
                case 9: goto L12;
                case 10: goto L21;
                default: goto L11;
            }
        L11:
            goto L3c
        L12:
            java.lang.Object r0 = r3.getEmbeddedObject()
            boolean r1 = r0 instanceof java.lang.Boolean
            if (r1 == 0) goto L21
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r4 = r0.booleanValue()
            return r4
        L21:
            java.lang.String r0 = r3.getText()
            java.lang.String r0 = r0.trim()
            java.lang.String r1 = "true"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L3c
            return r2
        L32:
            return r1
        L33:
            return r2
        L34:
            int r4 = r3.getIntValue()
            if (r4 == 0) goto L3b
            r1 = 1
        L3b:
            return r1
        L3c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.base.ParserMinimalBase.getValueAsBoolean(boolean):boolean");
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public double getValueAsDouble(double d4) throws IOException, JsonParseException {
        JsonToken jsonToken = this.f17696b;
        if (jsonToken != null) {
            switch (a.f17698a[jsonToken.ordinal()]) {
                case 5:
                case 11:
                    return getDoubleValue();
                case 6:
                    return 1.0d;
                case 7:
                case 8:
                    return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                case 9:
                    Object embeddedObject = getEmbeddedObject();
                    if (embeddedObject instanceof Number) {
                        return ((Number) embeddedObject).doubleValue();
                    }
                    return d4;
                case 10:
                    return NumberInput.parseAsDouble(getText(), d4);
                default:
                    return d4;
            }
        }
        return d4;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int getValueAsInt(int i4) throws IOException, JsonParseException {
        JsonToken jsonToken = this.f17696b;
        if (jsonToken != null) {
            switch (a.f17698a[jsonToken.ordinal()]) {
                case 5:
                case 11:
                    return getIntValue();
                case 6:
                    return 1;
                case 7:
                case 8:
                    return 0;
                case 9:
                    Object embeddedObject = getEmbeddedObject();
                    if (embeddedObject instanceof Number) {
                        return ((Number) embeddedObject).intValue();
                    }
                    return i4;
                case 10:
                    return NumberInput.parseAsInt(getText(), i4);
                default:
                    return i4;
            }
        }
        return i4;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public long getValueAsLong(long j4) throws IOException, JsonParseException {
        JsonToken jsonToken = this.f17696b;
        if (jsonToken != null) {
            switch (a.f17698a[jsonToken.ordinal()]) {
                case 5:
                case 11:
                    return getLongValue();
                case 6:
                    return 1L;
                case 7:
                case 8:
                    return 0L;
                case 9:
                    Object embeddedObject = getEmbeddedObject();
                    if (embeddedObject instanceof Number) {
                        return ((Number) embeddedObject).longValue();
                    }
                    return j4;
                case 10:
                    return NumberInput.parseAsLong(getText(), j4);
                default:
                    return j4;
            }
        }
        return j4;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public String getValueAsString(String str) throws IOException, JsonParseException {
        JsonToken jsonToken = this.f17696b;
        if (jsonToken != JsonToken.VALUE_STRING && (jsonToken == null || jsonToken == JsonToken.VALUE_NULL || !jsonToken.isScalarValue())) {
            return str;
        }
        return getText();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public char h(char c4) throws JsonProcessingException {
        if (isEnabled(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER)) {
            return c4;
        }
        if (c4 == '\'' && isEnabled(JsonParser.Feature.ALLOW_SINGLE_QUOTES)) {
            return c4;
        }
        j("Unrecognized character escape " + f(c4));
        return c4;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean hasCurrentToken() {
        if (this.f17696b != null) {
            return true;
        }
        return false;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public abstract boolean hasTextCharacters();

    protected void i() throws JsonParseException {
        throw b("Unexpected end-of-String in base64 content");
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public abstract boolean isClosed();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void j(String str) throws JsonParseException {
        throw b(str);
    }

    protected void k(Base64Variant base64Variant, char c4, int i4, String str) throws JsonParseException {
        String str2;
        if (c4 <= ' ') {
            str2 = "Illegal white space character (code 0x" + Integer.toHexString(c4) + ") as character #" + (i4 + 1) + " of 4-char base64 unit: can only used between units";
        } else if (base64Variant.usesPaddingChar(c4)) {
            str2 = "Unexpected padding character ('" + base64Variant.getPaddingChar() + "') as character #" + (i4 + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character";
        } else if (Character.isDefined(c4) && !Character.isISOControl(c4)) {
            str2 = "Illegal character '" + c4 + "' (code 0x" + Integer.toHexString(c4) + ") in base64 content";
        } else {
            str2 = "Illegal character (code 0x" + Integer.toHexString(c4) + ") in base64 content";
        }
        if (str != null) {
            str2 = str2 + ": " + str;
        }
        throw b(str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l() throws JsonParseException {
        m(" in " + this.f17696b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(String str) throws JsonParseException {
        j("Unexpected end-of-input" + str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n() throws JsonParseException {
        m(" in a value");
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public abstract JsonToken nextToken() throws IOException, JsonParseException;

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonToken nextValue() throws IOException, JsonParseException {
        JsonToken nextToken = nextToken();
        if (nextToken == JsonToken.FIELD_NAME) {
            return nextToken();
        }
        return nextToken;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(int i4, String str) throws JsonParseException {
        String str2 = "Unexpected character (" + f(i4) + ")";
        if (str != null) {
            str2 = str2 + ": " + str;
        }
        j(str2);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public abstract void overrideCurrentName(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void p() {
        throw new RuntimeException("Internal error: this code path should never get executed");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(int i4) throws JsonParseException {
        j("Illegal character (" + f((char) i4) + "): only regular white space (\\r, \\n, \\t) is allowed between tokens");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r(int i4, String str) throws JsonParseException {
        if (!isEnabled(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS) || i4 >= 32) {
            j("Illegal unquoted character (" + f((char) i4) + "): has to be escaped using backslash to be included in " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void s(String str, Throwable th) throws JsonParseException {
        throw d(str, th);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonParser skipChildren() throws IOException, JsonParseException {
        JsonToken jsonToken = this.f17696b;
        if (jsonToken != JsonToken.START_OBJECT && jsonToken != JsonToken.START_ARRAY) {
            return this;
        }
        int i4 = 1;
        while (true) {
            JsonToken nextToken = nextToken();
            if (nextToken == null) {
                g();
                return this;
            }
            int i5 = a.f17698a[nextToken.ordinal()];
            if (i5 != 1 && i5 != 2) {
                if (i5 == 3 || i5 == 4) {
                    i4--;
                    if (i4 == 0) {
                        return this;
                    }
                }
            } else {
                i4++;
            }
        }
    }

    @Override // com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.core.Versioned
    public Version version() {
        return VersionUtil.versionFor(getClass());
    }
}
