package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.format.InputAccessor;
import com.fasterxml.jackson.core.format.MatchStrength;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.InputDecorator;
import com.fasterxml.jackson.core.io.OutputDecorator;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.core.io.UTF8Writer;
import com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper;
import com.fasterxml.jackson.core.json.CoreVersion;
import com.fasterxml.jackson.core.json.ReaderBasedJsonParser;
import com.fasterxml.jackson.core.json.UTF8JsonGenerator;
import com.fasterxml.jackson.core.json.WriterBasedJsonGenerator;
import com.fasterxml.jackson.core.sym.BytesToNameCanonicalizer;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringReader;
import java.io.Writer;
import java.lang.ref.SoftReference;
import java.net.URL;

/* loaded from: classes3.dex */
public class JsonFactory implements Versioned, Serializable {
    public static final String FORMAT_NAME_JSON = "JSON";

    /* renamed from: c  reason: collision with root package name */
    protected static final int f17648c = Feature.collectDefaults();

    /* renamed from: d  reason: collision with root package name */
    protected static final int f17649d = JsonParser.Feature.collectDefaults();

    /* renamed from: e  reason: collision with root package name */
    protected static final int f17650e = JsonGenerator.Feature.collectDefaults();

    /* renamed from: f  reason: collision with root package name */
    private static final SerializableString f17651f = DefaultPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;

    /* renamed from: g  reason: collision with root package name */
    protected static final ThreadLocal<SoftReference<BufferRecycler>> f17652g = new ThreadLocal<>();
    private static final long serialVersionUID = 8726401676402117450L;
    protected CharacterEscapes _characterEscapes;
    protected int _factoryFeatures;
    protected int _generatorFeatures;
    protected InputDecorator _inputDecorator;
    protected ObjectCodec _objectCodec;
    protected OutputDecorator _outputDecorator;
    protected int _parserFeatures;
    protected SerializableString _rootValueSeparator;

    /* renamed from: a  reason: collision with root package name */
    protected final transient CharsToNameCanonicalizer f17653a;

    /* renamed from: b  reason: collision with root package name */
    protected final transient BytesToNameCanonicalizer f17654b;

    /* loaded from: classes3.dex */
    public enum Feature {
        INTERN_FIELD_NAMES(true),
        CANONICALIZE_FIELD_NAMES(true);
        
        private final boolean _defaultState;

        Feature(boolean z3) {
            this._defaultState = z3;
        }

        public static int collectDefaults() {
            Feature[] values;
            int i4 = 0;
            for (Feature feature : values()) {
                if (feature.enabledByDefault()) {
                    i4 |= feature.getMask();
                }
            }
            return i4;
        }

        public boolean enabledByDefault() {
            return this._defaultState;
        }

        public boolean enabledIn(int i4) {
            if ((i4 & getMask()) != 0) {
                return true;
            }
            return false;
        }

        public int getMask() {
            return 1 << ordinal();
        }
    }

    public JsonFactory() {
        this(null);
    }

    public BufferRecycler _getBufferRecycler() {
        BufferRecycler bufferRecycler;
        ThreadLocal<SoftReference<BufferRecycler>> threadLocal = f17652g;
        SoftReference<BufferRecycler> softReference = threadLocal.get();
        if (softReference == null) {
            bufferRecycler = null;
        } else {
            bufferRecycler = softReference.get();
        }
        if (bufferRecycler == null) {
            BufferRecycler bufferRecycler2 = new BufferRecycler();
            threadLocal.set(new SoftReference<>(bufferRecycler2));
            return bufferRecycler2;
        }
        return bufferRecycler;
    }

    protected void a(Class<?> cls) {
        if (getClass() == cls) {
            return;
        }
        throw new IllegalStateException("Failed copy(): " + getClass().getName() + " (version: " + version() + ") does not override copy(); it has to");
    }

    protected IOContext b(Object obj, boolean z3) {
        return new IOContext(_getBufferRecycler(), obj, z3);
    }

    protected JsonGenerator c(Writer writer, IOContext iOContext) throws IOException {
        return e(writer, iOContext);
    }

    public boolean canUseSchema(FormatSchema formatSchema) {
        String formatName = getFormatName();
        if (formatName != null && formatName.equals(formatSchema.getSchemaType())) {
            return true;
        }
        return false;
    }

    public final JsonFactory configure(Feature feature, boolean z3) {
        return z3 ? enable(feature) : disable(feature);
    }

    public JsonFactory copy() {
        a(JsonFactory.class);
        return new JsonFactory(null);
    }

    public JsonGenerator createGenerator(OutputStream outputStream, JsonEncoding jsonEncoding) throws IOException {
        return createJsonGenerator(outputStream, jsonEncoding);
    }

    public JsonGenerator createJsonGenerator(OutputStream outputStream, JsonEncoding jsonEncoding) throws IOException {
        IOContext b4 = b(outputStream, false);
        b4.setEncoding(jsonEncoding);
        if (jsonEncoding == JsonEncoding.UTF8) {
            OutputDecorator outputDecorator = this._outputDecorator;
            if (outputDecorator != null) {
                outputStream = outputDecorator.decorate(b4, outputStream);
            }
            return m(outputStream, b4);
        }
        Writer n4 = n(outputStream, jsonEncoding, b4);
        OutputDecorator outputDecorator2 = this._outputDecorator;
        if (outputDecorator2 != null) {
            n4 = outputDecorator2.decorate(b4, n4);
        }
        return c(n4, b4);
    }

    public JsonParser createJsonParser(File file) throws IOException, JsonParseException {
        IOContext b4 = b(file, true);
        InputStream fileInputStream = new FileInputStream(file);
        InputDecorator inputDecorator = this._inputDecorator;
        if (inputDecorator != null) {
            fileInputStream = inputDecorator.decorate(b4, fileInputStream);
        }
        return i(fileInputStream, b4);
    }

    public JsonParser createParser(File file) throws IOException, JsonParseException {
        return createJsonParser(file);
    }

    public JsonFactory disable(Feature feature) {
        this._factoryFeatures = (~feature.getMask()) & this._factoryFeatures;
        return this;
    }

    @Deprecated
    protected JsonGenerator e(Writer writer, IOContext iOContext) throws IOException {
        WriterBasedJsonGenerator writerBasedJsonGenerator = new WriterBasedJsonGenerator(iOContext, this._generatorFeatures, this._objectCodec, writer);
        CharacterEscapes characterEscapes = this._characterEscapes;
        if (characterEscapes != null) {
            writerBasedJsonGenerator.setCharacterEscapes(characterEscapes);
        }
        SerializableString serializableString = this._rootValueSeparator;
        if (serializableString != f17651f) {
            writerBasedJsonGenerator.setRootValueSeparator(serializableString);
        }
        return writerBasedJsonGenerator;
    }

    public JsonFactory enable(Feature feature) {
        this._factoryFeatures = feature.getMask() | this._factoryFeatures;
        return this;
    }

    @Deprecated
    protected JsonParser f(InputStream inputStream, IOContext iOContext) throws IOException, JsonParseException {
        return new ByteSourceJsonBootstrapper(iOContext, inputStream).constructParser(this._parserFeatures, this._objectCodec, this.f17654b, this.f17653a, isEnabled(Feature.CANONICALIZE_FIELD_NAMES), isEnabled(Feature.INTERN_FIELD_NAMES));
    }

    @Deprecated
    protected JsonParser g(Reader reader, IOContext iOContext) throws IOException, JsonParseException {
        return new ReaderBasedJsonParser(iOContext, this._parserFeatures, reader, this._objectCodec, this.f17653a.makeChild(isEnabled(Feature.CANONICALIZE_FIELD_NAMES), isEnabled(Feature.INTERN_FIELD_NAMES)));
    }

    public CharacterEscapes getCharacterEscapes() {
        return this._characterEscapes;
    }

    public ObjectCodec getCodec() {
        return this._objectCodec;
    }

    public String getFormatName() {
        if (getClass() == JsonFactory.class) {
            return FORMAT_NAME_JSON;
        }
        return null;
    }

    public InputDecorator getInputDecorator() {
        return this._inputDecorator;
    }

    public OutputDecorator getOutputDecorator() {
        return this._outputDecorator;
    }

    public String getRootValueSeparator() {
        SerializableString serializableString = this._rootValueSeparator;
        if (serializableString == null) {
            return null;
        }
        return serializableString.getValue();
    }

    @Deprecated
    protected JsonParser h(byte[] bArr, int i4, int i5, IOContext iOContext) throws IOException, JsonParseException {
        return new ByteSourceJsonBootstrapper(iOContext, bArr, i4, i5).constructParser(this._parserFeatures, this._objectCodec, this.f17654b, this.f17653a, isEnabled(Feature.CANONICALIZE_FIELD_NAMES), isEnabled(Feature.INTERN_FIELD_NAMES));
    }

    public MatchStrength hasFormat(InputAccessor inputAccessor) throws IOException {
        if (getClass() == JsonFactory.class) {
            return p(inputAccessor);
        }
        return null;
    }

    protected JsonParser i(InputStream inputStream, IOContext iOContext) throws IOException, JsonParseException {
        return f(inputStream, iOContext);
    }

    public final boolean isEnabled(Feature feature) {
        return (feature.getMask() & this._factoryFeatures) != 0;
    }

    protected JsonParser j(Reader reader, IOContext iOContext) throws IOException, JsonParseException {
        return g(reader, iOContext);
    }

    protected JsonParser l(byte[] bArr, int i4, int i5, IOContext iOContext) throws IOException, JsonParseException {
        return h(bArr, i4, i5, iOContext);
    }

    @Deprecated
    protected JsonGenerator m(OutputStream outputStream, IOContext iOContext) throws IOException {
        UTF8JsonGenerator uTF8JsonGenerator = new UTF8JsonGenerator(iOContext, this._generatorFeatures, this._objectCodec, outputStream);
        CharacterEscapes characterEscapes = this._characterEscapes;
        if (characterEscapes != null) {
            uTF8JsonGenerator.setCharacterEscapes(characterEscapes);
        }
        SerializableString serializableString = this._rootValueSeparator;
        if (serializableString != f17651f) {
            uTF8JsonGenerator.setRootValueSeparator(serializableString);
        }
        return uTF8JsonGenerator;
    }

    protected Writer n(OutputStream outputStream, JsonEncoding jsonEncoding, IOContext iOContext) throws IOException {
        if (jsonEncoding == JsonEncoding.UTF8) {
            return new UTF8Writer(iOContext, outputStream);
        }
        return new OutputStreamWriter(outputStream, jsonEncoding.getJavaName());
    }

    protected InputStream o(URL url) throws IOException {
        String host;
        if ("file".equals(url.getProtocol()) && ((host = url.getHost()) == null || host.length() == 0)) {
            if (url.getPath().indexOf(37) < 0) {
                return new FileInputStream(url.getPath());
            }
            return new FileInputStream(url.getPath());
        }
        return url.openStream();
    }

    protected MatchStrength p(InputAccessor inputAccessor) throws IOException {
        return ByteSourceJsonBootstrapper.hasJSONFormat(inputAccessor);
    }

    protected Object readResolve() {
        return new JsonFactory(this._objectCodec);
    }

    public boolean requiresCustomCodec() {
        return false;
    }

    public JsonFactory setCharacterEscapes(CharacterEscapes characterEscapes) {
        this._characterEscapes = characterEscapes;
        return this;
    }

    public JsonFactory setCodec(ObjectCodec objectCodec) {
        this._objectCodec = objectCodec;
        return this;
    }

    public JsonFactory setInputDecorator(InputDecorator inputDecorator) {
        this._inputDecorator = inputDecorator;
        return this;
    }

    public JsonFactory setOutputDecorator(OutputDecorator outputDecorator) {
        this._outputDecorator = outputDecorator;
        return this;
    }

    public JsonFactory setRootValueSeparator(String str) {
        SerializedString serializedString;
        if (str == null) {
            serializedString = null;
        } else {
            serializedString = new SerializedString(str);
        }
        this._rootValueSeparator = serializedString;
        return this;
    }

    @Override // com.fasterxml.jackson.core.Versioned
    public Version version() {
        return CoreVersion.instance.version();
    }

    public JsonFactory(ObjectCodec objectCodec) {
        this.f17653a = CharsToNameCanonicalizer.createRoot();
        this.f17654b = BytesToNameCanonicalizer.createRoot();
        this._factoryFeatures = f17648c;
        this._parserFeatures = f17649d;
        this._generatorFeatures = f17650e;
        this._rootValueSeparator = f17651f;
        this._objectCodec = objectCodec;
    }

    public final JsonFactory configure(JsonParser.Feature feature, boolean z3) {
        return z3 ? enable(feature) : disable(feature);
    }

    public JsonGenerator createGenerator(Writer writer) throws IOException {
        return createJsonGenerator(writer);
    }

    public JsonParser createParser(URL url) throws IOException, JsonParseException {
        return createJsonParser(url);
    }

    public JsonFactory disable(JsonParser.Feature feature) {
        this._parserFeatures = (~feature.getMask()) & this._parserFeatures;
        return this;
    }

    public JsonFactory enable(JsonParser.Feature feature) {
        this._parserFeatures = feature.getMask() | this._parserFeatures;
        return this;
    }

    public final boolean isEnabled(JsonParser.Feature feature) {
        return (feature.getMask() & this._parserFeatures) != 0;
    }

    public final JsonFactory configure(JsonGenerator.Feature feature, boolean z3) {
        return z3 ? enable(feature) : disable(feature);
    }

    public JsonGenerator createGenerator(OutputStream outputStream) throws IOException {
        return createJsonGenerator(outputStream);
    }

    public JsonParser createParser(InputStream inputStream) throws IOException, JsonParseException {
        return createJsonParser(inputStream);
    }

    public JsonFactory disable(JsonGenerator.Feature feature) {
        this._generatorFeatures = (~feature.getMask()) & this._generatorFeatures;
        return this;
    }

    public JsonFactory enable(JsonGenerator.Feature feature) {
        this._generatorFeatures = feature.getMask() | this._generatorFeatures;
        return this;
    }

    public final boolean isEnabled(JsonGenerator.Feature feature) {
        return (feature.getMask() & this._generatorFeatures) != 0;
    }

    public JsonGenerator createGenerator(File file, JsonEncoding jsonEncoding) throws IOException {
        return createJsonGenerator(file, jsonEncoding);
    }

    public JsonParser createParser(Reader reader) throws IOException, JsonParseException {
        return createJsonParser(reader);
    }

    public JsonParser createParser(byte[] bArr) throws IOException, JsonParseException {
        return createJsonParser(bArr);
    }

    public JsonParser createJsonParser(URL url) throws IOException, JsonParseException {
        IOContext b4 = b(url, true);
        InputStream o4 = o(url);
        InputDecorator inputDecorator = this._inputDecorator;
        if (inputDecorator != null) {
            o4 = inputDecorator.decorate(b4, o4);
        }
        return i(o4, b4);
    }

    public JsonParser createParser(byte[] bArr, int i4, int i5) throws IOException, JsonParseException {
        return createJsonParser(bArr, i4, i5);
    }

    public JsonParser createParser(String str) throws IOException, JsonParseException {
        return createJsonParser(str);
    }

    public JsonGenerator createJsonGenerator(Writer writer) throws IOException {
        IOContext b4 = b(writer, false);
        OutputDecorator outputDecorator = this._outputDecorator;
        if (outputDecorator != null) {
            writer = outputDecorator.decorate(b4, writer);
        }
        return c(writer, b4);
    }

    public JsonParser createJsonParser(InputStream inputStream) throws IOException, JsonParseException {
        IOContext b4 = b(inputStream, false);
        InputDecorator inputDecorator = this._inputDecorator;
        if (inputDecorator != null) {
            inputStream = inputDecorator.decorate(b4, inputStream);
        }
        return i(inputStream, b4);
    }

    public JsonGenerator createJsonGenerator(OutputStream outputStream) throws IOException {
        return createJsonGenerator(outputStream, JsonEncoding.UTF8);
    }

    public JsonParser createJsonParser(Reader reader) throws IOException, JsonParseException {
        IOContext b4 = b(reader, false);
        InputDecorator inputDecorator = this._inputDecorator;
        if (inputDecorator != null) {
            reader = inputDecorator.decorate(b4, reader);
        }
        return j(reader, b4);
    }

    public JsonGenerator createJsonGenerator(File file, JsonEncoding jsonEncoding) throws IOException {
        OutputStream fileOutputStream = new FileOutputStream(file);
        IOContext b4 = b(fileOutputStream, true);
        b4.setEncoding(jsonEncoding);
        if (jsonEncoding == JsonEncoding.UTF8) {
            OutputDecorator outputDecorator = this._outputDecorator;
            if (outputDecorator != null) {
                fileOutputStream = outputDecorator.decorate(b4, fileOutputStream);
            }
            return m(fileOutputStream, b4);
        }
        Writer n4 = n(fileOutputStream, jsonEncoding, b4);
        OutputDecorator outputDecorator2 = this._outputDecorator;
        if (outputDecorator2 != null) {
            n4 = outputDecorator2.decorate(b4, n4);
        }
        return c(n4, b4);
    }

    public JsonParser createJsonParser(byte[] bArr) throws IOException, JsonParseException {
        InputStream decorate;
        IOContext b4 = b(bArr, true);
        InputDecorator inputDecorator = this._inputDecorator;
        if (inputDecorator != null && (decorate = inputDecorator.decorate(b4, bArr, 0, bArr.length)) != null) {
            return i(decorate, b4);
        }
        return l(bArr, 0, bArr.length, b4);
    }

    public JsonParser createJsonParser(byte[] bArr, int i4, int i5) throws IOException, JsonParseException {
        InputStream decorate;
        IOContext b4 = b(bArr, true);
        InputDecorator inputDecorator = this._inputDecorator;
        if (inputDecorator != null && (decorate = inputDecorator.decorate(b4, bArr, i4, i5)) != null) {
            return i(decorate, b4);
        }
        return l(bArr, i4, i5, b4);
    }

    public JsonParser createJsonParser(String str) throws IOException, JsonParseException {
        Reader stringReader = new StringReader(str);
        IOContext b4 = b(stringReader, true);
        InputDecorator inputDecorator = this._inputDecorator;
        if (inputDecorator != null) {
            stringReader = inputDecorator.decorate(b4, stringReader);
        }
        return j(stringReader, b4);
    }
}
