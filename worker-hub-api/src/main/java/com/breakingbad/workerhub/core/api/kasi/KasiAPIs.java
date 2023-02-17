package com.breakingbad.workerhub.core.api.kasi;

import com.breakingbad.workerhub.core.api.kasi.model.KasiResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface KasiAPIs {

    @GET("getRestDeInfo")
    Call<KasiResponse> getHolidaysByYearAndMonth(
            @Query("solYear") String year,
            @Query("solMonth") String month,
            @Query("_type") String type,
            @Query("serviceKey") String key);

}
