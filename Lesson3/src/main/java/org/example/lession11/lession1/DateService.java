package org.example.lession11.lession1;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Service
public class DateService {

    private final ObjectProvider<SimpleDateFormat> isoProvider;
    private final ObjectProvider<SimpleDateFormat> localeProvider;

    public DateService(@Qualifier("isoFormatter")    ObjectProvider<SimpleDateFormat> isoProvider,
                       @Qualifier("localeFormatter") ObjectProvider<SimpleDateFormat> localeProvider) {
        this.isoProvider    = isoProvider;
        this.localeProvider = localeProvider;
    }

    public String todayIso() {
        return isoProvider.getObject().format(new Date());
    }

    public String today() {
        return localeProvider.getObject().format(new Date());
    }

}

