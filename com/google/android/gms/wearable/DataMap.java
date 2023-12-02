package com.google.android.gms.wearable;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.arlosoft.macrodroid.helper.HelperCommandsKt;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.wearable.zzcf;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
@VisibleForTesting
/* loaded from: classes4.dex */
public class DataMap {
    @NonNull
    public static final String TAG = "DataMap";

    /* renamed from: a  reason: collision with root package name */
    private final HashMap f22632a = new HashMap();

    private static int a(ArrayList arrayList) {
        if (arrayList.isEmpty()) {
            return 0;
        }
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            Object obj = arrayList.get(i4);
            if (obj != null) {
                if (obj instanceof Integer) {
                    return 2;
                }
                if (obj instanceof String) {
                    return 3;
                }
                if (obj instanceof DataMap) {
                    return 4;
                }
                if (obj instanceof Bundle) {
                    return 5;
                }
            }
        }
        return 1;
    }

    @NonNull
    public static ArrayList<DataMap> arrayListFromBundleArrayList(@NonNull ArrayList<Bundle> arrayList) {
        ArrayList<DataMap> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            arrayList2.add(fromBundle(arrayList.get(i4)));
        }
        return arrayList2;
    }

    private static final void b(String str, Object obj, String str2, Object obj2, ClassCastException classCastException) {
        Log.w(TAG, "Key " + str + " expected " + str2 + " but value was a " + obj.getClass().getName() + ".  The default value " + obj2 + " was returned.");
        Log.w(TAG, "Attempt to cast generated internal exception:", classCastException);
    }

    @NonNull
    public static DataMap fromBundle(@NonNull Bundle bundle) {
        bundle.setClassLoader((ClassLoader) Preconditions.checkNotNull(Asset.class.getClassLoader()));
        DataMap dataMap = new DataMap();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj instanceof String) {
                dataMap.putString(str, (String) obj);
            } else if (obj instanceof Integer) {
                dataMap.putInt(str, ((Integer) obj).intValue());
            } else if (obj instanceof Long) {
                dataMap.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Double) {
                dataMap.putDouble(str, ((Double) obj).doubleValue());
            } else if (obj instanceof Float) {
                dataMap.putFloat(str, ((Float) obj).floatValue());
            } else if (obj instanceof Boolean) {
                dataMap.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Byte) {
                dataMap.putByte(str, ((Byte) obj).byteValue());
            } else if (obj instanceof byte[]) {
                dataMap.putByteArray(str, (byte[]) obj);
            } else if (obj instanceof String[]) {
                dataMap.putStringArray(str, (String[]) obj);
            } else if (obj instanceof long[]) {
                dataMap.putLongArray(str, (long[]) obj);
            } else if (obj instanceof float[]) {
                dataMap.putFloatArray(str, (float[]) obj);
            } else if (obj instanceof Asset) {
                dataMap.putAsset(str, (Asset) obj);
            } else if (obj instanceof Bundle) {
                dataMap.putDataMap(str, fromBundle((Bundle) obj));
            } else if (obj instanceof ArrayList) {
                ArrayList<String> arrayList = (ArrayList) obj;
                int a4 = a(arrayList);
                if (a4 != 0) {
                    if (a4 != 1) {
                        if (a4 != 2) {
                            if (a4 != 3) {
                                if (a4 == 5) {
                                    dataMap.putDataMapArrayList(str, arrayListFromBundleArrayList(arrayList));
                                }
                            } else {
                                dataMap.putStringArrayList(str, arrayList);
                            }
                        } else {
                            dataMap.putIntegerArrayList(str, arrayList);
                        }
                    } else {
                        dataMap.putStringArrayList(str, arrayList);
                    }
                } else {
                    dataMap.putStringArrayList(str, arrayList);
                }
            }
        }
        return dataMap;
    }

    @NonNull
    public static DataMap fromByteArray(@NonNull byte[] bArr) {
        try {
            return com.google.android.gms.internal.wearable.zzl.zza(new com.google.android.gms.internal.wearable.zzk(com.google.android.gms.internal.wearable.zzx.zzc(bArr), new ArrayList()));
        } catch (zzcf e4) {
            throw new IllegalArgumentException("Unable to convert data", e4);
        }
    }

    public void clear() {
        this.f22632a.clear();
    }

    public boolean containsKey(@NonNull String str) {
        return this.f22632a.containsKey(str);
    }

    public boolean equals(@Nullable Object obj) {
        boolean equals;
        if (!(obj instanceof DataMap)) {
            return false;
        }
        DataMap dataMap = (DataMap) obj;
        if (size() != dataMap.size()) {
            return false;
        }
        for (String str : keySet()) {
            Object obj2 = get(str);
            Object obj3 = dataMap.get(str);
            if (obj2 instanceof Asset) {
                if (!(obj3 instanceof Asset)) {
                    return false;
                }
                Asset asset = (Asset) obj2;
                Asset asset2 = (Asset) obj3;
                if (asset != null && asset2 != null) {
                    if (!TextUtils.isEmpty(asset.getDigest())) {
                        equals = ((String) Preconditions.checkNotNull(asset.getDigest())).equals(asset2.getDigest());
                    } else {
                        equals = Arrays.equals(asset.zza(), asset2.zza());
                    }
                    if (!equals) {
                        return false;
                    }
                } else if (asset != asset2) {
                    return false;
                }
            } else if (obj2 instanceof String[]) {
                if (!(obj3 instanceof String[]) || !Arrays.equals((String[]) obj2, (String[]) obj3)) {
                    return false;
                }
            } else if (obj2 instanceof long[]) {
                if (!(obj3 instanceof long[]) || !Arrays.equals((long[]) obj2, (long[]) obj3)) {
                    return false;
                }
            } else if (obj2 instanceof float[]) {
                if (!(obj3 instanceof float[]) || !Arrays.equals((float[]) obj2, (float[]) obj3)) {
                    return false;
                }
            } else if (obj2 instanceof byte[]) {
                if (!(obj3 instanceof byte[]) || !Arrays.equals((byte[]) obj2, (byte[]) obj3)) {
                    return false;
                }
            } else if (!Objects.equal(obj2, obj3)) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    public <T> T get(@NonNull String str) {
        return (T) this.f22632a.get(str);
    }

    @Nullable
    public Asset getAsset(@NonNull String str) {
        Object obj = this.f22632a.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (Asset) obj;
        } catch (ClassCastException e4) {
            b(str, obj, "Asset", "<null>", e4);
            return null;
        }
    }

    public boolean getBoolean(@NonNull String str) {
        return getBoolean(str, false);
    }

    public byte getByte(@NonNull String str) {
        return getByte(str, (byte) 0);
    }

    @Nullable
    public byte[] getByteArray(@NonNull String str) {
        Object obj = this.f22632a.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (byte[]) obj;
        } catch (ClassCastException e4) {
            b(str, obj, "byte[]", "<null>", e4);
            return null;
        }
    }

    @Nullable
    public DataMap getDataMap(@NonNull String str) {
        Object obj = this.f22632a.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (DataMap) obj;
        } catch (ClassCastException e4) {
            b(str, obj, TAG, "<null>", e4);
            return null;
        }
    }

    @Nullable
    public ArrayList<DataMap> getDataMapArrayList(@NonNull String str) {
        Object obj = this.f22632a.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (ArrayList) obj;
        } catch (ClassCastException e4) {
            b(str, obj, "ArrayList<DataMap>", "<null>", e4);
            return null;
        }
    }

    public double getDouble(@NonNull String str) {
        return getDouble(str, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    }

    public float getFloat(@NonNull String str) {
        return getFloat(str, 0.0f);
    }

    @Nullable
    public float[] getFloatArray(@NonNull String str) {
        Object obj = this.f22632a.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (float[]) obj;
        } catch (ClassCastException e4) {
            b(str, obj, "float[]", "<null>", e4);
            return null;
        }
    }

    public int getInt(@NonNull String str) {
        return getInt(str, 0);
    }

    @Nullable
    public ArrayList<Integer> getIntegerArrayList(@NonNull String str) {
        Object obj = this.f22632a.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (ArrayList) obj;
        } catch (ClassCastException e4) {
            b(str, obj, "ArrayList<Integer>", "<null>", e4);
            return null;
        }
    }

    public long getLong(@NonNull String str) {
        return getLong(str, 0L);
    }

    @Nullable
    public long[] getLongArray(@NonNull String str) {
        Object obj = this.f22632a.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (long[]) obj;
        } catch (ClassCastException e4) {
            b(str, obj, "long[]", "<null>", e4);
            return null;
        }
    }

    @Nullable
    public String getString(@NonNull String str) {
        Object obj = this.f22632a.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (String) obj;
        } catch (ClassCastException e4) {
            b(str, obj, "String", "<null>", e4);
            return null;
        }
    }

    @Nullable
    public String[] getStringArray(@NonNull String str) {
        Object obj = this.f22632a.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (String[]) obj;
        } catch (ClassCastException e4) {
            b(str, obj, "String[]", "<null>", e4);
            return null;
        }
    }

    @Nullable
    public ArrayList<String> getStringArrayList(@NonNull String str) {
        Object obj = this.f22632a.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (ArrayList) obj;
        } catch (ClassCastException e4) {
            b(str, obj, "ArrayList<String>", "<null>", e4);
            return null;
        }
    }

    public int hashCode() {
        return this.f22632a.hashCode() * 29;
    }

    public boolean isEmpty() {
        return this.f22632a.isEmpty();
    }

    @NonNull
    public Set<String> keySet() {
        return this.f22632a.keySet();
    }

    public void putAll(@NonNull DataMap dataMap) {
        for (String str : dataMap.keySet()) {
            this.f22632a.put(str, dataMap.get(str));
        }
    }

    public void putAsset(@NonNull String str, @NonNull Asset asset) {
        this.f22632a.put(str, asset);
    }

    public void putBoolean(@NonNull String str, boolean z3) {
        this.f22632a.put(str, Boolean.valueOf(z3));
    }

    public void putByte(@NonNull String str, byte b4) {
        this.f22632a.put(str, Byte.valueOf(b4));
    }

    public void putByteArray(@NonNull String str, @NonNull byte[] bArr) {
        this.f22632a.put(str, bArr);
    }

    public void putDataMap(@NonNull String str, @NonNull DataMap dataMap) {
        this.f22632a.put(str, dataMap);
    }

    public void putDataMapArrayList(@NonNull String str, @NonNull ArrayList<DataMap> arrayList) {
        this.f22632a.put(str, arrayList);
    }

    public void putDouble(@NonNull String str, double d4) {
        this.f22632a.put(str, Double.valueOf(d4));
    }

    public void putFloat(@NonNull String str, float f4) {
        this.f22632a.put(str, Float.valueOf(f4));
    }

    public void putFloatArray(@NonNull String str, @NonNull float[] fArr) {
        this.f22632a.put(str, fArr);
    }

    public void putInt(@NonNull String str, int i4) {
        this.f22632a.put(str, Integer.valueOf(i4));
    }

    public void putIntegerArrayList(@NonNull String str, @NonNull ArrayList<Integer> arrayList) {
        this.f22632a.put(str, arrayList);
    }

    public void putLong(@NonNull String str, long j4) {
        this.f22632a.put(str, Long.valueOf(j4));
    }

    public void putLongArray(@NonNull String str, @NonNull long[] jArr) {
        this.f22632a.put(str, jArr);
    }

    public void putString(@NonNull String str, @NonNull String str2) {
        this.f22632a.put(str, str2);
    }

    public void putStringArray(@NonNull String str, @NonNull String[] strArr) {
        this.f22632a.put(str, strArr);
    }

    public void putStringArrayList(@NonNull String str, @NonNull ArrayList<String> arrayList) {
        this.f22632a.put(str, arrayList);
    }

    @Nullable
    public Object remove(@NonNull String str) {
        return this.f22632a.remove(str);
    }

    public int size() {
        return this.f22632a.size();
    }

    @NonNull
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        for (String str : this.f22632a.keySet()) {
            Object obj = this.f22632a.get(str);
            if (obj instanceof String) {
                bundle.putString(str, (String) obj);
            } else if (obj instanceof Integer) {
                bundle.putInt(str, ((Integer) obj).intValue());
            } else if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (obj instanceof Float) {
                bundle.putFloat(str, ((Float) obj).floatValue());
            } else if (obj instanceof Boolean) {
                bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Byte) {
                bundle.putByte(str, ((Byte) obj).byteValue());
            } else if (obj instanceof byte[]) {
                bundle.putByteArray(str, (byte[]) obj);
            } else if (obj instanceof String[]) {
                bundle.putStringArray(str, (String[]) obj);
            } else if (obj instanceof long[]) {
                bundle.putLongArray(str, (long[]) obj);
            } else if (obj instanceof float[]) {
                bundle.putFloatArray(str, (float[]) obj);
            } else if (obj instanceof Asset) {
                bundle.putParcelable(str, (Asset) obj);
            } else if (obj instanceof DataMap) {
                bundle.putParcelable(str, ((DataMap) obj).toBundle());
            } else if (obj instanceof ArrayList) {
                ArrayList<String> arrayList = (ArrayList) obj;
                int a4 = a(arrayList);
                if (a4 != 0) {
                    if (a4 != 1) {
                        if (a4 != 2) {
                            if (a4 != 3) {
                                if (a4 == 4) {
                                    ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
                                    int size = arrayList.size();
                                    for (int i4 = 0; i4 < size; i4++) {
                                        arrayList2.add(((DataMap) arrayList.get(i4)).toBundle());
                                    }
                                    bundle.putParcelableArrayList(str, arrayList2);
                                }
                            } else {
                                bundle.putStringArrayList(str, arrayList);
                            }
                        } else {
                            bundle.putIntegerArrayList(str, arrayList);
                        }
                    } else {
                        bundle.putStringArrayList(str, arrayList);
                    }
                } else {
                    bundle.putStringArrayList(str, arrayList);
                }
            }
        }
        return bundle;
    }

    @NonNull
    public byte[] toByteArray() {
        return com.google.android.gms.internal.wearable.zzl.zzb(this).zza.zzL();
    }

    @NonNull
    public String toString() {
        return this.f22632a.toString();
    }

    public boolean getBoolean(@NonNull String str, boolean z3) {
        Object obj = this.f22632a.get(str);
        if (obj == null) {
            return z3;
        }
        try {
            return ((Boolean) obj).booleanValue();
        } catch (ClassCastException e4) {
            b(str, obj, "Boolean", Boolean.valueOf(z3), e4);
            return z3;
        }
    }

    public byte getByte(@NonNull String str, byte b4) {
        Object obj = this.f22632a.get(str);
        if (obj == null) {
            return b4;
        }
        try {
            return ((Byte) obj).byteValue();
        } catch (ClassCastException e4) {
            b(str, obj, "Byte", Byte.valueOf(b4), e4);
            return b4;
        }
    }

    public double getDouble(@NonNull String str, double d4) {
        Object obj = this.f22632a.get(str);
        if (obj == null) {
            return d4;
        }
        try {
            return ((Double) obj).doubleValue();
        } catch (ClassCastException e4) {
            b(str, obj, "Double", Double.valueOf(d4), e4);
            return d4;
        }
    }

    public float getFloat(@NonNull String str, float f4) {
        Object obj = this.f22632a.get(str);
        if (obj == null) {
            return f4;
        }
        try {
            return ((Float) obj).floatValue();
        } catch (ClassCastException e4) {
            b(str, obj, "Float", Float.valueOf(f4), e4);
            return f4;
        }
    }

    public int getInt(@NonNull String str, int i4) {
        Object obj = this.f22632a.get(str);
        if (obj == null) {
            return i4;
        }
        try {
            return ((Integer) obj).intValue();
        } catch (ClassCastException e4) {
            b(str, obj, "Integer", "<null>", e4);
            return i4;
        }
    }

    public long getLong(@NonNull String str, long j4) {
        Object obj = this.f22632a.get(str);
        if (obj == null) {
            return j4;
        }
        try {
            return ((Long) obj).longValue();
        } catch (ClassCastException e4) {
            b(str, obj, HelperCommandsKt.HELPER_SETTING_VALUE_TYPE_LONG, "<null>", e4);
            return j4;
        }
    }

    @NonNull
    public String getString(@NonNull String str, @NonNull String str2) {
        String string = getString(str);
        return string == null ? str2 : string;
    }
}
