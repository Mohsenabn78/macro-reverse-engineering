package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.JavaVersion;
import com.google.gson.internal.PreJava9DateFormatProvider;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/* loaded from: classes5.dex */
public final class DefaultDateTypeAdapter<T extends Date> extends TypeAdapter<T> {

    /* renamed from: a  reason: collision with root package name */
    private final DateType<T> f32676a;

    /* renamed from: b  reason: collision with root package name */
    private final List<DateFormat> f32677b;

    /* loaded from: classes5.dex */
    public static abstract class DateType<T extends Date> {
        public static final DateType<Date> DATE = new DateType<Date>(Date.class) { // from class: com.google.gson.internal.bind.DefaultDateTypeAdapter.DateType.1
            @Override // com.google.gson.internal.bind.DefaultDateTypeAdapter.DateType
            protected Date b(Date date) {
                return date;
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private final Class<T> f32678a;

        /* JADX INFO: Access modifiers changed from: protected */
        public DateType(Class<T> cls) {
            this.f32678a = cls;
        }

        private TypeAdapterFactory a(DefaultDateTypeAdapter<T> defaultDateTypeAdapter) {
            return TypeAdapters.newFactory(this.f32678a, defaultDateTypeAdapter);
        }

        protected abstract T b(Date date);

        public final TypeAdapterFactory createAdapterFactory(String str) {
            return a(new DefaultDateTypeAdapter<>(this, str));
        }

        public final TypeAdapterFactory createDefaultsAdapterFactory() {
            return a(new DefaultDateTypeAdapter<>(this, 2, 2));
        }

        public final TypeAdapterFactory createAdapterFactory(int i4) {
            return a(new DefaultDateTypeAdapter<>(this, i4));
        }

        public final TypeAdapterFactory createAdapterFactory(int i4, int i5) {
            return a(new DefaultDateTypeAdapter<>(this, i4, i5));
        }
    }

    private Date a(JsonReader jsonReader) throws IOException {
        String nextString = jsonReader.nextString();
        synchronized (this.f32677b) {
            for (DateFormat dateFormat : this.f32677b) {
                try {
                    return dateFormat.parse(nextString);
                } catch (ParseException unused) {
                }
            }
            try {
                return ISO8601Utils.parse(nextString, new ParsePosition(0));
            } catch (ParseException e4) {
                throw new JsonSyntaxException("Failed parsing '" + nextString + "' as Date; at path " + jsonReader.getPreviousPath(), e4);
            }
        }
    }

    public String toString() {
        DateFormat dateFormat = this.f32677b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }

    @Override // com.google.gson.TypeAdapter
    public T read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        return this.f32676a.b(a(jsonReader));
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Date date) throws IOException {
        String format;
        if (date == null) {
            jsonWriter.nullValue();
            return;
        }
        DateFormat dateFormat = this.f32677b.get(0);
        synchronized (this.f32677b) {
            format = dateFormat.format(date);
        }
        jsonWriter.value(format);
    }

    private DefaultDateTypeAdapter(DateType<T> dateType, String str) {
        ArrayList arrayList = new ArrayList();
        this.f32677b = arrayList;
        Objects.requireNonNull(dateType);
        this.f32676a = dateType;
        Locale locale = Locale.US;
        arrayList.add(new SimpleDateFormat(str, locale));
        if (Locale.getDefault().equals(locale)) {
            return;
        }
        arrayList.add(new SimpleDateFormat(str));
    }

    private DefaultDateTypeAdapter(DateType<T> dateType, int i4) {
        ArrayList arrayList = new ArrayList();
        this.f32677b = arrayList;
        Objects.requireNonNull(dateType);
        this.f32676a = dateType;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateInstance(i4, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateInstance(i4));
        }
        if (JavaVersion.isJava9OrLater()) {
            arrayList.add(PreJava9DateFormatProvider.getUSDateFormat(i4));
        }
    }

    private DefaultDateTypeAdapter(DateType<T> dateType, int i4, int i5) {
        ArrayList arrayList = new ArrayList();
        this.f32677b = arrayList;
        Objects.requireNonNull(dateType);
        this.f32676a = dateType;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(i4, i5, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(i4, i5));
        }
        if (JavaVersion.isJava9OrLater()) {
            arrayList.add(PreJava9DateFormatProvider.getUSDateTimeFormat(i4, i5));
        }
    }
}
