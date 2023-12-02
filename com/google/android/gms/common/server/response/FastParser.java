package com.google.android.gms.common.server.response;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.util.Base64Utils;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import kotlin.text.Typography;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.pool.TypePool;
import okio.internal._BufferKt;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
@ShowFirstParty
@KeepForSdk
/* loaded from: classes4.dex */
public class FastParser<T extends FastJsonResponse> {

    /* renamed from: g  reason: collision with root package name */
    private static final char[] f20659g = {'u', 'l', 'l'};

    /* renamed from: h  reason: collision with root package name */
    private static final char[] f20660h = {Advice.OffsetMapping.ForOrigin.Renderer.ForReturnTypeName.SYMBOL, 'u', 'e'};

    /* renamed from: i  reason: collision with root package name */
    private static final char[] f20661i = {Advice.OffsetMapping.ForOrigin.Renderer.ForReturnTypeName.SYMBOL, 'u', 'e', Typography.quote};

    /* renamed from: j  reason: collision with root package name */
    private static final char[] f20662j = {'a', 'l', Advice.OffsetMapping.ForOrigin.Renderer.ForJavaSignature.SYMBOL, 'e'};

    /* renamed from: k  reason: collision with root package name */
    private static final char[] f20663k = {'a', 'l', Advice.OffsetMapping.ForOrigin.Renderer.ForJavaSignature.SYMBOL, 'e', Typography.quote};

    /* renamed from: l  reason: collision with root package name */
    private static final char[] f20664l = {'\n'};

    /* renamed from: m  reason: collision with root package name */
    private static final zai f20665m = new zaa();

    /* renamed from: n  reason: collision with root package name */
    private static final zai f20666n = new zab();

    /* renamed from: o  reason: collision with root package name */
    private static final zai f20667o = new zac();

    /* renamed from: p  reason: collision with root package name */
    private static final zai f20668p = new zad();

    /* renamed from: q  reason: collision with root package name */
    private static final zai f20669q = new zae();

    /* renamed from: r  reason: collision with root package name */
    private static final zai f20670r = new zaf();

    /* renamed from: s  reason: collision with root package name */
    private static final zai f20671s = new zag();

    /* renamed from: t  reason: collision with root package name */
    private static final zai f20672t = new zah();

    /* renamed from: a  reason: collision with root package name */
    private final char[] f20673a = new char[1];

    /* renamed from: b  reason: collision with root package name */
    private final char[] f20674b = new char[32];

    /* renamed from: c  reason: collision with root package name */
    private final char[] f20675c = new char[1024];

    /* renamed from: d  reason: collision with root package name */
    private final StringBuilder f20676d = new StringBuilder(32);

    /* renamed from: e  reason: collision with root package name */
    private final StringBuilder f20677e = new StringBuilder(1024);

    /* renamed from: f  reason: collision with root package name */
    private final Stack f20678f = new Stack();

    /* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
    @ShowFirstParty
    @KeepForSdk
    /* loaded from: classes4.dex */
    public static class ParseException extends Exception {
        public ParseException(@NonNull String str) {
            super(str);
        }

        public ParseException(@NonNull String str, @NonNull Throwable th) {
            super("Error instantiating inner object", th);
        }

        public ParseException(@NonNull Throwable th) {
            super(th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @ResultIgnorabilityUnspecified
    private final boolean A(BufferedReader bufferedReader, FastJsonResponse fastJsonResponse) throws ParseException, IOException {
        HashMap hashMap;
        Map<String, FastJsonResponse.Field<?, ?>> fieldMappings = fastJsonResponse.getFieldMappings();
        String r4 = r(bufferedReader);
        if (r4 != null) {
            while (r4 != null) {
                FastJsonResponse.Field<?, ?> field = fieldMappings.get(r4);
                if (field == null) {
                    r4 = s(bufferedReader);
                } else {
                    this.f20678f.push(4);
                    int i4 = field.f20649b;
                    switch (i4) {
                        case 0:
                            if (field.f20650c) {
                                fastJsonResponse.zav(field, v(bufferedReader, f20665m));
                                break;
                            } else {
                                fastJsonResponse.zau(field, m(bufferedReader));
                                break;
                            }
                        case 1:
                            if (field.f20650c) {
                                fastJsonResponse.zag(field, v(bufferedReader, f20671s));
                                break;
                            } else {
                                fastJsonResponse.zae(field, u(bufferedReader));
                                break;
                            }
                        case 2:
                            if (field.f20650c) {
                                fastJsonResponse.zay(field, v(bufferedReader, f20666n));
                                break;
                            } else {
                                fastJsonResponse.zax(field, o(bufferedReader));
                                break;
                            }
                        case 3:
                            if (field.f20650c) {
                                fastJsonResponse.zas(field, v(bufferedReader, f20667o));
                                break;
                            } else {
                                fastJsonResponse.zaq(field, l(bufferedReader));
                                break;
                            }
                        case 4:
                            if (field.f20650c) {
                                fastJsonResponse.zao(field, v(bufferedReader, f20668p));
                                break;
                            } else {
                                fastJsonResponse.zam(field, k(bufferedReader));
                                break;
                            }
                        case 5:
                            if (field.f20650c) {
                                fastJsonResponse.zac(field, v(bufferedReader, f20672t));
                                break;
                            } else {
                                fastJsonResponse.zaa(field, t(bufferedReader));
                                break;
                            }
                        case 6:
                            if (field.f20650c) {
                                fastJsonResponse.zaj(field, v(bufferedReader, f20669q));
                                break;
                            } else {
                                fastJsonResponse.zai(field, z(bufferedReader, false));
                                break;
                            }
                        case 7:
                            if (field.f20650c) {
                                fastJsonResponse.zaC(field, v(bufferedReader, f20670r));
                                break;
                            } else {
                                fastJsonResponse.zaA(field, p(bufferedReader));
                                break;
                            }
                        case 8:
                            fastJsonResponse.zal(field, Base64Utils.decode(q(bufferedReader, this.f20675c, this.f20677e, f20664l)));
                            break;
                        case 9:
                            fastJsonResponse.zal(field, Base64Utils.decodeUrlSafe(q(bufferedReader, this.f20675c, this.f20677e, f20664l)));
                            break;
                        case 10:
                            char j4 = j(bufferedReader);
                            if (j4 == 'n') {
                                y(bufferedReader, f20659g);
                                hashMap = null;
                            } else if (j4 == '{') {
                                this.f20678f.push(1);
                                hashMap = new HashMap();
                                while (true) {
                                    char j5 = j(bufferedReader);
                                    if (j5 != 0) {
                                        if (j5 != '\"') {
                                            if (j5 == '}') {
                                                x(1);
                                            }
                                        } else {
                                            String a4 = a(bufferedReader, this.f20674b, this.f20676d, null);
                                            if (j(bufferedReader) == ':') {
                                                if (j(bufferedReader) == '\"') {
                                                    hashMap.put(a4, a(bufferedReader, this.f20674b, this.f20676d, null));
                                                    char j6 = j(bufferedReader);
                                                    if (j6 != ',') {
                                                        if (j6 == '}') {
                                                            x(1);
                                                        } else {
                                                            throw new ParseException("Unexpected character while parsing string map: " + j6);
                                                        }
                                                    }
                                                } else {
                                                    throw new ParseException("Expected String value for key ".concat(String.valueOf(a4)));
                                                }
                                            } else {
                                                throw new ParseException("No map value found for key ".concat(String.valueOf(a4)));
                                            }
                                        }
                                    } else {
                                        throw new ParseException("Unexpected EOF");
                                    }
                                }
                            } else {
                                throw new ParseException("Expected start of a map object");
                            }
                            fastJsonResponse.zaB(field, hashMap);
                            break;
                        case 11:
                            if (field.f20650c) {
                                char j7 = j(bufferedReader);
                                if (j7 == 'n') {
                                    y(bufferedReader, f20659g);
                                    fastJsonResponse.addConcreteTypeArrayInternal(field, field.f20653f, null);
                                    break;
                                } else {
                                    this.f20678f.push(5);
                                    if (j7 == '[') {
                                        fastJsonResponse.addConcreteTypeArrayInternal(field, field.f20653f, w(bufferedReader, field));
                                        break;
                                    } else {
                                        throw new ParseException("Expected array start");
                                    }
                                }
                            } else {
                                char j8 = j(bufferedReader);
                                if (j8 == 'n') {
                                    y(bufferedReader, f20659g);
                                    fastJsonResponse.addConcreteTypeInternal(field, field.f20653f, null);
                                    break;
                                } else {
                                    this.f20678f.push(1);
                                    if (j8 == '{') {
                                        try {
                                            FastJsonResponse zad = field.zad();
                                            A(bufferedReader, zad);
                                            fastJsonResponse.addConcreteTypeInternal(field, field.f20653f, zad);
                                            break;
                                        } catch (IllegalAccessException e4) {
                                            throw new ParseException("Error instantiating inner object", e4);
                                        } catch (InstantiationException e5) {
                                            throw new ParseException("Error instantiating inner object", e5);
                                        }
                                    } else {
                                        throw new ParseException("Expected start of object");
                                    }
                                }
                            }
                        default:
                            throw new ParseException("Invalid field type " + i4);
                    }
                    x(4);
                    x(2);
                    char j9 = j(bufferedReader);
                    if (j9 != ',') {
                        if (j9 == '}') {
                            r4 = null;
                        } else {
                            throw new ParseException("Expected end of object or field separator, but found: " + j9);
                        }
                    } else {
                        r4 = r(bufferedReader);
                    }
                }
            }
            x(1);
            return true;
        }
        x(1);
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0030, code lost:
        throw new com.google.android.gms.common.server.response.FastParser.ParseException("Unexpected control character while reading string");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final java.lang.String a(java.io.BufferedReader r8, char[] r9, java.lang.StringBuilder r10, @androidx.annotation.Nullable char[] r11) throws com.google.android.gms.common.server.response.FastParser.ParseException, java.io.IOException {
        /*
            r0 = 0
            r10.setLength(r0)
            int r1 = r9.length
            r8.mark(r1)
            r1 = 0
            r2 = 0
        La:
            int r3 = r8.read(r9)
            r4 = -1
            if (r3 == r4) goto L67
            r4 = 0
        L12:
            if (r4 >= r3) goto L5f
            char r5 = r9[r4]
            boolean r6 = java.lang.Character.isISOControl(r5)
            if (r6 == 0) goto L31
            if (r11 == 0) goto L29
            r6 = 0
        L1f:
            if (r6 > 0) goto L29
            char r7 = r11[r6]
            if (r7 != r5) goto L26
            goto L31
        L26:
            int r6 = r6 + 1
            goto L1f
        L29:
            com.google.android.gms.common.server.response.FastParser$ParseException r8 = new com.google.android.gms.common.server.response.FastParser$ParseException
            java.lang.String r9 = "Unexpected control character while reading string"
            r8.<init>(r9)
            throw r8
        L31:
            r6 = 34
            r7 = 1
            if (r5 != r6) goto L53
            if (r1 != 0) goto L5b
            r10.append(r9, r0, r4)
            r8.reset()
            int r4 = r4 + r7
            long r0 = (long) r4
            r8.skip(r0)
            if (r2 == 0) goto L4e
            java.lang.String r8 = r10.toString()
            java.lang.String r8 = com.google.android.gms.common.util.JsonUtils.unescapeString(r8)
            return r8
        L4e:
            java.lang.String r8 = r10.toString()
            return r8
        L53:
            r6 = 92
            if (r5 != r6) goto L5b
            r1 = r1 ^ 1
            r2 = 1
            goto L5c
        L5b:
            r1 = 0
        L5c:
            int r4 = r4 + 1
            goto L12
        L5f:
            r10.append(r9, r0, r3)
            int r3 = r9.length
            r8.mark(r3)
            goto La
        L67:
            com.google.android.gms.common.server.response.FastParser$ParseException r8 = new com.google.android.gms.common.server.response.FastParser$ParseException
            java.lang.String r9 = "Unexpected EOF while parsing string"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.server.response.FastParser.a(java.io.BufferedReader, char[], java.lang.StringBuilder, char[]):java.lang.String");
    }

    private final char j(BufferedReader bufferedReader) throws ParseException, IOException {
        if (bufferedReader.read(this.f20673a) == -1) {
            return (char) 0;
        }
        while (Character.isWhitespace(this.f20673a[0])) {
            if (bufferedReader.read(this.f20673a) == -1) {
                return (char) 0;
            }
        }
        return this.f20673a[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final double k(BufferedReader bufferedReader) throws ParseException, IOException {
        int n4 = n(bufferedReader, this.f20675c);
        if (n4 == 0) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        return Double.parseDouble(new String(this.f20675c, 0, n4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float l(BufferedReader bufferedReader) throws ParseException, IOException {
        int n4 = n(bufferedReader, this.f20675c);
        if (n4 == 0) {
            return 0.0f;
        }
        return Float.parseFloat(new String(this.f20675c, 0, n4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int m(BufferedReader bufferedReader) throws ParseException, IOException {
        int i4;
        int i5;
        int i6;
        int i7;
        int n4 = n(bufferedReader, this.f20675c);
        if (n4 == 0) {
            return 0;
        }
        char[] cArr = this.f20675c;
        if (n4 > 0) {
            char c4 = cArr[0];
            if (c4 == '-') {
                i4 = Integer.MIN_VALUE;
            } else {
                i4 = -2147483647;
            }
            if (c4 == '-') {
                i5 = 1;
            } else {
                i5 = 0;
            }
            if (i5 < n4) {
                i6 = i5 + 1;
                int digit = Character.digit(cArr[i5], 10);
                if (digit >= 0) {
                    i7 = -digit;
                } else {
                    throw new ParseException("Unexpected non-digit character");
                }
            } else {
                i6 = i5;
                i7 = 0;
            }
            while (i6 < n4) {
                int i8 = i6 + 1;
                int digit2 = Character.digit(cArr[i6], 10);
                if (digit2 >= 0) {
                    if (i7 >= -214748364) {
                        int i9 = i7 * 10;
                        if (i9 >= i4 + digit2) {
                            i7 = i9 - digit2;
                            i6 = i8;
                        } else {
                            throw new ParseException("Number too large");
                        }
                    } else {
                        throw new ParseException("Number too large");
                    }
                } else {
                    throw new ParseException("Unexpected non-digit character");
                }
            }
            if (i5 != 0) {
                if (i6 <= 1) {
                    throw new ParseException("No digits to parse");
                }
                return i7;
            }
            return -i7;
        }
        throw new ParseException("No number to parse");
    }

    @ResultIgnorabilityUnspecified
    private final int n(BufferedReader bufferedReader, char[] cArr) throws ParseException, IOException {
        int i4;
        char j4 = j(bufferedReader);
        if (j4 != 0) {
            if (j4 != ',') {
                if (j4 == 'n') {
                    y(bufferedReader, f20659g);
                    return 0;
                }
                bufferedReader.mark(1024);
                if (j4 == '\"') {
                    i4 = 0;
                    boolean z3 = false;
                    while (i4 < 1024 && bufferedReader.read(cArr, i4, 1) != -1) {
                        char c4 = cArr[i4];
                        if (!Character.isISOControl(c4)) {
                            if (c4 == '\"') {
                                if (!z3) {
                                    bufferedReader.reset();
                                    bufferedReader.skip(i4 + 1);
                                    return i4;
                                }
                            } else if (c4 == '\\') {
                                z3 = !z3;
                                i4++;
                            }
                            z3 = false;
                            i4++;
                        } else {
                            throw new ParseException("Unexpected control character while reading string");
                        }
                    }
                } else {
                    cArr[0] = j4;
                    i4 = 1;
                    while (i4 < 1024 && bufferedReader.read(cArr, i4, 1) != -1) {
                        char c5 = cArr[i4];
                        if (c5 != '}' && c5 != ',' && !Character.isWhitespace(c5) && cArr[i4] != ']') {
                            i4++;
                        } else {
                            bufferedReader.reset();
                            bufferedReader.skip(i4 - 1);
                            cArr[i4] = 0;
                            return i4;
                        }
                    }
                }
                if (i4 == 1024) {
                    throw new ParseException("Absurdly long value");
                }
                throw new ParseException("Unexpected EOF");
            }
            throw new ParseException("Missing value");
        }
        throw new ParseException("Unexpected EOF");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long o(BufferedReader bufferedReader) throws ParseException, IOException {
        long j4;
        long j5;
        int i4;
        int n4 = n(bufferedReader, this.f20675c);
        if (n4 == 0) {
            return 0L;
        }
        char[] cArr = this.f20675c;
        if (n4 > 0) {
            int i5 = 0;
            char c4 = cArr[0];
            if (c4 == '-') {
                j4 = Long.MIN_VALUE;
            } else {
                j4 = -9223372036854775807L;
            }
            if (c4 == '-') {
                i5 = 1;
            }
            if (i5 < n4) {
                i4 = i5 + 1;
                int digit = Character.digit(cArr[i5], 10);
                if (digit >= 0) {
                    j5 = -digit;
                } else {
                    throw new ParseException("Unexpected non-digit character");
                }
            } else {
                j5 = 0;
                i4 = i5;
            }
            while (i4 < n4) {
                int i6 = i4 + 1;
                int digit2 = Character.digit(cArr[i4], 10);
                if (digit2 >= 0) {
                    if (j5 >= _BufferKt.OVERFLOW_ZONE) {
                        long j6 = j5 * 10;
                        long j7 = digit2;
                        if (j6 >= j4 + j7) {
                            j5 = j6 - j7;
                            i4 = i6;
                        } else {
                            throw new ParseException("Number too large");
                        }
                    } else {
                        throw new ParseException("Number too large");
                    }
                } else {
                    throw new ParseException("Unexpected non-digit character");
                }
            }
            if (i5 != 0) {
                if (i4 <= 1) {
                    throw new ParseException("No digits to parse");
                }
                return j5;
            }
            return -j5;
        }
        throw new ParseException("No number to parse");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public final String p(BufferedReader bufferedReader) throws ParseException, IOException {
        return q(bufferedReader, this.f20674b, this.f20676d, null);
    }

    @Nullable
    private final String q(BufferedReader bufferedReader, char[] cArr, StringBuilder sb, @Nullable char[] cArr2) throws ParseException, IOException {
        char j4 = j(bufferedReader);
        if (j4 != '\"') {
            if (j4 == 'n') {
                y(bufferedReader, f20659g);
                return null;
            }
            throw new ParseException("Expected string");
        }
        return a(bufferedReader, cArr, sb, cArr2);
    }

    @Nullable
    @ResultIgnorabilityUnspecified
    private final String r(BufferedReader bufferedReader) throws ParseException, IOException {
        this.f20678f.push(2);
        char j4 = j(bufferedReader);
        if (j4 != '\"') {
            if (j4 != ']') {
                if (j4 == '}') {
                    x(2);
                    return null;
                }
                throw new ParseException("Unexpected token: " + j4);
            }
            x(2);
            x(1);
            x(5);
            return null;
        }
        this.f20678f.push(3);
        String a4 = a(bufferedReader, this.f20674b, this.f20676d, null);
        x(3);
        if (j(bufferedReader) == ':') {
            return a4;
        }
        throw new ParseException("Expected key/value separator");
    }

    @Nullable
    private final String s(BufferedReader bufferedReader) throws ParseException, IOException {
        bufferedReader.mark(1024);
        char j4 = j(bufferedReader);
        int i4 = 1;
        if (j4 != '\"') {
            if (j4 != ',') {
                if (j4 != '[') {
                    if (j4 != '{') {
                        bufferedReader.reset();
                        n(bufferedReader, this.f20675c);
                    } else {
                        this.f20678f.push(1);
                        bufferedReader.mark(32);
                        char j5 = j(bufferedReader);
                        if (j5 == '}') {
                            x(1);
                        } else if (j5 == '\"') {
                            bufferedReader.reset();
                            r(bufferedReader);
                            do {
                            } while (s(bufferedReader) != null);
                            x(1);
                        } else {
                            throw new ParseException("Unexpected token " + j5);
                        }
                    }
                } else {
                    this.f20678f.push(5);
                    bufferedReader.mark(32);
                    if (j(bufferedReader) == ']') {
                        x(5);
                    } else {
                        bufferedReader.reset();
                        boolean z3 = false;
                        loop1: while (true) {
                            boolean z4 = false;
                            while (i4 > 0) {
                                char j6 = j(bufferedReader);
                                if (j6 != 0) {
                                    if (!Character.isISOControl(j6)) {
                                        if (j6 == '\"') {
                                            if (!z4) {
                                                z3 = !z3;
                                            }
                                            j6 = Typography.quote;
                                        }
                                        if (j6 == '[') {
                                            if (!z3) {
                                                i4++;
                                            }
                                            j6 = TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH;
                                        }
                                        if (j6 == ']' && !z3) {
                                            i4--;
                                        }
                                        if (j6 == '\\' && z3) {
                                            z4 = !z4;
                                        }
                                    } else {
                                        throw new ParseException("Unexpected control character while reading array");
                                    }
                                } else {
                                    throw new ParseException("Unexpected EOF while parsing array");
                                }
                            }
                            x(5);
                            break loop1;
                        }
                    }
                }
            } else {
                throw new ParseException("Missing value");
            }
        } else if (bufferedReader.read(this.f20673a) != -1) {
            char c4 = this.f20673a[0];
            boolean z5 = false;
            do {
                if (c4 == '\"') {
                    if (z5) {
                        c4 = Typography.quote;
                        z5 = true;
                    }
                }
                if (c4 == '\\') {
                    z5 = !z5;
                } else {
                    z5 = false;
                }
                if (bufferedReader.read(this.f20673a) != -1) {
                    c4 = this.f20673a[0];
                } else {
                    throw new ParseException("Unexpected EOF while parsing string");
                }
            } while (!Character.isISOControl(c4));
            throw new ParseException("Unexpected control character while reading string");
        } else {
            throw new ParseException("Unexpected EOF while parsing string");
        }
        char j7 = j(bufferedReader);
        if (j7 != ',') {
            if (j7 == '}') {
                x(2);
                return null;
            }
            throw new ParseException("Unexpected token " + j7);
        }
        x(2);
        return r(bufferedReader);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public final BigDecimal t(BufferedReader bufferedReader) throws ParseException, IOException {
        int n4 = n(bufferedReader, this.f20675c);
        if (n4 == 0) {
            return null;
        }
        return new BigDecimal(new String(this.f20675c, 0, n4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public final BigInteger u(BufferedReader bufferedReader) throws ParseException, IOException {
        int n4 = n(bufferedReader, this.f20675c);
        if (n4 == 0) {
            return null;
        }
        return new BigInteger(new String(this.f20675c, 0, n4));
    }

    @Nullable
    private final ArrayList v(BufferedReader bufferedReader, zai zaiVar) throws ParseException, IOException {
        char j4 = j(bufferedReader);
        if (j4 == 'n') {
            y(bufferedReader, f20659g);
            return null;
        } else if (j4 == '[') {
            this.f20678f.push(5);
            ArrayList arrayList = new ArrayList();
            while (true) {
                bufferedReader.mark(1024);
                char j5 = j(bufferedReader);
                if (j5 != 0) {
                    if (j5 != ',') {
                        if (j5 != ']') {
                            bufferedReader.reset();
                            arrayList.add(zaiVar.a(this, bufferedReader));
                        } else {
                            x(5);
                            return arrayList;
                        }
                    }
                } else {
                    throw new ParseException("Unexpected EOF");
                }
            }
        } else {
            throw new ParseException("Expected start of array");
        }
    }

    @Nullable
    private final ArrayList w(BufferedReader bufferedReader, FastJsonResponse.Field field) throws ParseException, IOException {
        ArrayList arrayList = new ArrayList();
        char j4 = j(bufferedReader);
        if (j4 != ']') {
            if (j4 != 'n') {
                if (j4 == '{') {
                    this.f20678f.push(1);
                    while (true) {
                        try {
                            FastJsonResponse zad = field.zad();
                            if (A(bufferedReader, zad)) {
                                arrayList.add(zad);
                                char j5 = j(bufferedReader);
                                if (j5 != ',') {
                                    if (j5 == ']') {
                                        x(5);
                                        return arrayList;
                                    }
                                    throw new ParseException("Unexpected token: " + j5);
                                } else if (j(bufferedReader) == '{') {
                                    this.f20678f.push(1);
                                } else {
                                    throw new ParseException("Expected start of next object in array");
                                }
                            } else {
                                return arrayList;
                            }
                        } catch (IllegalAccessException e4) {
                            throw new ParseException("Error instantiating inner object", e4);
                        } catch (InstantiationException e5) {
                            throw new ParseException("Error instantiating inner object", e5);
                        }
                    }
                } else {
                    throw new ParseException("Unexpected token: " + j4);
                }
            } else {
                y(bufferedReader, f20659g);
                x(5);
                return null;
            }
        } else {
            x(5);
            return arrayList;
        }
    }

    private final void x(int i4) throws ParseException {
        if (!this.f20678f.isEmpty()) {
            int intValue = ((Integer) this.f20678f.pop()).intValue();
            if (intValue == i4) {
                return;
            }
            throw new ParseException("Expected state " + i4 + " but had " + intValue);
        }
        throw new ParseException("Expected state " + i4 + " but had empty stack");
    }

    private final void y(BufferedReader bufferedReader, char[] cArr) throws ParseException, IOException {
        int i4 = 0;
        while (true) {
            int length = cArr.length;
            if (i4 < length) {
                int read = bufferedReader.read(this.f20674b, 0, length - i4);
                if (read != -1) {
                    for (int i5 = 0; i5 < read; i5++) {
                        if (cArr[i5 + i4] != this.f20674b[i5]) {
                            throw new ParseException("Unexpected character");
                        }
                    }
                    i4 += read;
                } else {
                    throw new ParseException("Unexpected EOF");
                }
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean z(BufferedReader bufferedReader, boolean z3) throws ParseException, IOException {
        char[] cArr;
        char[] cArr2;
        char j4 = j(bufferedReader);
        if (j4 != '\"') {
            if (j4 != 'f') {
                if (j4 != 'n') {
                    if (j4 == 't') {
                        if (z3) {
                            cArr2 = f20661i;
                        } else {
                            cArr2 = f20660h;
                        }
                        y(bufferedReader, cArr2);
                        return true;
                    }
                    throw new ParseException("Unexpected token: " + j4);
                }
                y(bufferedReader, f20659g);
                return false;
            }
            if (z3) {
                cArr = f20663k;
            } else {
                cArr = f20662j;
            }
            y(bufferedReader, cArr);
            return false;
        } else if (!z3) {
            return z(bufferedReader, true);
        } else {
            throw new ParseException("No boolean value found in string");
        }
    }

    @KeepForSdk
    public void parse(@NonNull InputStream inputStream, @NonNull T t3) throws ParseException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 1024);
        try {
            try {
                this.f20678f.push(0);
                char j4 = j(bufferedReader);
                if (j4 != 0) {
                    if (j4 != '[') {
                        if (j4 == '{') {
                            this.f20678f.push(1);
                            A(bufferedReader, t3);
                        } else {
                            throw new ParseException("Unexpected token: " + j4);
                        }
                    } else {
                        this.f20678f.push(5);
                        Map<String, FastJsonResponse.Field<?, ?>> fieldMappings = t3.getFieldMappings();
                        if (fieldMappings.size() == 1) {
                            FastJsonResponse.Field<?, ?> value = fieldMappings.entrySet().iterator().next().getValue();
                            t3.addConcreteTypeArrayInternal(value, value.f20653f, w(bufferedReader, value));
                        } else {
                            throw new ParseException("Object array response class must have a single Field");
                        }
                    }
                    x(0);
                    try {
                        bufferedReader.close();
                        return;
                    } catch (IOException unused) {
                        Log.w("FastParser", "Failed to close reader while parsing.");
                        return;
                    }
                }
                throw new ParseException("No data to parse");
            } catch (IOException e4) {
                throw new ParseException(e4);
            }
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (IOException unused2) {
                Log.w("FastParser", "Failed to close reader while parsing.");
            }
            throw th;
        }
    }
}
