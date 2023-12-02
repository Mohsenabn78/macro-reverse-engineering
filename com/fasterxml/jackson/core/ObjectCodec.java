package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.type.ResolvedType;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.util.Iterator;

/* loaded from: classes3.dex */
public abstract class ObjectCodec {
    protected ObjectCodec() {
    }

    public abstract TreeNode createArrayNode();

    public abstract TreeNode createObjectNode();

    public JsonFactory getFactory() {
        return getJsonFactory();
    }

    @Deprecated
    public abstract JsonFactory getJsonFactory();

    public abstract <T extends TreeNode> T readTree(JsonParser jsonParser) throws IOException, JsonProcessingException;

    public abstract <T> T readValue(JsonParser jsonParser, ResolvedType resolvedType) throws IOException, JsonProcessingException;

    public abstract <T> T readValue(JsonParser jsonParser, TypeReference<?> typeReference) throws IOException, JsonProcessingException;

    public abstract <T> T readValue(JsonParser jsonParser, Class<T> cls) throws IOException, JsonProcessingException;

    public abstract <T> Iterator<T> readValues(JsonParser jsonParser, ResolvedType resolvedType) throws IOException, JsonProcessingException;

    public abstract <T> Iterator<T> readValues(JsonParser jsonParser, TypeReference<?> typeReference) throws IOException, JsonProcessingException;

    public abstract <T> Iterator<T> readValues(JsonParser jsonParser, Class<T> cls) throws IOException, JsonProcessingException;

    public abstract JsonParser treeAsTokens(TreeNode treeNode);

    public abstract <T> T treeToValue(TreeNode treeNode, Class<T> cls) throws JsonProcessingException;

    public abstract void writeValue(JsonGenerator jsonGenerator, Object obj) throws IOException, JsonProcessingException;
}
