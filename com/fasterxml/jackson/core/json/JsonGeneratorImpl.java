package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.core.util.VersionUtil;
import java.io.IOException;

/* loaded from: classes3.dex */
public abstract class JsonGeneratorImpl extends GeneratorBase {

    /* renamed from: l  reason: collision with root package name */
    protected static final int[] f17788l = CharTypes.get7BitOutputEscapes();

    /* renamed from: g  reason: collision with root package name */
    protected final IOContext f17789g;

    /* renamed from: h  reason: collision with root package name */
    protected int[] f17790h;

    /* renamed from: i  reason: collision with root package name */
    protected int f17791i;

    /* renamed from: j  reason: collision with root package name */
    protected CharacterEscapes f17792j;

    /* renamed from: k  reason: collision with root package name */
    protected SerializableString f17793k;

    public JsonGeneratorImpl(IOContext iOContext, int i4, ObjectCodec objectCodec) {
        super(i4, objectCodec);
        this.f17790h = f17788l;
        this.f17793k = DefaultPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        this.f17789g = iOContext;
        if (isEnabled(JsonGenerator.Feature.ESCAPE_NON_ASCII)) {
            setHighestNonEscapedChar(127);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public CharacterEscapes getCharacterEscapes() {
        return this.f17792j;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public int getHighestEscapedChar() {
        return this.f17791i;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public JsonGenerator setCharacterEscapes(CharacterEscapes characterEscapes) {
        this.f17792j = characterEscapes;
        if (characterEscapes == null) {
            this.f17790h = f17788l;
        } else {
            this.f17790h = characterEscapes.getEscapeCodesForAscii();
        }
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public JsonGenerator setHighestNonEscapedChar(int i4) {
        if (i4 < 0) {
            i4 = 0;
        }
        this.f17791i = i4;
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public JsonGenerator setRootValueSeparator(SerializableString serializableString) {
        this.f17793k = serializableString;
        return this;
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.core.Versioned
    public Version version() {
        return VersionUtil.versionFor(getClass());
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeStringField(String str, String str2) throws IOException, JsonGenerationException {
        writeFieldName(str);
        writeString(str2);
    }
}
