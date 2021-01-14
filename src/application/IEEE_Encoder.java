package application;

public class IEEE_Encoder {
	private String decimal_num;
	
	public IEEE_Encoder(String dec) {
		this.decimal_num = dec;
	}
	/***
	 * Convert the decimal_num into a floating point representation of 32 bits(Single precision)
	 * @return A binary string representation of the floating point
	 */
	public String to_floating_point() {
		String result;
		float dec;
		int exp = 127;
		try {
			dec = Float.parseFloat(this.decimal_num);
		}
		catch (NumberFormatException e) {
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
		while (!(dec > 1.0f && dec < 2.0f)) {
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
