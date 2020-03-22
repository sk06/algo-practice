import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * 
A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).

Each LED represents a zero or one, with the least significant bit on the right.

Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.

Example:

Input: n = 1
Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
Note:
The order of output does not matter.
The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".
 */
public class BinaryWatch_401 {
 
	    List<String> times = new ArrayList<>();
	    
	    public List<String> readBinaryWatch(int num) {
	        
	        if (num == 0)
	            return Collections.singletonList("0:00");
	        int[] time = new int[10];
	        binaryWatch(time, num, 0);
	        return times;
	    }
	    
	    public void binaryWatch(int[] time, int num, int idx){
	        
	        //get time in string format, add to the times list and return
	        if (isValid(time, num)){
	            times.add(getTimeString(time));
	            return;
	        }
	        if (idx >= time.length) return;
	        
	        time[idx] = 1;
	        binaryWatch(time, num-1, idx+1);
	        time[idx] = 0;
	        binaryWatch(time, num, idx+1);
	        
	        return;
	    }
	    
	    public String getTimeString(int[] time){
	        int hour = 8*time[0] + 4*time[1] + 2* time[2] + time[3];
	        int min = 32*time[4] + 16*time[5] + 8*time[6] + 4*time[7] + 2*time[8] + time[9];
	        String h = String.valueOf(hour);
	        String m = (min < 10) ? "0"+ String.valueOf(min):String.valueOf(min);
	        return h+":"+m;
	    }
	    
	    public boolean isValid(int[] time, int num){
	        int hour = 8*time[0] + 4*time[1] + 2* time[2] + time[3];
	        int min = 32*time[4] + 16*time[5] + 8*time[6] + 4*time[7] + 2*time[8] + time[9];
	        if (hour < 12 && min < 60 && num <= 0){
	            return true;
	        }
	        return false;
	    }
	    
	    
	
}
