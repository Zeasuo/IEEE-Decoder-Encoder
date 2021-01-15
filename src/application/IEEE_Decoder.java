package application;

import java.util.HashMap;

public class IEEE_Decoder {
	private String floating_point;
	private HashMap<String, String> special= new HashMap<String, String>();
	
	public IEEE_Decoder(String f) {
		this.floating_point = f;
		special.put("01111111100000000000000000000000", "Infinity");
		special.put("11111111100000000000000000000000", "-Infinity");
		special.put("01111111111111111111111111111111", "NaN");
		special.put("00000000000000000000000000000000", "0");
		special.put("10000000000000000000000000000000", "-0");
	}
	/***
	 * Convert the decimal_num into a floating point representation of 32 bits(Single precision)
	 * @return A binary string representation of the floating point
	 */
	public String to_decimal_num() {
		//Check for special values
		if (special.containsKey(this.floating_point)) {
			return special.get(this.floating_point);
		}
		//Check for validity
		if (this.floating_point.length() != 32 || !(this.is_binary_string(floating_point))) {
			return "Invalid input";
		}
		String sign = this.floating_point.substring(0, 1);
		String exponents = this.floating_point.substring(1, 9);
		String mantissa = this.floating_point.substring(9);
		String result = "";
		//Check for the sign
		if (sign.equals("1")) {
			result = "-";
		}
		//Calculate Exponents
		int power_of_2 = 7;
		int exp = 0;
		for (int i=0; i<8;i++) {
			if (exponents.charAt(i) == '1') {
				exp += Math.pow(2, power_of_2);
			}
			power_of_2 -= 1;
		}
		
		//Calculate mantissa
		int powerOf2AfterDecimal = -1;
		float value = 0;
		for (int i = 0; i<23; i++) {
			if(mantissa.charAt(i)=='1') {
				value += Math.pow(2, powerOf2AfterDecimal);
			}
			powerOf2AfterDecimal -= 1;
		}
		float temp = (float) ((1.0+value) * Math.pow(2, exp-127));
		return result + temp;
		
		
	}
	
	private boolean is_binary_string(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != '0' && s.charAt(i) != '1') {
				return false;
			}
			
		}
		return true;
	}

}
