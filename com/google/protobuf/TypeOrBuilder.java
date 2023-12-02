package com.google.protobuf;

import java.util.List;

/* loaded from: classes6.dex */
public interface TypeOrBuilder extends MessageLiteOrBuilder {
    Field getFields(int i4);

    int getFieldsCount();

    List<Field> getFieldsList();

    String getName();

    ByteString getNameBytes();

    String getOneofs(int i4);

    ByteString getOneofsBytes(int i4);

    int getOneofsCount();

    List<String> getOneofsList();

    Option getOptions(int i4);

    int getOptionsCount();

    List<Option> getOptionsList();

    SourceContext getSourceContext();

    Syntax getSyntax();

    int getSyntaxValue();

    boolean hasSourceContext();
}
