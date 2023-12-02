package com.google.firebase.functions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class Serializer {

    /* renamed from: a  reason: collision with root package name */
    private final DateFormat f31396a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Serializer() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        this.f31396a = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    public Object a(Object obj) {
        if (obj instanceof Number) {
            return obj;
        }
        if (obj instanceof String) {
            return obj;
        }
        if (obj instanceof Boolean) {
            return obj;
        }
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject.has("@type")) {
                String optString = jSONObject.optString("@type");
                String optString2 = jSONObject.optString("value");
                if (optString.equals("type.googleapis.com/google.protobuf.Int64Value")) {
                    try {
                        return Long.valueOf(Long.parseLong(optString2));
                    } catch (NumberFormatException unused) {
                        throw new IllegalArgumentException("Invalid Long format:" + optString2);
                    }
                } else if (optString.equals("type.googleapis.com/google.protobuf.UInt64Value")) {
                    try {
                        return Long.valueOf(Long.parseLong(optString2));
                    } catch (NumberFormatException unused2) {
                        throw new IllegalArgumentException("Invalid Long format:" + optString2);
                    }
                }
            }
            HashMap hashMap = new HashMap();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, a(jSONObject.opt(next)));
            }
            return hashMap;
        } else if (obj instanceof JSONArray) {
            ArrayList arrayList = new ArrayList();
            int i4 = 0;
            while (true) {
                JSONArray jSONArray = (JSONArray) obj;
                if (i4 < jSONArray.length()) {
                    arrayList.add(a(jSONArray.opt(i4)));
                    i4++;
                } else {
                    return arrayList;
                }
            }
        } else if (obj == JSONObject.NULL) {
            return null;
        } else {
            throw new IllegalArgumentException("Object cannot be decoded from JSON: " + obj);
        }
    }

    public Object b(Object obj) {
        if (obj != null && obj != JSONObject.NULL) {
            if (obj instanceof Long) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("@type", "type.googleapis.com/google.protobuf.Int64Value");
                    jSONObject.put("value", obj.toString());
                    return jSONObject;
                } catch (JSONException e4) {
                    throw new RuntimeException("Error encoding Long.", e4);
                }
            } else if (obj instanceof Number) {
                return obj;
            } else {
                if (obj instanceof String) {
                    return obj;
                }
                if (obj instanceof Boolean) {
                    return obj;
                }
                boolean z3 = obj instanceof JSONObject;
                if (z3) {
                    return obj;
                }
                boolean z4 = obj instanceof JSONArray;
                if (z4) {
                    return obj;
                }
                if (obj instanceof Map) {
                    JSONObject jSONObject2 = new JSONObject();
                    Map map = (Map) obj;
                    for (Object obj2 : map.keySet()) {
                        if (obj2 instanceof String) {
                            try {
                                jSONObject2.put((String) obj2, b(map.get(obj2)));
                            } catch (JSONException e5) {
                                throw new RuntimeException(e5);
                            }
                        } else {
                            throw new IllegalArgumentException("Object keys must be strings.");
                        }
                    }
                    return jSONObject2;
                } else if (obj instanceof List) {
                    JSONArray jSONArray = new JSONArray();
                    for (Object obj3 : (List) obj) {
                        jSONArray.put(b(obj3));
                    }
                    return jSONArray;
                } else if (z3) {
                    JSONObject jSONObject3 = new JSONObject();
                    JSONObject jSONObject4 = (JSONObject) obj;
                    Iterator<String> keys = jSONObject4.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (next != null) {
                            try {
                                jSONObject3.put(next, b(jSONObject4.opt(next)));
                            } catch (JSONException e6) {
                                throw new RuntimeException(e6);
                            }
                        } else {
                            throw new IllegalArgumentException("Object keys cannot be null.");
                        }
                    }
                    return jSONObject3;
                } else if (z4) {
                    JSONArray jSONArray2 = new JSONArray();
                    JSONArray jSONArray3 = (JSONArray) obj;
                    for (int i4 = 0; i4 < jSONArray3.length(); i4++) {
                        jSONArray2.put(b(jSONArray3.opt(i4)));
                    }
                    return jSONArray2;
                } else {
                    throw new IllegalArgumentException("Object cannot be encoded in JSON: " + obj);
                }
            }
        }
        return JSONObject.NULL;
    }
}
