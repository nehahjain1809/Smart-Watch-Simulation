/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Helper;

import Business.WorkPlace.Holiday;
import Business.WorkPlace.HolidayList;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author nehah
 */
public class VacationHelper {

    private final Set<LocalDate> publicHolidays = new HashSet<>();

    private final Map<Integer, List<LocalDate>> cache = new HashMap<>();

    public VacationHelper(ArrayList<Holiday> holidayList) {
        initPublicHolidays(holidayList);
    }

//    public static void main(String[] args) {
//        VacationHelper vacationHelper = new VacationHelper(2017);
//        System.out.println(vacationHelper.getBestVacationStartDates(2));
//        System.out.println(vacationHelper.getBestVacationStartDates(3));
//        System.out.println(vacationHelper.getBestVacationStartDates(2));
//        System.out.println(vacationHelper.getBestVacationStartDates(4));
//        System.out.println(vacationHelper.getBestVacationStartDates(8));
//    }

    public List<LocalDate> getBestVacationStartDates(int leavesRemaining) {
        if (!cache.containsKey(leavesRemaining)) {
            cache.put(leavesRemaining, calculateBestVacationStartDates(leavesRemaining));
        }
        return cache.get(leavesRemaining);
    }

    private List<LocalDate> calculateBestVacationStartDates(int leavesRemaining) {
        int bestVacationDays = 0;
        List<LocalDate> bestStartDates = new ArrayList<>();
        
        for (LocalDate publicHoliday : publicHolidays) {
            int forwardVacationDays = findForwardVacationDays(publicHoliday, leavesRemaining);
            int backwardVacationDays = findBackwardVacationDays(publicHoliday, leavesRemaining);
            
            if (forwardVacationDays < bestVacationDays && backwardVacationDays < bestVacationDays) {
                continue;
            }
            
            if (forwardVacationDays > bestVacationDays) {
                bestVacationDays = forwardVacationDays;
                bestStartDates = new ArrayList<>();
                bestStartDates.add(publicHoliday);
            } else if (forwardVacationDays == bestVacationDays) {
                bestStartDates.add(publicHoliday);
            }
            
            if (backwardVacationDays > bestVacationDays) {
                bestVacationDays = backwardVacationDays;
                bestStartDates = new ArrayList<>();
                bestStartDates.add(publicHoliday.plusDays(backwardVacationDays));
            } else if (forwardVacationDays == bestVacationDays) {
                bestStartDates.add(publicHoliday.plusDays(backwardVacationDays));
            }
            
        }
        return bestStartDates;
    }

    private int findForwardVacationDays(LocalDate fromDate, int leavesRemaining) {
        return findVacationDays(fromDate, leavesRemaining, 1);
    }

    private int findBackwardVacationDays(LocalDate fromDate, int leavesRemaining) {
        return findVacationDays(fromDate, leavesRemaining, -1);
    }

    private int findVacationDays(LocalDate fromDate, int leavesRemaining, int incrementDayCount) {
        int vacationCount = 0;
        do {
            if (!isHoliday(fromDate)) {
                leavesRemaining--;
            }
            vacationCount++;
            fromDate = fromDate.plusDays(1);
        } while (leavesRemaining != 0);
        return vacationCount;
    }

    private boolean isHoliday(LocalDate dateToCheck) {
        return publicHolidays.contains(dateToCheck) || DayOfWeek.SATURDAY.equals(dateToCheck.getDayOfWeek()) || DayOfWeek.SUNDAY.equals(dateToCheck.getDayOfMonth());
    }

    private void initPublicHolidays(ArrayList<Holiday> holidayList) {
        
        for(Holiday h:holidayList){
           // System.out.println(h.getDate());
            Date holidayDate=h.getDatetime();
            Calendar cal = Calendar.getInstance();
            cal.setTime(holidayDate);
            int year=cal.get(Calendar.YEAR);
            int date=cal.get(Calendar.DATE);
            int month=cal.get(Calendar.MONTH)+1;
//                System.out.println(holidayDate);
//                System.out.println(cal.get(Calendar.DATE));
//                System.out.println(cal.get(Calendar.MONTH));
//                System.out.println(cal.get(Calendar.YEAR));
            publicHolidays.add(LocalDate.of(year, month, date));
        }
//        publicHolidays.add(LocalDate.of(year, Month.JANUARY, 15));
//        publicHolidays.add(LocalDate.of(year, Month.FEBRUARY, 19));
//        publicHolidays.add(LocalDate.of(year, Month.MAY, 28));
//        publicHolidays.add(LocalDate.of(year, Month.JULY, 4));
//        publicHolidays.add(LocalDate.of(year, Month.SEPTEMBER, 3));
//        publicHolidays.add(LocalDate.of(year, Month.SEPTEMBER, 8));
        
       
    }
}


