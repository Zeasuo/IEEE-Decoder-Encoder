package application;

import java.util.HashMap;

public class IEEE_Encoder {
	private String decimal_num;
	private HashMap<String, String> special = new HashMap<String, String>();
	
	public IEEE_Encoder(String dec) {
		this.decimal_num = dec;
		special.put("infinity", "01111111100000000000000000000000");
		special.put("-infinity", "11111111100000000000000000000000");
		special.put("NaN", "01111111111111111111111111111111");
		special.put("0", "00000000000000000000000000000000");
		special.put("-0", "10000000000000000000000000000000");
	}
	/***
	 * Convert the decimal_num into a floating point representation of 32 bits(Single precision)
	 * @return A binary string representation of the floating point
	 */
	public String to_floating_point() {
		String result;
		float dec;
		int exp = 127;
		//check for special values
		if (special.containsKey(this.decimal_num)) {
			return special.get(this.decimal_num);
		}
		//Convert String to float
		try {
			dec = Float.parseFloat(this.decimal_num);
		}
		catch (Exception e) {
			return "Invalid input.";
		}
		//Check for sign
		if (dec < 0) {
			result = "1";
		}
		else {
			result = "0";
		}
		
		//Compute Exponents
		while (!(dec >= 1.0f && dec < 2.0f)) {
			if (dec >= 2.0f) {
				dec /= 2.0f;
				exp += 1;
			}
			else {
				dec *= 2.0f;
				exp -= 1;
			}
		}
		
		//Convert exp to binary string
		int power = 7;
		String bin_exp = "";
		for (int i=0; i<8;i++) {
			float temp = (float)Math.pow(2.0f, power);
			if (exp >= temp) {
				exp -= temp;
				power -= 1;
				bin_exp += "1";
			}
			else {
				power -= 1;
				bin_exp += "0";
			}
		}
		
		//Compute Mantissa
		int power_of_2 = -1;
		String mantissa = "";
		dec = dec-1;
		for (int i=0; i<23;i++) {
			float temp = (float)Math.pow(2.0f, power_of_2);
			if (dec >= temp) {
				dec -= temp;
				power_of_2 -= 1;
				mantissa += "1";
			}
			else {
				power_of_2 -= 1;
				mantissa += "0";
			}
		}
		return result + bin_exp + mantissa;
	}
}
