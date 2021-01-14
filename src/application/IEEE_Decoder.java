package application;

public class IEEE_Decoder {
	private String floating_point;
	
	public IEEE_Decoder(String f) {
		this.floating_point = f;
	}
	/***
	 * Convert the decimal_num into a floating point representation of 32 bits(Single precision)
	 * @return A binary string representation of the floating point
	 */
	public String to_decimal_num() {
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

}
