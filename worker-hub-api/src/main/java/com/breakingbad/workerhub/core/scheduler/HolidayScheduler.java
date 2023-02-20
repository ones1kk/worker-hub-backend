package com.breakingbad.workerhub.core.scheduler;

import com.breakingbad.workerhub.constant.LoggerNames;
import com.breakingbad.workerhub.core.api.kasi.KasiAPIs;
import com.breakingbad.workerhub.core.api.kasi.model.KasiResponse;
import com.breakingbad.workerhub.core.properties.ApiConfigProperties;
import com.breakingbad.workerhub.domain.holidays.Holidays;
import com.breakingbad.workerhub.external.domain.holidays.HolidaysService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import static com.breakingbad.workerhub.constant.ContentType.JSON;
import static org.springframework.util.CollectionUtils.isEmpty;

@Slf4j(topic = LoggerNames.KASI_API)
@RequiredArgsConstructor
@Component
public class HolidayScheduler {

    private final KasiAPIs kasiApis;

    private final HolidaysService holidaysService;

    private final ApiConfigProperties apiConfigProperties;

    private static final List<String> MONTHS = List.of("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12");

    @Transactional
    public void saveHolidaysByYears(Year year) throws IOException {
        log.info("|=▒▒▒▒▒▒▒▒▒▒= SCHEDULE =▒▒▒▒▒▒▒▒▒▒=> start to save {} holidays information...", year);
        List<Holidays> findHolidays = holidaysService.findAllByYear(year);

        if (!isEmpty(findHolidays)) {
            log.error("|=▒▒▒▒▒▒▒▒▒▒= SCHEDULE =▒▒▒▒▒▒▒▒▒▒=> {} holidays information is already saved...", year);
            return;
        }

        List<Holidays> holidays = getHolidays(year);
        holidaysService.saveAll(holidays);

        log.info("|=▒▒▒▒▒▒▒▒▒▒= SCHEDULE =▒▒▒▒▒▒▒▒▒▒=> finish to save {} holidays information...", year);
    }

    private List<Holidays> getHolidays(Year year) throws IOException {
        String serviceKey = apiConfigProperties.getKasi().getKey();
        List<Holidays> holidays = new ArrayList<>();
        for (String month : MONTHS) {
            Call<KasiResponse> call = kasiApis.getHolidaysByYearAndMonth(year.toString(), month, JSON.getVar(), serviceKey);
            Response<KasiResponse> response = call.execute();

            KasiResponse body = response.body();
            if (body != null) {
                holidays.addAll(body.toHolidays());
            }
        }
        return holidays;
    }

}
