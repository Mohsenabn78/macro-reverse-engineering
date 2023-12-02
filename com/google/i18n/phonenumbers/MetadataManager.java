package com.google.i18n.phonenumbers;

import androidx.compose.animation.core.d;
import com.google.i18n.phonenumbers.Phonemetadata;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class MetadataManager {

    /* renamed from: a  reason: collision with root package name */
    static final MetadataLoader f32810a = new MetadataLoader() { // from class: com.google.i18n.phonenumbers.MetadataManager.1
        @Override // com.google.i18n.phonenumbers.MetadataLoader
        public InputStream loadMetadata(String str) {
            return MetadataManager.class.getResourceAsStream(str);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static final Logger f32811b = Logger.getLogger(MetadataManager.class.getName());

    /* renamed from: c  reason: collision with root package name */
    private static final ConcurrentHashMap<Integer, Phonemetadata.PhoneMetadata> f32812c = new ConcurrentHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private static final ConcurrentHashMap<String, Phonemetadata.PhoneMetadata> f32813d = new ConcurrentHashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private static final Set<Integer> f32814e = AlternateFormatsCountryCodeSet.a();

    /* renamed from: f  reason: collision with root package name */
    private static final Set<String> f32815f = ShortNumbersRegionCodeSet.a();

    /* loaded from: classes5.dex */
    static class SingleFileMetadataMaps {

        /* renamed from: a  reason: collision with root package name */
        private final Map<String, Phonemetadata.PhoneMetadata> f32816a;

        /* renamed from: b  reason: collision with root package name */
        private final Map<Integer, Phonemetadata.PhoneMetadata> f32817b;

        private SingleFileMetadataMaps(Map<String, Phonemetadata.PhoneMetadata> map, Map<Integer, Phonemetadata.PhoneMetadata> map2) {
            this.f32816a = Collections.unmodifiableMap(map);
            this.f32817b = Collections.unmodifiableMap(map2);
        }

        static SingleFileMetadataMaps c(String str, MetadataLoader metadataLoader) {
            List<Phonemetadata.PhoneMetadata> d4 = MetadataManager.d(str, metadataLoader);
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            for (Phonemetadata.PhoneMetadata phoneMetadata : d4) {
                String id = phoneMetadata.getId();
                if (PhoneNumberUtil.REGION_CODE_FOR_NON_GEO_ENTITY.equals(id)) {
                    hashMap2.put(Integer.valueOf(phoneMetadata.getCountryCode()), phoneMetadata);
                } else {
                    hashMap.put(id, phoneMetadata);
                }
            }
            return new SingleFileMetadataMaps(hashMap, hashMap2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Phonemetadata.PhoneMetadata a(int i4) {
            return this.f32817b.get(Integer.valueOf(i4));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Phonemetadata.PhoneMetadata b(String str) {
            return this.f32816a.get(str);
        }
    }

    private MetadataManager() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Phonemetadata.PhoneMetadata b(int i4) {
        if (!f32814e.contains(Integer.valueOf(i4))) {
            return null;
        }
        return c(Integer.valueOf(i4), f32812c, "/com/google/i18n/phonenumbers/data/PhoneNumberAlternateFormatsProto", f32810a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> Phonemetadata.PhoneMetadata c(T t3, ConcurrentHashMap<T, Phonemetadata.PhoneMetadata> concurrentHashMap, String str, MetadataLoader metadataLoader) {
        Phonemetadata.PhoneMetadata phoneMetadata = concurrentHashMap.get(t3);
        if (phoneMetadata != null) {
            return phoneMetadata;
        }
        String str2 = str + "_" + t3;
        List<Phonemetadata.PhoneMetadata> d4 = d(str2, metadataLoader);
        if (d4.size() > 1) {
            f32811b.log(Level.WARNING, "more than one metadata in file " + str2);
        }
        Phonemetadata.PhoneMetadata phoneMetadata2 = d4.get(0);
        Phonemetadata.PhoneMetadata putIfAbsent = concurrentHashMap.putIfAbsent(t3, phoneMetadata2);
        if (putIfAbsent != null) {
            return putIfAbsent;
        }
        return phoneMetadata2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<Phonemetadata.PhoneMetadata> d(String str, MetadataLoader metadataLoader) {
        InputStream loadMetadata = metadataLoader.loadMetadata(str);
        if (loadMetadata != null) {
            List<Phonemetadata.PhoneMetadata> metadataList = g(loadMetadata).getMetadataList();
            if (metadataList.size() != 0) {
                return metadataList;
            }
            throw new IllegalStateException("empty metadata: " + str);
        }
        throw new IllegalStateException("missing metadata: " + str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Phonemetadata.PhoneMetadata e(String str) {
        if (!f32815f.contains(str)) {
            return null;
        }
        return c(str, f32813d, "/com/google/i18n/phonenumbers/data/ShortNumberMetadataProto", f32810a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SingleFileMetadataMaps f(AtomicReference<SingleFileMetadataMaps> atomicReference, String str, MetadataLoader metadataLoader) {
        SingleFileMetadataMaps singleFileMetadataMaps = atomicReference.get();
        if (singleFileMetadataMaps != null) {
            return singleFileMetadataMaps;
        }
        d.a(atomicReference, null, SingleFileMetadataMaps.c(str, metadataLoader));
        return atomicReference.get();
    }

    private static Phonemetadata.PhoneMetadataCollection g(InputStream inputStream) {
        ObjectInputStream objectInputStream;
        ObjectInputStream objectInputStream2 = null;
        try {
            try {
                objectInputStream = new ObjectInputStream(inputStream);
            } catch (IOException e4) {
                throw new RuntimeException("cannot load/parse metadata", e4);
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            Phonemetadata.PhoneMetadataCollection phoneMetadataCollection = new Phonemetadata.PhoneMetadataCollection();
            try {
                phoneMetadataCollection.readExternal(objectInputStream);
                try {
                    objectInputStream.close();
                } catch (IOException e5) {
                    f32811b.log(Level.WARNING, "error closing input stream (ignored)", (Throwable) e5);
                }
                return phoneMetadataCollection;
            } catch (IOException e6) {
                throw new RuntimeException("cannot load/parse metadata", e6);
            }
        } catch (Throwable th2) {
            th = th2;
            objectInputStream2 = objectInputStream;
            try {
                if (objectInputStream2 != null) {
                    objectInputStream2.close();
                } else {
                    inputStream.close();
                }
            } catch (IOException e7) {
                f32811b.log(Level.WARNING, "error closing input stream (ignored)", (Throwable) e7);
            }
            throw th;
        }
    }
}
