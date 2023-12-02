package com.google.common.net;

import com.arlosoft.macrodroid.data.HomeTile;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Ascii;
import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Map;
import javax.annotation.CheckForNull;
import kotlin.text.Typography;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import net.bytebuddy.pool.TypePool;

@Immutable
@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class MediaType {

    /* renamed from: a  reason: collision with root package name */
    private final String f28125a;

    /* renamed from: b  reason: collision with root package name */
    private final String f28126b;

    /* renamed from: c  reason: collision with root package name */
    private final ImmutableListMultimap<String, String> f28127c;
    @CheckForNull
    @LazyInit

    /* renamed from: d  reason: collision with root package name */
    private String f28128d;
    @LazyInit

    /* renamed from: e  reason: collision with root package name */
    private int f28129e;
    @CheckForNull
    @LazyInit

    /* renamed from: f  reason: collision with root package name */
    private Optional<Charset> f28130f;

    /* renamed from: g  reason: collision with root package name */
    private static final ImmutableListMultimap<String, String> f28119g = ImmutableListMultimap.of("charset", Ascii.toLowerCase(Charsets.UTF_8.name()));

    /* renamed from: h  reason: collision with root package name */
    private static final CharMatcher f28120h = CharMatcher.ascii().and(CharMatcher.javaIsoControl().negate()).and(CharMatcher.isNot(' ')).and(CharMatcher.noneOf("()<>@,;:\\\"/[]?="));

    /* renamed from: i  reason: collision with root package name */
    private static final CharMatcher f28121i = CharMatcher.ascii().and(CharMatcher.noneOf("\"\\\r"));

    /* renamed from: j  reason: collision with root package name */
    private static final CharMatcher f28122j = CharMatcher.anyOf(" \t\r\n");

    /* renamed from: k  reason: collision with root package name */
    private static final Map<MediaType, MediaType> f28123k = Maps.newHashMap();
    public static final MediaType ANY_TYPE = e("*", "*");
    public static final MediaType ANY_TEXT_TYPE = e("text", "*");
    public static final MediaType ANY_IMAGE_TYPE = e("image", "*");
    public static final MediaType ANY_AUDIO_TYPE = e("audio", "*");
    public static final MediaType ANY_VIDEO_TYPE = e("video", "*");
    public static final MediaType ANY_APPLICATION_TYPE = e("application", "*");
    public static final MediaType ANY_FONT_TYPE = e("font", "*");
    public static final MediaType CACHE_MANIFEST_UTF_8 = f("text", "cache-manifest");
    public static final MediaType CSS_UTF_8 = f("text", "css");
    public static final MediaType CSV_UTF_8 = f("text", "csv");
    public static final MediaType HTML_UTF_8 = f("text", "html");
    public static final MediaType I_CALENDAR_UTF_8 = f("text", "calendar");
    public static final MediaType PLAIN_TEXT_UTF_8 = f("text", "plain");
    public static final MediaType TEXT_JAVASCRIPT_UTF_8 = f("text", "javascript");
    public static final MediaType TSV_UTF_8 = f("text", "tab-separated-values");
    public static final MediaType VCARD_UTF_8 = f("text", "vcard");
    public static final MediaType WML_UTF_8 = f("text", "vnd.wap.wml");
    public static final MediaType XML_UTF_8 = f("text", "xml");
    public static final MediaType VTT_UTF_8 = f("text", "vtt");
    public static final MediaType BMP = e("image", "bmp");
    public static final MediaType CRW = e("image", "x-canon-crw");
    public static final MediaType GIF = e("image", "gif");
    public static final MediaType ICO = e("image", "vnd.microsoft.icon");
    public static final MediaType JPEG = e("image", "jpeg");
    public static final MediaType PNG = e("image", "png");
    public static final MediaType PSD = e("image", "vnd.adobe.photoshop");
    public static final MediaType SVG_UTF_8 = f("image", "svg+xml");
    public static final MediaType TIFF = e("image", "tiff");
    public static final MediaType WEBP = e("image", "webp");
    public static final MediaType HEIF = e("image", "heif");
    public static final MediaType JP2K = e("image", "jp2");
    public static final MediaType MP4_AUDIO = e("audio", "mp4");
    public static final MediaType MPEG_AUDIO = e("audio", "mpeg");
    public static final MediaType OGG_AUDIO = e("audio", "ogg");
    public static final MediaType WEBM_AUDIO = e("audio", "webm");
    public static final MediaType L16_AUDIO = e("audio", "l16");
    public static final MediaType L24_AUDIO = e("audio", "l24");
    public static final MediaType BASIC_AUDIO = e("audio", HomeTile.TILE_TYPE_BASIC);
    public static final MediaType AAC_AUDIO = e("audio", "aac");
    public static final MediaType VORBIS_AUDIO = e("audio", "vorbis");
    public static final MediaType WMA_AUDIO = e("audio", "x-ms-wma");
    public static final MediaType WAX_AUDIO = e("audio", "x-ms-wax");
    public static final MediaType VND_REAL_AUDIO = e("audio", "vnd.rn-realaudio");
    public static final MediaType VND_WAVE_AUDIO = e("audio", "vnd.wave");
    public static final MediaType MP4_VIDEO = e("video", "mp4");
    public static final MediaType MPEG_VIDEO = e("video", "mpeg");
    public static final MediaType OGG_VIDEO = e("video", "ogg");
    public static final MediaType QUICKTIME = e("video", "quicktime");
    public static final MediaType WEBM_VIDEO = e("video", "webm");
    public static final MediaType WMV = e("video", "x-ms-wmv");
    public static final MediaType FLV_VIDEO = e("video", "x-flv");
    public static final MediaType THREE_GPP_VIDEO = e("video", "3gpp");
    public static final MediaType THREE_GPP2_VIDEO = e("video", "3gpp2");
    public static final MediaType APPLICATION_XML_UTF_8 = f("application", "xml");
    public static final MediaType ATOM_UTF_8 = f("application", "atom+xml");
    public static final MediaType BZIP2 = e("application", "x-bzip2");
    public static final MediaType DART_UTF_8 = f("application", "dart");
    public static final MediaType APPLE_PASSBOOK = e("application", "vnd.apple.pkpass");
    public static final MediaType EOT = e("application", "vnd.ms-fontobject");
    public static final MediaType EPUB = e("application", "epub+zip");
    public static final MediaType FORM_DATA = e("application", "x-www-form-urlencoded");
    public static final MediaType KEY_ARCHIVE = e("application", "pkcs12");
    public static final MediaType APPLICATION_BINARY = e("application", "binary");
    public static final MediaType GEO_JSON = e("application", "geo+json");
    public static final MediaType GZIP = e("application", "x-gzip");
    public static final MediaType HAL_JSON = e("application", "hal+json");
    public static final MediaType JAVASCRIPT_UTF_8 = f("application", "javascript");
    public static final MediaType JOSE = e("application", "jose");
    public static final MediaType JOSE_JSON = e("application", "jose+json");
    public static final MediaType JSON_UTF_8 = f("application", "json");
    public static final MediaType JWT = e("application", "jwt");
    public static final MediaType MANIFEST_JSON_UTF_8 = f("application", "manifest+json");
    public static final MediaType KML = e("application", "vnd.google-earth.kml+xml");
    public static final MediaType KMZ = e("application", "vnd.google-earth.kmz");
    public static final MediaType MBOX = e("application", "mbox");
    public static final MediaType APPLE_MOBILE_CONFIG = e("application", "x-apple-aspen-config");
    public static final MediaType MICROSOFT_EXCEL = e("application", "vnd.ms-excel");
    public static final MediaType MICROSOFT_OUTLOOK = e("application", "vnd.ms-outlook");
    public static final MediaType MICROSOFT_POWERPOINT = e("application", "vnd.ms-powerpoint");
    public static final MediaType MICROSOFT_WORD = e("application", "msword");
    public static final MediaType MEDIA_PRESENTATION_DESCRIPTION = e("application", "dash+xml");
    public static final MediaType WASM_APPLICATION = e("application", "wasm");
    public static final MediaType NACL_APPLICATION = e("application", "x-nacl");
    public static final MediaType NACL_PORTABLE_APPLICATION = e("application", "x-pnacl");
    public static final MediaType OCTET_STREAM = e("application", "octet-stream");
    public static final MediaType OGG_CONTAINER = e("application", "ogg");
    public static final MediaType OOXML_DOCUMENT = e("application", "vnd.openxmlformats-officedocument.wordprocessingml.document");
    public static final MediaType OOXML_PRESENTATION = e("application", "vnd.openxmlformats-officedocument.presentationml.presentation");
    public static final MediaType OOXML_SHEET = e("application", "vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    public static final MediaType OPENDOCUMENT_GRAPHICS = e("application", "vnd.oasis.opendocument.graphics");
    public static final MediaType OPENDOCUMENT_PRESENTATION = e("application", "vnd.oasis.opendocument.presentation");
    public static final MediaType OPENDOCUMENT_SPREADSHEET = e("application", "vnd.oasis.opendocument.spreadsheet");
    public static final MediaType OPENDOCUMENT_TEXT = e("application", "vnd.oasis.opendocument.text");
    public static final MediaType OPENSEARCH_DESCRIPTION_UTF_8 = f("application", "opensearchdescription+xml");
    public static final MediaType PDF = e("application", "pdf");
    public static final MediaType POSTSCRIPT = e("application", "postscript");
    public static final MediaType PROTOBUF = e("application", "protobuf");
    public static final MediaType RDF_XML_UTF_8 = f("application", "rdf+xml");
    public static final MediaType RTF_UTF_8 = f("application", "rtf");
    public static final MediaType SFNT = e("application", "font-sfnt");
    public static final MediaType SHOCKWAVE_FLASH = e("application", "x-shockwave-flash");
    public static final MediaType SKETCHUP = e("application", "vnd.sketchup.skp");
    public static final MediaType SOAP_XML_UTF_8 = f("application", "soap+xml");
    public static final MediaType TAR = e("application", "x-tar");
    public static final MediaType WOFF = e("application", "font-woff");
    public static final MediaType WOFF2 = e("application", "font-woff2");
    public static final MediaType XHTML_UTF_8 = f("application", "xhtml+xml");
    public static final MediaType XRD_UTF_8 = f("application", "xrd+xml");
    public static final MediaType ZIP = e("application", "zip");
    public static final MediaType FONT_COLLECTION = e("font", "collection");
    public static final MediaType FONT_OTF = e("font", "otf");
    public static final MediaType FONT_SFNT = e("font", "sfnt");
    public static final MediaType FONT_TTF = e("font", "ttf");
    public static final MediaType FONT_WOFF = e("font", "woff");
    public static final MediaType FONT_WOFF2 = e("font", "woff2");

    /* renamed from: l  reason: collision with root package name */
    private static final Joiner.MapJoiner f28124l = Joiner.on("; ").withKeyValueSeparator("=");

    /* loaded from: classes5.dex */
    private static final class Tokenizer {

        /* renamed from: a  reason: collision with root package name */
        final String f28131a;

        /* renamed from: b  reason: collision with root package name */
        int f28132b = 0;

        Tokenizer(String str) {
            this.f28131a = str;
        }

        @CanIgnoreReturnValue
        char a(char c4) {
            boolean z3;
            Preconditions.checkState(e());
            if (f() == c4) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkState(z3);
            this.f28132b++;
            return c4;
        }

        char b(CharMatcher charMatcher) {
            Preconditions.checkState(e());
            char f4 = f();
            Preconditions.checkState(charMatcher.matches(f4));
            this.f28132b++;
            return f4;
        }

        String c(CharMatcher charMatcher) {
            boolean z3;
            int i4 = this.f28132b;
            String d4 = d(charMatcher);
            if (this.f28132b != i4) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkState(z3);
            return d4;
        }

        @CanIgnoreReturnValue
        String d(CharMatcher charMatcher) {
            Preconditions.checkState(e());
            int i4 = this.f28132b;
            this.f28132b = charMatcher.negate().indexIn(this.f28131a, i4);
            if (e()) {
                return this.f28131a.substring(i4, this.f28132b);
            }
            return this.f28131a.substring(i4);
        }

        boolean e() {
            int i4 = this.f28132b;
            if (i4 >= 0 && i4 < this.f28131a.length()) {
                return true;
            }
            return false;
        }

        char f() {
            Preconditions.checkState(e());
            return this.f28131a.charAt(this.f28132b);
        }
    }

    private MediaType(String str, String str2, ImmutableListMultimap<String, String> immutableListMultimap) {
        this.f28125a = str;
        this.f28126b = str2;
        this.f28127c = immutableListMultimap;
    }

    private static MediaType b(MediaType mediaType) {
        f28123k.put(mediaType, mediaType);
        return mediaType;
    }

    private String c() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f28125a);
        sb.append('/');
        sb.append(this.f28126b);
        if (!this.f28127c.isEmpty()) {
            sb.append("; ");
            f28124l.appendTo(sb, Multimaps.transformValues((ListMultimap) this.f28127c, new Function() { // from class: com.google.common.net.b
                @Override // com.google.common.base.Function
                public final Object apply(Object obj) {
                    String h4;
                    h4 = MediaType.h((String) obj);
                    return h4;
                }
            }).entries());
        }
        return sb.toString();
    }

    public static MediaType create(String str, String str2) {
        MediaType d4 = d(str, str2, ImmutableListMultimap.of());
        d4.f28130f = Optional.absent();
        return d4;
    }

    private static MediaType d(String str, String str2, Multimap<String, String> multimap) {
        boolean z3;
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str2);
        Preconditions.checkNotNull(multimap);
        String j4 = j(str);
        String j5 = j(str2);
        if ("*".equals(j4) && !"*".equals(j5)) {
            z3 = false;
        } else {
            z3 = true;
        }
        Preconditions.checkArgument(z3, "A wildcard type cannot be used with a non-wildcard subtype");
        ImmutableListMultimap.Builder builder = ImmutableListMultimap.builder();
        for (Map.Entry<String, String> entry : multimap.entries()) {
            String j6 = j(entry.getKey());
            builder.put((ImmutableListMultimap.Builder) j6, i(j6, entry.getValue()));
        }
        MediaType mediaType = new MediaType(j4, j5, builder.build());
        return (MediaType) MoreObjects.firstNonNull(f28123k.get(mediaType), mediaType);
    }

    private static MediaType e(String str, String str2) {
        MediaType b4 = b(new MediaType(str, str2, ImmutableListMultimap.of()));
        b4.f28130f = Optional.absent();
        return b4;
    }

    private static MediaType f(String str, String str2) {
        MediaType b4 = b(new MediaType(str, str2, f28119g));
        b4.f28130f = Optional.of(Charsets.UTF_8);
        return b4;
    }

    private static String g(String str) {
        StringBuilder sb = new StringBuilder(str.length() + 16);
        sb.append(Typography.quote);
        for (int i4 = 0; i4 < str.length(); i4++) {
            char charAt = str.charAt(i4);
            if (charAt == '\r' || charAt == '\\' || charAt == '\"') {
                sb.append('\\');
            }
            sb.append(charAt);
        }
        sb.append(Typography.quote);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String h(String str) {
        if (!f28120h.matchesAllOf(str) || str.isEmpty()) {
            return g(str);
        }
        return str;
    }

    private static String i(String str, String str2) {
        Preconditions.checkNotNull(str2);
        Preconditions.checkArgument(CharMatcher.ascii().matchesAllOf(str2), "parameter values must be ASCII: %s", str2);
        if ("charset".equals(str)) {
            return Ascii.toLowerCase(str2);
        }
        return str2;
    }

    private static String j(String str) {
        Preconditions.checkArgument(f28120h.matchesAllOf(str));
        Preconditions.checkArgument(!str.isEmpty());
        return Ascii.toLowerCase(str);
    }

    private Map<String, ImmutableMultiset<String>> k() {
        return Maps.transformValues(this.f28127c.asMap(), new Function() { // from class: com.google.common.net.a
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return ImmutableMultiset.copyOf((Collection) obj);
            }
        });
    }

    @CanIgnoreReturnValue
    public static MediaType parse(String str) {
        String c4;
        Preconditions.checkNotNull(str);
        Tokenizer tokenizer = new Tokenizer(str);
        try {
            CharMatcher charMatcher = f28120h;
            String c5 = tokenizer.c(charMatcher);
            tokenizer.a('/');
            String c6 = tokenizer.c(charMatcher);
            ImmutableListMultimap.Builder builder = ImmutableListMultimap.builder();
            while (tokenizer.e()) {
                CharMatcher charMatcher2 = f28122j;
                tokenizer.d(charMatcher2);
                tokenizer.a(TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER);
                tokenizer.d(charMatcher2);
                CharMatcher charMatcher3 = f28120h;
                String c7 = tokenizer.c(charMatcher3);
                tokenizer.a(SignatureVisitor.INSTANCEOF);
                if ('\"' == tokenizer.f()) {
                    tokenizer.a(Typography.quote);
                    StringBuilder sb = new StringBuilder();
                    while ('\"' != tokenizer.f()) {
                        if ('\\' == tokenizer.f()) {
                            tokenizer.a('\\');
                            sb.append(tokenizer.b(CharMatcher.ascii()));
                        } else {
                            sb.append(tokenizer.c(f28121i));
                        }
                    }
                    c4 = sb.toString();
                    tokenizer.a(Typography.quote);
                } else {
                    c4 = tokenizer.c(charMatcher3);
                }
                builder.put((ImmutableListMultimap.Builder) c7, c4);
            }
            return d(c5, c6, builder.build());
        } catch (IllegalStateException e4) {
            throw new IllegalArgumentException("Could not parse '" + str + "'", e4);
        }
    }

    public Optional<Charset> charset() {
        Optional<Charset> optional = this.f28130f;
        if (optional == null) {
            optional = Optional.absent();
            UnmodifiableIterator<String> it = this.f28127c.get((ImmutableListMultimap<String, String>) "charset").iterator();
            String str = null;
            while (it.hasNext()) {
                String next = it.next();
                if (str == null) {
                    optional = Optional.of(Charset.forName(next));
                    str = next;
                } else if (!str.equals(next)) {
                    throw new IllegalStateException("Multiple charset values defined: " + str + ", " + next);
                }
            }
            this.f28130f = optional;
        }
        return optional;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MediaType)) {
            return false;
        }
        MediaType mediaType = (MediaType) obj;
        if (this.f28125a.equals(mediaType.f28125a) && this.f28126b.equals(mediaType.f28126b) && k().equals(mediaType.k())) {
            return true;
        }
        return false;
    }

    public boolean hasWildcard() {
        if (!"*".equals(this.f28125a) && !"*".equals(this.f28126b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i4 = this.f28129e;
        if (i4 == 0) {
            int hashCode = Objects.hashCode(this.f28125a, this.f28126b, k());
            this.f28129e = hashCode;
            return hashCode;
        }
        return i4;
    }

    public boolean is(MediaType mediaType) {
        if ((mediaType.f28125a.equals("*") || mediaType.f28125a.equals(this.f28125a)) && ((mediaType.f28126b.equals("*") || mediaType.f28126b.equals(this.f28126b)) && this.f28127c.entries().containsAll(mediaType.f28127c.entries()))) {
            return true;
        }
        return false;
    }

    public ImmutableListMultimap<String, String> parameters() {
        return this.f28127c;
    }

    public String subtype() {
        return this.f28126b;
    }

    public String toString() {
        String str = this.f28128d;
        if (str == null) {
            String c4 = c();
            this.f28128d = c4;
            return c4;
        }
        return str;
    }

    public String type() {
        return this.f28125a;
    }

    public MediaType withCharset(Charset charset) {
        Preconditions.checkNotNull(charset);
        MediaType withParameter = withParameter("charset", charset.name());
        withParameter.f28130f = Optional.of(charset);
        return withParameter;
    }

    public MediaType withParameter(String str, String str2) {
        return withParameters(str, ImmutableSet.of(str2));
    }

    public MediaType withParameters(Multimap<String, String> multimap) {
        return d(this.f28125a, this.f28126b, multimap);
    }

    public MediaType withoutParameters() {
        if (this.f28127c.isEmpty()) {
            return this;
        }
        return create(this.f28125a, this.f28126b);
    }

    public MediaType withParameters(String str, Iterable<String> iterable) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(iterable);
        String j4 = j(str);
        ImmutableListMultimap.Builder builder = ImmutableListMultimap.builder();
        UnmodifiableIterator<Map.Entry<String, String>> it = this.f28127c.entries().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            String key = next.getKey();
            if (!j4.equals(key)) {
                builder.put((ImmutableListMultimap.Builder) key, next.getValue());
            }
        }
        for (String str2 : iterable) {
            builder.put((ImmutableListMultimap.Builder) j4, i(j4, str2));
        }
        MediaType mediaType = new MediaType(this.f28125a, this.f28126b, builder.build());
        if (!j4.equals("charset")) {
            mediaType.f28130f = this.f28130f;
        }
        return (MediaType) MoreObjects.firstNonNull(f28123k.get(mediaType), mediaType);
    }
}
