package be.oniryx.mapstruct.mapper.util;


import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Date Mapper
 *
 * @author Cédric B.
 */
public class DateMapper {

    /**
     * @param date
     * @return
     */
    public XMLGregorianCalendar toXml(final Date date) {
        return DateHelper.toXmlDate(date);
    }

    /**
     * @param date
     * @return
     */
    public XMLGregorianCalendar toXml(final LocalDate date) {
        return DateHelper.toXmlDate(date);
    }

    /**
     * @param date
     * @return
     */
    public XMLGregorianCalendar toXml(final LocalDateTime date) {
        return DateHelper.toXmlDate(date);
    }


    /**
     * @param date
     * @return
     */
    public Date toDate(final XMLGregorianCalendar date) {
        return DateHelper.fromXmlDate(date);
    }

    /**
     * @param date
     * @return
     */
    public LocalDate toLocaDate(final XMLGregorianCalendar date) {
        return DateHelper.fromXmlDateToLocalDate(date);
    }

    /**
     * @param date
     * @return
     */
    public LocalDateTime toLocalDAteTime(final XMLGregorianCalendar date) {
        return DateHelper.fromXmlDateToLocalDateTime(date);
    }

}
