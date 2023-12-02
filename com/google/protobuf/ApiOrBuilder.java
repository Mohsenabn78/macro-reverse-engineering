package com.google.protobuf;

import java.util.List;

/* loaded from: classes6.dex */
public interface ApiOrBuilder extends MessageLiteOrBuilder {
    Method getMethods(int i4);

    int getMethodsCount();

    List<Method> getMethodsList();

    Mixin getMixins(int i4);

    int getMixinsCount();

    List<Mixin> getMixinsList();

    String getName();

    ByteString getNameBytes();

    Option getOptions(int i4);

    int getOptionsCount();

    List<Option> getOptionsList();

    SourceContext getSourceContext();

    Syntax getSyntax();

    int getSyntaxValue();

    String getVersion();

    ByteString getVersionBytes();

    boolean hasSourceContext();
}
