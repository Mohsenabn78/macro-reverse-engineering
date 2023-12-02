package com.google.i18n.phonenumbers;

import com.google.i18n.phonenumbers.Phonemetadata;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes5.dex */
final class MultiFileMetadataSourceImpl implements MetadataSource {

    /* renamed from: a  reason: collision with root package name */
    private final String f32818a;

    /* renamed from: b  reason: collision with root package name */
    private final MetadataLoader f32819b;

    /* renamed from: c  reason: collision with root package name */
    private final ConcurrentHashMap<String, Phonemetadata.PhoneMetadata> f32820c;

    /* renamed from: d  reason: collision with root package name */
    private final ConcurrentHashMap<Integer, Phonemetadata.PhoneMetadata> f32821d;

    MultiFileMetadataSourceImpl(String str, MetadataLoader metadataLoader) {
        this.f32820c = new ConcurrentHashMap<>();
        this.f32821d = new ConcurrentHashMap<>();
        this.f32818a = str;
        this.f32819b = metadataLoader;
    }

    private boolean c(int i4) {
        List<String> list = CountryCodeToRegionCodeMap.a().get(Integer.valueOf(i4));
        if (list.size() != 1 || !PhoneNumberUtil.REGION_CODE_FOR_NON_GEO_ENTITY.equals(list.get(0))) {
            return false;
        }
        return true;
    }

    @Override // com.google.i18n.phonenumbers.MetadataSource
    public Phonemetadata.PhoneMetadata a(String str) {
        return MetadataManager.c(str, this.f32820c, this.f32818a, this.f32819b);
    }

    @Override // com.google.i18n.phonenumbers.MetadataSource
    public Phonemetadata.PhoneMetadata b(int i4) {
        if (!c(i4)) {
            return null;
        }
        return MetadataManager.c(Integer.valueOf(i4), this.f32821d, this.f32818a, this.f32819b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MultiFileMetadataSourceImpl(MetadataLoader metadataLoader) {
        this("/com/google/i18n/phonenumbers/data/PhoneNumberMetadataProto", metadataLoader);
    }
}
