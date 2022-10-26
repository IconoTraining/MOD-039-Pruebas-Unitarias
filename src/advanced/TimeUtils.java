package advanced;

import java.time.LocalDateTime;


//class TimeService {
//	public LocalDateTime getTime() {
//		LocalDateTime time = LocalDateTime.now();
//		return time;
//	}
//}



public class TimeUtils {
	
//	private TimeService timeService;
//	
//	public TimeUtils(TimeService timeService) {
//		this.timeService = timeService;
//	}
//	
	public String getTimeOfDay(LocalDateTime time)
	{
		//LocalDateTime time = LocalDateTime.now();
		//LocalDateTime time = timeService.getTime();
	    if (time.getHour() < 6)
	    {
	        return "Night";
	    }
	    if (time.getHour() < 12)
	    {
	        return "Morning";
	    }
	    if (time.getHour() < 18)
	    {
	        return "Afternoon";
	    }
	    return "Evening";
	}

//	protected LocalDateTime getTime() {
//		LocalDateTime time = LocalDateTime.now();
//		return time;
//	}
	
//	public String getTimeOfDay()
//	{
//		LocalDateTime time = LocalDateTime.now();
//	    return getTimeOfDay(time);
//	}
	
	
}




//4: 0, 6, 12, 18
// 
//5: 0, 5, 11, 17, 19
//5: 0, 6, 12, 18

