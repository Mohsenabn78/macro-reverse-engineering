package com.google.firebase.remoteconfig.internal;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class ConfigContainer {

    /* renamed from: g  reason: collision with root package name */
    private static final Date f31929g = new Date(0);

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f31930a;

    /* renamed from: b  reason: collision with root package name */
    private JSONObject f31931b;

    /* renamed from: c  reason: collision with root package name */
    private Date f31932c;

    /* renamed from: d  reason: collision with root package name */
    private JSONArray f31933d;

    /* renamed from: e  reason: collision with root package name */
    private JSONObject f31934e;

    /* renamed from: f  reason: collision with root package name */
    private long f31935f;

    /* loaded from: classes5.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private JSONObject f31936a;

        /* renamed from: b  reason: collision with root package name */
        private Date f31937b;

        /* renamed from: c  reason: collision with root package name */
        private JSONArray f31938c;

        /* renamed from: d  reason: collision with root package name */
        private JSONObject f31939d;

        /* renamed from: e  reason: collision with root package name */
        private long f31940e;

        public ConfigContainer build() throws JSONException {
            return new ConfigContainer(this.f31936a, this.f31937b, this.f31938c, this.f31939d, this.f31940e);
        }

        public Builder replaceConfigsWith(Map<String, String> map) {
            this.f31936a = new JSONObject(map);
            return this;
        }

        public Builder withAbtExperiments(JSONArray jSONArray) {
            try {
                this.f31938c = new JSONArray(jSONArray.toString());
            } catch (JSONException unused) {
            }
            return this;
        }

        public Builder withFetchTime(Date date) {
            this.f31937b = date;
            return this;
        }

        public Builder withPersonalizationMetadata(JSONObject jSONObject) {
            try {
                this.f31939d = new JSONObject(jSONObject.toString());
            } catch (JSONException unused) {
            }
            return this;
        }

        public Builder withTemplateVersionNumber(long j4) {
            this.f31940e = j4;
            return this;
        }

        private Builder() {
            this.f31936a = new JSONObject();
            this.f31937b = ConfigContainer.f31929g;
            this.f31938c = new JSONArray();
            this.f31939d = new JSONObject();
            this.f31940e = 0L;
        }

        public Builder replaceConfigsWith(JSONObject jSONObject) {
            try {
                this.f31936a = new JSONObject(jSONObject.toString());
            } catch (JSONException unused) {
            }
            return this;
        }

        public Builder(ConfigContainer configContainer) {
            this.f31936a = configContainer.getConfigs();
            this.f31937b = configContainer.getFetchTime();
            this.f31938c = configContainer.getAbtExperiments();
            this.f31939d = configContainer.getPersonalizationMetadata();
            this.f31940e = configContainer.getTemplateVersionNumber();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ConfigContainer b(JSONObject jSONObject) throws JSONException {
        JSONObject optJSONObject = jSONObject.optJSONObject("personalization_metadata_key");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        return new ConfigContainer(jSONObject.getJSONObject("configs_key"), new Date(jSONObject.getLong("fetch_time_key")), jSONObject.getJSONArray("abt_experiments_key"), optJSONObject, jSONObject.optLong("template_version_number_key"));
    }

    private static ConfigContainer c(JSONObject jSONObject) throws JSONException {
        return b(new JSONObject(jSONObject.toString()));
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConfigContainer)) {
            return false;
        }
        return this.f31930a.toString().equals(((ConfigContainer) obj).toString());
    }

    public JSONArray getAbtExperiments() {
        return this.f31933d;
    }

    public Set<String> getChangedParams(ConfigContainer configContainer) throws JSONException {
        JSONObject configs = c(configContainer.f31930a).getConfigs();
        HashSet hashSet = new HashSet();
        Iterator<String> keys = getConfigs().keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!configContainer.getConfigs().has(next)) {
                hashSet.add(next);
            } else if (!getConfigs().get(next).equals(configContainer.getConfigs().get(next))) {
                hashSet.add(next);
            } else if ((getPersonalizationMetadata().has(next) && !configContainer.getPersonalizationMetadata().has(next)) || (!getPersonalizationMetadata().has(next) && configContainer.getPersonalizationMetadata().has(next))) {
                hashSet.add(next);
            } else if (getPersonalizationMetadata().has(next) && configContainer.getPersonalizationMetadata().has(next) && !getPersonalizationMetadata().getJSONObject(next).toString().equals(configContainer.getPersonalizationMetadata().getJSONObject(next).toString())) {
                hashSet.add(next);
            } else {
                configs.remove(next);
            }
        }
        Iterator<String> keys2 = configs.keys();
        while (keys2.hasNext()) {
            hashSet.add(keys2.next());
        }
        return hashSet;
    }

    public JSONObject getConfigs() {
        return this.f31931b;
    }

    public Date getFetchTime() {
        return this.f31932c;
    }

    public JSONObject getPersonalizationMetadata() {
        return this.f31934e;
    }

    public long getTemplateVersionNumber() {
        return this.f31935f;
    }

    public int hashCode() {
        return this.f31930a.hashCode();
    }

    public String toString() {
        return this.f31930a.toString();
    }

    private ConfigContainer(JSONObject jSONObject, Date date, JSONArray jSONArray, JSONObject jSONObject2, long j4) throws JSONException {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("configs_key", jSONObject);
        jSONObject3.put("fetch_time_key", date.getTime());
        jSONObject3.put("abt_experiments_key", jSONArray);
        jSONObject3.put("personalization_metadata_key", jSONObject2);
        jSONObject3.put("template_version_number_key", j4);
        this.f31931b = jSONObject;
        this.f31932c = date;
        this.f31933d = jSONArray;
        this.f31934e = jSONObject2;
        this.f31935f = j4;
        this.f31930a = jSONObject3;
    }

    public static Builder newBuilder(ConfigContainer configContainer) {
        return new Builder(configContainer);
    }
}
