package com.breakingbad.workerhub.external.domain.holidays;

import com.breakingbad.workerhub.domain.holidays.Holidays;
import com.breakingbad.workerhub.domain.holidays.repository.HolidaysRepository;
import com.breakingbad.workerhub.domain.holidays.repository.query.HolidaysQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Year;
import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class HolidaysService {

    private final HolidaysQueryRepository holidaysQueryRepository;

    private final HolidaysRepository holidaysRepository;

    public List<Holidays> findAllByYear(Year year) {
        return holidaysQueryRepository.findAllByYear(year);
    }

    public Long findCountByYears(List<Year> years) {
        return holidaysQueryRepository.findCountByYears(years);
    }

    @Transactional
    public List<Holidays> saveAll(Collection<Holidays> holidays) {
        return holidaysRepository.saveAll(holidays);
    }

}
