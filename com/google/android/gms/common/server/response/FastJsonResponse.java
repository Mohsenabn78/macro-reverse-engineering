package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.MapUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
@ShowFirstParty
@KeepForSdk
/* loaded from: classes4.dex */
public abstract class FastJsonResponse {

    /* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
    @ShowFirstParty
    /* loaded from: classes4.dex */
    public interface FieldConverter<I, O> {
        int zaa();

        int zab();

        @Nullable
        Object zac(@NonNull Object obj);

        @NonNull
        Object zad(@NonNull Object obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public static final Object zaD(@NonNull Field field, @Nullable Object obj) {
        if (field.f20658k != null) {
            return field.zaf(obj);
        }
        return obj;
    }

    private final void zaE(Field field, @Nullable Object obj) {
        String str = field.f20653f;
        Object zae = field.zae(obj);
        int i4 = field.f20651d;
        switch (i4) {
            case 0:
                if (zae != null) {
                    setIntegerInternal(field, str, ((Integer) zae).intValue());
                    return;
                } else {
                    zaG(str);
                    return;
                }
            case 1:
                zaf(field, str, (BigInteger) zae);
                return;
            case 2:
                if (zae != null) {
                    setLongInternal(field, str, ((Long) zae).longValue());
                    return;
                } else {
                    zaG(str);
                    return;
                }
            case 3:
            default:
                throw new IllegalStateException("Unsupported type for conversion: " + i4);
            case 4:
                if (zae != null) {
                    zan(field, str, ((Double) zae).doubleValue());
                    return;
                } else {
                    zaG(str);
                    return;
                }
            case 5:
                zab(field, str, (BigDecimal) zae);
                return;
            case 6:
                if (zae != null) {
                    setBooleanInternal(field, str, ((Boolean) zae).booleanValue());
                    return;
                } else {
                    zaG(str);
                    return;
                }
            case 7:
                setStringInternal(field, str, (String) zae);
                return;
            case 8:
            case 9:
                if (zae != null) {
                    setDecodedBytesInternal(field, str, (byte[]) zae);
                    return;
                } else {
                    zaG(str);
                    return;
                }
        }
    }

    private static final void zaF(StringBuilder sb, Field field, Object obj) {
        int i4 = field.f20649b;
        if (i4 != 11) {
            if (i4 == 7) {
                sb.append("\"");
                sb.append(JsonUtils.escapeString((String) obj));
                sb.append("\"");
                return;
            }
            sb.append(obj);
            return;
        }
        Class cls = field.f20655h;
        Preconditions.checkNotNull(cls);
        sb.append(((FastJsonResponse) cls.cast(obj)).toString());
    }

    private static final void zaG(String str) {
        if (Log.isLoggable("FastJsonResponse", 6)) {
            Log.e("FastJsonResponse", "Output field (" + str + ") has a null value, but expected a primitive");
        }
    }

    @KeepForSdk
    public <T extends FastJsonResponse> void addConcreteTypeArrayInternal(@NonNull Field field, @NonNull String str, @Nullable ArrayList<T> arrayList) {
        throw new UnsupportedOperationException("Concrete type array not supported");
    }

    @KeepForSdk
    public <T extends FastJsonResponse> void addConcreteTypeInternal(@NonNull Field field, @NonNull String str, @NonNull T t3) {
        throw new UnsupportedOperationException("Concrete type not supported");
    }

    @NonNull
    @KeepForSdk
    public abstract Map<String, Field<?, ?>> getFieldMappings();

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    @KeepForSdk
    public Object getFieldValue(@NonNull Field field) {
        boolean z3;
        String str = field.f20653f;
        if (field.f20655h != null) {
            if (getValueObject(str) == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkState(z3, "Concrete field shouldn't be value object: %s", field.f20653f);
            try {
                char upperCase = Character.toUpperCase(str.charAt(0));
                String substring = str.substring(1);
                return getClass().getMethod("get" + upperCase + substring, new Class[0]).invoke(this, new Object[0]);
            } catch (Exception e4) {
                throw new RuntimeException(e4);
            }
        }
        return getValueObject(str);
    }

    @Nullable
    @KeepForSdk
    protected abstract Object getValueObject(@NonNull String str);

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public boolean isFieldSet(@NonNull Field field) {
        if (field.f20651d == 11) {
            if (field.f20652e) {
                throw new UnsupportedOperationException("Concrete type arrays not supported");
            }
            throw new UnsupportedOperationException("Concrete types not supported");
        }
        return isPrimitiveFieldSet(field.f20653f);
    }

    @KeepForSdk
    protected abstract boolean isPrimitiveFieldSet(@NonNull String str);

    @KeepForSdk
    protected void setBooleanInternal(@NonNull Field<?, ?> field, @NonNull String str, boolean z3) {
        throw new UnsupportedOperationException("Boolean not supported");
    }

    @KeepForSdk
    protected void setDecodedBytesInternal(@NonNull Field<?, ?> field, @NonNull String str, @Nullable byte[] bArr) {
        throw new UnsupportedOperationException("byte[] not supported");
    }

    @KeepForSdk
    protected void setIntegerInternal(@NonNull Field<?, ?> field, @NonNull String str, int i4) {
        throw new UnsupportedOperationException("Integer not supported");
    }

    @KeepForSdk
    protected void setLongInternal(@NonNull Field<?, ?> field, @NonNull String str, long j4) {
        throw new UnsupportedOperationException("Long not supported");
    }

    @KeepForSdk
    protected void setStringInternal(@NonNull Field<?, ?> field, @NonNull String str, @Nullable String str2) {
        throw new UnsupportedOperationException("String not supported");
    }

    @KeepForSdk
    protected void setStringMapInternal(@NonNull Field<?, ?> field, @NonNull String str, @Nullable Map<String, String> map) {
        throw new UnsupportedOperationException("String map not supported");
    }

    @KeepForSdk
    protected void setStringsInternal(@NonNull Field<?, ?> field, @NonNull String str, @Nullable ArrayList<String> arrayList) {
        throw new UnsupportedOperationException("String list not supported");
    }

    @NonNull
    @KeepForSdk
    public String toString() {
        Map<String, Field<?, ?>> fieldMappings = getFieldMappings();
        StringBuilder sb = new StringBuilder(100);
        for (String str : fieldMappings.keySet()) {
            Field<?, ?> field = fieldMappings.get(str);
            if (isFieldSet(field)) {
                Object zaD = zaD(field, getFieldValue(field));
                if (sb.length() == 0) {
                    sb.append("{");
                } else {
                    sb.append(",");
                }
                sb.append("\"");
                sb.append(str);
                sb.append("\":");
                if (zaD == null) {
                    sb.append("null");
                } else {
                    switch (field.f20651d) {
                        case 8:
                            sb.append("\"");
                            sb.append(Base64Utils.encode((byte[]) zaD));
                            sb.append("\"");
                            continue;
                        case 9:
                            sb.append("\"");
                            sb.append(Base64Utils.encodeUrlSafe((byte[]) zaD));
                            sb.append("\"");
                            continue;
                        case 10:
                            MapUtils.writeStringMapToJson(sb, (HashMap) zaD);
                            continue;
                        default:
                            if (field.f20650c) {
                                ArrayList arrayList = (ArrayList) zaD;
                                sb.append("[");
                                int size = arrayList.size();
                                for (int i4 = 0; i4 < size; i4++) {
                                    if (i4 > 0) {
                                        sb.append(",");
                                    }
                                    Object obj = arrayList.get(i4);
                                    if (obj != null) {
                                        zaF(sb, field, obj);
                                    }
                                }
                                sb.append("]");
                                break;
                            } else {
                                zaF(sb, field, zaD);
                                continue;
                            }
                    }
                }
            }
        }
        if (sb.length() > 0) {
            sb.append("}");
        } else {
            sb.append("{}");
        }
        return sb.toString();
    }

    public final void zaA(@NonNull Field field, @Nullable String str) {
        if (field.f20658k != null) {
            zaE(field, str);
        } else {
            setStringInternal(field, field.f20653f, str);
        }
    }

    public final void zaB(@NonNull Field field, @Nullable Map map) {
        if (field.f20658k != null) {
            zaE(field, map);
        } else {
            setStringMapInternal(field, field.f20653f, map);
        }
    }

    public final void zaC(@NonNull Field field, @Nullable ArrayList arrayList) {
        if (field.f20658k != null) {
            zaE(field, arrayList);
        } else {
            setStringsInternal(field, field.f20653f, arrayList);
        }
    }

    public final void zaa(@NonNull Field field, @Nullable BigDecimal bigDecimal) {
        if (field.f20658k != null) {
            zaE(field, bigDecimal);
        } else {
            zab(field, field.f20653f, bigDecimal);
        }
    }

    protected void zab(@NonNull Field field, @NonNull String str, @Nullable BigDecimal bigDecimal) {
        throw new UnsupportedOperationException("BigDecimal not supported");
    }

    public final void zac(@NonNull Field field, @Nullable ArrayList arrayList) {
        if (field.f20658k != null) {
            zaE(field, arrayList);
        } else {
            zad(field, field.f20653f, arrayList);
        }
    }

    protected void zad(@NonNull Field field, @NonNull String str, @Nullable ArrayList arrayList) {
        throw new UnsupportedOperationException("BigDecimal list not supported");
    }

    public final void zae(@NonNull Field field, @Nullable BigInteger bigInteger) {
        if (field.f20658k != null) {
            zaE(field, bigInteger);
        } else {
            zaf(field, field.f20653f, bigInteger);
        }
    }

    protected void zaf(@NonNull Field field, @NonNull String str, @Nullable BigInteger bigInteger) {
        throw new UnsupportedOperationException("BigInteger not supported");
    }

    public final void zag(@NonNull Field field, @Nullable ArrayList arrayList) {
        if (field.f20658k != null) {
            zaE(field, arrayList);
        } else {
            zah(field, field.f20653f, arrayList);
        }
    }

    protected void zah(@NonNull Field field, @NonNull String str, @Nullable ArrayList arrayList) {
        throw new UnsupportedOperationException("BigInteger list not supported");
    }

    public final void zai(@NonNull Field field, boolean z3) {
        if (field.f20658k != null) {
            zaE(field, Boolean.valueOf(z3));
        } else {
            setBooleanInternal(field, field.f20653f, z3);
        }
    }

    public final void zaj(@NonNull Field field, @Nullable ArrayList arrayList) {
        if (field.f20658k != null) {
            zaE(field, arrayList);
        } else {
            zak(field, field.f20653f, arrayList);
        }
    }

    protected void zak(@NonNull Field field, @NonNull String str, @Nullable ArrayList arrayList) {
        throw new UnsupportedOperationException("Boolean list not supported");
    }

    public final void zal(@NonNull Field field, @Nullable byte[] bArr) {
        if (field.f20658k != null) {
            zaE(field, bArr);
        } else {
            setDecodedBytesInternal(field, field.f20653f, bArr);
        }
    }

    public final void zam(@NonNull Field field, double d4) {
        if (field.f20658k != null) {
            zaE(field, Double.valueOf(d4));
        } else {
            zan(field, field.f20653f, d4);
        }
    }

    protected void zan(@NonNull Field field, @NonNull String str, double d4) {
        throw new UnsupportedOperationException("Double not supported");
    }

    public final void zao(@NonNull Field field, @Nullable ArrayList arrayList) {
        if (field.f20658k != null) {
            zaE(field, arrayList);
        } else {
            zap(field, field.f20653f, arrayList);
        }
    }

    protected void zap(@NonNull Field field, @NonNull String str, @Nullable ArrayList arrayList) {
        throw new UnsupportedOperationException("Double list not supported");
    }

    public final void zaq(@NonNull Field field, float f4) {
        if (field.f20658k != null) {
            zaE(field, Float.valueOf(f4));
        } else {
            zar(field, field.f20653f, f4);
        }
    }

    protected void zar(@NonNull Field field, @NonNull String str, float f4) {
        throw new UnsupportedOperationException("Float not supported");
    }

    public final void zas(@NonNull Field field, @Nullable ArrayList arrayList) {
        if (field.f20658k != null) {
            zaE(field, arrayList);
        } else {
            zat(field, field.f20653f, arrayList);
        }
    }

    protected void zat(@NonNull Field field, @NonNull String str, @Nullable ArrayList arrayList) {
        throw new UnsupportedOperationException("Float list not supported");
    }

    public final void zau(@NonNull Field field, int i4) {
        if (field.f20658k != null) {
            zaE(field, Integer.valueOf(i4));
        } else {
            setIntegerInternal(field, field.f20653f, i4);
        }
    }

    public final void zav(@NonNull Field field, @Nullable ArrayList arrayList) {
        if (field.f20658k != null) {
            zaE(field, arrayList);
        } else {
            zaw(field, field.f20653f, arrayList);
        }
    }

    protected void zaw(@NonNull Field field, @NonNull String str, @Nullable ArrayList arrayList) {
        throw new UnsupportedOperationException("Integer list not supported");
    }

    public final void zax(@NonNull Field field, long j4) {
        if (field.f20658k != null) {
            zaE(field, Long.valueOf(j4));
        } else {
            setLongInternal(field, field.f20653f, j4);
        }
    }

    public final void zay(@NonNull Field field, @Nullable ArrayList arrayList) {
        if (field.f20658k != null) {
            zaE(field, arrayList);
        } else {
            zaz(field, field.f20653f, arrayList);
        }
    }

    protected void zaz(@NonNull Field field, @NonNull String str, @Nullable ArrayList arrayList) {
        throw new UnsupportedOperationException("Long list not supported");
    }

    /* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
    @VisibleForTesting
    @SafeParcelable.Class(creator = "FieldCreator")
    @ShowFirstParty
    @KeepForSdk
    /* loaded from: classes4.dex */
    public static class Field<I, O> extends AbstractSafeParcelable {
        public static final zaj CREATOR = new zaj();
        @SafeParcelable.VersionField(getter = "getVersionCode", id = 1)

        /* renamed from: a  reason: collision with root package name */
        private final int f20648a;
        @SafeParcelable.Field(getter = "getTypeIn", id = 2)

        /* renamed from: b  reason: collision with root package name */
        protected final int f20649b;
        @SafeParcelable.Field(getter = "isTypeInArray", id = 3)

        /* renamed from: c  reason: collision with root package name */
        protected final boolean f20650c;
        @SafeParcelable.Field(getter = "getTypeOut", id = 4)

        /* renamed from: d  reason: collision with root package name */
        protected final int f20651d;
        @SafeParcelable.Field(getter = "isTypeOutArray", id = 5)

        /* renamed from: e  reason: collision with root package name */
        protected final boolean f20652e;
        @NonNull
        @SafeParcelable.Field(getter = "getOutputFieldName", id = 6)

        /* renamed from: f  reason: collision with root package name */
        protected final String f20653f;
        @SafeParcelable.Field(getter = "getSafeParcelableFieldId", id = 7)

        /* renamed from: g  reason: collision with root package name */
        protected final int f20654g;
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        protected final Class f20655h;
        @Nullable
        @SafeParcelable.Field(getter = "getConcreteTypeName", id = 8)

        /* renamed from: i  reason: collision with root package name */
        protected final String f20656i;

        /* renamed from: j  reason: collision with root package name */
        private zan f20657j;
        @Nullable
        @SafeParcelable.Field(getter = "getWrappedConverter", id = 9, type = "com.google.android.gms.common.server.converter.ConverterWrapper")

        /* renamed from: k  reason: collision with root package name */
        private final FieldConverter f20658k;

        /* JADX INFO: Access modifiers changed from: package-private */
        @SafeParcelable.Constructor
        public Field(@SafeParcelable.Param(id = 1) int i4, @SafeParcelable.Param(id = 2) int i5, @SafeParcelable.Param(id = 3) boolean z3, @SafeParcelable.Param(id = 4) int i6, @SafeParcelable.Param(id = 5) boolean z4, @SafeParcelable.Param(id = 6) String str, @SafeParcelable.Param(id = 7) int i7, @Nullable @SafeParcelable.Param(id = 8) String str2, @Nullable @SafeParcelable.Param(id = 9) com.google.android.gms.common.server.converter.zaa zaaVar) {
            this.f20648a = i4;
            this.f20649b = i5;
            this.f20650c = z3;
            this.f20651d = i6;
            this.f20652e = z4;
            this.f20653f = str;
            this.f20654g = i7;
            if (str2 == null) {
                this.f20655h = null;
                this.f20656i = null;
            } else {
                this.f20655h = SafeParcelResponse.class;
                this.f20656i = str2;
            }
            if (zaaVar == null) {
                this.f20658k = null;
            } else {
                this.f20658k = zaaVar.zab();
            }
        }

        @NonNull
        @VisibleForTesting
        @KeepForSdk
        public static Field<byte[], byte[]> forBase64(@NonNull String str, int i4) {
            return new Field<>(8, false, 8, false, str, i4, null, null);
        }

        @NonNull
        @KeepForSdk
        public static Field<Boolean, Boolean> forBoolean(@NonNull String str, int i4) {
            return new Field<>(6, false, 6, false, str, i4, null, null);
        }

        @NonNull
        @KeepForSdk
        public static <T extends FastJsonResponse> Field<T, T> forConcreteType(@NonNull String str, int i4, @NonNull Class<T> cls) {
            return new Field<>(11, false, 11, false, str, i4, cls, null);
        }

        @NonNull
        @KeepForSdk
        public static <T extends FastJsonResponse> Field<ArrayList<T>, ArrayList<T>> forConcreteTypeArray(@NonNull String str, int i4, @NonNull Class<T> cls) {
            return new Field<>(11, true, 11, true, str, i4, cls, null);
        }

        @NonNull
        @KeepForSdk
        public static Field<Double, Double> forDouble(@NonNull String str, int i4) {
            return new Field<>(4, false, 4, false, str, i4, null, null);
        }

        @NonNull
        @KeepForSdk
        public static Field<Float, Float> forFloat(@NonNull String str, int i4) {
            return new Field<>(3, false, 3, false, str, i4, null, null);
        }

        @NonNull
        @VisibleForTesting
        @KeepForSdk
        public static Field<Integer, Integer> forInteger(@NonNull String str, int i4) {
            return new Field<>(0, false, 0, false, str, i4, null, null);
        }

        @NonNull
        @KeepForSdk
        public static Field<Long, Long> forLong(@NonNull String str, int i4) {
            return new Field<>(2, false, 2, false, str, i4, null, null);
        }

        @NonNull
        @KeepForSdk
        public static Field<String, String> forString(@NonNull String str, int i4) {
            return new Field<>(7, false, 7, false, str, i4, null, null);
        }

        @NonNull
        @KeepForSdk
        public static Field<HashMap<String, String>, HashMap<String, String>> forStringMap(@NonNull String str, int i4) {
            return new Field<>(10, false, 10, false, str, i4, null, null);
        }

        @NonNull
        @KeepForSdk
        public static Field<ArrayList<String>, ArrayList<String>> forStrings(@NonNull String str, int i4) {
            return new Field<>(7, true, 7, true, str, i4, null, null);
        }

        @NonNull
        @KeepForSdk
        public static Field withConverter(@NonNull String str, int i4, @NonNull FieldConverter<?, ?> fieldConverter, boolean z3) {
            fieldConverter.zaa();
            fieldConverter.zab();
            return new Field(7, z3, 0, false, str, i4, null, fieldConverter);
        }

        @Nullable
        final com.google.android.gms.common.server.converter.zaa b() {
            FieldConverter fieldConverter = this.f20658k;
            if (fieldConverter == null) {
                return null;
            }
            return com.google.android.gms.common.server.converter.zaa.zaa(fieldConverter);
        }

        @Nullable
        final String d() {
            String str = this.f20656i;
            if (str == null) {
                return null;
            }
            return str;
        }

        @KeepForSdk
        public int getSafeParcelableFieldId() {
            return this.f20654g;
        }

        @NonNull
        public final String toString() {
            Objects.ToStringHelper add = Objects.toStringHelper(this).add("versionCode", Integer.valueOf(this.f20648a)).add("typeIn", Integer.valueOf(this.f20649b)).add("typeInArray", Boolean.valueOf(this.f20650c)).add("typeOut", Integer.valueOf(this.f20651d)).add("typeOutArray", Boolean.valueOf(this.f20652e)).add("outputFieldName", this.f20653f).add("safeParcelFieldId", Integer.valueOf(this.f20654g)).add("concreteTypeName", d());
            Class cls = this.f20655h;
            if (cls != null) {
                add.add("concreteType.class", cls.getCanonicalName());
            }
            FieldConverter fieldConverter = this.f20658k;
            if (fieldConverter != null) {
                add.add("converterName", fieldConverter.getClass().getCanonicalName());
            }
            return add.toString();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(@NonNull Parcel parcel, int i4) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeInt(parcel, 1, this.f20648a);
            SafeParcelWriter.writeInt(parcel, 2, this.f20649b);
            SafeParcelWriter.writeBoolean(parcel, 3, this.f20650c);
            SafeParcelWriter.writeInt(parcel, 4, this.f20651d);
            SafeParcelWriter.writeBoolean(parcel, 5, this.f20652e);
            SafeParcelWriter.writeString(parcel, 6, this.f20653f, false);
            SafeParcelWriter.writeInt(parcel, 7, getSafeParcelableFieldId());
            SafeParcelWriter.writeString(parcel, 8, d(), false);
            SafeParcelWriter.writeParcelable(parcel, 9, b(), i4, false);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }

        @NonNull
        public final Field zab() {
            return new Field(this.f20648a, this.f20649b, this.f20650c, this.f20651d, this.f20652e, this.f20653f, this.f20654g, this.f20656i, b());
        }

        @NonNull
        public final FastJsonResponse zad() throws InstantiationException, IllegalAccessException {
            Preconditions.checkNotNull(this.f20655h);
            Class cls = this.f20655h;
            if (cls == SafeParcelResponse.class) {
                Preconditions.checkNotNull(this.f20656i);
                Preconditions.checkNotNull(this.f20657j, "The field mapping dictionary must be set if the concrete type is a SafeParcelResponse object.");
                return new SafeParcelResponse(this.f20657j, this.f20656i);
            }
            return (FastJsonResponse) cls.newInstance();
        }

        @NonNull
        public final Object zae(@Nullable Object obj) {
            Preconditions.checkNotNull(this.f20658k);
            return Preconditions.checkNotNull(this.f20658k.zac(obj));
        }

        @NonNull
        public final Object zaf(@NonNull Object obj) {
            Preconditions.checkNotNull(this.f20658k);
            return this.f20658k.zad(obj);
        }

        @NonNull
        public final Map zah() {
            Preconditions.checkNotNull(this.f20656i);
            Preconditions.checkNotNull(this.f20657j);
            return (Map) Preconditions.checkNotNull(this.f20657j.zab(this.f20656i));
        }

        public final void zai(zan zanVar) {
            this.f20657j = zanVar;
        }

        public final boolean zaj() {
            if (this.f20658k != null) {
                return true;
            }
            return false;
        }

        protected Field(int i4, boolean z3, int i5, boolean z4, @NonNull String str, int i6, @Nullable Class cls, @Nullable FieldConverter fieldConverter) {
            this.f20648a = 1;
            this.f20649b = i4;
            this.f20650c = z3;
            this.f20651d = i5;
            this.f20652e = z4;
            this.f20653f = str;
            this.f20654g = i6;
            this.f20655h = cls;
            if (cls == null) {
                this.f20656i = null;
            } else {
                this.f20656i = cls.getCanonicalName();
            }
            this.f20658k = fieldConverter;
        }
    }
}
