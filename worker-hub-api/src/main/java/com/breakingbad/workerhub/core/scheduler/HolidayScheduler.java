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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.breakingbad.workerhub.constant.ContentType.JSON;

@Slf4j(topic = LoggerNames.KASI_API)
@RequiredArgsConstructor
@Component
public class HolidayScheduler {

    private final KasiAPIs kasiApis;

    private final HolidaysService holidaysService;

    private final ApiConfigProperties apiConfigProperties;

    private static final List<String> MONTHS = List.of("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12");

    @Transactional
    public void saveHolidaysByYears(List<Year> years) throws IOException {
        log.info("|=▒▒▒▒▒▒▒▒▒▒= SCHEDULE =▒▒▒▒▒▒▒▒▒▒=> start to save holidays information...");
        List<Holidays> holidays = new ArrayList<>();

        Long count = holidaysService.findCountByYears(years);
        if (hasHolidays(count)) {
            log.error("|=▒▒▒▒▒▒▒▒▒▒= SCHEDULE =▒▒▒▒▒▒▒▒▒▒=> holidays information is already saved...");
            return;
        }

        for (Year year : years) {
            holidays.addAll(getHolidays(year));
        }
        holidaysService.saveAll(holidays);

        log.info("|=▒▒▒▒▒▒▒▒▒▒= SCHEDULE =▒▒▒▒▒▒▒▒▒▒=> finish to save holidays information...");
    }

    private boolean hasHolidays(Long count) {
        return count > 0L;
    }

    /**
     * 검토 예정
     *
     * @param years
     * @return
     */
    private Map<Year, List<String>> makeYearByMonth(List<Year> years) {
        Map<Year, List<String>> result = new HashMap<>();
        years.forEach(year -> result.put(year, MONTHS));

//        years.stream().map(Year::toString)
//                .collect(collectingAndThen(toMap(year -> year, MONTHS), Collections::unmodifiableMap));

        return result;
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
