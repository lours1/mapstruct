package be.oniryx.mapstruct.mapper.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Classe utilitaire de gestion des dates
 *
 * @author tblfrd
 */
public class DateHelper {

    private static final transient Logger LOG = LoggerFactory.getLogger(DateHelper.class);

    private DateHelper() {}

    /**
     * Mapping entre une date Date et une date xml XmlGregorianCalendar
     *
     * @param date - Date à convertir
     * @return XMLGregorianCalendar
     */
    public static XMLGregorianCalendar toXmlDate(final Date date) {
        try {
            if (date == null) {
                return null;
            }
            GregorianCalendar gc = new GregorianCalendar();
            DatatypeFactory df = getDatatypeFactory();
            gc.setTimeInMillis(date.getTime());
            return df.newXMLGregorianCalendar(gc);
        } catch (DatatypeConfigurationException e) {
            LOG.error(e.getMessage(), e);
            return null;
        }
    }

    public static Date fromXmlDate(final XMLGregorianCalendar date) {
        try {
            if (date == null) {
                return null;
            }
            Calendar calendar = date.toGregorianCalendar();
            return calendar.getTime();
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return null;
        }
    }

    public static LocalDate fromXmlDateToLocalDate(XMLGregorianCalendar date) {
        if (date == null) {
            return null;
        }
        return date.toGregorianCalendar().toZonedDateTime().toLocalDate();
    }

    public static LocalDateTime fromXmlDateToLocalDateTime(XMLGregorianCalendar date) {
        if (date == null) {
            return null;
        }
        return date.toGregorianCalendar().toZonedDateTime().toLocalDateTime();
    }

    public static XMLGregorianCalendar toXmlDate(LocalDate date) {
        if (date == null) {
            return null;
        }
        GregorianCalendar gcal = GregorianCalendar.from(date.atStartOfDay(ZoneId.systemDefault()));
        return toXmlDate(gcal, false);
    }
    public static XMLGregorianCalendar toXmlDate(LocalDateTime date) {
        if (date == null) {
            return null;
        }
        GregorianCalendar gcal = GregorianCalendar.from(date.atZone(ZoneId.systemDefault()));
        return toXmlDate(gcal, true);
    }


    //need to make a internla cache for DataTypeFactory for the performance
    // to Dto for all code rue take 16s without cache and 88ms with cache
    private static DatatypeFactory datatypeFactory = null;
    private static DatatypeFactory getDatatypeFactory() throws DatatypeConfigurationException {
        if(datatypeFactory == null){
            datatypeFactory = DatatypeFactory.newInstance();
        }
        return datatypeFactory;
    }

    private static XMLGregorianCalendar toXmlDate(GregorianCalendar gcal, boolean withTime){
        try {

            XMLGregorianCalendar xmlGregorianCalendar = getDatatypeFactory().newXMLGregorianCalendar(gcal);
            xmlGregorianCalendar.setTimezone(DatatypeConstants.FIELD_UNDEFINED);
            if(!withTime){
                xmlGregorianCalendar.setTimezone(DatatypeConstants.FIELD_UNDEFINED);
                xmlGregorianCalendar.setTime(DatatypeConstants.FIELD_UNDEFINED,
                        DatatypeConstants.FIELD_UNDEFINED,
                        DatatypeConstants.FIELD_UNDEFINED,
                        DatatypeConstants.FIELD_UNDEFINED);
            }
            return xmlGregorianCalendar;
        } catch (DatatypeConfigurationException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }
}
