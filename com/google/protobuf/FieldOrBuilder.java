package com.google.protobuf;

import com.google.protobuf.Field;
import java.util.List;

/* loaded from: classes6.dex */
public interface FieldOrBuilder extends MessageLiteOrBuilder {
    Field.Cardinality getCardinality();

    int getCardinalityValue();

    String getDefaultValue();

    ByteString getDefaultValueBytes();

    String getJsonName();

    ByteString getJsonNameBytes();

    Field.Kind getKind();

    int getKindValue();

    String getName();

    ByteString getNameBytes();

    int getNumber();

    int getOneofIndex();

    Option getOptions(int i4);

    int getOptionsCount();

    List<Option> getOptionsList();

    boolean getPacked();

    String getTypeUrl();

    ByteString getTypeUrlBytes();
}
