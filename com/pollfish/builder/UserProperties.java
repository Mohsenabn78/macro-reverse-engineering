package com.pollfish.builder;

import androidx.autofill.HintConstants;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.RoomMasterTable;
import com.arlosoft.macrodroid.cloudmessaging.CloudMessages;
import com.google.android.gms.stats.CodePackage;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010!\n\u0002\b\u0017\n\u0002\u0010%\n\u0002\b\u0014\u0018\u00002\u00020\u0001:\f789:;<=>?@ABBÃ\u0001\b\u0000\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u00104\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010/¢\u0006\u0004\b5\u00106R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001f\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006R\u0019\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006R\u0019\u0010%\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006R\u0019\u0010(\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\u0006R\u0019\u0010+\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b)\u0010\u0004\u001a\u0004\b*\u0010\u0006R\u0019\u0010.\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b,\u0010\u0004\u001a\u0004\b-\u0010\u0006R%\u00104\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010/8\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103¨\u0006C"}, d2 = {"Lcom/pollfish/builder/UserProperties;", "", "", "a", "Ljava/lang/String;", "getGender", "()Ljava/lang/String;", HintConstants.AUTOFILL_HINT_GENDER, "b", "getYearOfBirth", "yearOfBirth", CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "getMaritalStatus", "maritalStatus", "d", "getParentalStatus", "parentalStatus", "e", "getOrganizationRole", "organizationRole", "f", "getNumberOfEmployees", "numberOfEmployees", "", "g", "Ljava/util/List;", "getSpokenLanguages", "()Ljava/util/List;", "spokenLanguages", "h", "getEducationLevel", "educationLevel", "i", "getEmploymentStatus", "employmentStatus", "j", "getCareer", "career", "k", "getRace", "race", "l", "getIncome", "income", "m", "getPostalData", "postalData", "", "n", "Ljava/util/Map;", "getCustomAttributes", "()Ljava/util/Map;", "customAttributes", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "Builder", "Career", "EducationLevel", "EmploymentStatus", "Gender", "Income", "MaritalStatus", "NumberOfEmployees", "OrganizationRole", "ParentalStatus", "Race", "SpokenLanguage", "pollfish_googleplayRelease"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class UserProperties {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final String f36634a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final String f36635b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final String f36636c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final String f36637d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final String f36638e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private final String f36639f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private final List<String> f36640g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private final String f36641h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private final String f36642i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private final String f36643j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private final String f36644k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private final String f36645l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private final String f36646m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    private final Map<String, String> f36647n;

    @Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0010%\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b7\u00108J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001bJ\u0016\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001bJ\u0006\u0010!\u001a\u00020 R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010#R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010#R\u0018\u0010\t\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010#R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010#R\u0018\u0010\r\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010#R\u001e\u0010,\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010#R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010#R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010#R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010#R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u0010#R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010#R$\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105¨\u00069"}, d2 = {"Lcom/pollfish/builder/UserProperties$Builder;", "", "Lcom/pollfish/builder/UserProperties$Gender;", HintConstants.AUTOFILL_HINT_GENDER, "", "yearOfBirth", "Lcom/pollfish/builder/UserProperties$MaritalStatus;", "maritalStatus", "Lcom/pollfish/builder/UserProperties$ParentalStatus;", "parentalStatus", "Lcom/pollfish/builder/UserProperties$OrganizationRole;", "organizationRole", "Lcom/pollfish/builder/UserProperties$NumberOfEmployees;", "numberOfEmployees", "Lcom/pollfish/builder/UserProperties$SpokenLanguage;", "spokenLanguage", "addSpokenLanguage", "Lcom/pollfish/builder/UserProperties$EducationLevel;", "educationLevel", "Lcom/pollfish/builder/UserProperties$EmploymentStatus;", "employmentStatus", "Lcom/pollfish/builder/UserProperties$Career;", "career", "Lcom/pollfish/builder/UserProperties$Race;", "race", "Lcom/pollfish/builder/UserProperties$Income;", "income", "", "postalData", "key", "value", "customAttribute", "Lcom/pollfish/builder/UserProperties;", "build", "a", "Ljava/lang/String;", "b", CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "d", "e", "f", "", "g", "Ljava/util/List;", "spokenLanguages", "h", "i", "j", "k", "l", "m", "", "n", "Ljava/util/Map;", "custom", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "()V", "pollfish_googleplayRelease"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class Builder {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private String f36648a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private String f36649b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private String f36650c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private String f36651d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        private String f36652e;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        private String f36653f;
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        private List<String> f36654g;
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        private String f36655h;
        @Nullable

        /* renamed from: i  reason: collision with root package name */
        private String f36656i;
        @Nullable

        /* renamed from: j  reason: collision with root package name */
        private String f36657j;
        @Nullable

        /* renamed from: k  reason: collision with root package name */
        private String f36658k;
        @Nullable

        /* renamed from: l  reason: collision with root package name */
        private String f36659l;
        @Nullable

        /* renamed from: m  reason: collision with root package name */
        private String f36660m;
        @Nullable

        /* renamed from: n  reason: collision with root package name */
        private Map<String, String> f36661n;

        @NotNull
        public final Builder addSpokenLanguage(@NotNull SpokenLanguage spokenLanguage) {
            if (this.f36654g == null) {
                this.f36654g = new ArrayList();
            }
            List<String> list = this.f36654g;
            if (list != null) {
                list.add(spokenLanguage.getValue());
            }
            return this;
        }

        @NotNull
        public final UserProperties build() {
            return new UserProperties(this.f36648a, this.f36649b, this.f36650c, this.f36651d, this.f36652e, this.f36653f, this.f36654g, this.f36655h, this.f36656i, this.f36657j, this.f36658k, this.f36659l, this.f36660m, this.f36661n);
        }

        @NotNull
        public final Builder career(@NotNull Career career) {
            this.f36657j = career.getValue();
            return this;
        }

        @NotNull
        public final Builder customAttribute(@NotNull String str, @NotNull String str2) {
            if (this.f36661n == null) {
                this.f36661n = new LinkedHashMap();
            }
            Map<String, String> map = this.f36661n;
            if (map != null) {
                map.put(str, str2);
            }
            return this;
        }

        @NotNull
        public final Builder educationLevel(@NotNull EducationLevel educationLevel) {
            this.f36655h = educationLevel.getValue();
            return this;
        }

        @NotNull
        public final Builder employmentStatus(@NotNull EmploymentStatus employmentStatus) {
            this.f36656i = employmentStatus.getValue();
            return this;
        }

        @NotNull
        public final Builder gender(@NotNull Gender gender) {
            this.f36648a = gender.getValue();
            return this;
        }

        @NotNull
        public final Builder income(@NotNull Income income) {
            this.f36659l = income.getValue();
            return this;
        }

        @NotNull
        public final Builder maritalStatus(@NotNull MaritalStatus maritalStatus) {
            this.f36650c = maritalStatus.getValue();
            return this;
        }

        @NotNull
        public final Builder numberOfEmployees(@NotNull NumberOfEmployees numberOfEmployees) {
            this.f36653f = numberOfEmployees.getValue();
            return this;
        }

        @NotNull
        public final Builder organizationRole(@NotNull OrganizationRole organizationRole) {
            this.f36652e = organizationRole.getValue();
            return this;
        }

        @NotNull
        public final Builder parentalStatus(@NotNull ParentalStatus parentalStatus) {
            this.f36651d = parentalStatus.getValue();
            return this;
        }

        @NotNull
        public final Builder postalData(@NotNull String str) {
            this.f36660m = str;
            return this;
        }

        @NotNull
        public final Builder race(@NotNull Race race) {
            this.f36658k = race.getValue();
            return this;
        }

        @NotNull
        public final Builder yearOfBirth(int i4) {
            this.f36649b = String.valueOf(i4);
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b.\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0¨\u00061"}, d2 = {"Lcom/pollfish/builder/UserProperties$Career;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "AGRICULTURE_FORESTRY_FISHING_OR_HUNTING", "ARTS_ENTERTAINMENT_OR_RECREATION", "BROADCASTING", "CONSTRUCTION", "EDUCATION", "FINANCE_AND_INSURANCE", "GOVERNMENT_AND_PUBLIC_ADMINISTRATION", "HEALTH_CARE_AND_SOCIAL_ASSISTANCE", "HOMEMAKER", "HOTEL_AND_FOOD_SERVICES", "INFORMATION_OTHER", "INFORMATION_SERVICES_AND_DATA", "LEGAL_SERVICES", "MANUFACTURING_COMPUTER_AND_ELECTRONICS", "MANUFACTURING_OTHER", "MILITARY", "MINING", "PROCESSING", "PUBLISHING", "REAL_ESTATE_RENTAL_OR_LEASING", "RELIGIOUS", "RETAIL", "RETIRED", "SCIENTIFIC_OR_TECHNICAL_SERVICES", "SOFTWARE", "STUDENT", "TELECOMMUNICATIONS", "TRANSPORTATION_AND_WAREHOUSING", "UNEMPLOYED", "ENERGY_UTILITIES_OIL_AND_GAS", "WHOLESALE", "OTHER", "ADVERTISING", "AUTOMOTIVE", "CONSULTING", "FASHION_APPAREL", "HUMAN_RESOURCES", "MARKET_RESEARCH", "MARKETING_SALES", "SHIPPING_DISTRIBUTION", "PERSONAL_SERVICES", CodePackage.SECURITY, "pollfish_googleplayRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public enum Career {
        AGRICULTURE_FORESTRY_FISHING_OR_HUNTING("0"),
        ARTS_ENTERTAINMENT_OR_RECREATION("1"),
        BROADCASTING(ExifInterface.GPS_MEASUREMENT_2D),
        CONSTRUCTION(ExifInterface.GPS_MEASUREMENT_3D),
        EDUCATION("4"),
        FINANCE_AND_INSURANCE("5"),
        GOVERNMENT_AND_PUBLIC_ADMINISTRATION("6"),
        HEALTH_CARE_AND_SOCIAL_ASSISTANCE("7"),
        HOMEMAKER("8"),
        HOTEL_AND_FOOD_SERVICES("9"),
        INFORMATION_OTHER("10"),
        INFORMATION_SERVICES_AND_DATA("11"),
        LEGAL_SERVICES("12"),
        MANUFACTURING_COMPUTER_AND_ELECTRONICS("13"),
        MANUFACTURING_OTHER("14"),
        MILITARY("15"),
        MINING("16"),
        PROCESSING("17"),
        PUBLISHING("18"),
        REAL_ESTATE_RENTAL_OR_LEASING("19"),
        RELIGIOUS("20"),
        RETAIL("21"),
        RETIRED("22"),
        SCIENTIFIC_OR_TECHNICAL_SERVICES("23"),
        SOFTWARE("24"),
        STUDENT("25"),
        TELECOMMUNICATIONS("26"),
        TRANSPORTATION_AND_WAREHOUSING("27"),
        UNEMPLOYED("28"),
        ENERGY_UTILITIES_OIL_AND_GAS("29"),
        WHOLESALE("30"),
        OTHER("31"),
        ADVERTISING("32"),
        AUTOMOTIVE("33"),
        CONSULTING("34"),
        FASHION_APPAREL("35"),
        HUMAN_RESOURCES("36"),
        MARKET_RESEARCH("37"),
        MARKETING_SALES("38"),
        SHIPPING_DISTRIBUTION("39"),
        PERSONAL_SERVICES("40"),
        SECURITY("41");
        
        @NotNull
        private final String value;

        Career(String str) {
            this.value = str;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/pollfish/builder/UserProperties$EducationLevel;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "ELEMENTARY_SCHOOL", "MIDDLE_SCHOOL", "HIGH_SCHOOL", "VOCATIONAL_TECHNICAL_COLLEGE", "UNIVERSITY", "POST_GRADUATE", "pollfish_googleplayRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public enum EducationLevel {
        ELEMENTARY_SCHOOL("0"),
        MIDDLE_SCHOOL("1"),
        HIGH_SCHOOL(ExifInterface.GPS_MEASUREMENT_2D),
        VOCATIONAL_TECHNICAL_COLLEGE(ExifInterface.GPS_MEASUREMENT_3D),
        UNIVERSITY("4"),
        POST_GRADUATE("5");
        
        @NotNull
        private final String value;

        EducationLevel(String str) {
            this.value = str;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/pollfish/builder/UserProperties$EmploymentStatus;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "EMPLOYED_FOR_WAGES", "SELF_EMPLOYED", "UNEMPLOYED_LOOKING", "UNEMPLOYED_NOT_LOOKING", "HOMEMAKER", "STUDENT", "MILITARY", "RETIRED", "UNABLE_TO_WORK", "OTHER", "pollfish_googleplayRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public enum EmploymentStatus {
        EMPLOYED_FOR_WAGES("0"),
        SELF_EMPLOYED("1"),
        UNEMPLOYED_LOOKING(ExifInterface.GPS_MEASUREMENT_2D),
        UNEMPLOYED_NOT_LOOKING(ExifInterface.GPS_MEASUREMENT_3D),
        HOMEMAKER("4"),
        STUDENT("5"),
        MILITARY("6"),
        RETIRED("7"),
        UNABLE_TO_WORK("8"),
        OTHER("9");
        
        @NotNull
        private final String value;

        EmploymentStatus(String str) {
            this.value = str;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/pollfish/builder/UserProperties$Gender;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "FEMALE", "MALE", "OTHER", "pollfish_googleplayRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public enum Gender {
        FEMALE("1"),
        MALE(ExifInterface.GPS_MEASUREMENT_2D),
        OTHER(ExifInterface.GPS_MEASUREMENT_3D);
        
        @NotNull
        private final String value;

        Gender(String str) {
            this.value = str;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/pollfish/builder/UserProperties$Income;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "LOWER_I", "LOWER_II", "MIDDLE_I", "MIDDLE_II", "HIGH_I", "HIGH_II", "HIGH_III", "RATHER_NOT_TO_SAY", "pollfish_googleplayRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public enum Income {
        LOWER_I("0"),
        LOWER_II("1"),
        MIDDLE_I(ExifInterface.GPS_MEASUREMENT_2D),
        MIDDLE_II(ExifInterface.GPS_MEASUREMENT_3D),
        HIGH_I("4"),
        HIGH_II("5"),
        HIGH_III("6"),
        RATHER_NOT_TO_SAY("7");
        
        @NotNull
        private final String value;

        Income(String str) {
            this.value = str;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/pollfish/builder/UserProperties$MaritalStatus;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SINGLE", "MARRIED", "DIVORCED", "LIVING_WITH_PARENT", "SEPARATED", "WIDOWED", "PREFER_NOT_TO_SAY", "pollfish_googleplayRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public enum MaritalStatus {
        SINGLE("0"),
        MARRIED("1"),
        DIVORCED(ExifInterface.GPS_MEASUREMENT_2D),
        LIVING_WITH_PARENT(ExifInterface.GPS_MEASUREMENT_3D),
        SEPARATED("4"),
        WIDOWED("5"),
        PREFER_NOT_TO_SAY("6");
        
        @NotNull
        private final String value;

        MaritalStatus(String str) {
            this.value = str;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/pollfish/builder/UserProperties$NumberOfEmployees;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "ONE", "TWO_TO_FIVE", "SIX_TO_TEN", "ELEVEN_TO_TWENTY_FIVE", "TWENTY_FIVE_TO_FIFTY", "FIFTY_ONE_TO_HUNDREND", "HUNDREND_ONE_TO_TWO_HUNDRENDS_FIFTY", "TWO_HUNDRENDS_FIFTY_ONE_TO_FIVE_HUNDRENDS", "FIVE_HUNDRENDS_ONE_TO_THOUSAND", "THOUSAND_ONE_TO_FIVE_THOUSANDS", "GREATER_THAN_FIVE_THOUSANDS", "DO_NOT_WORK", "PREFER_NOT_TO_SAY", "pollfish_googleplayRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public enum NumberOfEmployees {
        ONE("0"),
        TWO_TO_FIVE("1"),
        SIX_TO_TEN(ExifInterface.GPS_MEASUREMENT_2D),
        ELEVEN_TO_TWENTY_FIVE(ExifInterface.GPS_MEASUREMENT_3D),
        TWENTY_FIVE_TO_FIFTY("4"),
        FIFTY_ONE_TO_HUNDREND("5"),
        HUNDREND_ONE_TO_TWO_HUNDRENDS_FIFTY("6"),
        TWO_HUNDRENDS_FIFTY_ONE_TO_FIVE_HUNDRENDS("7"),
        FIVE_HUNDRENDS_ONE_TO_THOUSAND("8"),
        THOUSAND_ONE_TO_FIVE_THOUSANDS("9"),
        GREATER_THAN_FIVE_THOUSANDS("10"),
        DO_NOT_WORK("11"),
        PREFER_NOT_TO_SAY("12");
        
        @NotNull
        private final String value;

        NumberOfEmployees(String str) {
            this.value = str;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001d\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001f¨\u0006 "}, d2 = {"Lcom/pollfish/builder/UserProperties$OrganizationRole;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "OWNER_PARTNER", "PRESIDENT_CEO_CHAIRPERSON", "C_LEVEL_EXECUTIVE", "MIDDLE_MANAGEMENT", "CHIEF_FINANCIAL_OFFICER", "CHIEF_TECHNICAL_OFFICER", "SENIOR_MANAGEMENT", "DIRECTOR", "HR_MANAGER", "PRODUCT_MANAGER", "SUPPLY_MANAGER", "PROJECT_MANAGEMENT", "SALES_MANAGER", "BUSINESS_ADMINISTRATOR", "SUPERVISOR", "ADMINISTRATIVE_CLERICAL", "CRAFTSMAN", "FOREMAN", "TECHNICAL_STAFF", "FACULTY_STAFF", "SALES_STAFF", "BUYER_PURCHASING_AGENT", "OTHER_NON_MANAGEMENT", "NOT_WORK", "PREFER_NOT_TO_SAY", "pollfish_googleplayRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public enum OrganizationRole {
        OWNER_PARTNER("0"),
        PRESIDENT_CEO_CHAIRPERSON("1"),
        C_LEVEL_EXECUTIVE(ExifInterface.GPS_MEASUREMENT_2D),
        MIDDLE_MANAGEMENT(ExifInterface.GPS_MEASUREMENT_3D),
        CHIEF_FINANCIAL_OFFICER("4"),
        CHIEF_TECHNICAL_OFFICER("5"),
        SENIOR_MANAGEMENT("6"),
        DIRECTOR("7"),
        HR_MANAGER("8"),
        PRODUCT_MANAGER("9"),
        SUPPLY_MANAGER("10"),
        PROJECT_MANAGEMENT("11"),
        SALES_MANAGER("12"),
        BUSINESS_ADMINISTRATOR("13"),
        SUPERVISOR("14"),
        ADMINISTRATIVE_CLERICAL("15"),
        CRAFTSMAN("16"),
        FOREMAN("17"),
        TECHNICAL_STAFF("18"),
        FACULTY_STAFF("19"),
        SALES_STAFF("20"),
        BUYER_PURCHASING_AGENT("21"),
        OTHER_NON_MANAGEMENT("22"),
        NOT_WORK("23"),
        PREFER_NOT_TO_SAY("24");
        
        @NotNull
        private final String value;

        OrganizationRole(String str) {
            this.value = str;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/pollfish/builder/UserProperties$ParentalStatus;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX_OR_MORE", "PREFER_NOT_TO_SAY", "pollfish_googleplayRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public enum ParentalStatus {
        ZERO("0"),
        ONE("1"),
        TWO(ExifInterface.GPS_MEASUREMENT_2D),
        THREE(ExifInterface.GPS_MEASUREMENT_3D),
        FOUR("4"),
        FIVE("5"),
        SIX_OR_MORE("6"),
        PREFER_NOT_TO_SAY("7");
        
        @NotNull
        private final String value;

        ParentalStatus(String str) {
            this.value = str;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/pollfish/builder/UserProperties$Race;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "ARAB", "ASIAN", "BLACK", "WHITE", "HISPANIC", "LATINO", "MULTIRACIAL", "OTHER", "RATHER_NOT_TO_SAY", "pollfish_googleplayRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public enum Race {
        ARAB("0"),
        ASIAN("1"),
        BLACK(ExifInterface.GPS_MEASUREMENT_2D),
        WHITE(ExifInterface.GPS_MEASUREMENT_3D),
        HISPANIC("4"),
        LATINO("5"),
        MULTIRACIAL("6"),
        OTHER("7"),
        RATHER_NOT_TO_SAY("8");
        
        @NotNull
        private final String value;

        Race(String str) {
            this.value = str;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b/\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1¨\u00062"}, d2 = {"Lcom/pollfish/builder/UserProperties$SpokenLanguage;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "ENGLISH", "ARABIC", "BULGARIAN", "CHINESE", "CZECH", "DANISH", "DUTCH", "FILIPINO", "THAI", "FINNISH", "FRENCH", "GERMAN", "GREEK", "HINDI", "INDONESIAN", "ITALIAN", "JAPANESE", "POLISH", "PORTUGUESE", "ROMANIAN", "RUSSIAN", "SERBIAN", "SPANISH", "SWEDISH", "TURKISH", "VIETNAMESE", "KOREAN", "HUNGARIAN", "CHINESE_TRADITIONAL", "NORWEGIAN", "EGYPTIAN", "UKRAINIAN", "HEBREW", "BENGALI", "SLOVAK", "PERSIAN", "AZERBAIJANI", "GEORGIAN", "LITHUANIAN", "PUNJABI", "PASHTO", "ESTONIAN", "UZBEK", "pollfish_googleplayRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public enum SpokenLanguage {
        ENGLISH("0"),
        ARABIC("1"),
        BULGARIAN(ExifInterface.GPS_MEASUREMENT_2D),
        CHINESE(ExifInterface.GPS_MEASUREMENT_3D),
        CZECH("4"),
        DANISH("5"),
        DUTCH("6"),
        FILIPINO("7"),
        THAI("8"),
        FINNISH("9"),
        FRENCH("10"),
        GERMAN("11"),
        GREEK("12"),
        HINDI("13"),
        INDONESIAN("14"),
        ITALIAN("15"),
        JAPANESE("16"),
        POLISH("17"),
        PORTUGUESE("18"),
        ROMANIAN("20"),
        RUSSIAN("21"),
        SERBIAN("22"),
        SPANISH("23"),
        SWEDISH("24"),
        TURKISH("25"),
        VIETNAMESE("26"),
        KOREAN("27"),
        HUNGARIAN("28"),
        CHINESE_TRADITIONAL("29"),
        NORWEGIAN("30"),
        EGYPTIAN("31"),
        UKRAINIAN("32"),
        HEBREW("33"),
        BENGALI("34"),
        SLOVAK("35"),
        PERSIAN("36"),
        AZERBAIJANI("37"),
        GEORGIAN("38"),
        LITHUANIAN("39"),
        PUNJABI("40"),
        PASHTO("41"),
        ESTONIAN(RoomMasterTable.DEFAULT_ID),
        UZBEK("43");
        
        @NotNull
        private final String value;

        SpokenLanguage(String str) {
            this.value = str;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }
    }

    public UserProperties() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
    }

    @Nullable
    public final String getCareer() {
        return this.f36643j;
    }

    @Nullable
    public final Map<String, String> getCustomAttributes() {
        return this.f36647n;
    }

    @Nullable
    public final String getEducationLevel() {
        return this.f36641h;
    }

    @Nullable
    public final String getEmploymentStatus() {
        return this.f36642i;
    }

    @Nullable
    public final String getGender() {
        return this.f36634a;
    }

    @Nullable
    public final String getIncome() {
        return this.f36645l;
    }

    @Nullable
    public final String getMaritalStatus() {
        return this.f36636c;
    }

    @Nullable
    public final String getNumberOfEmployees() {
        return this.f36639f;
    }

    @Nullable
    public final String getOrganizationRole() {
        return this.f36638e;
    }

    @Nullable
    public final String getParentalStatus() {
        return this.f36637d;
    }

    @Nullable
    public final String getPostalData() {
        return this.f36646m;
    }

    @Nullable
    public final String getRace() {
        return this.f36644k;
    }

    @Nullable
    public final List<String> getSpokenLanguages() {
        return this.f36640g;
    }

    @Nullable
    public final String getYearOfBirth() {
        return this.f36635b;
    }

    public UserProperties(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable List<String> list, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11, @Nullable String str12, @Nullable Map<String, String> map) {
        this.f36634a = str;
        this.f36635b = str2;
        this.f36636c = str3;
        this.f36637d = str4;
        this.f36638e = str5;
        this.f36639f = str6;
        this.f36640g = list;
        this.f36641h = str7;
        this.f36642i = str8;
        this.f36643j = str9;
        this.f36644k = str10;
        this.f36645l = str11;
        this.f36646m = str12;
        this.f36647n = map;
    }

    public /* synthetic */ UserProperties(String str, String str2, String str3, String str4, String str5, String str6, List list, String str7, String str8, String str9, String str10, String str11, String str12, Map map, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? null : str, (i4 & 2) != 0 ? null : str2, (i4 & 4) != 0 ? null : str3, (i4 & 8) != 0 ? null : str4, (i4 & 16) != 0 ? null : str5, (i4 & 32) != 0 ? null : str6, (i4 & 64) != 0 ? null : list, (i4 & 128) != 0 ? null : str7, (i4 & 256) != 0 ? null : str8, (i4 & 512) != 0 ? null : str9, (i4 & 1024) != 0 ? null : str10, (i4 & 2048) != 0 ? null : str11, (i4 & 4096) != 0 ? null : str12, (i4 & 8192) == 0 ? map : null);
    }
}
