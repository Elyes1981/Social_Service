package com.sofrecom.operation.customer.service;

import com.sofrecom.operation.customer.dao.AvailibilitiesMou3inaRepository;
import com.sofrecom.operation.customer.dao.CustomerOrderMou3inaListRepository;
import com.sofrecom.operation.customer.dao.CustomerReservationRepository;
import com.sofrecom.operation.customer.dao.WeekendRepository;
import com.sofrecom.operation.customer.entities.AvailibilitiesMou3ina;
import com.sofrecom.operation.customer.entities.CustomerOrderMou3inaList;
import com.sofrecom.operation.customer.entities.Weekend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class AvailibilitiesMou3inaImpl implements IAvailibilitiesMou3ina {
	@Autowired
	AvailibilitiesMou3inaRepository availibilitiesMou3inaRepository;

	@Autowired
	CustomerReservationRepository customerReservationRepository;

	@Autowired
	CustomerOrderMou3inaListRepository customerOrderMou3inaListRepository;


	@Autowired
	WeekendRepository weekendRepository ;


	@Override
	public AvailibilitiesMou3ina addAvailibilitiesMou3ina(AvailibilitiesMou3ina m) {
		return availibilitiesMou3inaRepository.save(m);
	}

	@Override
	public List<AvailibilitiesMou3ina> findAll() {

		return availibilitiesMou3inaRepository.findAll();
	}



	@Override
	public List<AvailibilitiesMou3ina> findMorning() {
		return null;
	}



	public static int getNumberOfDaysInMonth(int year, int month) {
		YearMonth yearMonthObject = YearMonth.of(year, month);
		int daysInMonth = yearMonthObject.lengthOfMonth();
		return daysInMonth;
	}


	@Override
	public List<Float> findWeekndByMou3ina(Long id, Integer year) {
		List<AvailibilitiesMou3ina> allweek = new ArrayList<AvailibilitiesMou3ina>();
		List<CustomerOrderMou3inaList> orders = new ArrayList<CustomerOrderMou3inaList>();
		List<Weekend> allweekwek = new ArrayList<Weekend>();
		orders = customerOrderMou3inaListRepository.findAllByMou3inaID(id, year);
		Map<String, Long> testorders = orders.stream()
				.collect(Collectors.groupingBy(p -> String.valueOf(Month.from(p.getOrderDay().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())), Collectors.counting()));


		//System.out.println(testorders);
		//testorders.entrySet().forEach(entry -> {
		//System.out.println("Key/Value: " + entry.getKey() + ":" + entry.getValue());
		//System.out.println(entry.getKey().equals("JULY"));
		//});
		//System.out.println(testorders.get("JULY"));
		allweek = availibilitiesMou3inaRepository.findByMou3inaEntityYear(id, year);
		Map<String, Long> test = allweek.stream()
				.collect(Collectors.groupingBy(p -> Month.from(p.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()).toString(), Collectors.counting()));
		allweekwek = weekendRepository.findByMou3inaEntitya(id, year);
		List<Long> SommeByMonyh = new ArrayList<>();
		List<Float> list = new ArrayList<Float>();
		Map<String, Long> testWeeknd = allweekwek.stream().collect(Collectors.groupingBy(p -> Month.from(p.getDate()).toString(), Collectors.counting()));
		// for January
		long JANUARYOrders = testorders.get("JANUARY") != null ? testorders.get("JANUARY") : 0;
		//System.out.println(JANUARYOrders);
		long JANUARY = testWeeknd.get("JANUARY") != null ? testWeeknd.get("JANUARY") : 0;
		long JANUARYTEST = test.get("JANUARY") != null ? test.get("JANUARY") : 0;
		list.add(((float) JANUARYOrders / (float) (getNumberOfDaysInMonth(year, 1) - JANUARY + JANUARYTEST)) * 100);
		SommeByMonyh.add(getNumberOfDaysInMonth(year, 1) - JANUARY + JANUARYTEST);

		// for February
		long FEBRUARY = testWeeknd.get("FEBRUARY") != null ? testWeeknd.get("FEBRUARY") : 0;
		long FEBRUARYTEST = test.get("FEBRUARY") != null ? test.get("FEBRUARY") : 0;
		long FEBRUARYOrders = testorders.get("FEBRUARY") != null ? testorders.get("FEBRUARY") : 0;
		list.add(((float) FEBRUARYOrders / (float) (getNumberOfDaysInMonth(year, 2) - FEBRUARY + FEBRUARYTEST)) * 100);
		SommeByMonyh.add(getNumberOfDaysInMonth(year, 2) - FEBRUARY + FEBRUARYTEST);
		// for MARCH
		long MARCHOrders = testorders.get("MARCH") != null ? testorders.get("MARCH") : 0;
		long MARCH = testWeeknd.get("MARCH") != null ? testWeeknd.get("MARCH") : 0;
		long MARCHTEST = test.get("MARCH") != null ? test.get("MARCH") : 0;
		list.add(((float) MARCHOrders / (float) (getNumberOfDaysInMonth(year, 3) - MARCH + MARCHTEST)) * 100);
		SommeByMonyh.add(getNumberOfDaysInMonth(year, 3) - (MARCH + MARCHTEST) * 100);
		// FOR APRIL
		long APRILOrders = testorders.get("APRIL") != null ? testorders.get("APRIL") : 0;
		long APRIL = testWeeknd.get("APRIL") != null ? testWeeknd.get("APRIL") : 0;
		long APRILTEST = test.get("APRIL") != null ? test.get("APRIL") : 0;
		list.add(((float) APRILOrders / (float) (getNumberOfDaysInMonth(year, 4) - APRIL + APRILTEST)) * 100);
		SommeByMonyh.add(getNumberOfDaysInMonth(year, 4) - APRIL + APRILTEST);
		// FOR MAY
		long MAYOrders = testorders.get("MAY") != null ? testorders.get("MAY") : 0;
		long MAY = testWeeknd.get("MAY") != null ? testWeeknd.get("MAY") : 0;
		long MAYTEDT = test.get("MAY") != null ? test.get("MAY") : 0;
		list.add(((float) MAYOrders / (float) (getNumberOfDaysInMonth(year, 5) - MAY + MAYTEDT)) * 100);
		SommeByMonyh.add(getNumberOfDaysInMonth(year, 5) - MAY + MAYTEDT);
		//FOR JUNE
		long JUNEOrders = testorders.get("JUNE") != null ? testorders.get("JUNE") : 0;
		long JUNE = testWeeknd.get("JUNE") != null ? testWeeknd.get("JUNE") : 0;
		long JUNEtest = test.get("JUNE") != null ? test.get("JUNE") : 0;
		list.add(((float) JUNEOrders / (float) (getNumberOfDaysInMonth(year, 6) - JUNE + JUNEtest)) * 100);
		SommeByMonyh.add(getNumberOfDaysInMonth(year, 6) - JUNE + JUNEtest);
		//FOR JULY
		long JULYOrders = testorders.get("JULY") != null ? testorders.get("JULY") : 0;
		System.out.println(testorders.get("JULY")) ;
		//System.out.println(test);
		long JULY = testWeeknd.get("JULY") != null ? testWeeknd.get("JULY") : 0;
		long JULYtest = test.get("JULY") != null ? test.get("JULY") : 0;
		list.add(((float) JULYOrders / (float) (getNumberOfDaysInMonth(year, 7) - JULY + JULYtest)) * 100);
		SommeByMonyh.add(getNumberOfDaysInMonth(year, 7) - JULY + JULYtest);
		//FOR AUGUST
		long AUGUSTOrders = testorders.get("AUGUST") != null ? testorders.get("AUGUST") : 0;
		long AUGUST = testWeeknd.get("AUGUST") != null ? testWeeknd.get("AUGUST") : 0;
		long AUGUSTtest = test.get("AUGUST") != null ? test.get("AUGUST") : 0;

		list.add(((float) AUGUSTOrders / (float) (getNumberOfDaysInMonth(year, 8) - AUGUST + AUGUSTtest)) * 100);
		SommeByMonyh.add(getNumberOfDaysInMonth(year, 8) - AUGUST + AUGUSTtest);
		// FOR SEPTEMBER
		long SEPTEMBEROrders = testorders.get("SEPTEMBER") != null ? testorders.get("SEPTEMBER") : 0;
		long SEPTEMBER = testWeeknd.get("SEPTEMBER") != null ? testWeeknd.get("SEPTEMBER") : 0;
		long SEPTEMBERtest = test.get("SEPTEMBER") != null ? test.get("SEPTEMBER") : 0;
		list.add((float) (SEPTEMBEROrders / (float) (getNumberOfDaysInMonth(year, 9) - SEPTEMBER + SEPTEMBERtest)) * 100);
		//System.out.println((float) (getNumberOfDaysInMonth(year, 9) - SEPTEMBER + SEPTEMBERtest));
		SommeByMonyh.add(getNumberOfDaysInMonth(year, 9) - SEPTEMBER + SEPTEMBERtest);
		//System.out.println((float) (SEPTEMBEROrders / (float) (getNumberOfDaysInMonth(year, 9) - SEPTEMBER + SEPTEMBERtest)) * 100);
		//System.out.println(((float) SEPTEMBEROrders / (float) (getNumberOfDaysInMonth(year, 9) - (SEPTEMBER + SEPTEMBERtest))	* 100));
		//FOR OCTOBRE
		long OCTOBEROrders = testorders.get("OCTOBER") != null ? testorders.get("OCTOBER") : 0;
		long OCTOBER = testWeeknd.get("OCTOBER") != null ? testWeeknd.get("OCTOBER") : 0;
		long OCTOBERtest = test.get("OCTOBER") != null ? test.get("OCTOBER") : 0;
		list.add(((float) OCTOBEROrders / (float) (getNumberOfDaysInMonth(year, 10) - OCTOBER + OCTOBERtest)) * 100);
		SommeByMonyh.add(getNumberOfDaysInMonth(year, 10) - OCTOBER + OCTOBERtest);
		// FOR NOVEMBRE
		long NOVEMBEROrders = testorders.get("NOVEMBER") != null ? testorders.get("NOVEMBER") : 0;
		long NOVEMBER = testWeeknd.get("NOVEMBER") != null ? testWeeknd.get("NOVEMBER") : 0;
		long NOVEMBERtest = test.get("NOVEMBER") != null ? test.get("NOVEMBER") : 0;
		list.add(((float) NOVEMBEROrders / (float) (getNumberOfDaysInMonth(year, 11) - NOVEMBER + NOVEMBERtest))
				* 100);
		SommeByMonyh.add(getNumberOfDaysInMonth(year, 11) - NOVEMBER + NOVEMBERtest);
		// FOR DECEMBER
		long DECEMBEROrders = testorders.get("DECEMBER") != null ? testorders.get("DECEMBER") : 0;
		long DECEMBER = testWeeknd.get("DECEMBER") != null ? testWeeknd.get("DECEMBER") : 0;
		long DECEMBERtest = test.get("DECEMBER") != null ? test.get("DECEMBER") : 0;
		SommeByMonyh.add(getNumberOfDaysInMonth(year, 12) - DECEMBER + DECEMBERtest);
		list.add(((float) DECEMBEROrders / (float) (getNumberOfDaysInMonth(year, 12) - DECEMBER + DECEMBERtest))
				* 100);
		//System.out.println(orders);
		//System.out.println(SommeByMonyh);

		return list;
		//allweekwek.stream().collect(Collectors.groupingBy(p -> Month.from(p.getDate()), Collectors.counting()));
	}

}



