package com.google.gson;

import com.google.gson.internal.NonNullElementWrapperList;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public final class JsonArray extends JsonElement implements Iterable<JsonElement> {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<JsonElement> f32595a;

    public JsonArray() {
        this.f32595a = new ArrayList<>();
    }

    private JsonElement a() {
        int size = this.f32595a.size();
        if (size == 1) {
            return this.f32595a.get(0);
        }
        throw new IllegalStateException("Array must have size 1, but has size " + size);
    }

    public void add(Boolean bool) {
        this.f32595a.add(bool == null ? JsonNull.INSTANCE : new JsonPrimitive(bool));
    }

    public void addAll(JsonArray jsonArray) {
        this.f32595a.addAll(jsonArray.f32595a);
    }

    public List<JsonElement> asList() {
        return new NonNullElementWrapperList(this.f32595a);
    }

    public boolean contains(JsonElement jsonElement) {
        return this.f32595a.contains(jsonElement);
    }

    public boolean equals(Object obj) {
        if (obj != this && (!(obj instanceof JsonArray) || !((JsonArray) obj).f32595a.equals(this.f32595a))) {
            return false;
        }
        return true;
    }

    public JsonElement get(int i4) {
        return this.f32595a.get(i4);
    }

    @Override // com.google.gson.JsonElement
    public BigDecimal getAsBigDecimal() {
        return a().getAsBigDecimal();
    }

    @Override // com.google.gson.JsonElement
    public BigInteger getAsBigInteger() {
        return a().getAsBigInteger();
    }

    @Override // com.google.gson.JsonElement
    public boolean getAsBoolean() {
        return a().getAsBoolean();
    }

    @Override // com.google.gson.JsonElement
    public byte getAsByte() {
        return a().getAsByte();
    }

    @Override // com.google.gson.JsonElement
    @Deprecated
    public char getAsCharacter() {
        return a().getAsCharacter();
    }

    @Override // com.google.gson.JsonElement
    public double getAsDouble() {
        return a().getAsDouble();
    }

    @Override // com.google.gson.JsonElement
    public float getAsFloat() {
        return a().getAsFloat();
    }

    @Override // com.google.gson.JsonElement
    public int getAsInt() {
        return a().getAsInt();
    }

    @Override // com.google.gson.JsonElement
    public long getAsLong() {
        return a().getAsLong();
    }

    @Override // com.google.gson.JsonElement
    public Number getAsNumber() {
        return a().getAsNumber();
    }

    @Override // com.google.gson.JsonElement
    public short getAsShort() {
        return a().getAsShort();
    }

    @Override // com.google.gson.JsonElement
    public String getAsString() {
        return a().getAsString();
    }

    public int hashCode() {
        return this.f32595a.hashCode();
    }

    public boolean isEmpty() {
        return this.f32595a.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<JsonElement> iterator() {
        return this.f32595a.iterator();
    }

    public boolean remove(JsonElement jsonElement) {
        return this.f32595a.remove(jsonElement);
    }

    public JsonElement set(int i4, JsonElement jsonElement) {
        ArrayList<JsonElement> arrayList = this.f32595a;
        if (jsonElement == null) {
            jsonElement = JsonNull.INSTANCE;
        }
        return arrayList.set(i4, jsonElement);
    }

    public int size() {
        return this.f32595a.size();
    }

    public void add(Character ch) {
        this.f32595a.add(ch == null ? JsonNull.INSTANCE : new JsonPrimitive(ch));
    }

    @Override // com.google.gson.JsonElement
    public JsonArray deepCopy() {
        if (!this.f32595a.isEmpty()) {
            JsonArray jsonArray = new JsonArray(this.f32595a.size());
            Iterator<JsonElement> it = this.f32595a.iterator();
            while (it.hasNext()) {
                jsonArray.add(it.next().deepCopy());
            }
            return jsonArray;
        }
        return new JsonArray();
    }

    public JsonElement remove(int i4) {
        return this.f32595a.remove(i4);
    }

    public JsonArray(int i4) {
        this.f32595a = new ArrayList<>(i4);
    }

    public void add(Number number) {
        this.f32595a.add(number == null ? JsonNull.INSTANCE : new JsonPrimitive(number));
    }

    public void add(String str) {
        this.f32595a.add(str == null ? JsonNull.INSTANCE : new JsonPrimitive(str));
    }

    public void add(JsonElement jsonElement) {
        if (jsonElement == null) {
            jsonElement = JsonNull.INSTANCE;
        }
        this.f32595a.add(jsonElement);
    }
}
