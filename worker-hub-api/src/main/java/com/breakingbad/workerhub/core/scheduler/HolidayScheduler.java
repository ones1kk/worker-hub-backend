package com.breakingbad.workerhub.core.scheduler;

import com.breakingbad.workerhub.constant.APIUrls;
import com.breakingbad.workerhub.constant.HttpMethod;
import com.breakingbad.workerhub.constant.LoggerNames;
import com.breakingbad.workerhub.constant.RequestProperties;
import com.breakingbad.workerhub.core.api.APICaller;
import com.breakingbad.workerhub.core.api.APIConfiguration;
import com.breakingbad.workerhub.core.api.model.KASIResponse;
import com.breakingbad.workerhub.core.properties.ApiConfigProperties;
import com.breakingbad.workerhub.domain.holidays.Holidays;
import com.breakingbad.workerhub.external.domain.holidays.HolidaysService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j(topic = LoggerNames.KASI_API)
@RequiredArgsConstructor
@Component
public class HolidayScheduler {

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


    private List<Holidays> getHolidays(Year year) throws IOException {
        String serviceKey = apiConfigProperties.getKasi().getKey();
        List<Holidays> holidays = new ArrayList<>();

        for (String month : MONTHS) {
            APIConfiguration configure = APIConfiguration.configure(HttpMethod.GET, RequestProperties.JSON,
                    Map.of("solYear", year.toString(), "solMonth", month,
                            "_type", "json", "ServiceKey", serviceKey));

            KASIResponse response = APICaller.of(APIUrls.KASI_HOLIDAYS)
                    .configure(configure)
                    .call()
                    .getResponse(KASIResponse.class);

            holidays.addAll(response.toHolidays());
        }
        return holidays;
    }

}
