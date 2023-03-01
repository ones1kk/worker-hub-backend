package com.breakingbad.workerhub.internal.domain.holidays;

import com.breakingbad.workerhub.domain.holidays.Holidays;
import com.breakingbad.workerhub.domain.holidays.repository.HolidaysRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Year;
import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class HolidaysInternalService {

    private final HolidaysRepository holidaysRepository;

    public List<Holidays> findAllByYear(Year year) {
        return holidaysRepository.findAllByYear(year);
    }

    public Long findCountByYears(List<Year> years) {
        return holidaysRepository.findCountByYears(years);
    }

    @Transactional
    public List<Holidays> saveAll(Collection<Holidays> holidays) {
        return holidaysRepository.saveAll(holidays);
    }

}
